package minna2019

import java.util.Scanner

object A extends App {
  val sc = new Scanner(System.in)
  val n = sc.nextInt()
  val k = sc.nextInt()

  println(if ((n + 1) / 2 >= k) "YES" else "NO")
}
