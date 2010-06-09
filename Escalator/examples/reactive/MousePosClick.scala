
import edu.depauw.reactive._
import edu.depauw.reactive.Predef._

runScript {
	lazy val label:Label = Label("The value is: " + state.value)
	lazy val state = (0, 0) till (label.leftClick --> (_ => label.mousePos))
	Frame(label)
}

