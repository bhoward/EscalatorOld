package test;

import jm.JMC
import jm.music.data._
import jm.util._
import jm.constants.Pitches._
import jm.constants.Durations._
import jm.constants.ProgramChanges._

class Group(list: List[(Int, Double, Double)]) //extends Element
{
  	var startTime: double = 0.0
        var noteList: List[(Int, Double, Double)] = list
        var totalTime: Double = {
            var max: Double = 0.0
            for ((_, dur, start) <- list) {
              if (dur + start > max) max = dur + start
            }
            max
        }
        //var maxDur: Double = getMax(N(0.0),this)
        
  	def |(n: N): Group =
        {
          /*
                noteList = (n.getPitch, n.getDuration, totalTime) :: noteList
                totalTime = totalTime + n.getDuration
                return this
           */
                
                return new Group((n.getPitch, n.getDuration, totalTime) :: noteList)
        }
          
        def |(g: Group): Group =
        {
               val totalTime2: Double = totalTime + g.getTotalTime
               val newG: Group = g.shiftStart(totalTime)
               
               /*
               totalTime = totalTime2
               */
                 
               //val newG: Group = g.shiftStart(totalTime)
               //totalTime = totalTime + newG.getTotalTime
               
               /*
               noteList = noteList ::: newG.getList
               return this
               */
               return new Group(noteList ::: newG.getList)
        }
        
        def &(n: N): Group =
        {
          /*
          	totalTime = getMax(n, this)
                noteList = (n.getPitch, n.getDuration, startTime) :: noteList
                return this
           */
             return new Group((n.getPitch, n.getDuration, startTime) :: noteList)
        }
        
        def &(g: Group): Group =
        {
          /*
                totalTime = getMax(g, this)
                noteList = noteList ::: g.getList
                return this
           */
             return new Group(noteList ::: g.getList)
        }
        
        def *(n: Int): Group =
          if (n <= 0) new Group(Nil)
          else this | this * (n - 1)
        
        def getStartTime(): Double =
        {
                return startTime
        }
        
        def addNote(pitch: Int,dur: Double,startTime: Double)
        {
          	noteList = (pitch, dur, startTime) :: noteList
                if (startTime + dur > totalTime) totalTime = startTime + dur
        }
        
        def getMax(n: N, g: Group): Double =
        {
          	if(g.getTotalTime > n.getDuration) g.getTotalTime else n.getDuration
        }
        
        def getMax(g1: Group, g2: Group): Double =
        {
                if(g1.getTotalTime > g2.getTotalTime) g1.getTotalTime else g2.getTotalTime
        }
        /*def getMax(n: N, g: Group): Double =
        {
          	if (g.getList.tail == null)
                {
                    if (n.getDuration > g.getList.head._2) 
                      { 
                          n.getDuration
                      }
                      else g.getList.head._2
                }

                else getMax(toNote(g.getList.head), new Group(g.getList.tail))
        }*/
        
        def getList(): List[(Int, Double, Double)] =
        {
          	noteList
        }
        
        def toNote(list: (Int, Double, Double)): N =
        {
           	N(list._1, list._2)
        }
        
        def getTotalTime: Double =
        {
          	totalTime
        }
        
        def changeTotalTime(newTime: Double)
        {
          	totalTime = newTime
        }
        
        def shiftDur(dur: Double): Group =
        {
          	val g: Group = new Group(noteList.map(x => (x._1, x._2 + dur, x._3)))
                return g
        }
        
        def shiftStart(offset: Double): Group =
        {
                val g: Group = new Group(noteList.map(x => (x._1, x._2, x._3 + offset)))
                return g
        }
}
