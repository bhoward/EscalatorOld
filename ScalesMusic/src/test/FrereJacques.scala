package test;

import edu.depauw.scales.music._
import Duration._

object FrereJacques {
  def main(args: Array[String]) {
    val first  = C(4, QN) + D(4, QN) + E(4, QN) + C(4, QN)
    val second = E(4, QN) + F(4, QN) + G(4, HN)
    val third  = G(4, EN) + A(4, EN) + G(4, EN) + F(4, EN) + E(4, QN) + C(4, QN)
    val fourth = C(4, QN) + G(3, QN) + C(4, HN)
    
    val pause  = R(WN) * 2
    
    val melody = first * 2 + second * 2 + third * 2 + fourth * 2
    
    val score = Score(200, melody * (pause + melody) * (pause * 2 + melody) * (pause * 3 + melody))
    score.play
  }
}