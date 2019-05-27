package abc127

import java.util.Scanner

object B extends App {
  val sc = new Scanner(System.in)
  val r, d, x = sc.nextLong

  Stream.iterate(x * r - d)(xi => xi * r - d)
    .take(10)
    .foreach(println)
}
