package codinginterview

object c0205 {
	class Node(var link: Node, var value: String)
	
	val e = new Node(null, "e")               //> e  : codinginterview.c0205.Node = codinginterview.c0205$Node@21b585b1
	val d = new Node(e, "d")                  //> d  : codinginterview.c0205.Node = codinginterview.c0205$Node@df9411
	val c = new Node(d, "c")                  //> c  : codinginterview.c0205.Node = codinginterview.c0205$Node@5671e889
	val b = new Node(c, "b")                  //> b  : codinginterview.c0205.Node = codinginterview.c0205$Node@5059a6b5
	val a = new Node(b, "a")                  //> a  : codinginterview.c0205.Node = codinginterview.c0205$Node@2dcfde49
	d.link = b
	
	def circular(startNode: Node): Option[Node] = {
	
		def circularInternal(node: Node, nodes: Seq[Node]): Option[Node] = {
			node match {
				case null => None
				case node => Some(node)
				case node if (!nodes.exists(_.value == node.value)) => circularInternal(node.link, nodes :+ node)
			}
		}
		
		circularInternal(startNode, Seq.empty)
	}                                         //> circular: (startNode: codinginterview.c0205.Node)Option[codinginterview.c020
                                                  //| 5.Node]
	
	circular(a).map(_.value)                  //> res0: Option[String] = Some(a)
	
}