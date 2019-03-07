package abc111

import java.util.Scanner

object B extends App {
  val sc = new Scanner(System.in)

  val x = sc.nextInt()

  val l = Seq(111, 222, 333, 444, 555, 666, 777, 888, 999)

  println(l.find(_ >= x).get)

}
