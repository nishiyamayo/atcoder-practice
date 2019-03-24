package abc122

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val s = sc.next.toCharArray

  s.map(c => c match {
    case 'A' => 'T'
    case 'T' => 'A'
    case 'C' => 'G'
    case 'G' => 'C'
  }
  ).foreach(print)
  println()
}
