package cracking.the.coding

object C0205 extends App {
	class Node(var link: Node, var value: String)
	
	val e = new Node(null, "e")
	val d = new Node(e, "d")
	val c = new Node(d, "c")
	val b = new Node(c, "b")
	val a = new Node(b, "a")
	d.link = b
	
	def circular(startNode: Node): Option[Node] = {
	
		def circularInternal(node: Node, nodes: Seq[Node]): Option[Node] = {
			node match {
				case null => None
				case node if (!nodes.exists(_.value == node.value)) => circularInternal(node.link, nodes :+ node)
				case node => Some(node)
			}
		}
		
		circularInternal(startNode, Seq.empty)
	}
	
	println(circular(a).map(_.value))
	
}