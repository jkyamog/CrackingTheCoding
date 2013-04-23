package cracking.the.coding

import scala.util.parsing.combinator.JavaTokenParsers
import scala.util.parsing.combinator.syntactical.StdTokenParsers
import scala.util.parsing.combinator.RegexParsers

/**
  Variable-Base Expression Evaluation

You've woken up one day to find that everyone suddenly expresses numbers in different number bases. 
You're seeing prices in octal and phone numbers in hexadecimal. It's a numerical Tower of Babel! For 
your own sanity, you decide to program a simple mathematical expression evaluator that can handle 
numbers in different number bases. It should support addition, subtraction, and multiplication, 
should respect order of operations, and should handle number bases between 2 and 16.

While your language of choice may directly support expression evaluation, please create your own.

The input on stdin is a mathematical expression on a single line. Number constants are expressed 
like "123_4", which is "123" in base 4, which is 27 in base 10. Some digits in the higher bases 
will be represented with uppercase letters. Numbers within the expression will always be non-negative 
integers. The operators will be +, -, and *. Whitespace should be ignored.

Your program should emit to stdout a single base-10 number with no underscores.

While correctness and performance are the most important parts of this problem, a human will be 
reading your solution, so please make an effort to submit clean, readable code. In particular, 
do not write code as if you were solving a problem for a competition.

Here's an example input and output:

   Input:
1430_5 - 110_2 * 2A_12 + 10_10

   Output:
46
 */

object VariableBaseExpressionEvaluation extends App {
	import Calculator._
	
	def pn(x: Number) = println(x + " " + x.base.toString + " " + x.numbers + " " + x.toBase10)
	
	pn(Number("123_4"))
	pn(Number("1430_5"))
	pn(Number("110_2"))
	pn(Number("2A_12"))
	pn(Number("10_10"))
	
	println(Calculator.evaluate(
			Operation('+',
				Operation('-', Number("1430_5"), 
						Operation('*', Number("110_2"), Number("2A_12"))
						)
				,
				Number("10_10"))
				)
		)

	println(parse("1430_5 - 110_2"))
	
	val foo = parse("1430_5 - 110_2 * 2A_12 + 10_10")
	println(evaluate(foo.get))

	val bar = parse("3710_8 - 111001001_2 + 2F_16 / 20_10") // 1992 - 457 + 47 / 20 = 1537.35
	println(bar)
	println(evaluate(bar.get))

	val bar2 = parse("3710_8 * 111001001_2 + 2F_16 / 20_10") // 1992 * 457 + 47 / 20 = 910346.35
	println(bar2)
	println(evaluate(bar2.get))
	
}

abstract class Expr

case class Number(value: String) extends Expr {
	import Calculator._
	
	val base = value.dropWhile(_ != '_').tail
	val numbers = value.takeWhile(_ != '_')
	
	val toBase10 = {
		numbers.reverse.map(base10Map).zipWithIndex // reverse then for each place, put an index
			.map{ // calculate for each place the value
				case (v, i) if i == 0 => v * 1
				case (v, i) => v * math.pow(base.toInt, i)
			}
			.sum // sum all places to obtain the value
	}
	
	override def toString = toBase10.toString
}

case class Operation(op: Char, left: Expr, right: Expr) extends Expr


object Calculator {
	val base10Map = Map(
			'0' -> 0,
			'1' -> 1,
			'2' -> 2,
			'3' -> 3,
			'4' -> 4,
			'5' -> 5,
			'6' -> 6,
			'7' -> 7,
			'8' -> 8,
			'9' -> 9,
			'A' -> 10,
			'B' -> 11,
			'C' -> 12,
			'D' -> 13,
			'E' -> 14,
			'F' -> 15
	)
	
	/*
	 * recursively walk down the expr tree, valuate until the Number then convert to base10
	 */
	def evaluate(expr: Expr): Double = expr match {
		case n: Number => n.toBase10
		case Operation(op, left, right) => op match {
			case '+' => evaluate(left) + evaluate(right) 
			case '-' => evaluate(left) - evaluate(right) 
			case '*' => evaluate(left) * evaluate(right) 
			case '/' => evaluate(left) / evaluate(right) 
		}
	}
	
	def parse(text: String) = Parser.parse(text)
	
	// below is heavily taken from scala RegexParser example
	object Parser extends RegexParsers {
		def number: Parser[Expr] = """[0-9A-F]+_[0-9]{1,2}""".r ^^ { Number(_) }
		def factor: Parser[Expr] = number | term
		def term: Parser[Expr] = factor ~ rep("*" ~ factor | "/" ~ factor) ^^ {
			case number ~ list => (number /: list) {
				case (lhs, "*" ~ rhs) => Operation('*', lhs, rhs)
				case (lhs, "/" ~ rhs) => Operation('/', lhs, rhs)
			}
		}
		def expr: Parser[Expr] = term ~ rep("+" ~ term | "-" ~ term) ^^ {
			case number ~ list => list.foldLeft(number) { // same as before, using alternate name for /:
				case (lhs, "+" ~ rhs) => Operation('+', lhs, rhs)
				case (lhs, "-" ~ rhs) => Operation('-', lhs, rhs)
			}
		}
      
		def parse(text: String) = parseAll(expr, text)		
	}
	
}