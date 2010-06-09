package edu.depauw.escalatorx

import scala.xml.Node

trait XMLStrategy {
  def textKind(body: List[Node]): Node
  
  def fileKind(name: String, body: List[Node]): Node
  
  def fragmentKind(name: String, body: List[Node]): Node
  
  def scriptKind(body: List[Node]): Node
  
  def includePart(name: String): Node
}

object PersistStrategy extends XMLStrategy {
  def textKind(body: List[Node]) = <text>{body}</text>
  
  def fileKind(name: String, body: List[Node]) = <code type="file" name={name}>{body}</code>
  
  def fragmentKind(name: String, body: List[Node]) = <code type="fragment" name={name}>{body}</code>
  
  def scriptKind(body: List[Node]) = <code type="script">{body}</code>
  
  def includePart(name: String) = <include name={name} />
}

object RenderStrategy extends XMLStrategy {
  def textKind(body: List[Node]) = <p>{body}</p> // TODO use a markdown renderer?  Decide how to handle embedded expressions
  
  def fileKind(name: String, body: List[Node]) =
    <div class="fileBlock">
      <strong>File: {name}</strong>
      <pre>{body}</pre>
    </div>
    
  def fragmentKind(name: String, body: List[Node]) =
    <div class="fragmentBlock">
      <strong>Fragment: {name}</strong>
      <pre>{body}</pre>
    </div>
    
  def scriptKind(body: List[Node]) =
    <div class="scriptBlock">
      <strong>Script</strong>
      <pre>{body}</pre>
    </div>
    
  def includePart(name: String) = <strong>[See {name}]</strong>
}

object EditStrategy extends XMLStrategy {
  def textKind(body: List[Node]) = <pre>{body}</pre>
  
  def fileKind(name: String, body: List[Node]) = <pre>{body}</pre>
  
  def fragmentKind(name: String, body: List[Node]) = <pre>{body}</pre>
  
  def scriptKind(body: List[Node]) = <pre>{body}</pre>
  
  def includePart(name: String) = <input type="text" value={name} />
}
