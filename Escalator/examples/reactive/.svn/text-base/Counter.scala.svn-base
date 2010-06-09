
import edu.depauw.reactive._
import edu.depauw.reactive.Predef._

runScript {
	val button = Button("Click me!")
	val counter = 0 till (button.click --> {_ + 1})
	Frame(Label("The value is: " + counter.value) ^ button)
}



