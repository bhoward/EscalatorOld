package test;

import jm.constants.Pitches._
import jm.constants.Durations._
import jm.util.Play

object FrereJacques {
  def main(args: Array[String]) {
    val h = HALF_NOTE
    val q = QUARTER_NOTE
    val e = EIGHTH_NOTE
    
    val first  = N(C5, q) | N(D5, q) | N(E5, q) | N(C5, q)
    val second = N(E5, q) | N(F5, q) | N(G5, h)
    val third  = N(G5, e) | N(A5, e) | N(G5, e) | N(F5, e) |
                 N(E5, q) | N(C5, q)
    val fourth = N(C5, q) | N(G4, q) | N(C5, h)
    val pause  = N(WHOLE_NOTE) * 2
    
    val melody = first * 2 | second * 2 | third * 2 | fourth * 2
    
    val score = new MyScore(100) // 100 beats per minute
    score.add(melody &
              (pause | melody) &
              (pause * 2 | melody) &
              (pause * 3 | melody))
    
    Play.midi(score)
  }
}