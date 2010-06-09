package edu.depauw.escalatorx

import javax.swing.undo._

class InsertBlockUE extends AbstractUndoableEdit {
  override def getPresentationName = "Insert Block"
    
  override def undo() {
    super.undo()
  }
  
  override def redo() {
    super.redo()
  }
}

class DeleteBlockUE extends AbstractUndoableEdit {
  override def getPresentationName = "Delete Block"
    
  override def undo() {
    super.undo()
  }
  
  override def redo() {
    super.redo()
  }
}

class UpdateBlockUE extends AbstractUndoableEdit {
  override def getPresentationName = "Update Block"
    
  override def undo() {
    super.undo()
  }
  
  override def redo() {
    super.redo()
  }
}
