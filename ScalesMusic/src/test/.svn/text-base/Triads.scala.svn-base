package test

import edu.depauw.scales.music._
import Duration._

object Triads {
  def listToSequence (comps: List[Music]): Music = (comps foldRight (new Music(Nil))) {(x, y) => x + y}
  def listToParallel (comps: List[Music]): Music = (comps foldRight (new Music(Nil))) {(x, y) => x * y}
  
  
  //def majorScale (tonic: Music): List[Music] = tonic
  
  
  //given a root, produce major triad in 5-3 position
  def majTriad (root: Music): List[Music] = List(root,
                                                 root.transpose(4),
                                                 root.transpose(7),
                                                 root.transpose(4),
                                                 root)
  
  def minTriad (root: Music): List[Music] = List(root,
                                                 root.transpose(3),
                                                 root.transpose(7),
                                                 root.transpose(3),
                                                 root)
  
  def augTriad (root: Music): List[Music] = List(root,
                                                 root.transpose(4),
                                                 root.transpose(8),
                                                 root.transpose(4),
                                                 root)
  
  def dimTriad (root: Music): List[Music] = List(root,
                                                 root.transpose(3),
                                                 root.transpose(6),
                                                 root.transpose(3),
                                                 root)
  
  
  def majorScale (root: Music): List[Music] = List(root,
                                                   root.transpose(2),
                                                   root.transpose(4),
                                                   root.transpose(5),
                                                   root.transpose(7),
                                                   root.transpose(9),
                                                   root.transpose(11),
                                                   root.transpose(12))
                                                   
  
  def main (args: Array[String]){
    //chord and triad initial attempts
    val cM_TriadList = List(C(4, QN), E(4, QN), G(4, QN))
    val cM_Triad = (cM_TriadList foldRight (new Music(Nil))) {(x, y) => x + y}
    val cM: Music = C(4, QN) + E(4, QN) + G(4, QN) + E(4, QN) + C(4, QN)
    val cM_Chord = C(4, WN) * E(4, WN) * G(4, WN)
    //val score = Score(100, cM + cM_Chord)
    
    
    
    //blocked and arpeggiated chords built on the following roots
    val notes = List(C(4, EN), D(4, EN), E(4, EN), F(4, EN), G(4, EN))
    val majTriads = for {n <- notes} yield {listToSequence(majTriad(n)) + R(EN) +
                                              listToParallel(majTriad(n)) + R(EN)} 
    val minTriads = for {n <- notes} yield {listToSequence(minTriad(n)) + R(EN) +
                                              listToParallel(minTriad(n)) + R(EN)}
    val augTriads = for {n <- notes} yield {listToSequence(augTriad(n)) + R(EN) +
                                              listToParallel(augTriad(n)) + R(EN)} 
    val dimTriads = for {n <- notes} yield {listToSequence(dimTriad(n)) + R(EN) +	
                                              listToParallel(dimTriad(n)) + R(EN)}
    
    
    // val ascDscMajScale = majorScale ::: 
    //scala infinite list-->stream; supports same list operations, lazy evaluation
    //midi pitch max/min hard coded into list
    //shepard tones; each note not pure tone, has components of octaves above/below
    //
      
    
    val melody = listToSequence(majTriad(E(4, EN)))
    //val score = Score(100, listToSequence(dimTriads ::: minTriads ::: majTriads ::: augTriads))
    
    val score = Score(130, listToSequence(majorScale(C(4, EN))))
    score.play
  }		
}	
