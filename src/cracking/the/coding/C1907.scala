package cracking.the.coding

object C1907 extends App {
	
	def maxList(list: List[Int]) = {
		
		def comboList(l: List[Int]): List[List[Int]] = {
			if (l.isEmpty) List(Nil)
			else {
				val growRight = for {
					n <- 1 to l.length
				} yield (list.take(n))
				
				val dropLeft = for {
					sl <- growRight
					n <- 1 to sl.length
				} yield (sl.drop(n))
				
				growRight.toList ::: dropLeft.toList
			}
		}
		
		val sumWithList = comboList(list) map ( l => (l.sum, l))
		
		println(sumWithList)
		
		val maxSum = sumWithList sortBy (_._1) last
		
		maxSum._2
	}
	
	println(maxList(List(2, 8, 3)))
	println(maxList(List(2, -8, 3, -2, 4, -10)))

}