
import edu.depauw.reactive._
import edu.depauw.reactive.Predef._

runScript {
	val button = Button("Add new field")
	val counter = List(Field()) till (button.click --> (Field() :: _))
	Frame(button ^ counter.value.reduceLeft[Displayable](_^_))
}

