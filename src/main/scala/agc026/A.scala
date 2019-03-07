package agc026

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val n = sc.nextInt

  val a = (1 to n).map(_ => sc.nextInt)

  val ans = (0 to (n - 1)).foldLeft((0, 0)) {
    case ((cnt, cur), idx) => if (cur == a(idx)) {
      (cnt + 1, 0)
    } else {
      (cnt, a(idx))
    }
  }
    ._1

  println(ans)
}
