package arc001

import java.util.Scanner

object B extends App {
  val sc = new Scanner(System.in)

  val n, x = sc.nextLong

  println(3 * (n - gcd(n, x)))

  def gcd(a: Long, b: Long): Long =
    if (b == 0) a
    else gcd(b, a % b)
}
