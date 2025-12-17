import scala.io.Source._
import scala.collection.mutable.ArrayBuffer

object readStd {
  def main(args: Array[String]) = {

    println("Reading the lines ...")

    var maxJolts=ArrayBuffer[Long]()

    for(line <- stdin.getLines()) {
            var big: String=""
            var pos=0
            val l = line.length

            for(i <- 12 to 1 by -1) {
              var d='0'
              var dpos=pos
              var currpos=pos-1
              for(p <- line.substring(pos,l - i +1)) {
                    //println(line.substring(pos,l - i +1))
                    currpos+=1
                   if(p>d) {
                      d=p
                      dpos=currpos
                   }

              }
              //println(s"$d $dpos")
              big=big.concat(d.toString)
              println("Big: "+big)
              pos=dpos+1
            }

            println(s"$big $line")
            maxJolts+=big.toLong

      }
      println("Max jolts= "+maxJolts.reduce(_ + _))
  }
}
