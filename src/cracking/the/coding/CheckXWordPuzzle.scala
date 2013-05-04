package cracking.the.coding

object CheckXWordPuzzle extends App {
	
	val puzzle = List(
		List(null, null, null, "m", null, null, null, null, null, null, null, null, null),
		List(null, null, null, "o", null, null, null, null, null, null, "f", null, null),
		List("w", "e", "d", "n", "e", "s", "d", "a", "y", null, "r", null, null),
		List(null, null, null, "d", null, "a", null, null, null, null, "i", null, null),
		List(null, null, null, "a", null, "t", "h", "u", "r", "s", "d", "a", "y"),
		List(null, null, null, "y", null, "u", null, null, null, null, "a", null, null),
		List(null, null, null, null, null, "r", null, null, null, null, "y", null, null),
		List(null, "t", "u", "e", "s", "d", "a", "y", null, null, null, null, null),
		List(null, null, null, null, null, "a", null, null, null, null, null, null, null),
		List("s", "u", "n", "d", "a", "y", null, null, null, null, null, null, null)
	)
	
	val answers = List(
		"sunday",
		"monday",
		"tuesday",
		"wednesday",
		"thursday",
		"friday",
		"saturday"
	)
	
	def checkAnswer(puzzle: List[List[String]]) = {
		var word = ""
		val attempts = collection.mutable.ArrayBuffer[String]()
		
		for {
			row <- puzzle
			c <- row
		} {
			if (c != null) {
				word += c
			} else if (!word.isEmpty) {
				attempts += word
				word = ""
			}
		}
		
		attempts.filter(a => answers.contains(a))
	}
	
	println(checkAnswer(puzzle) ++ checkAnswer(puzzle.transpose))
	

}