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
	
	def LISS3(list: List[Int]): List[Stream[Int]] = {
		
		val paths = for {
			i <- 0 until list.length
			j <- (i + 1) until list.length
		} yield {
			val current = list(i)
			val next = list(j)
			println(s"current $current next $next")
			if (current < next)
				current #:: Stream(next)
			else
				current #:: Stream.empty
		}
		
		paths foreach println
		
		paths.toList
		
	}
	
	
	val lis1 = LIS(1, List(2))
	val lis2 = LIS(2, List(1))
	val lis3 = LIS(nums.head, nums.tail)
	
//	lis3 sortBy (_.length) foreach println

//	val snums = nums.toStream
	val tnums = List(2, 6, 4, 5, 1, 3)
//	val tnums = List(1, 2)
	val lis4 = LISS3(tnums)
	
	lis4.take(tnums.length) foreach { l =>
		println(l.take(7).toList)
//		println(l)
	}

	
}