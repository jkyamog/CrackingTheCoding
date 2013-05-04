package cracking.the.coding

object scratch2 {

	val range = 1 to 10                       //> range  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6,
                                                  //|  7, 8, 9, 10)
	
	range.collect{
		case n if n > 5 => n.toString
	}                                         //> res0: scala.collection.immutable.IndexedSeq[String] = Vector(6, 7, 8, 9, 10)
                                                  //| 

}