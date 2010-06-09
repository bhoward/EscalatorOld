package edu.depauw.escalatorx

import java.io.File
import java.awt.Dimension
import java.awt.Toolkit
import java.awt.event.{InputEvent, KeyEvent}

import javax.swing.KeyStroke
import javax.swing.WindowConstants._

import scala.swing._
import scala.swing.event._
import scala.xml.XML

// Main GUI frame for Escalator application
class EscalatorFrame(project: Project) extends Frame {
  private val frameSize = Toolkit.getDefaultToolkit().getScreenSize()
  private val frameWidth = frameSize.width
  private val frameHeight = frameSize.height
  preferredSize = frameSize
  minimumSize = frameSize

  val doc = project.doc
  val tabs = new TabbedPane
  val pane = new RenderEditPane(doc, tabs)
  val changes = new ChangeManager
  val split = new SplitPane(Orientation.Vertical, new ScrollPane(pane), tabs)
  
  val shortcutMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()
  def stroke(keyCode: Int) = Some(KeyStroke.getKeyStroke(keyCode, shortcutMask))
  def altStroke(keyCode: Int) = Some(KeyStroke.getKeyStroke(keyCode, shortcutMask + InputEvent.ALT_MASK))
  
  val newAction = new Action("New") {
    accelerator = stroke(KeyEvent.VK_N)
    
    def apply() {
      Escalator.openEmpty()
    }
  }

  val openAction = new Action("Open...") {
    def apply() {
      Escalator.openDocument() // TODO feed in the project-specific directory?
    }
  }
  
  val saveAction = new Action("Save") {
    accelerator = stroke(KeyEvent.VK_S)
    
    def apply() {
      saveDocument()
    }
  }

  val saveAsAction = new Action("Save As...") {
    accelerator = altStroke(KeyEvent.VK_S)
    
    def apply() {
      saveDocumentAs()
    }
  }
  
  val closeAction = new Action("Close") {
    accelerator = stroke(KeyEvent.VK_W)
    
    def apply() {
      queryExit()
    }
  }
  
  val exitAction = new Action("Exit"){
    def apply() {
      Escalator.exit()
    }
  }

  val undoAction = new Action("Undo") {
    enabled = false
    accelerator = stroke(KeyEvent.VK_Z)

    def apply() {
      changes.undo()
      update()
    }
  }
  
  val redoAction = new Action("Redo") {
    enabled = false
    accelerator = stroke(KeyEvent.VK_Y)

    def apply() {
      changes.redo()
      update()
    }
  }

  split.dividerLocation = frameWidth / 2
  contents = split
  update()

  menuBar = new EscalatorMenu(this)

  peer.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE)

  reactions += {
    case e: scala.swing.event.WindowClosing => queryExit()
  }
  
  def saveDocument() {
    if (project.file.getName == Project.UNNAMED) {
      saveDocumentAs()
    } else {
      doc.save(project.file)
      changes.setClean()
    }
  }
  
  def saveDocumentAs() {
    // TODO
  }
  
  def queryExit(): Boolean = {
    if (changes.isDirty) {
      // TODO offer chance to save first, or return false
    }
    
    close()
    true
  }
  
  def update() {
    title = "Escalator " + (if (changes.isDirty) "* " else "- ") + project.file.getName
    
    if (Escalator.onOSX) {
      val root = peer.getRootPane
      root.putClientProperty("Window.documentModified", changes.isDirty)
      root.putClientProperty("Window.documentFile", project.file)
    }
    
    undoAction.enabled = changes.canUndo
    undoAction.title = changes.getUndoPresentationName

    redoAction.enabled = changes.canRedo
    redoAction.title = changes.getRedoPresentationName
  }
}
