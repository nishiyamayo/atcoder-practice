package abc095

import java.util.Scanner

object A extends App {
  val sc = new Scanner(System.in)

  println(700 + sc.next().count(_ == 'o') * 100)
}
