package minna2019

import java.util.Scanner

object B extends App {
  val sc = new Scanner(System.in)

  val seq = (1 to 6).map(_ => sc.nextInt())
    .groupBy[Int](x => x)
    .toSeq
    .map(_._2.length)
    .sorted

  println(if (seq == Seq(1, 1, 2, 2)) "YES" else "NO")
}
