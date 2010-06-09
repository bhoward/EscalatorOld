package edu.depauw.escalatorx

import java.io.File
import javax.swing.SwingUtilities
import javax.swing.filechooser.FileFilter
import javax.swing.event._

import scala.swing._

// Escalator application object
// Can't use SimpleGUIApplication if we want to use the args...
object Escalator extends SwingApplication {
  // Recognize Mac OS X, so we can do Apple-peculiar GUI things...
  val onOSX = System.getProperty("mrj.version") != null
  
  private var initialFilenames: List[String] = Nil
  
  private var projects: List[Project] = Nil

  if (onOSX) {
    System.setProperty("apple.laf.useScreenMenuBar", "true")
    System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Escalator")
    OSXHelper.setOpenFileHandler(s => initialFilenames ::= s) // handles drag-drop of file(s) to open app
  }

  private val chooser = new FileChooser
  chooser.fileFilter = new FileFilter {
    def getDescription = "Escalator source file"
    def accept(file: File) = file.getName.toLowerCase.endsWith(".esc") || file.isDirectory
  }

  def openEmpty() {
    projects ::= Project.makeEmpty
  }
  
  def openFile(filename : String) {
    projects ::= Project.fromFile(filename)
  }
  
  def openDocument() {
    if (chooser.showOpenDialog(null) == FileChooser.Result.Approve) {
      openFile(chooser.selectedFile.getAbsolutePath)
    }
  }
  
  def exit() = {
    projects.toStream map (project => project.queryExit()) forall (ok => ok)
  }
    
  def startup(args: Array[String]) {
    if (onOSX) {
      // Set the more permanent handler for future open requests
      OSXHelper.setOpenFileHandler(openFile _)
    }
    
    initialFilenames :::= args.toList
    
    initialFilenames.foreach(openFile _)
    
    if (initialFilenames.isEmpty) openEmpty()
  }
  
  private lazy val about = new Frame {
    preferredSize = new Dimension(360, 180)
    title = "About Escalator"
    contents = new BorderPanel {
      lazy val ok = new Button("OK") {
        reactions += {
          case swing.event.ButtonClicked(_) => dispose
        }
      }
      
      lazy val body = new Component {
        override lazy val peer = new javax.swing.JEditorPane() {
          setContentType("text/html")
          setText("<html><body><h1>Escalator</h1>" +
            "<p>Version 2.0 pre-Alpha</p>" +
            "<p>Developed at DePauw University by" + "<br>" +
            "Chris Monsanto, Jeremy Kings and <a href='http://www.csc.depauw.edu/~bhoward/'>Dr. Brian Howard</a></p>" +
            "</body></html>")

          setEditable(false)
          addHyperlinkListener(new HyperlinkListener {
            def hyperlinkUpdate(e: javax.swing.event.HyperlinkEvent) {
              if (e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
                BareBonesBrowserLaunch.openURL(e.getURL().toString())
              }
            }
          })
        }
      }
      
      layout(body) = BorderPanel.Position.Center
      layout(ok) = BorderPanel.Position.South
    }
  }
  
  def showAbout = {
    about.visible = true
  }
}
