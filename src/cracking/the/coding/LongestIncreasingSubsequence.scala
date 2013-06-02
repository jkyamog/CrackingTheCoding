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
	
	val snums = nums.toStream
	val lis1 = LIS(1, List(2))
	val lis2 = LIS(2, List(1))
	val lis3 = LIS(nums.head, nums.tail)
	
	lis3 sortBy (_.length) foreach println
	
}