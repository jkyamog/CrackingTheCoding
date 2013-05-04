package cracking.the.coding

object FindPairs extends App {
	
	val arr1 = Array(1, 4, 6, 8, 9, 2, 8, 5)
	val arr2 = Array(5, 7, 5, 2, 5, 3)
	val targetSum = 7
	
	val pairs = for {
		int1 <- arr1
		int2 <- arr2
		if (int1 + int2 == targetSum)
	} yield (int1, int2)
	
	pairs foreach println
}