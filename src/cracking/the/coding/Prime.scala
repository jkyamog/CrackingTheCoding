package cracking.the.coding

import scala.annotation.tailrec

object Prime extends App {
	
	def isPrime1(n: Int) =
		if (n <= 2) true
		else 2 until n forall (n % _ != 0)
	
	def nPrime1(n: Int) = {
		@tailrec
		def nPrimeHelper(i: Int, primes: Seq[Int]): Seq[Int] = {
			if (primes.length == n) primes
			else if (isPrime1(i)) nPrimeHelper(i + 1, primes :+ i)
			else nPrimeHelper(i + 1, primes)
		}
		
		nPrimeHelper(1, Seq.empty)
	}

	def nPrime2(n: Int) = {
		def primes(i: Int): Stream[Int] = 
			if (isPrime1(i)) i #:: primes(i + 1)
			else primes(i + 1)
			
		primes(1).take(n).toList
	}
	
	println(nPrime1(5))
	println(nPrime2(5))
	
}