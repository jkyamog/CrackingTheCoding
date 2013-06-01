package cracking.the.coding

import scala.annotation.tailrec

object Fibbo extends App {
	
	def fib1(n: Int): Int = {
		if (n <= 2) 1
		else fib1(n-1) + fib1(n-2)
	}
	
	def fib2(n: Int) = {
		@tailrec
		def fibtr(i: Int, p: Int, s: Int): Int = {
			if (n == i) s
			else fibtr(i + 1, s, p + s)
		}
		
		fibtr(1, 0, 1)
	}
	
	def fib3(n: Int) = {
		var s = 1
		var p = 0
		for (i <- 1 until n) {
			val t = s
			s = s + p
			p = t
		}
		s
	}
	
	def fib4(n: Int) = {
		def fibs(p: Int, s: Int): Stream[Int] = p #:: fibs(s, p+s)
		
		fibs(1, 1).take(n).toList(n-1)
	}

	Seq(1, 2, 6) foreach { n =>
		println(fib1(n))
		println(fib2(n))
		println(fib3(n))
		println(fib4(n))
	}

}