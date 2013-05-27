package cracking.the.coding

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=7411
 */

object TagalogDictionary extends App {
	
	val alphabet = Seq("a","b","k","d","e","g","h","i","l","m","n","ng","o","p","r","s","t","u","w","y")
	
	def sortWords(words: Seq[String]) = words map toAscii sortBy(_._1) map (_._2)
	
	def toAscii(word: String) = {
		val buffer = new StringBuilder
		val slider = word.sliding(2)
		
		while (slider.hasNext) {
			val window = slider.next
			
			val ascii = if (window == "ng") {
				mapChar(window) toString
			} else {
				window map { ch => mapChar(ch.toString) }
			}
			
			buffer ++= ascii
		}

		(buffer.toString, word)
	}
	
	def mapChar(tagalogChar: String) = (65 + alphabet.indexOf(tagalogChar.toLowerCase)).asInstanceOf[Char]
	
	val toSort = Seq(
			Seq("abakada","alpabet","tagalog","ako"),
			Seq("ang","ano","anim","alak","alam","alab"),
			Seq("siya","niya","kaniya","ikaw","ito","iyon"),
			Seq("kaba","baka","naba","ngipin","nipin"),
			Seq("knilngiggnngginggn","ingkigningg","kingkong","dingdong","dindong","dingdont","ingkblot"),
			Seq("silangang", "baka", "bada", "silang"))
	
	val expected = Seq(
			Seq("abakada", "ako", "alpabet", "tagalog"),
			Seq("alab", "alak", "alam", "anim", "ano", "ang"),
			Seq("kaniya", "ikaw", "ito", "iyon", "niya", "siya"),
			Seq("baka", "kaba", "naba", "nipin", "ngipin"),
			Seq("kingkong","knilngiggnngginggn","dindong","dingdont","dingdong","ingkblot","ingkigningg"),
			Seq("baka", "bada", "silang", "silangang"))
			
	val sorted = toSort map sortWords
	
	sorted foreach println
	
	val correctAnswers = sorted zip expected filter { case (sorted, expected) => sorted == expected }
	
	println (correctAnswers.size)

}