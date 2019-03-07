package abc002

import java.util.Scanner

object B extends App {
  val sc = new Scanner(System.in)

  println(
    sc.next().filterNot(Seq('a', 'i', 'u', 'e', 'o').contains(_)).toString
  )
}
