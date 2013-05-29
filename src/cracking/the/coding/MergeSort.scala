package cracking.the.coding

object MergeSort extends App {
	
	def sort[T <% Ordered[T]](list: List[T]): List[T] = {
		if (list.size <= 1) list
		else {
			val n = (list.length) / 2
			val (listA, listB) = list.splitAt(n)
			val sortedA = sort(listA)
			val sortedB = sort(listB)
			
			merge(sortedA, sortedB)
		}
	}
	
	def merge[T <% Ordered[T]](listA: List[T], listB: List[T]): List[T] = (listA, listB) match {
		case (listA, Nil) => listA
		case (Nil, listB) => listB
		case (listA, listB) if (listA.head < listB.head) => listA.head :: merge(listA.tail, listB)
		case _ => listB.head :: merge(listA, listB.tail)
	}
	
	println(sort(List(2, 3, 1, 4, 5)))
	println(sort(List(5, 4, 3, 1, 2)))

}