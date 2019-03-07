package abc095

import java.util.Scanner

object C extends App {
  val sc = new Scanner(System.in)

  val (a, b, c, x, y) = (sc.nextLong(), sc.nextLong(), sc.nextLong(), sc.nextLong(), sc.nextLong())

  println(Seq(a * x + b * y, c * x * 2 + b * math.max(0, y - x), c * y * 2 + a * math.max(0, x - y)).min)
}
