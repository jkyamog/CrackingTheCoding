package cracking.the.coding

import scala.annotation.tailrec

object MaxOccurSequence extends App {
	
	def maxOccur1(list: List[Int]) = {
		var maxOccur = 0
		var current = list(0)
		var currentOccur = 1
		
		for {
			n <- list
		} {
			if (n > current) {
				current = n
				currentOccur = 1
			} else {
				currentOccur += 1
			}
			
			if (maxOccur < currentOccur) maxOccur = currentOccur
		}
		
		maxOccur
	}
	
	def maxOccur2(list: List[Int]) = {
		@tailrec
		def maxOccur(current: Int, list: List[Int], currentList: List[Int], maxList: List[Int]): List[Int] = {
			if (list.isEmpty) maxList
			else if (list.head == current && (currentList.length + 1) >= maxList.length)
				maxOccur(list.head, list.tail, current :: currentList, current :: currentList)
			else if (list.head == current)
				maxOccur(list.head, list.tail, current :: currentList, maxList)
			else
				maxOccur(list.head, list.tail, list.head :: Nil, maxList)
		}

		maxOccur(list.head, list.tail, list.head :: Nil, list.head :: Nil).size
	}

	val testData = List(1, 2, 2, 3, 3, 3, 4, 5, 5, 5)
	
	println(maxOccur1(testData))
	println(maxOccur2(testData))
}