package test

import jm.JMC
import jm.music.data._
import jm.util._
import jm.constants.Pitches._
import jm.constants.Durations._
import jm.constants.ProgramChanges._

//Helper Subclass for infix operations
// | is for adding Notes
// & is for adding chords, and harmonies
 

class N(note: Note) //extends Element
{
       val startTime: double = 0.0
  
       def |(n: N): Group =
       {
           val g: Group = new Group(List((this.getPitch, this.getDuration, startTime)))
           g.addNote(n.getPitch, n.getDuration, startTime + this.getDuration)
           return g
       }
    
       def |(g: Group): Group =
       {
           val newG: Group = new Group(List((this.getPitch, this.getDuration, startTime)) ::: g.shiftStart(this.getDuration + startTime).getList)
           return newG
       }
  
       def &(n: N): Group =
       {
           val g: Group = new Group(List((this.getPitch, this.getDuration, startTime)))
           g.addNote(n.getPitch, n.getDuration, startTime)
           return g
       }
    
       def &(g: Group): Group =
       {
           val newG: Group = new Group(List((this.getPitch, this.getDuration, startTime)) ::: g.getList)
           return newG
       }
       
       def *(n: Int): Group =
         if (n <= 0) new Group(Nil)
         else this | this * (n - 1)
       
       def getStartTime(): Double =
       {
           return startTime
       }
       
       def getPitch(): Int =
       {
           return note.getPitch
       }
       
       def getDuration(): Double =
       {
           return note.getDuration
       }
       
       def max(n1: N, n2: N): Double =
       {
         	if (n1.getDuration > n2.getDuration) n1.getDuration else n2.getDuration
       }
       
       def getMax(n: N, g: Group): Double =
       {
                 if(g.getTotalTime > n.getDuration) g.getTotalTime else n.getDuration
       }
       
       def getMax(g1: Group, g2: Group): Double =
       {
                 if(g1.getTotalTime > g2.getTotalTime) g1.getTotalTime else g2.getTotalTime
       }
}




/*
class N(note: Note)
{
          
      def |(note2: N): SeqGroup =
      {
            val phr: SeqGroup = new SeqGroup()
            phr.addNote(note)
            phr.addNote(note2.getNote)
            return phr
      }
        
      def |(list: MyChord): SeqGroup =
      {
            val phr: SeqGroup = new SeqGroup()
            phr.addNote(note)
            phr.addChord(list.getPitches.toArray, list.getRhythmValue.head)
            return phr
      }
      
      def &(note2: N): SeqGroup =
      {
        	var listPitches: List[Int] = List(note.getPitch)
                listPitches = note2.getPitch :: listPitches
                
                var listRhythmValues: List[Double] = List(note.getRhythmValue)
                listRhythmValues = note2.getRhythmValue :: listRhythmValues
                
        	var myChord: MyChord = new MyChord(listPitches, listRhythmValues)
                return myChord
      }
      
      def getPitch: Int =
      {
        	note.getPitch
      }
      
      def getNote: Note =
      {
        	note
      }
      
      def getRhythmValue: Double =
      {
        	note.getRhythmValue
      }
}
*/
object N
{
  	def apply(freq: Int, dur: Double): N =
            	new N(new Note(freq, dur))
                    
        def apply(dur: Double): N =
                new N(new Rest(dur))            
}