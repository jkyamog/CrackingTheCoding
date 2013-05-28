package cracking.the.coding

object MapUsingFold extends App {

	val cars = List("gt-r", "fxx", "gto")

	val upperCase = (acc: List[String], str: String) => str.toUpperCase :: acc

	val concat = cars.foldRight(List[String]())((car, acc) => upperCase(acc, car))
	
	println(concat)
}