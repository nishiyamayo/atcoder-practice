package abc097

import java.util.Scanner

object B extends App {

  val sc = new Scanner(System.in)

  val x = sc.nextInt()

  val ans = (1 :: (2 to x).toStream
    .flatMap(n => (2 to x).map(math.pow(n, _).toInt).takeWhile(_ <= x)).toList)
    .max


  println(ans)
}
