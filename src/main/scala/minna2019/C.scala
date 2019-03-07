package minna2019

import java.util.Scanner

object C extends App {

  val sc = new Scanner(System.in)

  val k, a, b = sc.nextLong()

  if (a + 2 > b) {
    println(k + 1)
  } else if (a >= k) {
    println(k + 1)
  } else {
    val m = (k - a + 1) / 2
    println(a + m * (b - a) + (if ((k - a + 1) % 2 == 0) 0 else 1))
  }
}
