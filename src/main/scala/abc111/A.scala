package abc111

import java.util.Scanner

object A extends App {
  val sc = new Scanner(System.in)
  println(sc.next().map(c =>
    if (c == '1')
      '9'
    else if (c == '9')
      '1'
    else
      c
  ))
}
