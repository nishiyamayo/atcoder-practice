package agc004

import java.util.Scanner

object A extends App {
  val sc = new Scanner(System.in)

  val in = (1 to 3).map(_ => sc.nextLong).sorted

  if (in.exists(_ % 2 == 0)) {
    println(0)
  } else {
    println(in(0) * in(1))
  }
}
