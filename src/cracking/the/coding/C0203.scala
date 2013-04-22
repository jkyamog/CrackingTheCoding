package cracking.the.coding

object C0203 extends App {


	// delete c from a -> b -> c -> d -> e = a -> d -> e
	
	case class Node(var link: Node, var value: String)
	
	val e = Node(null, "e")
	val d = Node(e, "d")
	val c = Node(d, "c")
	val b = Node(c, "b")
	val a = Node(b, "a")
	
	def delete(node: Node): Unit = {
			if (node.link.link == null) {
				node.value = node.link.value
				node.link = null
			} else {
				node.value = node.link.value
				delete(node.link)
			}
	}

	def nodeValues(node: Node): String = {
		if (node.link == null) node.value
		else node.value + nodeValues(node.link)
	}
	
	println(nodeValues(a))
	
	val correctValues = "abde"
	delete(c)
	println(correctValues == nodeValues(a))
}