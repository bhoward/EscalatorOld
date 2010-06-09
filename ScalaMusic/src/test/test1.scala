package test
import org.jfugue._

object test1
{
  	def main(args: Array[String])
        {
                val player:Player = new Player;
                val pattern:Pattern = new Pattern("I[Ocarina] F6i A6i B6q F6i A6i B6q | F6i A6i B6i E7i D7q B6i C7i | B6i G6i E6q- E6-q. D6i | E6i G6i E6h.");
                val pattern2:Pattern = new Pattern("I[Ocarina] F6i A6i B6q F6i A6i B6q | F6i A6i B6i E7i D7q B6i C7i | E7i B6i G6q- G6-q. B6i | G6i D6i E6h. | D6i E6i F6q G6i A6i B6q");
                val pattern3:Pattern = new Pattern("I[Ocarina] C7i B6i E6h. | F6i G6i A6q G6i C7i D7q | E7i F7i G7q. | D6i E6i F6q G6i A6i B6q | C7i B6i E6h.");
                val pattern4:Pattern = new Pattern("I[Ocarina] F6i E6i A6i G6i B6i A6i C7i B6i | D7i C7i E7i D7i F7i E7i B6s C7i A6s | B6h");
                val song:Pattern = new Pattern();
                song.add(pattern);
                song.add(pattern2);
                song.add(pattern3);
                song.add(pattern4);
                player.play(song);       
        }
}