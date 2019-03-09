package agc003

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val n = sc.nextInt
  val ans = (1 to n).map(_ => sc.nextLong)
    .foldLeft(0L, 0L) {
      case ((cnt, o), a) => (cnt + (a + o) / 2, if (a == 0) 0 else (a + o) % 2)
    }

  println(ans._1)
}
