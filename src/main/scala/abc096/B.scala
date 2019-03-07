package abc096

import java.util.Scanner

object B extends App {
  val sc = new Scanner(System.in)

  val (a, b, c) = (sc.nextInt(), sc.nextInt(), sc.nextInt())
  val k = sc.nextInt()

  val i = Seq(a, b, c)
  val ans = i.max * (math.pow(2, k) - 1) + i.sum

  println(ans.toInt)
}
