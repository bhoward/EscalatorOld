
import edu.depauw.reactive._
import edu.depauw.reactive.Predef._

runScript {
	val timer = Timer(100)
	val label = Label("The value is: " + timer.value)
	Frame(label)
}



