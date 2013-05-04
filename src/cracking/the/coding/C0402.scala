package cracking.the.coding

import scala.annotation.tailrec

case class Graph(link: Graph, value: String)

object C0402 extends App {

	val d = Graph(null, "d")
	val c = Graph(d, "c")
	val b = Graph(c, "b")
	val a = Graph(b, "a")
	
	@tailrec
	def hasRoute(start: Graph, destination: Graph): Boolean = {
		if (start == null) false
		else if (start == destination) true
		else hasRoute(start.link, destination)
	}

	println(hasRoute(a, d))

}