package edu.depauw.escalatorx

import javax.swing.undo._

class ChangeManager extends UndoManager {
  // This is ugly, and assumes that only addEdit/undo/redo are called, and addEdit never combines edits
  // Also, all edits are assumed significant
  var marker = 0
  
  def setClean() = marker = 0
  
  def isDirty = marker != 0
  
  override def addEdit(edit: UndoableEdit): Boolean = {
    marker += 1
    super.addEdit(edit)
  }
  
  override def undo() {
    marker -= 1
    super.undo()
  }
  
  override def redo() {
    marker += 1
    super.redo()
  }
  
  def revert() {
    while (marker > 0) undo()
    while (marker < 0) redo()
  }
}
