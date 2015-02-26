package cracking.the.coding

object LongestIncreasingSubsequence extends App {
	
	val nums = List(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)

  def bruteForceLIS(nums: Seq[Int]) = {
    def allCombo(currentList: Seq[Int], toPick: Seq[Int]): Seq[Seq[Int]] = {
      if (toPick.isEmpty) {
        Seq(currentList)
      } else if (toPick.size == 1) {
        Seq(currentList :+ toPick.head)
      } else {
        for {
          n <- toPick

          rest = toPick.dropWhile(_ != n) // get everything to the right of n
                      .tail               // remove n
                      .filter(_ > n)      // only get elements bigger than n, useless to compute the other combo, looking for increasing values only
          c <- allCombo(currentList :+ n, rest) // now add the n to the list chosen, use the rest for further computation
        } yield c
      }
    }

    allCombo(Seq.empty, nums).sortBy(_.size).last // get the biggest sized result
  }


  println(bruteForceLIS(nums))

// List(0, 2, 6, 9, 11, 15)
}