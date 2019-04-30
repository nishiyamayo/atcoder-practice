package iroha2019day1

import java.util.Scanner

object D extends App {

  val sc = new Scanner(System.in)

  val n, x, y = sc.nextInt

  val a = (1 to n).map(_ => sc.nextInt).sorted

  val ta = x + a.zipWithIndex.filter(_._2 % 2 == 1).map(_._1).sum
  val ao = y + a.zipWithIndex.filter(_._2 % 2 == 0).map(_._1).sum

  if (ta == ao) {
    println("Draw")
  } else if (ta > ao) {
    println("Takahashi")
  } else {
    println("Aoki")
  }
}
