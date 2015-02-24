package cracking.the.coding

import scala.collection.mutable.ListBuffer
import scala.annotation.tailrec

object TreeWalker extends App {
	
	case class Node(left: Node, right: Node, value: Int) {
		override def toString = value.toString
	}
	
	val n1 = Node(null, null, 1)
	val n3 = Node(null, null, 3)
	val n2 = Node(n1, n3, 2)
	
	val n7 = Node(null, null, 7)
	val n5 = Node(null, null, 5)
	val n6 = Node(n5, n7, 6)
	
	val n4 = Node(n2, n6, 4)
	
	val nb1 = Node(null, null, 1)
	val nb3 = Node(null, null, 3)
	val nb2 = Node(nb1, nb3, 2)

	
	def walkDFS(root: Node): List[Node] = {
		
		def walk(current: Node): List[Node] = {
			if (current == null) Nil
			else current :: walk(current.left) ::: walk(current.right)
		}
		
		walk(root)
	}
	
	def walkBFS(root: Node): List[Node] = {
		
		@tailrec
		def walk(toWalk: ListBuffer[Node], walked: ListBuffer[Node]): List[Node] = {
			if (toWalk.isEmpty) walked.toList
			else {
				val current = toWalk.head
				
				if (current.left != null) {
					walked += current.left
					toWalk += current.left
				}
				if (current.right != null) {
					walked += current.right
					toWalk += current.right
				}
				
				walk(toWalk.tail, walked)
			}
		}
		
		if (root == null) 
			Nil
		else
			walk(ListBuffer(root), ListBuffer(root))
	}
	
	def isSubtreeRef(root: Node, subTree: Node) = {
		val nodes = walkBFS(root)
		nodes.exists(_ eq subTree)
	}
	
	def isSubtreeValue(root: Node, subTree: Node) = {
		val nodes = walkBFS(root).map(_.value)
		val subNodes = walkBFS(subTree).map(_.value)
		
		val remaining = subNodes.dropWhile(nodes.contains(_))
		remaining.isEmpty
	}

  def preOrder(root: Node): List[Int] = {
    if (root != null) {
      root.value :: preOrder(root.left) ::: preOrder(root.right)
    } else Nil
  }

  def preOrderIterative(root: Node): Unit = {
    val stack = new java.util.Stack[Node]
    var current = root;

    stack.push(root.left)
    do {
      print(current.value + " ")
      if (current.right != null) stack.push(current.right)
      if (current.left != null) current = current.left else current = stack.pop()
    } while (!stack.empty())

  }

  def inOrder(root: Node): List[Int] = {
    if (root != null) {
      (inOrder(root.left) :+ root.value) ::: inOrder(root.right)
    } else Nil
  }

  def reconstructTree(preOrder: Seq[Int], inOrder: Seq[Int]): Node = {
    if (preOrder.isEmpty) null else {

      val root = preOrder.head
      val (leftNodes, rightNodes) = {
        val (lNodes, rNodes) = inOrder.span(_ != root)
        if (rNodes.isEmpty) (lNodes, Nil) else (lNodes, rNodes.tail)
      }
      val leftPreOrder = preOrder.filter(leftNodes.contains)
      val rightPreOrder = preOrder.filter(rightNodes.contains)
      val leftNode = reconstructTree(leftPreOrder, leftNodes)
      val rightNode = reconstructTree(rightPreOrder, rightNodes)
      Node(leftNode, rightNode, root)
    }
  }
	
	println(walkDFS(n4).map(_.value))
	println(walkBFS(n4).map(_.value))
	
	println(isSubtreeRef(n4, n2))
	println(isSubtreeRef(n4, nb2))
	println(isSubtreeValue(n4, nb2))

  println("preOrder")
  println(preOrder(n4).mkString(" "))
  println("preOrderIterative")
  preOrderIterative(n4)
  println("\ninOrder")
  println(inOrder(n4).mkString(" "))

  val newRoot = reconstructTree(preOrder(n4), inOrder(n4))
  println(walkDFS(n4).map(_.value))

  val testRoot = reconstructTree(Seq(50, 30, 15, 40, 35, 45, 70, 60, 88, 75, 72, 77),
                                Seq(15, 30, 35, 40, 45, 50, 60, 70, 72, 75, 77, 88))
  println(walkDFS(testRoot).map(_.value))


}