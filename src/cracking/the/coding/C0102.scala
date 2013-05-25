package cracking.the.coding

object C0102 extends App {
	val str = Array("a", "b", "c", null)
	
	def reverseC(str: Array[String]) = {
		if (str == null) null
		else {
			var reverse = collection.mutable.ListBuffer[String]()
			
			for (i <- (0 until (str.size - 1)).reverse) { // this reverse is for counting descending, its not reversing the array
				reverse += str(i)
			}
			
			reverse += null
		}
	}
	
	def reverseC2(str: Array[String]) = {
		def revInternal(s: Array[String]): Array[String] = {
			if (s == null) null
			else if (s.tail.isEmpty) s
			else revInternal(s.tail) :+ s.head
		}
	
		revInternal(str)
	}

	println(reverseC(str))
	println(reverseC(null))
	println(reverseC(Array("a", null)))
	println(reverseC2(str).toSeq)
	println(reverseC2(null))
	println(reverseC2(Array("a", null)).toSeq)
}