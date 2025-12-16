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
                        var l=1
                        var stop=0
                        while(l < iStr.length/2+1 && stop==0) {
                                // try to split by a substring and check for size of the returned array
                                if(iStr.split(iStr.substring(0,l)).size==0) {
                                //println(iStr+" , L: "+left+" R: "+right)
                                        //       add to the list
                                        println(iStr+" added to the list.")
                                        invalidIDs+=i
                                        stop=1
                                }
                                l+=1
                        }
                        // println(i)
                }
            }
    }


    // sum the list
        println("Sum of invalidIDs: "+invalidIDs.reduce(_ + _))

  }
}

