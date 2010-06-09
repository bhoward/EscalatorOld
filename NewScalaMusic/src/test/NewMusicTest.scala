package test
import jm.JMC
import jm.music.data._
import jm.util._
import jm.constants.Pitches._
import jm.constants.Durations._
import jm.constants.ProgramChanges._
 
object NewMusicTest
{
          val h: Double = HALF_NOTE
          val hd: Double = DOTTED_HALF_NOTE
          val q: Double = QUARTER_NOTE
          val qd: Double = DOTTED_QUARTER_NOTE
          val e: Double = EIGHTH_NOTE
          val ed: Double = DOTTED_EIGHTH_NOTE
          val s: Double = SIXTEENTH_NOTE
          val sd: Double = DOTTED_SIXTEENTH_NOTE
          val t: Double = THIRTYSECOND_NOTE 
          val tempo: Double = 60.0
           
    def main(args: Array[String])
    {
            /*
            val p1: Phrase = N(A6,q) | N(B6,q) | N(C6,q) & N(C4, q) | N(t) | N(A6,q) | N(B6,q) & N(C4, q) | N(C6,q) | N(A6,q) | N(B6,q) | N(C6,q) | N(t) | N(A6,q) | N(B6,q) | N(C6,q)
            val p2: Phrase = N(A5,s)| N(A5,s) | N(A5,s) & N(C4, s) | N(A5,s) & N(C4, s) | N(B5,s) & N(C4, s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) & N(C4, s) & N(B4, s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s)
            p1.setStartTime(0.0)
            p2.setStartTime(0.0)
            val part1: Part = new Part(p1, "Part1", OCARINA)
            val part2: Part = new Part(p2, "Part2", BAGPIPES)
            val score: Score = new Score()
            score.addPart(part1)
            score.addPart(part2)
            score.setTempo(tempo)
            Play.midi(score)*/
              
            val score: MyScore = new MyScore()
            
            //score.add(N(A6,q) | N(B6,q) | N(C6,q) & N(C4, q) | N(t) | N(A6,q) | N(B6,q) & N(C4, q) | N(C6,q) | N(A6,q) | N(B6,q) | N(C6,q) | N(t) | N(A6,q) | N(B6,q) | N(C6,q))
            //score.add(N(A5,s)| N(A5,s) | N(A5,s) & N(C4, s) | N(A5,s) & N(C4, s) | N(B5,s) & N(C4, s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) & N(C4, s) & N(B4, s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s))
            //score.add((N(A5,s)| N(A5,s) | N(A5,s) & N(C4, s) | N(A5,s) & N(C4, s) | N(B5,s) & N(C4, s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) & N(C4, s) & N(B4, s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s)) & (N(A5,s)| N(A5,s) | N(A5,s) & N(C4, s) | N(A5,s) & N(C4, s) | N(B5,s) & N(C4, s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) & N(C4, s) & N(B4, s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(A5,s)| N(A5,s) | N(A5,s) | N(A5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(B5,s) | N(C5,s) | N(C5,s) | N(C5,s) | N(C5,s)) )
            //score.add(N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s))
            //score.add(N(B6, e) | N(B6, e))
            //score.add(((N(B6, e) | N(B6, e)) & (N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s))) & ((N(B6, s) | N(B6, s)) & (N(A5,q) | N(A5,q) | N(A5,s) | N(A5,s))))
            //score.add(N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s) | N(A5,s))
            //score.add( N(C5,q) | N(D5, q) | N(E5, q) | N(F5, q) | N(G5, q) | N(A5, q) | N(B5, q) | N(C6, q))
            //score.add( N(C5,e) | N(D5, e) | N(E5, e) | N(F5, e) | N(G5, e) | N(A5, e) | N(B5, e) | N(C6, e))
            score.add((N(C5, e) | N(E5, e) | N(G5,q)) & (N(G4, q) | N(F4,q)))
            score.setTempo(184)
            Write.midi(score, "example2.mid")
            Play.midi(score)
            
    }
}
