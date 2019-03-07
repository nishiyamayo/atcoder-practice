package soundhound

import java.util.Scanner

object C extends App {

  val sc = new Scanner(System.in)

  val (n, m, d) = (sc.nextLong, sc.nextLong, sc.nextLong)

  if (d != 0) {
    printf("%.10f\n", 2.0 * (n - d) * (m - 1) / (n * n))
  } else {
    printf("%.10f\n", 1.0 * (n - d) * (m - 1) / (n * n))

  }
}
