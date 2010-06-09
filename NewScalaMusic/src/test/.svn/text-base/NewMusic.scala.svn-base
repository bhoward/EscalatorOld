package test
import jm.JMC
import jm.music.data._
import jm.util._
import jm.constants.Pitches._
import jm.constants.Durations._
import jm.constants.ProgramChanges._
 
object NewMusic
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
  	val tempo: Double = 120.0
           
    def main(args: Array[String])
    {
        println("Java works")
        val p1: Phrase = new Phrase()
        //p1.setTempo(tempo)
        p1.addNote(new Note(F5,s))
        p1.addNote(new Note(A5,s))
        p1.addNote(new Note(B5,e))
        p1.addNote(new Note(F5,s))
        p1.addNote(new Note(A5,s))
        p1.addNote(new Note(B5,e))
        
        p1.addNote(new Note(F5,s))
        p1.addNote(new Note(A5,s))
        p1.addNote(new Note(B5,s))
        p1.addNote(new Note(E6,s))
        p1.addNote(new Note(D6,e))
        p1.addNote(new Note(B5,s))
        p1.addNote(new Note(C6,s))
        
        p1.addNote(new Note(B5,s))
        p1.addNote(new Note(G5,s))
        p1.addNote(new Note(E5,q+s))
        p1.addNote(new Note(D5,s))
        
        p1.addNote(new Note(E5,s))
        p1.addNote(new Note(G5,s))
        p1.addNote(new Note(E5,qd))
        
        
        val part1: Part = new Part(p1, "Part1", OCARINA)
        val score: Score = new Score(part1)
        score.setTempo(tempo)
        Play.midi(score)
    }
}