package abc116

import java.util.Scanner

object A extends App {
  val sc = new Scanner(System.in)

  val s = (1 to 3).map(_ => sc.nextInt())
    .sorted

  println(s(0) * s(1) / 2)
}
