import scala.io.Source._
import scala.collection.mutable.ArrayBuffer

object readStd {
  def main(args: Array[String]) = {

          var invalidIDs=ArrayBuffer[Long]()

    println("Reading the lines ...")

    for(line <- stdin.getLines()) {
                println("Line: "+line)
            // split line to ranges at ,
            val ranges=line.split(",")
            for(range <- ranges) {
                // split ranges at -
                val rangeLimits=range.split("-")
                // for numbers in range ...
                for(i <- rangeLimits(0).toLong to rangeLimits(1).toLong) {
                        //   if lentght is even ...
                        val iStr=i.toString
                        if(iStr.length%2==0) {
                                //     split at half and compare if equal
                                val left=iStr.substring(0,iStr.length/2)
                                val right=iStr.substring((iStr.length/2))
                                //println(iStr+" , L: "+left+" R: "+right)
                                if(left==right) {
                                        //       add to the list
                                        println(iStr+" added to the list.")
                                        invalidIDs+=i
                                }
                        }
                        // println(i)
                }
            }
    }


    // sum the list
        println("Sum of invalidIDs: "+invalidIDs.reduce(_ + _))

  }
}

