package test;

object MusicTest 
{
  def main(args: Array[String])
  {
    val music: Music = new Music
    music.changeInstrument("Ocarina")
    music.addNotes("F6i A6i B6q F6i A6i B6q | F6i A6i B6i E7i D7q B6i C7i | B6i G6i E6q- E6-q. D6i | E6i G6i E6h.")
    //music.octaveHigher
    //music.octaveLower
    music.playMusic
  }
}