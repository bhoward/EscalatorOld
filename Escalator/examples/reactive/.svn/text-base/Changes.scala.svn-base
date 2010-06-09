
import edu.depauw.reactive._
import edu.depauw.reactive.Predef._

runScript {
	val field = Field()
	val state = "a" till (changed(field.value) --> { case "a" => "b" ; case _ => "a"})
	val label = Label(state.value)
	Frame(label ^ field)
}
