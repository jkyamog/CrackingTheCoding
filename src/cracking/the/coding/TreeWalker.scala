package cracking.the.coding

object TreeWalker extends App {
	
	case class Node(left: Node, right: Node, value: Int)
	
	val n1 = Node(null, null, 1)
	val n2 = Node(null, null, 2)
	val n3 = Node(n1, n2, 3)
	
	val n6 = Node(null, null, 6)
	val n7 = Node(null, null, 7)
	val n5 = Node(n6, n7, 5)
	
	val n4 = Node(n3, n5, 4)
	
	def walkDFS(root: Node): List[Int] = {
		
		def walk(current: Node): List[Int] = {
			if (current == null) Nil
			else current.value :: walk(current.left) ::: walk(current.right)
		}
		
		walk(root)
	}
	
	println(walkDFS(n4))

}