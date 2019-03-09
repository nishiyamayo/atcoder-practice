package agc001

import java.util.Scanner

object A extends App {

  val sc = new Scanner(System.in)

  val n = sc.nextInt

  val ls = (1 to 2 * n).map(_ => sc.nextInt)
    .sorted

  val ans = (0 to (n - 1)).foldLeft(0){
    case (acc, idx) => acc + ls(idx * 2)
  }

  println(ans)

}
