package abc113

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val n = sc.nextInt()
  val t, a = sc.nextLong() * 1000
  val hs = (1 to n).map(_ => sc.nextLong())

  val ans = hs
    .zipWithIndex
    .map(tup => (tup._2, t - tup._1 * 6))
    .minBy(tup => math.abs(a - tup._2))

  println(ans._1 + 1)

}
