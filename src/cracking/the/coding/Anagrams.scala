package cracking.the.coding

object Anagrams extends App {
	
	val dictionary = Seq(
			"ate", "eat", "tea", "army", "mary", "foo", "bar", "bra"			
	)
	
	def toSorted(word: String) = word.sorted
	
	val sortedDictionary = {
		val sorted = dictionary map (w => toSorted(w) -> w)
		sorted groupBy { case (k, v) =>
			k	
		} map { case (k, v) =>
			k -> v.map (_._2)
		}
	}
	
	def anagrams(word: String) = sortedDictionary.get(toSorted(word))
	
	println(anagrams("eat"))
	println(anagrams("mary"))

}