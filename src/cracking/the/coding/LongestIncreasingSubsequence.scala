package cracking.the.coding

object LongestIncreasingSubsequence extends App {
	
	val nums = List(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)

	def LIS(head: Int, list: List[Int]): List[List[Int]] = {
		if (list.isEmpty) List(head :: Nil)
		else {
			for {
				n <- (0 until list.length).toList
				sub <- LIS(list(n), list.takeRight(list.length - 1 - n))
			} yield {
				if (head < sub.head)
					head :: sub
				else
					head :: Nil
			}
		}
	}
	
	def LISS(head: Int, list: Stream[Int]): Stream[Stream[Int]] = {
		if (list.isEmpty) Stream(head #:: Stream.empty)
		else {
			for {
				l <- Stream(head) #:: LISS(list.head, list.tail)
			} yield {
				if (!l.isEmpty && (head < l.head))
					head #:: l
				else
					l
			}
		}
	}
	
	def LISS2(head: Int, list: Stream[Int]): Stream[Int] = {
		if (list.isEmpty) head #:: Stream.empty
		else {
			head #:: LISS2(list.head, (list.tail filter (_> head)))
		}
	}
	
	def LISS3(list: Stream[Int]): Stream[Stream[Int]] = {
		if (list.isEmpty) Stream.empty
		else
			for {
				l <- list
			} yield {
				LISS2(l, list.tail) 
			}
	}
	
	val lis1 = LIS(1, List(2))
	val lis2 = LIS(2, List(1))
	val lis3 = LIS(nums.head, nums.tail)
	
//	lis3 sortBy (_.length) foreach println

//	val snums = nums.toStream
	val snums = List(2, 6, 4, 5, 1, 3).toStream
//	val snums = List(2, 1).toStream
	val lis4 = LISS2(snums.head, snums.tail)
	
	lis4.take(snums.length) foreach { l =>
//		println(l.take(7).toList)
		println(l)
	}

	
}