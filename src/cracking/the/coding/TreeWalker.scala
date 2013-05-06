package cracking.the.coding

import scala.collection.mutable.ListBuffer
import scala.annotation.tailrec

object TreeWalker extends App {
	
	case class Node(left: Node, right: Node, value: Int)
	
	val n1 = Node(null, null, 1)
	val n3 = Node(null, null, 3)
	val n2 = Node(n1, n3, 2)
	
	val n7 = Node(null, null, 7)
	val n5 = Node(null, null, 5)
	val n6 = Node(n5, n7, 6)
	
	val n4 = Node(n2, n6, 4)
	
	def walkDFS(root: Node): List[Int] = {
		
		def walk(current: Node): List[Int] = {
			if (current == null) Nil
			else current.value :: walk(current.left) ::: walk(current.right)
		}
		
		walk(root)
	}
	
	def walkBFS(root: Node): List[Int] = {
		
		@tailrec
		def walk(toWalk: ListBuffer[Node], walked: ListBuffer[Int]): List[Int] = {
			if (toWalk.isEmpty) walked.toList
			else {
				val current = toWalk.head
				
				if (current.left != null) {
					walked += current.left.value
					toWalk += current.left
				}
				if (current.right != null) {
					walked += current.right.value
					toWalk += current.right
				}
				
				walk(toWalk.tail, walked)
			}
		}
		
		if (root == null) 
			Nil
		else
			walk(ListBuffer(root), ListBuffer(root.value))
	}
	
	println(walkDFS(n4))
	println(walkBFS(n4))

}