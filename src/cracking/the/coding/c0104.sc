package codinginterview

object c0104 {
	
	def isAnagram(str1: String, str2: String) = {
		if (str1 == null && str2 == null) true
		else if (str1 == null || str2 == null) false
		else if (str1.size != str2.size) false
		else {
			var isAnagram = true
		
			for (i <- 0 until str1.size) {
				if (str1(i) != str2(str2.size - i - 1)) isAnagram = false
			}
		
			isAnagram
		}
	}                                         //> isAnagram: (str1: String, str2: String)Boolean
	
	def isAnagram2(str1: String, str2: String) = {
		def isAnaInternal(head1: Char, tail1: String, head2: Char, tail2: String): Boolean = {
			if (head1 == head2 && tail1.tail.isEmpty && tail2.tail.isEmpty) true
			else if (head1 == head2) true && isAnaInternal(tail1.head, tail1.tail, tail2.head, tail2.tail)
			else false
		}

		(str1, str2) match {
			case (null, null) => true
			case (_, null) | (null, _) => false
			case (str1, str2) =>
				val reversed = str2.reverse
				isAnaInternal(str1.head, str1, reversed.head, reversed)
		}
	}                                         //> isAnagram2: (str1: String, str2: String)Boolean
	
	isAnagram("foo", "oof")                   //> res0: Boolean = true
	isAnagram("fo", "off")                    //> res1: Boolean = false
	isAnagram("xoo", "oof")                   //> res2: Boolean = false
	isAnagram(null, null)                     //> res3: Boolean = true
	isAnagram(null, "o")                      //> res4: Boolean = false
	isAnagram("o", null)                      //> res5: Boolean = false
	isAnagram("o", "o")                       //> res6: Boolean = true
	isAnagram("f", "o")                       //> res7: Boolean = false
	
	isAnagram2("foo", "oof")                  //> res8: Boolean = true
	isAnagram2("fo", "off")                   //> res9: Boolean = false
	isAnagram2("xoo", "oof")                  //> res10: Boolean = false
	isAnagram2(null, null)                    //> res11: Boolean = true
	isAnagram2(null, "o")                     //> res12: Boolean = false
	isAnagram2("o", null)                     //> res13: Boolean = false
	isAnagram2("o", "o")                      //> res14: Boolean = true
	isAnagram2("f", "o")                      //> res15: Boolean = false
}