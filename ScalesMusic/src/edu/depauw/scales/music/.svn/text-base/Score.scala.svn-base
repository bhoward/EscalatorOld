package edu.depauw.scales.music;

import jm.music.data.Part;

class Score(tempo: Double, music: Music, instrument: Int) {
  def play: Unit = {
    val part = new Part(instrument)
    part.setTempo(tempo)
    for (n <- music.notes) {
      part.addNote(new jm.music.data.Note(n.pitch, n.duration), n.start)
    }
    
    jm.util.Play.midi(part, false)
  }
}

object Score {
  def apply(tempo: Double, music: Music) = new Score(tempo, music, jm.constants.ProgramChanges.PIANO)
}