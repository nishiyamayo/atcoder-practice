package abc095

import java.util.Scanner

object B extends App {
  val sc = new Scanner(System.in)

  val (n, x) = (sc.nextInt(), sc.nextInt())
  val ar = for {
    _ <- (1 to n)
  } yield sc.nextInt()

  println(n + (x - ar.sum) / ar.min)
}
