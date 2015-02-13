package cracking.the.coding

object FindRepeat3 extends App {

  val arr = Seq(1, 3, 6, 2, 1, 7, 1)
  val noTimes = collection.mutable.Map[Int, Int]()

  for {
    n <- arr
  } {
    noTimes.get(n) match {
      case Some(times) => noTimes.put(n, times + 1)
      case None => noTimes.put(n, 1)
    }
  }

  val found = noTimes.find{ case (no, times) => times >= 3 }

  println(found)
}
