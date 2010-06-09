package edu.depauw.escalatorx

import javax.swing.event._
import javax.swing.text.html.HTMLDocument

import scala.swing._
import scala.xml.Node

class RenderEditPane(doc: Doc, tabs: TabbedPane) extends Component {
  private var mgr = new Manager
  private var html = doc.toHTML(mgr)
  override lazy val peer = new javax.swing.JEditorPane("text/html", "")
  
  peer.setText(html.toString)
  peer.setEditable(false)
  peer.addHyperlinkListener(new HyperlinkListener {
    def hyperlinkUpdate(e: HyperlinkEvent) {
      if (e.getEventType == HyperlinkEvent.EventType.ACTIVATED) {
        val action = e.getURL.getQuery
        if (action startsWith "edit") {
          val id = action.substring(4)
          mgr.getFrame(id.toInt) match {
            case Some(f) => tabs.selection.page = f
            
            case None =>
              val html = peer.getDocument.asInstanceOf[HTMLDocument]                                         
              val f = new EditFrame(mgr, doc, id, html)
              mgr.setFrame(id.toInt, f)
              tabs.pages += f
          }
        } else if (action startsWith "insert") {
          val id = action.substring(6)
          val html = peer.getDocument.asInstanceOf[HTMLDocument]
          val div = html.getElement(id + "a")
          val newBlock = new Block(TextKind, Nil)
          val newId = mgr.addBlock(newBlock).toString
          val newHTML =
            (<div id={newId + "a"}>
              <small>[<a href={"?insert" + newId}>insert</a>]</small>
              <small>[<a href={"?delete" + newId}>delete</a>]</small>
              <small>[<a href={"?edit" + newId}>edit</a>]</small>
            </div>
            <div id={newId}>{newBlock.toXML(RenderStrategy)}</div>
            <hr />
            <div id={id + "a"}>
              <small>[<a href={"?insert" + id}>insert</a>]</small>
              {if (id != "0") <small>[<a href={"?delete" + id}>delete</a>]</small>}
              {if (id != "0") <small>[<a href={"?edit" + id}>edit</a>]</small>}
            </div>)
          
          if (id != "0") {
            val nextBlock = mgr.getBlock(id.toInt)
            doc.insertBefore(newBlock, nextBlock)
          } else {
            doc.append(newBlock)
          }
          
          html.setOuterHTML(div, newHTML.mkString)
          
          val f = new EditFrame(mgr, doc, newId, html)
          mgr.setFrame(newId.toInt, f)
          tabs.pages += f
        } else if (action startsWith "delete") {
          val id = action.substring(6)
          val htmldoc = peer.getDocument.asInstanceOf[HTMLDocument]
          val diva = htmldoc.getElement(id + "a")
//          val div = html.getElement(id)
          
          // TODO query first?
          val block = mgr.getBlock(id.toInt)
          doc.delete(block)
          
//          html.setOuterHTML(diva, "foo")
//          html.setOuterHTML(div, "") // doesn't work...
          // TODO what about the <hr />?
          
          // OK, let's try re-rendering the page:  (THIS IS JUST A TEST!)
          mgr = new Manager
          html = doc.toHTML(mgr)
          val pos = diva.getStartOffset
          peer.setText(html.toString)
          peer.setCaretPosition(pos) // hmm...
        }
      }
    }
  })
}
