package abc125

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val n = sc.nextInt

  val x = (1 to n).map(_ => sc.nextInt)
  val y = (1 to n).map(_ => sc.nextInt)

  val ans = x.zip(y)
    .filter(t => t._1 > t._2)
    .map(t => t._1 - t._2)
    .sum

  println(ans)

}
