package codinginterview

object c0203 {


	// delete c from a -> b -> c -> d -> e = a -> d -> e
	
	case class Node(var link: Node, var value: String)
	
	val e = Node(null, "e")                   //> e  : codinginterview.c0203.Node = Node(null,e)
	val d = Node(e, "d")                      //> d  : codinginterview.c0203.Node = Node(Node(null,e),d)
	val c = Node(d, "c")                      //> c  : codinginterview.c0203.Node = Node(Node(Node(null,e),d),c)
	val b = Node(c, "b")                      //> b  : codinginterview.c0203.Node = Node(Node(Node(Node(null,e),d),c),b)
	val a = Node(b, "a")                      //> a  : codinginterview.c0203.Node = Node(Node(Node(Node(Node(null,e),d),c),b),
                                                  //| a)
	
	def delete(node: Node): Unit = {
			if (node.link.link == null) {
				node.value = node.link.value
				node.link = null
			} else {
				node.value = node.link.value
				delete(node.link)
			}
	}                                         //> delete: (node: codinginterview.c0203.Node)Unit

	def nodeValues(node: Node): String = {
		if (node.link == null) node.value
		else node.value + nodeValues(node.link)
	}                                         //> nodeValues: (node: codinginterview.c0203.Node)String
	
	nodeValues(a)                             //> res0: String = abcde
	
	val correctValues = "abde"                //> correctValues  : String = abde
	delete(c)
	correctValues == nodeValues(a)            //> res1: Boolean = true
}