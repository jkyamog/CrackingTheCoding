package cracking.the.coding

object InWindow extends App {
	
	val arr = Seq(1, 2, 3, 8, 5, 6, 7, 7, 9, 0)
//	var arr = Seq(1, 2, 3, 4, 5, 6)
	
	val slider = arr sliding 3
	
	while (slider.hasNext) {
		val window = slider.next
		println(window)
		
		val unique = window.distinct
		
		if (window != unique) println(window)
		
		val variance = 1
		
		val nearCombo = for {
			w1 <- window
			w2 <- window
			if (w1 == w2 - variance || w1 == w2 -variance)
		} yield(w2)
		
		println(nearCombo)
				
	}

}