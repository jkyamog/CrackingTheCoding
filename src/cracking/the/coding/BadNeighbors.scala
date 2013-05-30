package cracking.the.coding

import scala.collection.mutable.Buffer

/**

http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009

Problem Statement for BadNeighbors


Problem Statement
    	
The old song declares "Go ahead and hate your neighbor", and the residents of Onetinville have taken those words to heart. Every resident hates his next-door neighbors on both sides. Nobody is willing to live farther away from the town's well than his neighbors, so the town has been arranged in a big circle around the well. Unfortunately, the town's well is in disrepair and needs to be restored. You have been hired to collect donations for the Save Our Well fund.

Each of the town's residents is willing to donate a certain amount, as specified in the int[] donations, which is listed in clockwise order around the well. However, nobody is willing to contribute to a fund to which his neighbor has also contributed. Next-door neighbors are always listed consecutively in donations, except that the first and last entries in donations are also for next-door neighbors. You must calculate and return the maximum amount of donations that can be collected.

 
Definition
    	
Class:	BadNeighbors
Method:	maxDonations
Parameters:	int[]
Returns:	int
Method signature:	int maxDonations(int[] donations)
(be sure your method is public)
    
 
Constraints
-	donations contains between 2 and 40 elements, inclusive.
-	Each element in donations is between 1 and 1000, inclusive.
 */
object BadNeighbors extends App {
	
	def maxDonation(donations: Seq[Int]) = {
		var sum = 0
		val donated = Seq.empty padTo (donations.length, false) toBuffer
		
		var max = findMax(donations, donated)
		while (max > -1) {
			sum += max
			max = findMax(donations, donated)
		}
		
		val x = donated zip donations
		x foreach println
		
		sum
	}
	
	def findMax(donations: Seq[Int], donated: Buffer[Boolean]) = {
		var (max, mIndex) = (-1, -1)
		for (i <- 0 until donations.length) {
			if (donations(i) >= max && notDonated(i, donated)) {
				max = donations(i)
				mIndex = i
			}
		}
		
		if (max > -1) donated(mIndex) = true
		
		max
	}
	
	def notDonated(index: Int, donated: Buffer[Boolean]) = {
		var left = if (index == 0)
				donated.length - 1
			else
				index - 1
				
		var right = if (index == donated.length - 1)
				0
			else
				index + 1
				
		(!donated(index) && !donated(left) && !donated(right))
	}
	
	println(maxDonation(Seq(10, 3, 2, 5, 7, 8)))
	println(maxDonation(Seq(7, 7, 7, 7, 7, 7, 7)))
	println(maxDonation(Seq(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)))
	println(maxDonation(Seq(50, 49, 1, 49, 50, 49, 1, 49)))
	println(maxDonation(Seq(94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72)))
  
}