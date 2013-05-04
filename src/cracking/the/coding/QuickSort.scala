package cracking.the.coding

object QuickSort extends App {
	
	def quickSort(data: List[Int]): List[Int] = {
		if (data.size <= 1) data
		else {
			val pivot = data(data.size /2)
			val (less, greater) = (data.filter(_ < pivot), data.filter(_ > pivot)) 
			
			quickSort(less) ::: pivot :: quickSort(greater)
		}
	}
	
	println(quickSort(List(4, 7, 9, 2, 3, 6, 1, 8, 0, 5)))

}