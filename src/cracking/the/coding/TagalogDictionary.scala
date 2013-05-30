package cracking.the.coding

/**

http://community.topcoder.com/stat?c=problem_statement&pm=7411

Problem Statement
    	
In the first half of the 20th century, around the time that Tagalog became the national language of the Philippines, a standardized alphabet was introduced to be used in Tagalog school books (since then, the national language has changed to a hybrid "Pilipino" language, as Tagalog is only one of several major languages spoken in the Philippines).

Tagalog's 20-letter alphabet is as follows:

a b k d e g h i l m n ng o p r s t u w y
Note that not all letters used in English are present, 'k' is the third letter, and 'ng' is a single letter that comes between 'n' and 'o'.

You are compiling a Tagalog dictionary, and for people to be able to find words in it, the words need to be sorted in alphabetical order with reference to the Tagalog alphabet. Given a list of Tagalog words as a String[], return the same list in Tagalog alphabetical order.

 
Definition
    	
Class:	TagalogDictionary
Method:	sortWords
Parameters:	String[]
Returns:	String[]
Method signature:	String[] sortWords(String[] words)
(be sure your method is public)
    
 
Notes
-	Any 'n' followed followed by a 'g' should be considered a single 'ng' letter (the one that comes between 'n' and 'o').
 
Constraints
-	words will contain between 1 and 50 elements, inclusive.
-	Each element of words will contain between 1 and 50 characters, inclusive.
-	Each character of each element of words will be a valid lowercase letter that appears in the Tagalog alphabet.
-	Each element of words will be distinct.
 
*/

object TagalogDictionary extends App {
	
	val alphabet = Seq("a","b","k","d","e","g","h","i","l","m","n","ng","o","p","r","s","t","u","w","y")
	
	def sortWords(words: Seq[String]) = 
		words map toAscii sortBy{case (ascii, _) => ascii} map {case (_, tagalog) => tagalog}
	
	def toAscii(word: String) = {
		val buffer = for {
			window <- word.sliding(2).toSeq
		} yield {
			if (window == "ng")
				mapChar(window) toString
			else
				window map { ch => mapChar(ch.toString) }
		}

		(buffer.mkString, word)
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