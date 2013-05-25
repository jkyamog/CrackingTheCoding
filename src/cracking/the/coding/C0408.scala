package cracking.the.coding

object C0408 extends App {
/*
you are given a binary tree in which each node contains a value. design an algorithm to print all
paths which sum up to that value. note that it can be any path in the tree - it does not have to start at the root
*/
	
	case class Node(value: Int, left: Node = null, right: Node = null) {
		override def toString = value.toString
	}
	
	def dfsPaths(current: Node): List[List[Node]] = {
		if (current.left == null && current.right == null) List(List(current))
		else {
			for {
				child <- List(current.left, current.right)
				if child != null
				path <- dfsPaths(child)
			} yield (current :: path)
		}
	}
	
	def validPaths(paths: List[List[Node]], sum: Int) = {
		paths.flatMap { path =>
			for {
				i <- 1 to path.size
				if (path.take(i).map(_.value).sum == sum)
			} yield (path.take(i))
		}.toSet
	}
	
	val h = Node(4)
	val i = Node(1)
	val d = Node(1, h, i)
	val e = Node(2)
	val b = Node(5, d, e)
	val j = Node(1)
	val k = Node(1)
	val f = Node(2, j, k)
	val g = Node(4)
	val c = Node(3, f, g)
	val a = Node(7, b, c)

	val paths = dfsPaths(a)
	paths foreach println
	
	println("--------------")
	
	validPaths(paths, 14) foreach println
	println("--------------")
	validPaths(paths, 12) foreach println
	println("--------------")
	validPaths(dfsPaths(c), 7) foreach println

}