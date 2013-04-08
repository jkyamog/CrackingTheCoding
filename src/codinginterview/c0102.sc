package codinginterview

object c0102 {
	val str = Array("a", "b", "c", null)      //> str  : Array[String] = Array(a, b, c, null)
	
	def reverseC(str: Array[String]) = {
		if (str == null) null
		else {
			var reverse = collection.mutable.ListBuffer[String]()
			
			for (i <- (0 until (str.size - 1)) reverse) {
				reverse += str(i)
			}
			
			reverse += null
		}
	}                                         //> reverseC: (str: Array[String])scala.collection.mutable.ListBuffer[String]
	
	def reverseC2(str: Array[String]) = {
		def revInternal(s: Array[String]): Array[String] = {
			if (s == null) null
			else if (s.tail.isEmpty) s
			else revInternal(s.tail) :+ s.head
		}
	
		revInternal(str)
	}                                         //> reverseC2: (str: Array[String])Array[String]

	reverseC(str)                             //> res0: scala.collection.mutable.ListBuffer[String] = ListBuffer(c, b, a, null
                                                  //| )
	reverseC(null)                            //> res1: scala.collection.mutable.ListBuffer[String] = null
	reverseC(Array("a", null))                //> res2: scala.collection.mutable.ListBuffer[String] = ListBuffer(a, null)
	reverseC2(str)                            //> res3: Array[String] = Array(null, c, b, a)
	reverseC2(null)                           //> res4: Array[String] = null
	reverseC2(Array("a", null))               //> res5: Array[String] = Array(null, a)
}