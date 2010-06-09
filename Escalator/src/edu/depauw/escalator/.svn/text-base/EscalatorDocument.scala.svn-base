package edu.depauw.escalator

import java.io._
import java.awt.event.{ActionListener, ActionEvent}
import javax.swing.{JComponent, JButton}
import javax.swing.text._
import javax.swing.event.{DocumentListener, DocumentEvent}
import swing.FileChooser
import swing.Dialog._

/*
 * Document class for Scales documents
 */
class EscalatorDocument(editor : Editor) extends DefaultStyledDocument {
  private var isCompiled = false
  private var prevScriptCode = ""
  private var prevExternCode = ""
  private var fnames = List[String]()
  private var _fileSaved = true
  var saveFile : Option[java.io.File] = None
  
  private var objs = List[JComponent]()
  
  private val styleKit = editor.textPane.getEditorKit
  
  private def fileSaved = _fileSaved
  private def fileSaved_=(flag : Boolean) {
    if (flag || _fileSaved) {
      editor.markSaved(flag)
      _fileSaved = flag
    }
  }

  def fileName = saveFile.map(_.getCanonicalPath) getOrElse "Unnamed"
  
  /*
   * Session
   */

  val session = new Session
  var posToEval: scala.List[(Position, Result)] = scala.List()
  
  addDocumentListener(new MyDocumentListener)
  
  def addEvalable(linePos: Int, e: Result) {
    session.addEvalable(e)
    posToEval =  (createPosition(linePos), e) :: posToEval
  }

  def findEvalable(posToFind: Int): Option[Result] = {
    for ((pos, e) <- posToEval) {
      if (pos.getOffset == posToFind)
        return Some(e)
    }
    None
  }

  def findPos(eToFind: Result): Option[Int] = {
    for ((pos, e) <- posToEval) {
      if (eToFind == e)
        return Some(pos.getOffset())
    }
    None
  }

  def removeEvalable(posToFind: Int) {
    // inefficient
    for ((pos, e) <- posToEval)
      if (pos.getOffset() == posToFind) {
        removeEvalable(e)
        return
      }
  }

  def removeEvalable(e: Result) {
    session.removeEvalable(e)
    posToEval = posToEval.filterNot(t => t._2 == e)
  }

  /*
   * Components
   */

  class EqualsExpr(s:String, originalLine: String) extends session.Expr(s) {
    var posobj: Position = null // hack, need to initialize after addObject

    val button = new JButton("<<") {
      addActionListener(new ActionListener {
        def actionPerformed(evt: ActionEvent) {
          val pos = posobj.getOffset()
          EscalatorDocument.this.remove(pos, originalLine.length)
          insertString(pos, originalLine, editor.default)
          editor.textPane.setCaretPosition(pos + originalLine.length - 1)
        }
      })
    }

    add(button)
  }

  def addObject(pos:Int, c: JComponent, text: String) {
    // http://www.docjar.com/html/api/javax/swing/JTextPane.java.html CTRL-F "insertComponent"
    objs = c :: objs // TODO need to clean out this list eventually...
    val attrs = new SimpleAttributeSet
    StyleConstants.setComponent(attrs, c)
    insertString(pos, text, attrs)
  }
  
  def addObject(c: JComponent) { addObject(editor.textPane.getCaretPosition, c) }
  
  def addObject(c: JComponent, text: String) { addObject(editor.textPane.getCaretPosition, c, text) }
  
  def addObject(pos: Int, c: JComponent) { addObject(pos, c, " ") }

  def getComponent(pos:Int): Option[Evalable] = {
    val attrs = getCharacterElement(pos).getAttributes()
    val obj = attrs.getAttribute(StyleConstants.ComponentAttribute)
    if (obj == null) None else Some(obj.asInstanceOf[Evalable])
  }

  private def getComponentStart(pos: Int, obj: Evalable): Int =
    if (pos == 0) pos
    else getComponent(pos - 1) match {
      case Some(obj) =>
        getComponentStart(pos - 1, obj)
      case _ => pos
  }
  
  def updateComponentFonts() = {
    for (c <- objs) c.setFont(Escalator.font)
  }

  def compileDocument(): (Boolean, ErrorArea) = {
    if (isCompiled) return (true, null)
    
    def getAllBlocks(pos:Int):String = {
      val (para, begin, end) = getParagraph(pos)
      val paraTrim = para.trim
      if ((paraTrim.length > 0) && (paraTrim(0) == '@') && (paraTrim != "@@")) {
        val (code, newPos) = getSingleBlock(end)
        if (paraTrim != "@") {
          if (!prevExternCode.contains(code)) {
            if (!saveFile.isDefined) {
              if (!saveDocumentAs()) {
                editor.showStatus("Error while creating external source files. Please save this document.")
                return ""
              }
            }
            compileBlock(code, paraTrim.substring(1).trim())
            prevExternCode += code
          }
          if (end >= getLength) "" else getAllBlocks(newPos)
        } else if (end >= getLength) code else code + getAllBlocks(newPos)
      } else if (end >= getLength) "" else "" + getAllBlocks(end)
    }

    def getSingleBlock(pos:Int):(String, Int) = {
      var newPos = pos
      def getLine(): String = {
        val (para, begin, end) = getParagraph(newPos)
        if ((para.trim == "@@") || (end >= getLength)) "" else {
          newPos = end
          para + getLine()
        }
      }
      (getLine(), newPos)
    }

    def compileBlock(code: String, fname: String ) = {
      val dir = saveFile.get.getParent
      if (createSourceFile(dir, fname, code)) {
        session.interpreter.updateClassPath(dir)
      }
    }

    fnames = Nil
    val code = getAllBlocks(0)
    if (!fnames.isEmpty) {
      javax.swing.JOptionPane.showMessageDialog(editor.peer, "Please compile external files: " + fnames)
      // TODO this doesn't work properly
    }
    if (code != prevScriptCode) {
      prevScriptCode = code
      try { session.interpreter.exec(code) }
      catch {
        case e:ScriptException => return (false , new ErrorArea(e.getMessage))
        case e:IncompleteException => return (false, new ErrorArea("Incomplete code block: " + code))
      }
    }
    
    isCompiled = true
    ( true , null )
  }

  private def createSourceFile(dir: String, name: String, code: String): Boolean = {
    try {
      val file = new File(dir + System.getProperty("file.separator") + name)
      var toWrite = code

      if (fnames.exists( _ == name)) {
          val fis = new FileInputStream(file)
          val in = new BufferedReader( new InputStreamReader(fis))
          val sb = new StringBuffer("")
          var strLine = in.readLine()
          while (strLine != null) {
            sb.append(strLine + System.getProperty("line.separator"))
            strLine = in.readLine()
          }
          in.close()
          toWrite = sb.append(code).toString()
      }
      else fnames = name :: fnames

      val out = new BufferedWriter( new FileWriter(file))
      out.write(toWrite)
      out.close()
    }
    catch {
      case _ =>
        editor.showStatus("Error creating external source file: " + name)
        false
    }
    true
  }

  def parse(pos: Int): (Int, Int, ParseResult) = {
    val (para, begin, end) = getParagraph(pos)

    val mode = if (para.startsWith("==")) "==" else para.substring(0,1)

    def traverse(pos: Int): (String, Int) = {
      val (para, begin, end) = getParagraph(pos)
      if (para(0) == '|') {
        val line = para.substring(1)
        if (end >= getLength)
          (line, end)
        else {
          val (newLine, newEnd) = traverse(end)
          val fullLine = line + newLine
          (fullLine.substring(0, fullLine.length), newEnd)
        }
      } else {
        ("", pos)
      }
    }
    if (mode == ">" || mode == "=" || mode == "==") {
      val (result, newEnd) = traverse(end)
      val line = para.substring(mode.length) + result
      (begin, newEnd,
       if (mode == ">") {
         if (session.interpreter.isDecl(line)) {
           Decl(line)
         } else {
           Expr(line)
         }
       } else if (mode == "=") {
         EvalExpr(line)
       } else {
         SavedEvalExpr(line)
       })
    } else if (mode == "|") {
      if (begin == 0)
        (begin, end, RegularLine(para))
      else {
        parse(pos - 1)
      }
    } else {
      (begin, end, RegularLine(para))
    }
  }

  // Returns the new end.
  def eval(t: (Int, Int, ParseResult)): Option[Int] = {
    val (success, error) = compileDocument()

    val (begin, end, matchobj) = t

    // sorry this is hacky
    def handle(line: String, objcreator: String => Result): Option[Int] = {
      findEvalable(begin) match {
        case Some(e) =>
          if (success)
            e.eval(line)
          else
            e.setDisplay(error)
          return None
        case None => ()
      }

      val obj = objcreator(line)
      addEvalable(begin, obj)

      if (!success)
        obj.setDisplay(error)

      insertString(end - 1, "\n", editor.default)
      addObject(end, obj, " ")
      Some(end + 1)
    }

    matchobj match {
      case Expr(line) =>
        handle(line, new session.Expr(_))

      case Decl(line) =>
        handle(line, new session.Statement(_))

      case EvalExpr(line) =>
        var originalText = getText(begin, end - begin)
        remove(begin, end - begin - 1)

        val obj = new EqualsExpr(line, originalText)
        if (!success)
          obj.setDisplay(error)
        addObject(begin, obj, originalText)
        obj.posobj = createPosition(begin)
        Some(end - 1)

      case _ => None
    }
  }

  def eval(pos: Int):Option[Int] = eval(parse(pos))

  def getIndent(pos: Int): String = {
    val (para, begin, end) = getParagraph(pos)
    "^.?(\\s*)".r.findFirstMatchIn(para) match {
      case Some(m) => m.group(1)
      case None => ""
    }
  }

  def newline() {
    val pos = editor.textPane.getCaretPosition
    val (para, begin, end) = getParagraph(pos)
    if (begin != pos && !getComponent(begin).isDefined) // don't evaluate if at beginning of line
      parse(pos) match {
        case (_, _, RegularLine(_)) => ()
        case t =>
          try {
            eval(t) match {
              case Some(end) =>
                editor.textPane.setCaretPosition(nextLine(end))
              case None => ()
            }
          } catch {
            case _:IncompleteException =>
              val indent = getIndent(pos)
              insertString(pos, "\n|" + indent, editor.default)
              editor.textPane.setCaretPosition(pos + 2 + indent.length)
          }
          return
      }
    insertString(pos, "\n", editor.default)
  }

  def continue() {
    val pos = editor.textPane.getCaretPosition
    val (para, begin, end) = getParagraph(pos)
    val mode = para(0)
    if (mode == '|' || mode == '>' || mode == '=') {
      val indent = getIndent(pos)
      insertString(pos, "\n|" + indent, editor.default)
      editor.textPane.setCaretPosition(pos + 2 + indent.length)
    } else {
      insertString(pos, "\n", editor.default)
      editor.textPane.setCaretPosition(pos + 1)
    }
  }

  // Return the position of the next line, if it is blank.
  // If there isn't one, make one.
  def nextLine(pos:Int):Int = {
    val (para, begin, end) = getParagraph(pos)
    if (end <= getLength) {
      val (nextPara, nextBegin, nextEnd) = getParagraph(end)
      if (nextPara == "\n") // i'd like this to work if the line has spaces in it, but for now components are inserted as spaces... lets fix that in the future.
        return nextBegin
    }

    insertString(end, "\n", editor.default)
    end
  }

  def getModeChar(pos: Int):String = {
    if (pos <= 0) return ""
    val c = getText(pos, 1)
    if ((c == ">" || c == "=" || c == "@") &&
        (pos == 0 || getText(pos-1, 1) == "\n"))
      c
    else
      ""
  }

  def getModeChar():String = getModeChar(editor.textPane.getCaretPosition - 1)

  def getParagraph() : (String, Int, Int) =
    getParagraph(editor.textPane.getCaretPosition)

  def getParagraph(pos:Int) : (String, Int, Int) = {
    val el = getParagraphElement(pos)
    val start = el.getStartOffset
    val end = el.getEndOffset
    (getText(start, end - start), start, end)
  }

  def reevaluate() = {
    def evaluate(pos: Int, mode: Char) {
      if (pos < getLength) {
        val (begin, end, matchobj) = parse(pos)
        if (mode == '>') {
          matchobj match {
            case Decl(_) =>
              eval((begin, end, matchobj))
            case _ => ()
          }
        }
        else {
          matchobj match {
            case Expr(_) =>
              eval((begin, end, matchobj))
            case SavedEvalExpr(line) =>
              remove(begin, 1)
              eval((begin, end, EvalExpr(line)))
            case _ => ()
          }
        }
        evaluate(end+1, mode)
      }
    }

    evaluate(0, '>')
    evaluate(0, '=')
  }

  def newDocument(): Unit = {
    if (!closeDocument( false )) return
  }

  def openDocument(): Unit = {
    if (editor.chooser.showOpenDialog(editor) == FileChooser.Result.Approve) {
      if (!closeDocument( false )) return
      saveFile = Some(editor.chooser.selectedFile)
      openFile(saveFile.get)
    } else editor.showStatus("Open command cancelled by user.")
  }
  
  def openFile(file : File) {
    editor.showStatus("Opening: " + file.getName() + "...")
    try {
      val fis = new FileInputStream(file)
      styleKit.read(fis, this, 0)
      fis.close()
      saveFile = Some(file)
      editor.chooser.selectedFile = file
      
      reevaluate()
      editor.showStatus("Opening: " + file.getName() + " done.")
      fileSaved = true
    }
    catch {
      case _ => editor.showStatus("Opening: " + file.getName() + " ERROR!")
    }
  }

  def saveDocument(): Boolean = {
    if (!saveFile.isDefined) saveDocumentAs()
    else {
      saveData()
    }
  }

  def saveDocumentAs(): Boolean = {
    if (editor.chooser.showSaveDialog(editor) == FileChooser.Result.Approve) {
      saveFile = Some(editor.chooser.selectedFile)
      saveData()
    } else {
      editor.showStatus("Save command cancelled by user.")
      false
    }
  }

  private def saveData(): Boolean = {
    val file = saveFile.get
    editor.showStatus("Saving: " + file.getName() + "...")
    val sb = new StringBuffer()
    try {
      val out = new BufferedWriter(new FileWriter(file))
      var pos = 0
      while (pos < getLength) {
        val (para, begin, end) = getParagraph(pos)
        if (para.startsWith("=") && getComponent(begin).isDefined)
          sb.append("=" + para)
        else
          sb.append(para)
        pos = end
      }
      out.write(sb.toString())
      out.close()
      editor.showStatus("Saving: " + file.getName() + " done.")
      fileSaved = true
      reevaluate()
      true
    } catch { // TODO I don't think this ever happens -- need to look at return from compileDocument instead
      case e:ScriptException =>
        editor.showStatus("Saving: " + file.getName() + " WARNING: compilation error!")
        true
      case e:Exception =>
        editor.showStatus("Saving: " + file.getName() + " ERROR!")
        false
    }
  }

  def closeDocument(exit: Boolean): Boolean = {
    if (!fileSaved && (getLength != 0)) {
      showConfirmation( editor, "Save current file before closing?", "Save", Options.YesNoCancel) match {
        case Result.Yes => if (!saveDocument()) return false
        case Result.No => {}
        case Result.Cancel => return false
      }
    }

    editor.showStatus("Closing document...")
    if (getLength != 0) remove(0, getLength)
    prevScriptCode = ""
    prevExternCode = ""
    saveFile = None
    fileSaved = true
    if (!exit) reset()
    editor.showStatus("Closing document... done.")
    true
  }

  def reset() {
    posToEval = scala.List()
    session.reset()
  }

  override def remove(offs: Int, len: Int) {
    // TODO does this remove all of the components in the range?  I don't think so
    getComponent(offs) match {
      case Some(c) =>
        val begin = getComponentStart(offs, c)
        c match {
          case e: Result => removeEvalable(e)
          case _ => ()
        }
        super.remove(begin, offs - begin + len)
      case None => super.remove(offs, len)
    }
  }

  // Listens for any changes to the document.
  protected class MyDocumentListener extends DocumentListener {
    def insertUpdate(e: DocumentEvent) {
      isCompiled = false
      fileSaved = false
    }
    def removeUpdate(e: DocumentEvent) {
      isCompiled = false
      fileSaved = false
    }
    def changedUpdate(e: DocumentEvent) {
      isCompiled = false
      fileSaved = false
    }
  }
}
