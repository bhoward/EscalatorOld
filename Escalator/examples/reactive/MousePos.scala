
import edu.depauw.reactive._
import edu.depauw.reactive.Predef._

runScript {
	lazy val label:Label = Label("The value is: " + label.mousePos)
	Frame(label)
}

