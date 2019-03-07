package abc114

import java.util.Scanner

object B extends App {
  val sc = new Scanner(System.in)

  val s = sc.next
  val l = s.length

  val ans = (for {
    i <- 0 until l - 2
  } yield ("" + s(i) + s(i + 1) + s(i + 2)).toInt)
    .map(i => math.abs(753 - i))
    .min

  println(ans)
}
