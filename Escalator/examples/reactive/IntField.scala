
import edu.depauw.reactive._
import edu.depauw.reactive.Predef._

runScript {
	val n = IntField()
	val topRow = Label("Enter a number:") | n
	val bottomRow = Label("n:   " + n.value + "   n^2:   " + Math.pow(n.value, 2) + "   n^3:   " + Math.pow(n.value, 3))
	Frame(topRow ^ bottomRow)
}
