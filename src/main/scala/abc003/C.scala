package abc003

import java.util.Scanner

object C extends App {

  val sc = new Scanner(System.in)

  val n, k = sc.nextInt

  val rs = (1 to n ).map(_ => sc.nextLong).sorted.reverse

  val ans = rs.take(k)
    .reverse
    .foldLeft(0.0) {
      case (acc, r) => (acc + r) / 2
    }

  println(ans)
}
