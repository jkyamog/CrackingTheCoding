package cracking.the.coding

object FizzBuzz extends App {

	val range = 1 to 100

	val a1 = range.map {
		case n if (n % 3 == 0) && (n % 5 == 0) => "Fizz Buzz"
		case n if (n % 3 == 0) => "Fizz"
		case n if (n % 5 == 0) => "Buzz"
		case n => n.toString
	}
	
	println(a1)
	
	val a2 = collection.mutable.ArrayBuffer[String]()
	
	for {
		n <- range
	} {
		if ((n % 3 == 0) && (n % 5 == 0)) a2 += "Fizz Buzz"
		else if (n % 3 == 0) a2 += "Fizz"
		else if (n % 5 == 0) a2 += "Buzz"
		else a2 += n.toString
	}

	println(a2)
}