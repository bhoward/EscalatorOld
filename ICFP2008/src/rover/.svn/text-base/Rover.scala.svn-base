package rover

class Rover 
{
  
  var mapx: Double
  var mapy: Double
  var timeLimit: Double
  var minSensor: Double
  var maxSensor: Double
  var maxSpeed: Double
  var maxTurn: Double
  var maxHardTurn: Double
  
  var turnSpeed: Double
  var hardTurnSpeed: Double
  
  var timeStamp: Double
  var currentVehAcc: Char
  var currentVehTurn: Char
  var currentX: Double
  var currentY: Double
  var currentDir: Double
  var currentSpeed: Double
  
  //MAPSCALE is how many array indices go into one meter. With a MAPSCALE of ten, 
  //each array index represents .1 meters
  var map: Array[Array[Char]]
  val MAPSCALE: int = 10
  // ugly, but couldn't think of nicer way of doing it at the time
  // constructor takes the initialization string and initializes the appropriate variables
  def Rover(init: String)
  {
    var initC: Array[Char] = init.toCharArray()
    var i: int = 0
    var wSpace = 0
    while(i < initC.length)
    {
      if(initC[i] == " ")
      {
          var j:int = i
          while(initC[j] != " ")
          {
            j = j + 1
          }
          
          if(wSpace == 0)
          {
              mapx = buildAsDouble(initC,i,j)
              wSpace = wSpace + 1
          }
          else if(wSpace == 1)
          {
              mapy = buildAsDouble(initC,i,j)
              wSpace = wSpace + 1
          }
          else if(wSpace == 2)
          {
              timeLimit = buildAsDouble(initC,i,j)
              wSpace = wSpace + 1
          }
          else if(wSpace == 3)
          {
              minSensor = buildAsDouble(initC,i,j)
              wSpace = wSpace + 1
          }
          else if(wSpace == 4)
          {
              maxSensor = buildAsDouble(initC,i,j)
              wSpace = wSpace + 1
          }
          else if(wSpace == 5)
          {
              maxSpeed = buildAsDouble(initC,i,j)
              wSpace = wSpace + 1
          }
          else if(wSpace == 6)
          {
              maxTurn = buildAsDouble(initC,i,j)
              wSpace = wSpace + 1
          }
          else if(wSpace == 7)
          {
              maxHardTurn = buildAsDouble(initC,i,j)
              wSpace = wSpace + 1
          }
          i = i + 1
      }
      else
        i = i + 1
    }
    
    map = new Array[new Array[Char](mapy*MAPSCALE)](mapx*MAPSCALE)
  }
  
  //builds string from array indices a and b (b not inclusive)
  def buildAsDouble(ar: Array[Char],a: int, b: int): Double
  {
    var ar2 = new Array[Char](a - b)
    while(a != b)
    {
      ar2[a] = ar[a]
      a = a + 1
    }
    return ar2.toString().asDouble
  }
  
  
  
  // When called, slows down and rotates in place untill the entire area around the rover is seen
  def syncRotate(): String
  {
    //turnSpeed = 
  }
  
  //Given a start
  def calculateRotation(theta1: Double, theta2: Double)
  {
    
  }
  
  def syncHardRotate()
  {
    //hardTurnSpeed =
  }
  
  def calculateNextMove(telemetryMessage: String): String
  {
    decodeTMessage(telemetryMessage)
    //return message
  }
  
  //will set the appropriate global variables and then update the map with objects
  def decodeTMessage(tString: String)
  {
    
  }
  
}
