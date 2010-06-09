package edu.depauw.escalator

import swing._
import swing.event._

import java.io._
import javax.swing.filechooser._
import javax.swing._
import javax.swing.text._
import javax.swing.WindowConstants._

import java.awt.Dimension

// Main GUI frame for Scales application
class EscalatorFrame() extends Frame {
  private val frameWidth = 600
  private val frameHeight = 600
  private val frameSize = new Dimension(frameWidth,frameHeight)
  preferredSize = frameSize
  minimumSize = frameSize

  // Panel used for paragraph numbering
  val numPanel = new NumberingPanel
  private val numPanelWidth = 30
  private val numPanelHeight = 30
  private val numPanelSize = new Dimension(numPanelWidth,numPanelHeight)
  numPanel.preferredSize = numPanelSize

  val editorWidth = frameWidth - 2*numPanelWidth
  private val editorHeight = frameHeight - 50
  private val editorSize = new Dimension(editorWidth,editorHeight)

  val chooser = new FileChooser
  //chooser.multiSelectionEnable = false   //(doesn't work on my build?)
  chooser.fileFilter = new javax.swing.filechooser.FileFilter {
    def getDescription = "Text file or Scala source file"
    def accept(file: File) = (file.getName.endsWith(".txt") ||
                              file.getName.endsWith(".scala") ||
                              file.getName.endsWith(".scales") ||
                              file.isDirectory())
  }

  val editor = new Editor( this )
  editor.minimumSize = editorSize

  // Border panel which contains the editor and the paragraph numbering panel
  private val borderPanelIn = new BorderPanel
  borderPanelIn.layout(numPanel) = BorderPanel.Position.West
  borderPanelIn.layout(editor) = BorderPanel.Position.Center
  // Set up a scroll pane for the Border panel
  private val scrollPaneEdit = new ScrollPane(borderPanelIn)
  scrollPaneEdit.peer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS)
  scrollPaneEdit.peer.getVerticalScrollBar.setUnitIncrement(12)

  // Set up log for GUI operations (was a TextArea originally, now is more of a status bar)
  private val logWidth = frameWidth - 30
  private val logHeight = frameHeight - editorHeight
  private val logSize = new Dimension(logWidth, logHeight)
  val log = new Label("Status bar")

  menuBar = new EscalatorMenu(this)

  // Border panel which contains all UI elements
  val borderPanelOut = new BorderPanel
  borderPanelOut.layout(scrollPaneEdit) = BorderPanel.Position.Center
  borderPanelOut.layout(log) = BorderPanel.Position.South

  peer.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE)
  title = "Escalator"
  contents = borderPanelOut

  listenTo(borderPanelOut)
  reactions += {
    case ComponentResized(`borderPanelOut`) =>
      editor.repaint
    case WindowClosing(_) => editor.exit()
  }

  // Class def: Panel for paragraph numbering
  class NumberingPanel extends Panel {
    override def paint(g: Graphics2D): Unit = {
      super.paint(g)
      val root = editor.textPane.getDocument.getDefaultRootElement
      var r = new java.awt.Rectangle
      try {
        r = editor.textPane.modelToView(root.getStartOffset)
        g.drawString(1.toString,0,(r.getY + 12).asInstanceOf[Int])
      } catch { case e1: BadLocationException => {}}
      var lines = root.getElementCount
      for (i <- 0 until lines) {
        val offset = root.getElement(i).getEndOffset
        try {
          r = editor.textPane.modelToView(offset)
          g.drawString((i + 2).toString,0,(r.getY + 12).asInstanceOf[Int])
        } catch { case e:BadLocationException => {} }
      }
    }
  }
}

// Escalator application object
// Can't use SimpleGUIApplication if we want to use the args...
object Escalator extends GUIApplication {
  // Recognize Mac OS X, so we can do Apple-peculiar GUI things...
  val onOSX = System.getProperty("mrj.version") != null
  
  // Global font to be used in editor window
  var font = new java.awt.Font("monospaced", java.awt.Font.PLAIN, 14)
  
  private var filename : Option[String] = None

  if (onOSX) {
    System.setProperty("apple.laf.useScreenMenuBar", "true")
    System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Escalator")
    OSXHelper.setOpenFileHandler(s => filename = Some(s))
  }

  def main(args: Array[String]) = {
    val top = new EscalatorFrame()
    
    if (args.length > 0) filename = Some(args(0))
    
    def openFile(filename : String) {
      if (!top.editor.closeDocument(false)) return
      top.editor.openFile(new File(filename))
    }
    
    SwingUtilities.invokeLater {
      new Runnable {
        def run() {
          init()
          top.pack()
          top.visible = true
          
          filename.foreach(openFile _)
          
          if (onOSX) {
            // Set the more permanent handler for future open requests
            OSXHelper.setOpenFileHandler(openFile _)
          }
        }
      }
    }
  }

}
