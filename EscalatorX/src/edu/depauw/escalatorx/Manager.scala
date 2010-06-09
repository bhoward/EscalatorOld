package edu.depauw.escalatorx

class BlockHolder(var block: Block, var frame: Option[EditFrame])

class Manager {
  private var nextid = 1
  
  private var blocks = scala.collection.mutable.Map[Int, BlockHolder]()
  
  private var fragments = scala.collection.mutable.Map[String, Block]()
  
  def addBlock(block: Block): Int = {
    val holder = new BlockHolder(block, None)
    val id = nextid
    nextid += 1
    blocks(id) = holder
    
    // Record fragment blocks in the fragments map
    block.kind match {
      case FragmentKind(name) => fragments(name) = block
      case _ => // Do nothing
    }
    
    id
  }
  
  def getBlock(id: Int): Block = blocks(id).block
  
  def setBlock(id: Int, block: Block) {
    val holder = blocks(id)
    val oldBlock = holder.block
    
    holder.block = block
    
    oldBlock.kind match {
      case FragmentKind(name) => fragments.remove(name)
      case _ => // Do nothing
    }
    
    block.kind match {
      case FragmentKind(name) => fragments(name) = block
      case _ => // Do nothing
    }
  }
  
  def getFrame(id: Int): Option[EditFrame] = blocks(id).frame
  
  def setFrame(id: Int, frame: EditFrame) {
    val holder = blocks(id)
    holder.frame = Some(frame)
  }
  
  // TODO have something to clear out the Frame when it gets closed
  
  def getFragment(name: String): Block = fragments(name)
}
