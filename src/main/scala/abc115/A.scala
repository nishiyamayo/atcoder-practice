package abc115

import java.util.Scanner

object A extends App {
  val sc = new Scanner(System.in)

  val ans = "Christmas"

  val d = sc.nextInt()

  val eve = for {
    _ <- 0 to (24 - d)
  } yield "Eve"
  println((Seq(ans) ++ eve).mkString(" "))
}
