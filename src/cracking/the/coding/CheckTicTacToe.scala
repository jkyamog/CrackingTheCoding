package cracking.the.coding

object CheckTicTacToe extends App {
	
	def checkStraight(tictactoe: Seq[Seq[Char]]): Option[Char] = {
		val char = tictactoe(0)(0)
		val checks = for {
			offset <- 0 to 2
			if (tictactoe(0)(0 + offset) == char) &&
				(tictactoe(1)(0 + offset) == char) &&
				(tictactoe(2)(0 + offset) == char)
		} yield (char)
		
		checks.headOption
	}
	
	def checkDiagonal(tictactoe: Seq[Seq[Char]]): Option[Char] = {
		val char = tictactoe(2)(0)
		
		if ((tictactoe(1)(1) == char) && (tictactoe(0)(2) == char))
			Some(char)
		else
			None
	}
	
	def check(tictactoe: Seq[Seq[Char]]): Option[Char] = {
		Seq(checkStraight(tictactoe),
			checkStraight(tictactoe.transpose),
			checkDiagonal(tictactoe),
			checkDiagonal(tictactoe.transpose)
		).flatten.headOption
	}
	
	val c1 = check(Seq(
			Seq('x', 'x', 'x'),
			Seq('x', 'o', 'x'),
			Seq('o', 'x', 'o')
	))
	
	val c2 = check(Seq(
			Seq('x', 'x', 'o'),
			Seq('x', 'o', 'x'),
			Seq('o', 'x', 'o')
	))

	val c3 = check(Seq(
			Seq('x', 'o', 'x'),
			Seq('x', 'o', 'x'),
			Seq('o', 'x', 'o')
	))
	
	val c4 = check(Seq(
			Seq('x', 'x', 'o'),
			Seq('x', 'x', 'x'),
			Seq('o', 'x', 'o')
	))
	
	println(c1)
	println(c2)
	println(c3)
	println(c4)

}