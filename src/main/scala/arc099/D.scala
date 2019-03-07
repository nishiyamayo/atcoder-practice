package arc099

import java.util.Scanner

object D extends App {

  val sc = new Scanner(System.in)

  val k = sc.nextInt

  val seq = (1 to k).map(x => (x.toDouble / s(x), x))

  val filtered = seq.filterNot {
      case (v, idx) => (idx to k - 1).map(seq).find(_._1 < v).isDefined
    }

  println(filtered)

  def s(x: Int) = Iterator.iterate(x)(_ / 10)
    .takeWhile(_ != 0)
    .map(_ % 10)
    .sum

}
