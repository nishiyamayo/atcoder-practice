package abc127

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val a, b = sc.nextInt

  if (a <= 5) {
    println(0)
  } else if (a <= 12) {
    println(b / 2)
  } else {
    println(b)
  }

}
