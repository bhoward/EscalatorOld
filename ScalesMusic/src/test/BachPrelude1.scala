package test

import edu.depauw.scales.music._
import Duration._


object BachPrelude1 {
  
  def listToSequence (comps: List[Music]): Music = (comps foldRight (new Music(Nil))) {(x, y) => x + y}
  def listToParallel (comps: List[Music]): Music = (comps foldRight (new Music(Nil))) {(x, y) => x * y}
  def measure (comps1: List[Music], comps2: List[Music]): Music =
    listToSequence(comps1) + (listToSequence(comps2) * 2)
    
    //(((comps2 foldRight (new Music(Nil))) {(x, y) => x + y}) * 2)
  def main (args: Array[String]){
  /*  val m1_LH = C(4, EN) + E(4, EN)
    //val m1_RH = G(4, EN) + C(5, EN) + E(5, EN) + G(4, EN) + C(5, EN) + E(5, EN)
    val m1_RH = (G(4, EN) + C(5, EN) + E(5, EN)) * 2
    val m1 = m1_LH + m1_RH
    
    
    val m3_LH = C(4, EN) + D(4, EN)
    //val m3_RH = m1_RH.transpose(1)
    //val m3_RH = A(4, EN) + D(5, EN) + F(5, EN) + A(4, EN) + D(5, EN) + F(5, EN)
    val m3_RH = (A(4, EN) + D(5, EN) + F(5, EN)) * 2
    val m3 = m3_LH + m3_RH
    
    val m5_LH = B(3, EN) + D(4, EN)
    val m5_RH = (G(4, EN) + D(5, EN) + F(5, EN)) * 2
    val m5 = m5_LH + m5_RH
    
    val m9_RH = (A(4, EN) + E(5, EN) + A(5, EN)) * 2
    val m9 = m1_LH + m9_RH
    
    val m11_RH = (Fs(4, EN) + A(4, EN) + D(5, EN)) * 2
    val m11 = m3_LH + m11_RH
    
    
    val phrase1 = m1 * 2 + m3 * 2 + m5 * 2 //measures 1-6
    val phrase2 = m1 * 2 + m9 * 2 + m11 * 2 //measures 7-12
    
    val melody = phrase1 + phrase2
    */
    
    val m1 = measure(List(C(4, EN), E(4, EN)), List(G(4, EN), C(5, EN), E(5, EN)))
    val m3 = measure(List(C(4, EN), D(4, EN)), List(A(4, EN), D(5, EN), F(5, EN)))
    val m5 = measure(List(B(3, EN), D(4, EN)), List(G(4, EN), D(5, EN), F(5, EN)))
    val m9 = measure(List(C(4, EN), E(4, EN)), List(A(4, EN), E(5, EN), A(5, EN)))
    val m11 = measure(List(C(4, EN), D(4, EN)), List(Fs(4, EN), A(4, EN), D(5, EN)))
    val m13 = measure(List(B(3, EN), D(4, EN)), List(G(4, EN), D(5, EN), G(5, EN)))
    val m15 = measure(List(B(3, EN), C(4, EN)), List(E(4, EN), G(4, EN), C(5, EN)))
    val m17 = measure(List(A(3, EN), C(4, EN)), List(E(4, EN), G(4, EN), C(5, EN)))
    val m19 = measure(List(D(3, EN), A(3, EN)), List(D(4, EN), Fs(4, EN), C(5, EN)))
    val m21 = measure(List(G(3, EN), B(3, EN)), List(D(4, EN), G(4, EN), B(4, EN)))
    val m23 = measure(List(G(3, EN), Bf(3, EN)), List(E(4, EN), G(4, EN), Cs(5, EN)))
    val m25 = measure(List(F(3, EN), A(3, EN)), List(D(4, EN), A(4, EN), D(5, EN)))
    val m27 = measure(List(F(3, EN), Af(3, EN)), List(D(4, EN), F(4, EN), B(4, EN)))
    val m29 = measure(List(E(3, EN), G(3, EN)), List(C(4, EN), G(4, EN), C(5, EN)))
    val m31 = measure(List(E(3, EN), F(3, EN)), List(A(3, EN), C(4, EN), F(4, EN)))
    val m33 = measure(List(D(3, EN), F(3, EN)), List(A(3, EN), C(4, EN), F(4, EN)))
    val m35 = measure(List(G(2, EN), D(3, EN)), List(G(3, EN), B(3, EN), F(4, EN)))
    val m37 = measure(List(C(3, EN), E(3, EN)), List(G(3, EN), C(4, EN), E(4, EN)))
    val m39 = measure(List(C(3, EN), G(3, EN)), List(Bf(3, EN), C(4, EN), E(4, EN)))
    val m41 = measure(List(F(2, EN), F(3, EN)), List(A(3, EN), C(4, EN), E(4, EN)))
    val m43 = measure(List(Fs(2, EN), C(3, EN)), List(A(3, EN), C(4, EN), Ef(4, EN)))
    val m45 = measure(List(Af(2, EN), F(3, EN)), List(B(3, EN), C(4, EN), D(4, EN)))
    val m47 = measure(List(G(2, EN), F(3, EN)), List(G(3, EN), B(3, EN), D(4, EN)))
    val m49 = measure(List(G(2, EN), E(3, EN)), List(G(3, EN), C(4, EN), E(4, EN)))
    val m51 = measure(List(G(2, EN), D(3, EN)), List(G(3, EN), C(4, EN), F(4, EN)))
    val m53 = measure(List(G(2, EN), D(3, EN)), List(G(3, EN), B(3, EN), F(4, EN)))
    val m55 = measure(List(G(2, EN), Ef(3, EN)), List(A(3, EN), C(4, EN), Fs(4, EN)))
    val m57 = measure(List(G(2, EN), E(3, EN)), List(G(3, EN), C(4, EN), G(4, EN)))
    val m59 = measure(List(G(2, EN), D(3, EN)), List(G(3, EN), C(4, EN), F(4, EN)))
    val m61 = measure(List(G(2, EN), D(3, EN)), List(G(3, EN), B(3, EN), F(4, EN)))
    val m63 = measure(List(C(2, EN), C(3, EN)), List(G(3, EN), Bf(3, EN), E(4, EN)))
    val m65 = listToSequence(List(C(2, EN), C(3, EN), F(3, EN), A(3, EN), C(4, EN), F(4, EN), C(4, EN), A(3, EN)))
    val m66 = listToSequence(List(C(4, EN), A(3, EN), F(3, EN), A(3, EN), F(3, EN), D(3, EN), F(3, EN), D(3, EN)))
    val m67 = listToSequence(List(C(2, EN), B(2, EN), G(4, EN), B(4, EN), D(5, EN), F(5, EN), D(5, EN), B(4, EN)))
    val m68 = listToSequence(List(D(5, EN), B(4, EN), G(4, EN), B(4, EN), D(4, EN), F(4, EN), E(4, EN), D(4, EN)))
    val m69 = listToParallel(List(C(2, WN), C(3, WN), E(4, WN), G(4, WN), C(5, WN)))
    
    val singleMeasures = List(m1, m3, m5, m1, m9, m11, m13, m15, m17, m19, m21, m23, m25, m27, m29, m31, m33, m35,
                              m37, m39, m41, m43, m45, m47, m49, m51, m53, m55, m57, m59, m61, m63)
    val doubleMeasures = singleMeasures.map(m => m * 2)
    
    val melody = listToSequence(doubleMeasures ::: List(m65, m66, m67, m68, m69))
    val score = Score(130, melody)
    //val melody = m1 + m1 + m3 + m3
    //val melody = m1 * 2 + m3 * 2 + m5 * 2 + m1 * 2
  
    //val score = Score(100, melody)
    //val score = Score(100, phrase2)
    score.play	
    }
  
}
