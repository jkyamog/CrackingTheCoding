package cracking.the.coding

object HeapSort extends App {
	
	class MaxHeap(initial: Seq[Int]) {
		
		val buffer = collection.mutable.Buffer[Int]()
		
		initial foreach insert
		
		def insert(value: Int) = {
			buffer += value
			
			var index = buffer.size - 1
			while (buffer(index) > buffer(parent(index))) {
				swap(parent(index), index)
				index = parent(index)
			}
		}
		
		def delete: Int = {
			if (buffer.size == 0) throw new RuntimeException("empty heap, nothing to delete")
			
			val root = buffer(0)
			swap(0, buffer.size - 1)
			buffer.remove(buffer.size - 1)
			
			var index = 0
			while (lessThanChild(index)) {
				if (left(index) == (buffer.size - 1) || (buffer(left(index)) > buffer(right(index)))) {
					swap(left(index), index)
					index = left(index)
				} else {
					swap(right(index), index)
					index = right(index)
				}
			}
			
			root
		}
		
		def swap(indexA: Int, indexB: Int) = {
			buffer(indexA) = buffer(indexA) ^ buffer(indexB)
			buffer(indexB) = buffer(indexA) ^ buffer(indexB)
			buffer(indexA) = buffer(indexA) ^ buffer(indexB)
		}
		
		def lessThanChild(index: Int) = 
			(((left(index) < buffer.size) && buffer(left(index)) > buffer(index)) 
					|| ((right(index) < buffer.size) && buffer(right(index)) > buffer(index)))
		
		def left(index: Int) = index * 2 + 1

		def right(index: Int) = index * 2 + 2
		
		def parent(index: Int) = 
			if (index == 0) 0 
			else (index - 1) / 2
			
		override def toString = buffer.mkString(",")
	}
	
	val heap = new MaxHeap(Seq(9, 10, 9, 15, 8))
	
	println(heap)
	println(heap.delete)
	println(heap.delete)
	println(heap.delete)
	println(heap.delete)
	println(heap.delete)

}