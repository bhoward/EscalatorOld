package edu.depauw.escalatorx

import java.io._

import scala.xml.Node

class Doc(val title: String, var blocks: Seq[Block]) {
  def toXML = <document title={title}>{
    for (block <- blocks) yield block.toXML(PersistStrategy)
  }</document>
    
  // TODO add in SyntaxHighlighter, or equivalent
  // TODO convert arrows?  <- = 2190, => = 21D2
  // TODO write a tangler (extract source files into correct directories)
  def toHTML(mgr: Manager) =
    <html>
      <head>
        <title>{title} - Escalator</title>
        <base href={new java.net.URI("file", null, "/" + title, null).toString} />
        <style type="text/css">
          div.fileBlock {{
            background-color: #FFFFC0;
            border-style: solid;
            border-width: 1px;
            padding: 2px;
          }}
          div.fragmentBlock {{
            background-color: #C0FFFF;
            border-style: solid;
            border-width: 1px;
            padding: 2px;
          }}
          div.scriptBlock {{
            background-color: #FFC0FF;
            border-style: solid;
            border-width: 1px;
            padding: 2px;
          }}
          a {{text-decoration: none;}}
        </style>
      </head>
      <body>{
        for (block <- blocks) yield {
          val id = mgr.addBlock(block)
          
          <div id={id.toString + "a"}>
            <small>[<a href={"?insert" + id}>insert</a>]</small>
            <small>[<a href={"?delete" + id}>delete</a>]</small>
            <small>[<a href={"?edit" + id}>edit</a>]</small>
          </div>
          <div id={id.toString}>{block.toXML(RenderStrategy)}</div>
          <hr />
        }
      }
        <div id="0a">
          <small>[<a href="?insert0">insert</a>]</small>
        </div>
      </body>
    </html>
      
  // remember to do this when inserting a new block in the HTML
  def insertBefore(newBlock: Block, nextBlock: Block) {
    val i = blocks.findIndexOf(nextBlock eq _)

    blocks = blocks.take(i) ++ Array(newBlock) ++ blocks.drop(i)
  }
  
  def append(newBlock: Block) {
    blocks = blocks ++ Array(newBlock)
  }
  
  def delete(block: Block) {
    val i = blocks.findIndexOf(block eq _)
    
    blocks = blocks.take(i) ++ blocks.drop(i+1)
  }
  
  // remember to do this when done editing a block in the HTML
  def replace(newBlock: Block, oldBlock: Block) {
    val i = blocks.findIndexOf(oldBlock eq _)
    
    blocks = blocks.take(i) ++ Array(newBlock) ++ blocks.drop(i+1)
  }
  
  def tangle(mgr: Manager, dir: File) {
    for (Block(FileKind(name), contents) <- blocks) {
      using(new BufferedWriter(new FileWriter(new File(dir, name)))) { writer =>
        writeContents(writer, contents, mgr)
      }
    }
  }
  
  def writeContents(writer: Writer, contents: List[Part], mgr: Manager) {
    for (part <- contents) part match {
      case PlainPart(text) => writer.write(text)
      case IncludePart(name) => {
        val block = mgr.getFragment(name)
        writeContents(writer, block.contents, mgr) // TODO worry about infinite loops!
      }
    }
  }
  
  def save(file: File) {
    using(new BufferedWriter(new FileWriter(file))) { writer =>
      writer.write(toXML.toString)
    }
  }
  
  // From Martin Odersky, FOSDEM 2009
  def using[T <: { def close() }](resource: T)(block: T => Unit) {
    try {
      block(resource)
    } finally {
      if (resource != null) resource.close()
    }
  }
}

object Doc {
  def fromXML(node: Node) = {
    val title = (node \\ "@title").text
    val blocks = for (n <- node.child if n.label != "#PCDATA") yield Block.fromXML(n)
    new Doc(title, blocks)
  }
}