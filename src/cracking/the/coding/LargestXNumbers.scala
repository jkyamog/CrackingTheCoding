package cracking.the.coding

import scala.collection.mutable

object LargestXNumbers extends App {

  val stream = Stream(1, 5, 8, 2, 4, 10, 11)
  val xSize = 3

  var maxNumbers = new mutable.TreeSet[Int]

  stream.foreach { n =>
    if (maxNumbers.size >= xSize && n > maxNumbers.max) {
      maxNumbers.add(n)
      maxNumbers = maxNumbers.drop(1)
    } else if (maxNumbers.size < xSize) maxNumbers.add(n)
  }
  
  maxNumbers foreach println

}
