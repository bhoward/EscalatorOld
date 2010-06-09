package edu.depauw.escalatorx

import swing._
import swing.event._

import java.awt.event.KeyEvent._

import javax.swing.text._
import javax.swing.undo._
import javax.swing.{AbstractAction, KeyStroke}

class EscalatorMenu(frame: EscalatorFrame) extends MenuBar {
  contents += new Menu("File") {
    contents += new MenuItem(frame.newAction)
    contents += new MenuItem(frame.openAction)
    contents += new MenuItem(frame.saveAction)
    contents += new MenuItem(frame.saveAsAction)

    contents += new Separator
//    contents += new Menu("Import")
//    contents += new Menu("Export")
//    contents += new Separator

    contents += new MenuItem(frame.closeAction)

    if (Escalator.onOSX) {
      OSXHelper.setQuitHandler(Escalator.exit)
    } else {
      contents += new Separator
      contents += new MenuItem(frame.exitAction)
    }
  }

  contents += new Menu("Edit"){
    contents += new MenuItem(frame.undoAction)
    contents += new MenuItem(frame.redoAction)
    
    contents += new Separator
// Not appropriate for the rendered view
//    contents += new MenuItem("Cut") {
//      peer.setAction(new DefaultEditorKit.CutAction())
//      text = "Cut"
//      peer.setMnemonic(VK_T)
//    }
    contents += new MenuItem("Copy") {
      peer.setAction(new DefaultEditorKit.CopyAction())
      text = "Copy"
      peer.setMnemonic(VK_C)
    }
// Not appropriate for the rendered view
//    contents += new MenuItem("Paste") {
//      peer.setAction(new DefaultEditorKit.PasteAction())
//      text = "Paste"
//      peer.setMnemonic(VK_P)
//    }
    contents += new MenuItem("Delete") {
//      peer.setAction(frame.editor.textPane.getActionMap().get(DefaultEditorKit.deletePrevCharAction))
      text = "Delete"
      peer.setMnemonic(VK_D)
    }
    contents += new Separator
    contents += new MenuItem("Select All") {
//      peer.setAction(frame.editor.textPane.getActionMap().get(DefaultEditorKit.selectAllAction))
      text = "Select All"
      peer.setMnemonic(VK_A)
    }
    contents += new Separator
    contents += new Menu("Font Size") {
      contents += new MenuItem("14") {
        reactions += {
          case swing.event.ButtonClicked(_) =>
//          frame.editor.changeFontSize(14)
        }
      }
      contents += new MenuItem("24") {
        reactions += {
          case swing.event.ButtonClicked(_) =>
//          frame.editor.changeFontSize(24)
        }
      }
    }
  }
  
  contents += new Menu("Help"){
    contents += new Menu("Documentation") {
      contents += new MenuItem("Tutorials") {
        reactions += {
            case swing.event.ButtonClicked(_) => () // TODO fill this in
        }
      }
    }
    contents += new Separator
    if (Escalator.onOSX) {
      OSXHelper.setAboutHandler(Escalator.showAbout)
    } else {
      contents += new MenuItem("About Escalator") {
        reactions += {
          case swing.event.ButtonClicked(_) =>
            Escalator.showAbout
        }
      }
    }
    contents += new MenuItem("Escalator Home") {
      reactions += {
        case swing.event.ButtonClicked(_) => BareBonesBrowserLaunch.openURL("http://scales.csc.depauw.edu/")
      }
    }
    contents += new Menu("Bug Reporting") {
      contents += new MenuItem("New ticket") {
        reactions += {
          case swing.event.ButtonClicked(_) => BareBonesBrowserLaunch.openURL("http://twiki.csc.depauw.edu/projects/scales/newticket")
        }
      }
      contents += new MenuItem("View existing tickets") {
        reactions += {
          case swing.event.ButtonClicked(_) => BareBonesBrowserLaunch.openURL("http://twiki.csc.depauw.edu/projects/scales/report")
        }
      }
    }
  }
}
