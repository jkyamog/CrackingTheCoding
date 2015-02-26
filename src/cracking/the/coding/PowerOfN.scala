package cracking.the.coding


object PowerOfN extends App {

  def simple(x: Int, n: Int): Int = {
    (1 to n).foldLeft(1)((prod, _) => prod * x)
  }

  def fast(x: Int, n: Int): Int = {
    if (n == 0) 1
    else if (n == 1) x
    else {
      val p = fast(x, n/2)
      if (n % 2 == 0)
        p * p
      else
        p * p * x
    }
  }

  println(simple(2, 0))
  println(simple(2, 2))
  println(simple(2, 5))

  println(fast(2, 0))
  println(fast(2, 2))
  println(fast(2, 5))

  /*
  fast(2, 2) = 4
    fast(2, 1) = 2
        fast(2, 0) = 1
        1 + 1
    2 + 2
  */
}
