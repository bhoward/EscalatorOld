package rover

object RoverTest extends Application 
{
  val rov: Rover = new Rover("I 1.0 2.22 3.333 4.4444 5.55555 6.666666 7.7777777 8.88888888 ;")
  println("The map length is: " + rov.mapx)
  println("The map height is: " + rov.mapy)
  println("The map time limit is: " + rov.timeLimit)
  println("The rover's min sensor is: " + rov.minSensor)
  println("The rover's max sensor is: " + rov.maxSensor)
  println("The rover's max speed is: " + rov.maxSpeed)
  println("The rover's max speed is: " + rov.maxSpeed)
  println("The rover's max turning speed is: " + rov.maxTurn)
  println("The rover's max hard turning speed is: " + rov.maxHardTurn)
}
