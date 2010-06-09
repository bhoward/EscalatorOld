package edu.depauw.escalator

import swing._
import swing.event._

import javax.swing.text._
import javax.swing.undo._
import javax.swing.{AbstractAction, KeyStroke}
import java.awt.event.KeyEvent._

////////////////////////////
//////  MENUS - GUI  ///////
////////////////////////////
class EscalatorMenu(frame: EscalatorFrame) extends MenuBar {
  val shortcutMask = java.awt.Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()
  def stroke(keyCode : Int) = KeyStroke.getKeyStroke(keyCode, shortcutMask)
  def altStroke(keyCode : Int) = KeyStroke.getKeyStroke(keyCode, shortcutMask + java.awt.event.InputEvent.ALT_MASK)
  
  /////////////////////////
  // 1. FILE OPERATIONS  //
  /////////////////////////
  contents += new Menu("File") {
    // NEW: create a new file
    contents += new MenuItem("New") {
      reactions += {
        case swing.event.ButtonClicked(_) => frame.editor.newDocument()
      }
      peer.setAccelerator(stroke(VK_N))
    }

    // OPEN: open a file
    contents += new MenuItem("Open...") {
      reactions += {
        case swing.event.ButtonClicked(_) => frame.editor.openDocument()
      }
    }

    // SAVE: save the current file
    contents += new MenuItem("Save"){
      reactions += {
        case swing.event.ButtonClicked(_) => frame.editor.saveDocument()
      }
      peer.setAccelerator(stroke(VK_S))
    }

    // SAVE AS: save the current file under the name specified by the user
    contents += new MenuItem("Save As..."){
      reactions += {
        case swing.event.ButtonClicked(_) => frame.editor.saveDocumentAs()
      }
      peer.setAccelerator(altStroke(VK_S))
    }

    contents += new Separator
//    contents += new Menu("Import")
//    contents += new Menu("Export")
//    contents += new Separator

    // CLOSE: close the current document
    contents += new MenuItem("Close"){
      reactions += {
        case swing.event.ButtonClicked(_) => {
          frame.editor.closeDocument( false )
        }
      }
      peer.setAccelerator(stroke(VK_W))
    }

    if (Escalator.onOSX) {
      OSXHelper.setQuitHandler(frame.editor.exit())
    } else {
      contents += new Separator

      // EXIT: exit the application
      contents += new MenuItem("Exit"){
        reactions += {
          case swing.event.ButtonClicked(_) => frame.editor.exit()
        }
      }
    }
  }

  ///////////////////////
  // 2. TEXT EDITING   //
  ///////////////////////
  contents += new Menu("Edit"){
    contents += new MenuItem("Undo") {
      peer.setAction(frame.editor.undoAction)
      peer.setAccelerator(stroke(VK_Z))
      // mnemonic = Key.U
      peer.setMnemonic(VK_U) // replace with previous line, et seq, when Key class is fixed
    }
    contents += new MenuItem("Redo") {
      peer.setAction(frame.editor.redoAction)
      peer.setAccelerator(stroke(VK_Y))
      // mnemonic = Key.R
      peer.setMnemonic(VK_R)
    }
    contents += new Separator
    contents += new MenuItem("Cut") {
      peer.setAction( new DefaultEditorKit.CutAction())
      text = "Cut"
      // mnemonic = Key.T
      peer.setMnemonic(VK_T)
    }
    contents += new MenuItem("Copy") {
      peer.setAction( new DefaultEditorKit.CopyAction())
      text = "Copy"
      // mnemonic = Key.C
      peer.setMnemonic(VK_C)
    }
    contents += new MenuItem("Paste") {
      peer.setAction( new DefaultEditorKit.PasteAction())
      text = "Paste"
      // mnemonic = Key.P
      peer.setMnemonic(VK_P)
    }
    contents += new MenuItem("Delete") {
      peer.setAction(frame.editor.textPane.getActionMap().get(DefaultEditorKit.deletePrevCharAction))
      text = "Delete"
      // mnemonic = Key.D
      peer.setMnemonic(VK_D)
    }
    contents += new Separator
    contents += new MenuItem("Select All") {
      peer.setAction(frame.editor.textPane.getActionMap().get(DefaultEditorKit.selectAllAction))
      text = "Select All"
      // mnemonic = Key.A
      peer.setMnemonic(VK_A)
    }
    contents += new Separator
    contents += new Menu("Font Size") {
      contents += new MenuItem("14") {
        reactions += {
          case swing.event.ButtonClicked(_) => frame.editor.changeFontSize(14)
        }
      }
      contents += new MenuItem("24") {
        reactions += {
          case swing.event.ButtonClicked(_) => frame.editor.changeFontSize(24)
        }
      }
    }
  }
  
  ///////////////////////
  //  3. HELP/ABOUT    //
  ///////////////////////
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
      OSXHelper.setAboutHandler(frame.editor.createAbout())
    } else {
      contents += new MenuItem("About Escalator") {
        reactions += {
          case swing.event.ButtonClicked(_) => frame.editor.createAbout()
        }
      }
    }
    contents += new MenuItem("Escalator Home") {
      reactions += {
        case swing.event.ButtonClicked(_) => BareBonesBrowserLaunch.openURL("http://twiki.csc.depauw.edu/scales") // TODO use scales.csc.depauw.edu when it works
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
