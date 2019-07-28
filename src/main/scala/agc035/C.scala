package agc035

object C extends App {

  for {
    x <- Seq(1, 2, 3)
    y <- Seq(3, 4, 5)
  } yield println(x + y)

  for (x <- Seq(1, 2, 3)) {
    for (y <- Seq(3, 4, 5)) {
      println(x + y)
    }
  }
}
