package abc115

import java.util.Scanner

object C extends App {

  val sc = new Scanner(System.in)

  val n, k = sc.nextInt()

  val ar = (for {
    _ <- 0 until n
  } yield sc.nextInt())
    .sorted

  println(ar)

  val ans = (for {
    idx <- 0 until  n - k + 1
  } yield ar(idx + k - 1) - ar(idx))
    .min

  println(ans)

}
