/*package test
import jm.JMC
import jm.music.data._
import jm.util._
import jm.constants.Pitches._
import jm.constants.Durations._
import jm.constants.ProgramChanges._

//Helper Subclass for infix operations
//| is for adding Notes
//& is for adding chords, and harmonies


class SeqGroup //   extends Phrase
{
        //constructor?
        var onlyNotes: Boolean = true
        def elementList: List[N] = List()
        
        def getOnlyNotes() : boolean =
        {
          	return onlyNotes
        }
        
        def |(n: N): SeqGroup =
        {
               val p: SeqGroup = this
               //p.addNote(n.getNote)
               
               return p
        }
        
        
        def |(list: MyChord): SeqGroup = 
        {
          val phr: SeqGroup = this
          phr.addChord(list.getPitches.toArray, list.getRhythmValue.head)
          return phr
        }
        /*
        def &(phr: SeqGroup): SOMETHING =
        {
          
        }*/
}*/