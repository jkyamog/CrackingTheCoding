package cracking.the.coding

import scala.annotation.tailrec

case class Node(vertices: Seq[Node], value: Int)

object C0402 extends App {

	val n1 = Node(Seq.empty, 1)
	val n2 = Node(Seq(n1), 2)
	val n3 = Node(Seq(n2), 3)
	val n5 = Node(Seq(n2), 5)
	val n4 = Node(Seq(n3, n5), 4)
	val n6 = Node(Seq(n4), 6)
	
	def hasRoute(start: Node, destination: Node): Boolean = {
		def hasRouteHelper(current: Node): Boolean = {
			if (current.value == destination.value) true
			else if (current.vertices.isEmpty) false
			else {
				val hasRoutes = current.vertices.map(hasRouteHelper(_))
								
				hasRoutes.fold(false){(hasRoute, path) =>
					hasRoute || path
				}
			}
		}
		
		hasRouteHelper(start)
	}

	def hasRoute2(start: Node, destination: Node): Boolean = {
		@tailrec
		def hasRouteHelper(current: Node, toVisit: Seq[Node]): Boolean = {
			if (current.value == destination.value) true
			else if (current.vertices.isEmpty) false
			else if (toVisit.isEmpty) false
			else hasRouteHelper(toVisit.head, toVisit.tail ++ current.vertices)
		}
		
		hasRouteHelper(start, start.vertices)
	}
	
	println(hasRoute(n3, n6))
	println(hasRoute(n6, n3))
	println(hasRoute(n5, n3))
	println(hasRoute(n6, n1))

	println("--------")
	
	println(hasRoute(n3, n6))
	println(hasRoute(n6, n3))
	println(hasRoute(n5, n3))
	println(hasRoute(n6, n1))
	
}