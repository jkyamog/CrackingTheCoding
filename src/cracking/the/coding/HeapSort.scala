package cracking.the.coding

object HeapSort extends App {
	
	class MaxHeap[T <% Ordered[T]](initial: Seq[T]) {
		
		val buffer = collection.mutable.Buffer[T]()
		
		initial foreach insert
		
		def insert(value: T) = {
	  	buffer += value
		  siftUp
		}
		
		private def siftUp {
		  var index = buffer.size - 1
		  while (buffer(index) > buffer(parent(index))) {
		  	swap(parent(index), index)
		  	index = parent(index)
		  }
		}

		
		def delete: T = {
			if (buffer.size == 0) throw new RuntimeException("empty heap, nothing to delete")
			
			val root = buffer(0)
			swap(0, buffer.size - 1)
			buffer.remove(buffer.size - 1)
			
			siftDown
			
			root
		}
		
		private def siftDown {
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
		}
		
		def swap(indexA: Int, indexB: Int) = {
			val temp = buffer(indexA)
			buffer(indexA) = buffer(indexB)
			buffer(indexB) = temp
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
		
		def size = buffer.size
		def isEmpty = buffer.isEmpty
	  
	}
	
	val heap = new MaxHeap[Int](Seq(9, 10, 9, 15, 8))
	
	def sort[T](heap: MaxHeap[T]) = {
		for {
			i <- 0 until heap.size
		} yield (heap.delete)
	}
	
	val sorted = sort(heap)
	
	sorted foreach println
}