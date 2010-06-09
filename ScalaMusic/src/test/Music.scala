package test
import org.jfugue._

class Music
{
  
  	/*
  		@Author Dan Mateas
  		@June 28 2007
  	*/
  
  
  
        /* Global Variables representing each part needed to create the String to play
           Defaults: same as defined by the JFugue library
        */
          
  	var instrument: String = "Piano"
        var tempo: String = "120"
        var notes: String = ""
        var voice: String = "0"
        var key: String = "Cbmaj"
        var pattern: Pattern = new Pattern("")
	val player: Player = new Player
        
        //Call this function to build the Pattern based on the Global Variables
        def playMusic
        {
                var pattern:Pattern = new Pattern("K" + key + " T" + tempo + " v" + voice + " I[" + instrument + "] " + notes)
     		player.play(pattern)   
     		println(pattern)
        }
          
        //Adds notes to play
        def addNotes(newNotes: String): Unit =
        {
                notes = notes + newNotes
                return
        }
        
        //Change the Tempo
        def changeTempo(newTempo: String): Unit = 
        {
          	tempo = newTempo
                return  
        }
        
        //Change the Instrument
        def changeInstrument(newInstrument: String): Unit = 
        {
                instrument = newInstrument
                return
        }
        
        //Change the voice (if you want mulitple patterns played simultainiously
        def changeVoice(newVoice: String): Unit = 
        {
                voice = newVoice
                return
        }
        
        //Change the key
        def changeKey(newKey: String): Unit = 
        {
                key = newKey
                return
        }
        
        //Shell for changing the octave
        def octaveHigher: Unit =
        {
          	notes = octaveHigherShell(notes)
        }
        
        /*The way the octave works is that when you create a string of notes, you define the octave for each
          individual note. Therefore, to change all the octaves either higher, or lower, you must search through
          the String for a character corresponding to a number(as a number in Notes can only represend octave,
          then replace that character with the next higher number character. More notes in the details of this 
          in the method.          
          */
        
        
        def octaveHigherShell(n: String): String = 
        {
          	//println("Got to Function")
          	
                //The final String of notes that will be returned, and which we will be putting our result in
          	var notesFinal: String = ""
                    
                //changing the notes to an array so we can search through it
          	var arrayNotes: Array[Char] = n.toArray
                  
                /*we want to search through the array one by one, and while we have not found a number.
                Once we have found a number, we will split the array into two pieces, ArrayBeggining and ArrayEnd
                with the last element of ArrayBeggining be the number we found, only replaced with the next higher
                octave. ArrayEnd will then be the rest of the string.
                We will then set notesFinal = ArrayBeggining + octaveHigher(ArrayEnd), and continue untill the String
                hass been exhausted.
                */
                var i: Int = 0
                var found: Boolean = false
               while(i < n.length && !found)
               {
                  	
                        //We can create arrayNotesBeggining and arrayNotesEnd at the start of each iteration 
                        //of the loop, and use them only if we find a number.
                        
                        var j: Int = 0
                        var arrayNotesBeggining = new Array[Char] (i + 1)
                        while(j <= i)
                        {
                          //println("making beggining array")
                          arrayNotesBeggining(j) = arrayNotes(j)
                          j = j + 1
                        }
                          
                        var k: Int = 0
                        var arrayNotesEnd = new Array[Char] (arrayNotes.length - i - 1)
                        while(k < (arrayNotes.length - i - 1))
                        {
                          arrayNotesEnd(k) = arrayNotes(i + k + 1)
                          k = k + 1
                        }
                        
                        
                        //So far, I am doing this with If statements, and looking for each number in order. I'm sure
                        //there's a better way to do it, which I will work on as soon as i get this to work
                        
                        
                        //The numbers 1 and 10 are special. Since the highest octave is 10, my program will not change
                        //its value if found. But since octave 10 is two characters long, when i come across a '1' i
                        //have to first check to see if there is anything but a '0' after it. If there isn't a 0, it will 
                        //replace it with a 2 at the end of ArrayBeggining, update notesFinal, call the function recursivly,
                        //and set found = true to break out of the loop. If it finds a zero, it will continue searching
                        //Since the lowest octave is 1, i do not need to put a special case if it finds a 0.
                        
                  	if (arrayNotes(i) == '1')
                        {
                          if(arrayNotes(i + 1) != '0')
                          {
                  	    arrayNotesBeggining(i) = '2'
                            notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveHigherShell(arrayNotesEnd.mkString("", "", ""))
                            found = true
                          }
                        }
                        if (arrayNotes(i) == '2')
                        {
                              arrayNotesBeggining(i) = '3'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveHigherShell(arrayNotesEnd.mkString("", "", ""))
                              found = true  
                        }
                        if (arrayNotes(i) == '3')
                        {
                              arrayNotesBeggining(i) = '4'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveHigherShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        if (arrayNotes(i) == '4')
                        {
                              arrayNotesBeggining(i) = '5'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveHigherShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        if (arrayNotes(i) == '5')
                        {
                              arrayNotesBeggining(i) = '6'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveHigherShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        if (arrayNotes(i) == '6')
                        {
                              //println("Found 6")
                              arrayNotesBeggining(i) = '7'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveHigherShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        if (arrayNotes(i) == '7')
                        {
                              arrayNotesBeggining(i) = '8'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveHigherShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        if (arrayNotes(i) == '8')
                        {
                              arrayNotesBeggining(i) = '9'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveHigherShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        
                        
                        //case 9 is slightly different in that you have to replace the nine with a 1, then make 
                        //notesBegginingg(string) be the arrayNotesBeggining + the string 0
                        
                        if (arrayNotes(i) == '9')
                        {
                              arrayNotesBeggining(i) = '1'
                              
                              var NotesBeggining:String = arrayNotesBeggining.mkString("", "", "") + "0"
			      notesFinal = NotesBeggining + octaveHigherShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        
                        //Base Case: if i is equal to the length minus 1, it is at the end of the string. therefore
                        //return notesBeggining, which is the remainder of the string since the last number found
                        if(i == (n.length - 1))
                        {
                          notesFinal = arrayNotesBeggining.mkString("","","")
                        }
                        
                        //if no number are found ,and you're not at the end of the string, iterate and try again
                        i = i + 1
                }
                  
                //when i'm done with all my looping and recursion, i return notesFinal
                return notesFinal
        }

        def octaveLower: Unit =
        {
                  notes = octaveLowerShell(notes)
        }
        
        /*Octave lower is pretty much the same thing as Octave higher, only lowering the notes        
          */
        
        
        def octaveLowerShell(n: String): String = 
        {
               var notesFinal: String = ""
               var arrayNotes: Array[Char] = n.toArray
                
               var i: Int = 0
               var found: Boolean = false
               while(i < n.length && !found)
               {
                        var j: Int = 0
                        var arrayNotesBeggining = new Array[Char] (i + 1)
                        while(j <= i)
                        {
                          arrayNotesBeggining(j) = arrayNotes(j)
                          j = j + 1
                        }
                          
                        var k: Int = 0
                        var arrayNotesEnd = new Array[Char] (arrayNotes.length - i - 1)
                        while(k < (arrayNotes.length - i - 1))
                        {
                          arrayNotesEnd(k) = arrayNotes(i + k + 1)
                          k = k + 1
                        }

                        
                        if (arrayNotes(i) == '1')
                        {
                          if(arrayNotes(i + 1) == '0')
                          {
                            arrayNotesBeggining(i) = '9'
                              
                              var k: Int = 0
                              var arrayNotesEnd10 = new Array[Char] (arrayNotes.length - i - 2)
                              while(k < (arrayNotes.length - i - 2))
                              {
                                arrayNotesEnd10(k) = arrayNotes(i + k + 2)
                                k = k + 1
                              }
                            notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveLowerShell(arrayNotesEnd10.mkString("", "", ""))
                            found = true
                          }
                        }
                        if (arrayNotes(i) == '2')
                        {
                              arrayNotesBeggining(i) = '1'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveLowerShell(arrayNotesEnd.mkString("", "", ""))
                              found = true  
                        }
                        if (arrayNotes(i) == '3')
                        {
                              arrayNotesBeggining(i) = '2'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveLowerShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        if (arrayNotes(i) == '4')
                        {
                              arrayNotesBeggining(i) = '3'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveLowerShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        if (arrayNotes(i) == '5')
                        {
                              arrayNotesBeggining(i) = '4'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveLowerShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        if (arrayNotes(i) == '6')
                        {
                              //println("Found 6")
                              arrayNotesBeggining(i) = '5'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveLowerShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        if (arrayNotes(i) == '7')
                        {
                              arrayNotesBeggining(i) = '6'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveLowerShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        if (arrayNotes(i) == '8')
                        {
                              arrayNotesBeggining(i) = '7'
                              notesFinal = arrayNotesBeggining.mkString("", "", "") + octaveLowerShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        
                        if (arrayNotes(i) == '9')
                        {
                              arrayNotesBeggining(i) = '8'
                              
                              var NotesBeggining:String = arrayNotesBeggining.mkString("", "", "") + "0"
                              notesFinal = NotesBeggining + octaveLowerShell(arrayNotesEnd.mkString("", "", ""))
                              found = true
                        }
                        
                        if(i == (n.length - 1))
                        {
                          notesFinal = arrayNotesBeggining.mkString("","","")
                        }
                        i = i + 1
                }
                  
                return notesFinal
        }
}