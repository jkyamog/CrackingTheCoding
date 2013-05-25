package cracking.the.coding

object FindMissing extends App {
	
	val seqOfRandomNo = Seq(4, 5, 7, 1, 9)
	val missingOne = seqOfRandomNo.filterNot(_ == 5)
	
	val missingTwo = seqOfRandomNo.filterNot(n => n == 5 || n == 1)
	
	println(missingOne)
	println(missingTwo)
	
	println(seqOfRandomNo.sum - missingOne.sum)
	
	def findMissing2WithSpace(seq: Seq[Int]) = {
		// TODO
	}
}