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

  def preOrder(root: Node): Unit = {
    if (root != null) {
      print(root.value + " ")
      preOrder(root.left)
      preOrder(root.right)
    }
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
	
	println(walkDFS(n4).map(_.value))
	println(walkBFS(n4).map(_.value))
	
	println(isSubtreeRef(n4, n2))
	println(isSubtreeRef(n4, nb2))
	println(isSubtreeValue(n4, nb2))

  println("preOrder")
  preOrder(n4)
  println("\npreOrderIterative")
  preOrderIterative(n4)
}