package cracking.the.coding

object ShortestPath extends App {
	
	case class Node(link: Node, value: String) {
		override def toString = value
	}
	
	val d = Node(null, "d")
	val c = Node(d, "c")
	val b = Node(c, "b")
	val a = Node(b, "a")
	
	val x = Node(c, "x")
	val y = Node(x, "y")
	val z = Node(y, "z")

	def walk(node: Node, target: String, targetSteps: Int): Option[List[Node]] = {
		
		def walkHelper(n: Node, path: List[Node]): Option[List[Node]] = {
			if (n != null && n.value == target) Some(n :: path)
			else if (n == null) None
			else if (targetSteps < path.size) None
			else walkHelper(n.link, n :: path)
		}
		
		walkHelper(node, List.empty)
	}

	println(walk(z, "d", 10).map(_.map(_.value)))
	println(walk(a, "d", 10).map(_.map(_.value)))
	println(walk(a, "d", 1).map(_.map(_.value)))
	println(walk(a, "z", 10).map(_.map(_.value)))
	
	def shortestPath(candidates: List[Node], target: String): List[Node] = {
			var lastShortest = 99
		
			val f = candidates.flatMap { x =>
				val path = walk(x, target, lastShortest)
				lastShortest = path.size
				path
			}.reverse
		
		f.head
	}

	shortestPath(List(z, a, c), "d") foreach println
	
}