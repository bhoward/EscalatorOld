package edu.depauw.escalator

import swing._
import Dialog._

import java.io._
import javax.swing._
import javax.swing.text._
import javax.swing.text.html.HTMLEditorKit
import javax.swing.undo._
import javax.swing.event.{DocumentListener, DocumentEvent, UndoableEditListener, UndoableEditEvent, HyperlinkListener, HyperlinkEvent}

import java.awt.{Color, Dimension}
import java.awt.event._

sealed trait ParseResult
case class RegularLine(s: String) extends ParseResult // hello this is regular text
case class EvalExpr(expr: String) extends ParseResult // = f
case class SavedEvalExpr(expr: String) extends ParseResult // == f
case class Decl(decl: String) extends ParseResult // > val x = f
case class Expr(expr: String) extends ParseResult // > f

class Editor(frame: EscalatorFrame) extends scala.swing.Component {
  /* undo helpers */
  val undoAction = new UndoAction()
  val redoAction = new RedoAction()
  val undo = new UndoManager()

  /* components */
  override lazy val peer = new JTextPane {
    override def paint(g: java.awt.Graphics) = {
      super.paint(g)
      frame.numPanel.repaint()
    }
    override def getPreferredSize(): Dimension = {
      return new Dimension(frame.editorWidth,super.getPreferredSize().getHeight().asInstanceOf[Int])
    }
  }

  val textPane = peer
  val chooser = frame.chooser

  /* styleDoc and styles */
  private val styleDoc = new EscalatorDocument(this)
  textPane.setStyledDocument(styleDoc)

  val default = StyleContext.getDefaultStyleContext.getStyle(StyleContext.DEFAULT_STYLE)
  StyleConstants.setFontFamily(default, Escalator.font.getFamily)
  StyleConstants.setFontSize(default, Escalator.font.getSize)
  textPane.setLogicalStyle(default)

  styleDoc.addUndoableEditListener(new MyUndoableEditListener)
  
  def closeDocument(exit : Boolean) = styleDoc.closeDocument(exit)
  def openFile(file : java.io.File) = styleDoc.openFile(file)
  def newDocument() = styleDoc.newDocument()
  def openDocument() = styleDoc.openDocument()
  def saveDocument() = styleDoc.saveDocument()
  def saveDocumentAs() = styleDoc.saveDocumentAs()

  /*
   * Actions
   */

  private def setInput(keystroke: KeyStroke, name: String) {
    textPane.getInputMap().put(keystroke, name)
  }

  private def setAction(name:String, f: ActionEvent => Unit) {
    textPane.getActionMap().put(name, new AbstractAction(name) {
      def actionPerformed(evt: ActionEvent){
        f(evt)
      }
    })
  }

  private var inputCounter = 0
  def mapAction(keystroke: KeyStroke, f: ActionEvent => Unit) {
    val n = "action" + inputCounter
    setAction(n, f)
    setInput(keystroke, n)
    inputCounter += 1
  }

  mapAction(KeyStroke.getKeyStroke("ENTER"), x => styleDoc.newline())
  mapAction(KeyStroke.getKeyStroke("shift ENTER"), x => styleDoc.continue())
  // remap delete
  //setAction(DefaultEditorKit.deletePrevCharAction, delete)

  def exit():Boolean = {
    if (styleDoc.closeDocument( true )) {
      System.exit(0)
      true
    } else false
  }
  
  def changeFontSize(newSize : Int) {
    StyleConstants.setFontSize(default, newSize)
    textPane.setLogicalStyle(default)
    styleDoc.setCharacterAttributes(0, styleDoc.getLength + 1, default, false);
    Escalator.font = new java.awt.Font(Escalator.font.getFamily, Escalator.font.getStyle, newSize)
    styleDoc.insertString(textPane.getCaretPosition, " ", default)
    styleDoc.remove(textPane.getCaretPosition - 1, 1) // HACK!!!
    styleDoc.reevaluate()
    styleDoc.updateComponentFonts()
  }
  
  def showStatus(msg : String) {
    frame.log.text = msg
  }
  
  def markSaved(flag : Boolean) {
    if (flag) {
      frame.title = "Escalator - " + styleDoc.fileName
    } else {
      frame.title = "Escalator - *" + styleDoc.fileName
    }
    
    if (Escalator.onOSX) {
      val root = frame.peer.getRootPane
      root.putClientProperty("Window.documentModified", !flag)
      root.putClientProperty("Window.documentFile", styleDoc.saveFile getOrElse null)
    }
  }

  /*
   * About frame
   */
  def createAbout() = {
    val about = new Frame() {
      preferredSize = new Dimension(360, 180)
      // peer.setResizable( false )
      title = "About Escalator"
      val mainPanel = new BorderPanel
      val flowPanel = new FlowPanel {
        contents +=  new Button("OK") {
          reactions += {
            case swing.event.ButtonClicked(_) => dispose()
          }
        }
      }

      object aboutPane extends scala.swing.Component with HyperlinkListener {
        override lazy val peer = new JEditorPane() {
          setContentType("text/html")
          setEditorKit( new HTMLEditorKit())
          val tempField = new JTextField()
          setBorder(tempField.getBorder())
          setText("<html>" + "<body>" + "Escalator" + "<br>" +
            "version Alpha 1.0" + "<br>" + "<br>" +
            "Developed at DePauw University by" + "<br>" +
            "Chris Monsanto, Jeremy Kings and Dr. Brian Howard")

          setEditable( false )
        }

        def hyperlinkUpdate(e: HyperlinkEvent) {
          if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            BareBonesBrowserLaunch.openURL(e.getURL().toString())
          }
        }
      }

      mainPanel.layout(aboutPane) = BorderPanel.Position.Center
      mainPanel.layout(flowPanel) = BorderPanel.Position.South
      contents = mainPanel
    }

    about.pack()
    about.visible = true
  }

  /*
   * Undo Classes & Methods
   */
  class UndoAction extends AbstractAction("Undo") {
    setEnabled(false)

    def actionPerformed(e: ActionEvent) {
      try {
        undo.undo()
      } catch {
        case ex:CannotUndoException =>
          //println("Unable to undo: " + ex)
          //ex.printStackTrace()
      }
      updateUndoState()
      redoAction.updateRedoState()
    }

    def updateUndoState() {
      if (undo.canUndo()) {
        setEnabled(true)
        putValue(javax.swing.Action.NAME, undo.getUndoPresentationName())
      } else {
        setEnabled(false)
        putValue(javax.swing.Action.NAME, "Undo")
      }
    }
  }

  class RedoAction extends AbstractAction("Redo") {
    setEnabled(false)

    def actionPerformed(e: ActionEvent) {
      try {
        undo.redo()
      } catch {
        case ex:CannotRedoException =>
          //println("Unable to redo: " + ex)
          //ex.printStackTrace()
      }
      updateRedoState()
      undoAction.updateUndoState()
    }

    def updateRedoState() {
      if (undo.canRedo()) {
        setEnabled(true)
        putValue(javax.swing.Action.NAME, undo.getRedoPresentationName())
      } else {
        setEnabled(false)
        putValue(javax.swing.Action.NAME, "Redo")
      }
    }
  }

  // Listens for edits that can be undone.
  protected class MyUndoableEditListener extends UndoableEditListener {
    def undoableEditHappened(e: UndoableEditEvent) {
      //Remember the edit and update the menus.
      undo.addEdit(e.getEdit())
      undoAction.updateUndoState()
      redoAction.updateRedoState()
    }
  }
}
