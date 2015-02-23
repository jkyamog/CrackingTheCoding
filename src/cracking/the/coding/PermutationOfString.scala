package cracking.the.coding


object PermutationOfString extends App {

  // b a r => n! => 1 * 2 * 3

  // b a r
  // b r a
  // a b r
  // a r b
  // r b a
  // r a b

  val str = "barb"

  def permutations[T](list: List[T]): Set[List[T]] = {
    if (list.isEmpty)
      Set.empty
    else if (list.size == 1)
      Set(list)
    else
      (for {
        n <- 0 until list.size
        (before, after) = list.splitAt(n)
        j <- permutations(before ::: after.tail)
      } yield list(n) :: j).toSet
  }

  println(permutations(str.toList).size == str.toList.permutations.size)
  println(permutations(str.toList).size)
  println(str.toList.permutations.size)
}
