package arc099

import java.util.Scanner

object C extends App {
  val sc = new Scanner(System.in)

  val (n, k) = (sc.nextInt, sc.nextInt)
  val li = (1 to n).map(_ => sc.nextInt)

  println(1 + (n - 2) / (k - 1))
}
