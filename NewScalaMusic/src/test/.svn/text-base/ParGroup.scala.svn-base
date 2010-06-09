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


class ParGroup(pitchesList: List[Int], rhythmList: List[Double])
{
        
        var pitches: List[Int] = pitchesList
        var rhythms: List[Double] = rhythmList
        
        def addNote(n: N)
        {
                  pitches = n.getPitch :: pitches
                  rhythms = n.getRhythmValue :: rhythms
        }
        
        def getPitches: List[Int] =
        {
                  pitches
        }
        
        def getRhythmValue: List[Double] =
        {
                  rhythms
        }
        
        def &(n: N): ParGroup =
        {
                  val ParGroup = this
                ParGroup.addNote(n)
                return ParGroup
        }
        
        def |(list: ParGroup): SeqGroup =
        {
                val phr: SeqGroup = new SeqGroup()
                phr.addChord(this.getPitches.toArray, this.getRhythmValue.head)
                phr.addChord(list.getPitches.toArray, list.getRhythmValue.head)
                return phr
        }
        
        def |(n: N): SeqGroup =
        {
                val phr: SeqGroup = new SeqGroup() 
                phr.addChord(this.getPitches.toArray, this.getRhythmValue.head)
                phr.addNote(n.getNote)
                return phr
        }
        
        def addChord (n: N)
        {
          	
        }
}*/