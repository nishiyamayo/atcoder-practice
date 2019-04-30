package iroha2019day1

import java.util.Scanner

object E extends App {

  val sc = new Scanner(System.in)

  val n, a = sc.nextLong()
  val b = sc.nextInt

  val ds = ((1 to b).map(_ => sc.nextLong) ++ Seq(n)).sorted.distinct

  val ans = ds.foldLeft((0L, 0L)) {
    case ((la, sum), d) => {
      (d, (d - la - 1) / a + sum + 1)
    }
  }

  println(n - ans._2)
}
