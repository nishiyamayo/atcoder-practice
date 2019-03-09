package agc002

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val a, b = sc.nextLong

  if ((a < 0 && b > 0) || a == 0 || b == 0) {
    println("Zero")
  } else if(a > 0 || (b - a) % 2 == 1) {
    println("Positive")
  } else {
    println("Negative")
  }
}
