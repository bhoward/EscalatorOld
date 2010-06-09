package edu.depauw.escalatorx

import javax.swing.text.{ElementIterator, PlainDocument, StyleConstants}
import javax.swing.text.html.{HTML, HTMLDocument, HTMLEditorKit}

import scala.swing.Component

class SourceEditPane(block: Block) extends Component {
  override lazy val peer = new javax.swing.JEditorPane("text/html", block.toXML(EditStrategy).toString)
  
  def content: List[Part] = {
    val html = peer.getDocument.asInstanceOf[HTMLDocument]

    for (elt <- new ElementIteratorWrapper(new ElementIterator(html))) {
      // Find the PRE element -- there should be just one
      
      val attributes = elt.getAttributes

      if (attributes.getAttribute(StyleConstants.NameAttribute) == HTML.Tag.PRE) {
        var result = List[Part]()

        for (child <- new ElementIteratorWrapper(new ElementIterator(elt))) {
          val childAttributes = child.getAttributes
          val nameAttribute = childAttributes.getAttribute(StyleConstants.NameAttribute)

          if (nameAttribute == HTML.Tag.CONTENT) {
            val startOffset = child.getStartOffset
            val endOffset = child.getEndOffset
            val length = endOffset - startOffset
            val text = html.getText(startOffset, length)

            // Merge adjacent PlainParts
            result match {
              case PlainPart(source) :: rest => result = PlainPart(source + text) :: rest
              case _ => result = PlainPart(text) :: result
            }
            
          } else if (nameAttribute == HTML.Tag.INPUT) {
            val content = childAttributes.getAttribute(StyleConstants.ModelAttribute).asInstanceOf[PlainDocument]
            
            result = IncludePart(content.getText(0, content.getLength)) :: result
          }
        }

        return result.reverse
      }
    }
    
    // Shouldn't get here
    error("No PRE element found")
  }
  
  def insertFragment {
    val html = peer.getDocument.asInstanceOf[HTMLDocument]
    val kit = peer.getEditorKit.asInstanceOf[HTMLEditorKit]
    kit.insertHTML(html, peer.getCaretPosition, "<input type='text'>", 0, 0, HTML.Tag.INPUT)
  }
}

class ElementIteratorWrapper(it: ElementIterator) extends Iterator[javax.swing.text.Element] {
  private var doesHaveNext = false // set to true if next value has been retrieved but not yet used
  
  def hasNext = {
    doesHaveNext = doesHaveNext || it.next != null
    doesHaveNext
  }
  
  def next = if (doesHaveNext) {doesHaveNext = false; it.current} else it.next
}
