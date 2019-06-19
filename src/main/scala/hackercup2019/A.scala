package hackercup2019

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val t = sc.nextInt

  for {
    i <- 1 to t
    s = sc.next
    n = s.length
    bs = s.count(_ == 'B')
  } yield {
    val x =  if (n / 2 <= bs && bs < n - 1) "Y" else "N"
    println(s"Case #${i}: $x")
  }

}
