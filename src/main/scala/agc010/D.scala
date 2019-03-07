package agc010

import java.util.Scanner

object D extends App {

  val sc = new Scanner(System.in)

  val n = sc.nextInt()
  val ar = (1 to n).map(_ => sc.nextLong())

  val determined = ar.count(_ % 2 == 1) > 1 || ar.exists(_ == 1) || (ar.sum - n) % 2 == 1

  if (determined) {
    if ((ar.sum - n) % 2 == 1) {
      println("First")
    } else {
      println("Second")
    }
  } else {
    println("noob")
  }
}
