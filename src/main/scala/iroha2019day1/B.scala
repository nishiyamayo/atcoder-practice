package iroha2019day1

import java.util.Scanner

object B extends App {
  val sc = new Scanner(System.in)

  val s = sc.next
  val k = sc.nextInt % s.length

  println(s.substring(k) + s.substring(0, k))
}
