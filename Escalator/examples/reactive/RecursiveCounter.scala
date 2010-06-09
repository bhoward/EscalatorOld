
import edu.depauw.reactive._
import edu.depauw.reactive.Predef._

runScript {
	lazy val button:Button = Button("Click me to go to " + (counter.value + 1))
	lazy val counter = 0 till (button.click --> {_ + 1})
	val label = Label("The value is: " + counter.value)
	Frame(label ^ button)
	
}
