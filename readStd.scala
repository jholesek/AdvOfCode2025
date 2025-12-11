import scala.io.Source._

object readStd {
  def main(args: Array[String]) = {
    for(line <- stdin.getLines())
      println("Line: "+line);
  }
}
