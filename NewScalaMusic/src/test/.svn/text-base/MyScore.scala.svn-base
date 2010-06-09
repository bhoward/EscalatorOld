package test;

import jm.JMC
import jm.music.data._
import jm.util._
import jm.constants.Pitches._
import jm.constants.Durations._
import jm.constants.ProgramChanges._

class MyScore extends Score 
{
  	def this(tempo: Int) {
  	  this()
          this.setTempo(tempo)
        }
          
        def add(n: N)
        {
         	val part: Part = new Part()
                part.addNote(new Note(n.getPitch, n.getDuration), n.getStartTime)
                this.addPart(part)
        }
    
        def add(g: Group)
        {
               println("Test")
               val part: Part = new Part()
               val n: N = g.toNote(g.getList.head)
               part.addNote(new Note(n.getPitch, n.getDuration), g.getList.head._3)
               this.addPart(part)
               if(g.getList.tail != Nil) add(new Group(g.getList.tail))
        }
        
        def add(n: N, I: Int)
        {
                val part: Part = new Part()
                part.addNote(new Note(n.getPitch, n.getDuration), n.getStartTime)
                part.setInstrument(I)
                this.addPart(part)
        }
    
        def add(g: Group, I: Int)
        {
               println("Test")
               val part: Part = new Part()
               val n: N = g.toNote(g.getList.head)
               part.addNote(new Note(n.getPitch, n.getDuration), g.getList.head._3)
               part.setInstrument(I)
               this.addPart(part)
               if(g.getList.tail != Nil) add((new Group(g.getList.tail)), I)
        }
}
