package edu.depauw.escalatorx

import javax.swing.text.html.HTMLDocument

import scala.swing._
import scala.collection.mutable.ListBuffer

class EditFrame(mgr: Manager, doc: Doc, id: String, html: HTMLDocument)
extends TabbedPane.Page(id, new EditFramePanel(mgr, doc, id, html)) {
}

class EditFramePanel(mgr: Manager, doc: Doc, id: String, html: HTMLDocument) extends BorderPanel {
  val block = mgr.getBlock(id.toInt)
  
  val toolbar = new BoxPanel(Orientation.Horizontal)
    
  val blockType = new ComboBox(List("Text", "File", "Fragment", "Script"))
  val blockName = new TextField
  
  blockType.selection.item = block match {
    case Block(TextKind, _) => "Text"
    case Block(FileKind(n), _) => blockName.text = n; "File"
    case Block(FragmentKind(n), _) => blockName.text = n; "Fragment"
    case Block(ScriptKind, _) => "Script"
  }
  
  toolbar.contents += new Label("Block Type:")
  toolbar.contents += blockType
  
  toolbar.contents += new Label("Name:")
  toolbar.contents += blockName
  
  val update = new Button("Update")
  
  val insertFragment = new Button("Insert Fragment") // TODO put this in a menu item?  Keyboard shortcut?
  
  toolbar.contents += update
  toolbar.contents += insertFragment
  
  val editor = new SourceEditPane(block)
  
  layout(toolbar) = BorderPanel.Position.North
  layout(editor) = BorderPanel.Position.Center
  
  reactions += {
    case event.SelectionChanged(`blockType`) => blockType.selection.item match {
      case "File" | "Fragment" => blockName.enabled = true
      case _ => blockName.enabled = false
    }
    
    case event.ButtonClicked(`update`) => {
      val newBlock = blockType.selection.item match {
        case "Text" => Block(TextKind, editor.content)
        case "File" => Block(FileKind(blockName.text), editor.content)
        case "Fragment" => Block(FragmentKind(blockName.text), editor.content)
        case "Script" => Block(ScriptKind, editor.content)
      }
      doc.replace(newBlock, block)
      mgr.setBlock(id.toInt, newBlock)
      val elt = html.getElement(id)
      html.setOuterHTML(elt, "<div id='" + id + "'>" + newBlock.toXML(RenderStrategy).toString + "</div>")
    }
    
    case event.ButtonClicked(`insertFragment`) => {
      editor.insertFragment
    }
  }
  
  listenTo(blockType.selection)
  listenTo(update)
  listenTo(insertFragment)
  // TODO also listen to frame closing -- query save if modified
  // TODO track modification, and enable/disable Update button accordingly
  
  this.size = new java.awt.Dimension(600, 400)
}
