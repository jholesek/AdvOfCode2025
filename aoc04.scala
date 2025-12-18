import scala.io.Source._
import scala.collection.mutable.ArrayBuffer

object readStd {
  def main(args: Array[String]) = {

    println("Reading the lines ...")

    var grid=ArrayBuffer[ArrayBuffer[Char]]()

    for(line <- stdin.getLines()) {
            var lineArr=ArrayBuffer[Char]()
            for(p <- line) {
                    lineArr+=p
            }
            grid+=lineArr
    }

    println(grid)
    println(grid(0))
    println(grid(0)(1))
    println(grid.size)
    println(grid.length)
    println(grid(0).length)

    //loop over grid ...
    //
    var canFork=0
    var gpos=0
    for(l <- grid) {
            var lpos=0
            for(p <- l) {
                // if roll
                if(p=='@') {
                        // count adjacent rolls
                        var adjCount=0
                        for(radj <- -1 to 1)
                                for(cadj <- -1 to 1) {
                                        if(!(radj==0 && cadj==0) && 
                                                !(gpos+radj < 0 || gpos+radj >= grid.length) &&
                                                !(lpos+cadj < 0 || lpos+cadj >= grid(gpos).length)
                                                ) {
                                                        //println(s"$gpos $radj $lpos $cadj")
                                                        if(grid(gpos+radj)(lpos+cadj)=='@')
                                                                adjCount+=1
                                                }
                                }

                        // if count < 4 mark as pick
                        if(adjCount<4) {
                                canFork+=1
                                //println(s"${grid(gpos)} $gpos $lpos $adjCount $canFork")
                        }
                }
                lpos+=1
            }
            gpos+=1
    }
    //
    println("Can forklift: "+canFork)
  }
}

