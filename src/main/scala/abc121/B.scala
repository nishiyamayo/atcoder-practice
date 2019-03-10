package abc121

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val n, m, c = sc.nextInt

  val B = (1 to m).map(_ => sc.nextInt)

  val ans = (1 to n)
    .map(_ => (1 to m).map(_ => sc.nextInt))
    .count(A => A.zip(B).foldLeft(0) {case (sum, (a, b)) => sum + a * b} + c > 0 )

  println(ans)

}
