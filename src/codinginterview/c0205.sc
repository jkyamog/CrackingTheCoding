package codinginterview

object c0205 {
	case class Node(var link: Node, value: String)
	
	val e = Node(null, "e")                   //> e  : codinginterview.c0205.Node = Node(null,e)
	val d = Node(e, "d")                      //> d  : codinginterview.c0205.Node = Node(Node(null,e),d)
	val c = Node(d, "c")                      //> c  : codinginterview.c0205.Node = Node(Node(Node(null,e),d),c)
	val b = Node(c, "b")                      //> b  : codinginterview.c0205.Node = Node(Node(Node(Node(null,e),d),c),b)
	val a = Node(b, "a")                      //> a  : codinginterview.c0205.Node = Node(Node(Node(Node(Node(null,e),d),c),b),
                                                  //| a)
	a.link = a
	
	def circular(startNode: Node): Option[Node] = {
		def circularInternal(startNode: Node, nextNode: Node): Option[Node] = {
			if (nextNode == null) None
			else if (nextNode == startNode) Some(startNode)
			else if (circularInternal(startNode, nextNode.link).isDefined) {println("here"); Some(startNode)}
			else {println("here2"); circularInternal(nextNode, nextNode.link)}
		}

		circularInternal(startNode, startNode.link)
	}                                         //> circular: (startNode: codinginterview.c0205.Node)Option[codinginterview.c020
                                                  //| 5.Node]
	
	circular(a)                               //> java.lang.StackOverflowError
                                                  //| 	at scala.collection.AbstractTraversable.<init>(Traversable.scala:105)
                                                  //| 	at scala.collection.AbstractIterable.<init>(Iterable.scala:54)
                                                  //| 	at scala.collection.AbstractSeq.<init>(Seq.scala:40)
                                                  //| 	at scala.collection.mutable.AbstractSeq.<init>(Seq.scala:47)
                                                  //| 	at scala.collection.mutable.StringBuilder.<init>(StringBuilder.scala:28)
                                                  //| 
                                                  //| 	at scala.collection.mutable.StringBuilder.<init>(StringBuilder.scala:46)
                                                  //| 
                                                  //| 	at scala.collection.mutable.StringBuilder.<init>(StringBuilder.scala:51)
                                                  //| 
                                                  //| 	at scala.collection.TraversableOnce$class.mkString(TraversableOnce.scala
                                                  //| :286)
                                                  //| 	at scala.collection.AbstractIterator.mkString(Iterator.scala:1157)
                                                  //| 	at scala.runtime.ScalaRunTime$._toString(ScalaRunTime.scala:174)
                                                  //| 	at codinginterview.c0205$Node.toString(codinginterview.c0205.scala:4)
                                                  //| 	at java.lang.String.valueOf(String.java:2854)
                                                  //| 	at scala.collection.mutable.StringBuilder.append(StringBuilder.scala:197
                                                  //| )
                                                  //| 	at sca
                                                  //| Output exceeds cutoff limit.
	
}