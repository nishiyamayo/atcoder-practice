package soundhound

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val l = sc.next
  val n = sc.nextInt

  println(l.zipWithIndex.filter(_._2 % n == 0).map(_._1).mkString)
}
