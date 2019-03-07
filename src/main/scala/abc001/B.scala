package abc001

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val m = sc.nextInt()

  if (m < 100) {
    println(0)
  } else if (m <= 5000) {
    val tmp = m / 100
    if (tmp / 10 == 0) {
      println(s"0$tmp")
    } else {
      println(tmp)
    }
  } else if (m <= 30000) {
    println(m / 1000 + 50)
  } else if (m <= 70000) {
    println((m / 1000 - 30) / 5 + 80)
  } else {
    println(89)
  }

}
