package abc115

import java.util.Scanner

object B extends App {
  val sc = new Scanner(System.in)

  val n = sc.nextInt()

  val ar = for {
    _ <- 0 to (n - 1)
  } yield sc.nextInt()

  val m = ar.max
  val sum = ar.sum
  println(sum - m / 2)
}
