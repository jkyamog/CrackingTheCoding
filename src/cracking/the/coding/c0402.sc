package coding

case class Graph(link: Graph, value: String)

object cA {

	val d = Graph(null, "d")
	val c = Graph(d, "c")
	val b = Graph(c, "b")
	val a = Graph(b, "a")
	
	def hasRoute(start: Graph, destination: Graph): Boolean = {
		if (start == null) false
		else if (start == destination) true
		else hasRoute(start.link, destination)
	}

	hasRoute(a, d)


}