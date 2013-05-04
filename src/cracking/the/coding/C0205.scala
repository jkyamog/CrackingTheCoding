package cracking.the.coding

import scala.annotation.tailrec

object C0205 extends App {
	class Node(var link: Node, var value: String)
	
	val e = new Node(null, "e")
	val d = new Node(e, "d")
	val c = new Node(d, "c")
	val b = new Node(c, "b")
	val a = new Node(b, "a")
	d.link = b
	
	def circular(startNode: Node): Option[Node] = {
	
		@tailrec
		def circularInternal(node: Node, nodes: List[Node]): Option[Node] = {
			node match {
				case null => None
				case node if (!nodes.exists(_.value == node.value)) => circularInternal(node.link, node :: nodes)
				case node => Some(node)
			}
		}
		
		circularInternal(startNode, List.empty)
	}
	
	println(circular(a).map(_.value))
	
}