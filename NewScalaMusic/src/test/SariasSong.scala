package test
import jm.JMC
import jm.music.data._
import jm.util._
import jm.constants.Pitches._
import jm.constants.Durations._
import jm.constants.ProgramChanges._
 
object SariasSong
{
        val hd: Double = DOTTED_QUARTER_NOTE
        val h: Double = QUARTER_NOTE
        val q: Double = EIGHTH_NOTE
        val qd: Double = DOTTED_EIGHTH_NOTE
        val i: Double = SIXTEENTH_NOTE 
        val s: Double = THIRTYSECOND_NOTE 
  	//val tempo: Double = 60.0
          
    def main(args: Array[String])
    {
        val p1: Phrase = new Phrase()
        p1.addNote(new Note(F5,i))
        p1.addNote(new Note(A5,i))
        p1.addNote(new Note(B5,q))
        p1.addNote(new Note(F5,i))
        p1.addNote(new Note(A5,i))
        p1.addNote(new Note(B5,q))
        
        p1.addNote(new Note(F5,i))
        p1.addNote(new Note(A5,i))
        p1.addNote(new Note(B5,i))
        p1.addNote(new Note(E6,i))
        p1.addNote(new Note(D6,q))
        p1.addNote(new Note(B5,i))
        p1.addNote(new Note(C6,i))
        
        p1.addNote(new Note(B5,i))
        p1.addNote(new Note(G5,i))
        p1.addNote(new Note(E5,h+i))
        p1.addNote(new Note(D5,i))
        
        p1.addNote(new Note(E5,i))
        p1.addNote(new Note(G5,i))
        p1.addNote(new Note(E5,hd))
        
        val p2: Phrase = new Phrase()
        p2.addNote(new Note(F5,i))
        p2.addNote(new Note(A5,i))
        p2.addNote(new Note(B5,q))
        p2.addNote(new Note(F5,i))
        p2.addNote(new Note(A5,i))
        p2.addNote(new Note(B5,q))
        
        p2.addNote(new Note(F5,i))
        p2.addNote(new Note(A5,i))
        p2.addNote(new Note(B5,i))
        p2.addNote(new Note(E6,i))
        p2.addNote(new Note(D6,q))
        p2.addNote(new Note(B5,i))
        p2.addNote(new Note(C6,i))
        
        p2.addNote(new Note(E6,i))
        p2.addNote(new Note(B5,i))
        p2.addNote(new Note(G5,h+i))
        p2.addNote(new Note(B5,i))
        
        p2.addNote(new Note(G5,i))
        p2.addNote(new Note(D5,i))
        p2.addNote(new Note(E5,hd))
        
        p2.addNote(new Note(D5,i))
        p2.addNote(new Note(E5,i))
        p2.addNote(new Note(F5,q))
        p2.addNote(new Note(G5,i))
        p2.addNote(new Note(A5,i))
        p2.addNote(new Note(B5,q))
        
        
        val p3: Phrase = new Phrase()
        p3.addNote(new Note(C6,i))
        p3.addNote(new Note(B5,i))
        p3.addNote(new Note(E5,hd))
        
        p3.addNote(new Note(F5,i))
        p3.addNote(new Note(G5,i))
        p3.addNote(new Note(A5,q))
        p3.addNote(new Note(G5,i))
        p3.addNote(new Note(C6,i))
        p3.addNote(new Note(D6,q))
        
        p3.addNote(new Note(E6,i))
        p3.addNote(new Note(F6,i))
        p3.addNote(new Note(G6,qd))
        
        p3.addNote(new Note(D5,i))
        p3.addNote(new Note(E5,i))
        p3.addNote(new Note(F5,q))
        p3.addNote(new Note(G5,i))
        p3.addNote(new Note(A5,i))
        p3.addNote(new Note(B5,q))
        
        p3.addNote(new Note(C6,i))
        p3.addNote(new Note(B5,i))
        p3.addNote(new Note(E5,hd))
        
        val p4: Phrase = new Phrase()
        p4.addNote(new Note(F5,i))
        p4.addNote(new Note(E5,i))
        p4.addNote(new Note(A5,i))
        p4.addNote(new Note(G5,i))
        p4.addNote(new Note(B5,i))
        p4.addNote(new Note(A5,i))
        p4.addNote(new Note(C6,i))
        p4.addNote(new Note(B5,i))
        
        p4.addNote(new Note(D6,i))
        p4.addNote(new Note(C6,i))
        p4.addNote(new Note(E6,i))
        p4.addNote(new Note(D6,i))
        p4.addNote(new Note(F6,i))
        p4.addNote(new Note(E6,i))
        p4.addNote(new Note(B5,s))
        p4.addNote(new Note(C6,i))
        p4.addNote(new Note(A5,s))
        
        p4.addNote(new Note(B5,h))

       
        val part1: Part = new Part(p1, "Saria's Song", OCARINA)
        part1.addPhrase(p2)
        part1.addPhrase(p3)
        part1.addPhrase(p4)
        val score: Score = new Score(part1)
        //score.setTempo(tempo)
        Play.midi(score)
    }
}