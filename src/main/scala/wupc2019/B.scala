package wupc2019

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val h, w = sc.nextInt

  val bs = (1 to h * w).map(_ => sc.nextInt)

  val ok = bs.contains(5) || bs.max == 0

  if (bs.max == 0) {
    println("Yes 0")
  } else if (!bs.contains(5)) {
    println("No")
  } else if (bs(0) == 5 || bs(h * w - 1) == 5 || (h > 1 && w > 1)) {
    bs.max match {
      case 0 =>
      case 9 => println("Yes 4")
      case 8 => println("Yes 3")
      case 7 => println("Yes 2")
      case 6 => println("Yes 2")
      case _ => println("Yes 1")
    }
  } else {
    val ans = bs
      .zipWithIndex
      .filter(_._1 == 5)
      .map(t => {
        val l = (0 until t._2).map(bs(_)).max match {
          case 9 => 3
          case 8 => 2
          case 7 => 1
          case 6 => 1
          case _ => 0
        }
        val r = (t._2 + 1 until w * h).map(bs(_)).max match {
          case 9 => 3
          case 8 => 2
          case 7 => 1
          case 6 => 1
          case _ => 0
        }
        l + r + 1
      })
      .min
    println(s"Yes ${ans}")
  }
}
