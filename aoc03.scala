import scala.io.Source._
import scala.collection.mutable.ArrayBuffer

object readStd {
  def main(args: Array[String]) = {

    println("Reading the lines ...")

    var maxJolts=ArrayBuffer[Int]()

    for(line <- stdin.getLines()) {
            var big=0
            var pos=0
            for(p <- line) {
                    pos+=1
                    for(d <- line.substring(pos)) {
                            val t = 10*p.asDigit+d.asDigit
                            //println(s"$p $d $t $big")
                            if(big<t)
                                    big=t
                    }

            }
            println(s"$big $line")
            maxJolts+=big

      }
      println("Max jolts= "+maxJolts.reduce(_ + _))
  }
}
