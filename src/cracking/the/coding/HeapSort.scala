package cracking.the.coding

object HeapSort extends App {
	
	abstract class Heap[T <% Ordered[T]](initial: Seq[T]) {
		
		val buffer = collection.mutable.Buffer[T]()
		
		initial foreach insert
		
		def insert(value: T) = {
	  	buffer += value
		  siftUp
		}
		
		private def siftUp {
		  var index = buffer.size - 1
		  while (compare(buffer(index), buffer(parent(index)))) {
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
			while (compareChild(index)) {
				if (left(index) == (buffer.size - 1) || compare(buffer(left(index)), buffer(right(index)))) {
					swap(left(index), index)
					index = left(index)
				} else {
					swap(right(index), index)
					index = right(index)
				}
			}
		}
		
		def compare(a: T, b: T): Boolean
		
		def swap(indexA: Int, indexB: Int) = {
			val temp = buffer(indexA)
			buffer(indexA) = buffer(indexB)
			buffer(indexB) = temp
		}
		
		def compareChild(index: Int) = 
			(((left(index) < buffer.size) && compare(buffer(left(index)), buffer(index))) 
					|| ((right(index) < buffer.size) && compare(buffer(right(index)), buffer(index))))
		
		def left(index: Int) = index * 2 + 1

		def right(index: Int) = index * 2 + 2
		
		def parent(index: Int) = 
			if (index == 0) 0 
			else (index - 1) / 2
			
		override def toString = buffer.mkString(",")
		
		def size = buffer.size
		def isEmpty = buffer.isEmpty
	  
	}
	
	class MaxHeap[T <% Ordered[T]](initial: Seq[T]) extends Heap(initial) {
		def compare(a: T, b: T) = {
			a > b
		}
	}
	
	class MinHeap[T <% Ordered[T]](initial: Seq[T]) extends Heap(initial) {
		def compare(a: T, b: T) = {
			a < b
		}
	}

	def sort[T](heap: Heap[T]) = {
		for {
			i <- 0 until heap.size
		} yield (heap.delete)
	}
	
	val heapMax = new MaxHeap[Int](Seq(9, 10, 9, 15, 8))
	println(heapMax.buffer.mkString(","))
	val sortedDesc = sort(heapMax)
	println(sortedDesc.mkString(","))
	
	println
	
	val heapMin = new MinHeap[Int](Seq(9, 10, 9, 15, 8))
	println(heapMin.buffer.mkString(","))
	val sortedAsc = sort(heapMin)
	println(sortedAsc.mkString(","))
	
	val pqueue = collection.mutable.PriorityQueue[Int]()
	pqueue.enqueue(9, 10, 11, 9, 15, 8)
	val rqueue = pqueue.reverse.filter(_ != 11)
	while (!rqueue.isEmpty)
		println(rqueue.dequeue)
	
	
	
}