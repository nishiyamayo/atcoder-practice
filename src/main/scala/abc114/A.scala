package abc114

import java.util.Scanner

object A extends App {
  val sc = new Scanner(System.in)

  val x = sc.nextInt

  if (x == 3 || x == 5 || x == 7) {
    println("YES")
  } else {
    println("NO")
  }
}
