package cracking.the.coding

object scratch {

	println("a")                              //> a

//	val occurances = Seq[Tuple2[String, Int]](("a", 1), ("r", 1), ("m", 1), ("y", 1))

	val occurances = Array(Set(1, 2, 3), Set(4, 5, 6))
                                                  //> occurances  : Array[scala.collection.immutable.Set[Int]] = Array(Set(1, 2, 3
                                                  //| ), Set(4, 5, 6))

	occurances.flatMap { a =>
		Some(a.sum)
	}                                         //> res0: Array[Int] = Array(6, 15)
	
	val foo = Seq(1, 2, 3)                    //> foo  : Seq[Int] = List(1, 2, 3)
	val bar = Seq('a', 'b', 'c', 'd')         //> bar  : Seq[Char] = List(a, b, c, d)
	
	for {
		i <- foo sliding 2
	} yield (i)                               //> res1: Iterator[Seq[Int]] = non-empty iterator
	
	val permutation = for {
		i <- foo
		j <- foo
		k <- foo
	} yield (i, j, k)                         //> permutation  : Seq[(Int, Int, Int)] = List((1,1,1), (1,1,2), (1,1,3), (1,2,1
                                                  //| ), (1,2,2), (1,2,3), (1,3,1), (1,3,2), (1,3,3), (2,1,1), (2,1,2), (2,1,3), (
                                                  //| 2,2,1), (2,2,2), (2,2,3), (2,3,1), (2,3,2), (2,3,3), (3,1,1), (3,1,2), (3,1,
                                                  //| 3), (3,2,1), (3,2,2), (3,2,3), (3,3,1), (3,3,2), (3,3,3))
                                                  
	def permutations[T](seq: List[T]): List[List[T]] = {
		if (seq.isEmpty)
			Nil
		else if (seq.size == 1)
			List(seq)
		else
			for {
				i <- seq
				j <- permutations(seq.filterNot(_ == i))
			} yield {
				i :: j
			}
	}                                         //> permutations: [T](seq: List[T])List[List[T]]
	
	def factorial(n: Int): Int = {
		def factorialHelper(num: Int, result: Int): Int = {
			if (num > n)
				result
			else
				factorialHelper(num + 1, result * num)
		}
	
		factorialHelper(1, 1)
	}                                         //> factorial: (n: Int)Int
	
  permutations(foo.toList)                        //> res2: List[List[Int]] = List(List(1, 2, 3), List(1, 3, 2), List(2, 1, 3), Li
                                                  //| st(2, 3, 1), List(3, 1, 2), List(3, 2, 1))
                                                  
  permutations(bar.toList)                        //> res3: List[List[Char]] = List(List(a, b, c, d), List(a, b, d, c), List(a, c
                                                  //| , b, d), List(a, c, d, b), List(a, d, b, c), List(a, d, c, b), List(b, a, c
                                                  //| , d), List(b, a, d, c), List(b, c, a, d), List(b, c, d, a), List(b, d, a, c
                                                  //| ), List(b, d, c, a), List(c, a, b, d), List(c, a, d, b), List(c, b, a, d), 
                                                  //| List(c, b, d, a), List(c, d, a, b), List(c, d, b, a), List(d, a, b, c), Lis
                                                  //| t(d, a, c, b), List(d, b, a, c), List(d, b, c, a), List(d, c, a, b), List(d
                                                  //| , c, b, a))
	
	val moo =	foo.permutations          //> moo  : Iterator[Seq[Int]] = non-empty iterator
	
	factorial(5)                              //> res4: Int = 120
	
	def combinations[T](n: Int, seq: Seq[T]) = permutations(seq.toList).size / factorial(n)
                                                  //> combinations: [T](n: Int, seq: Seq[T])Int
                                                  
	combinations(2, foo)                      //> res5: Int = 3
	
//	val moo = foo.combinations(1)

	foo.combinations(2).size                  //> res6: Int = 3
	
	while (moo.hasNext) println(moo.next)     //> List(1, 2, 3)
                                                  //| List(1, 3, 2)
                                                  //| List(2, 1, 3)
                                                  //| List(2, 3, 1)
                                                  //| List(3, 1, 2)
                                                  //| List(3, 2, 1)

}