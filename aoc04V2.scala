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
    /*
    println(grid)
    println(grid(0))
    println(grid(0)(1))
    println(grid.size)
    println(grid.length)
    println(grid(0).length)
    */

    //loop over grid ...
    //
    var allFork=0
    var stillLifts=1
   while(stillLifts==1) {
    var canFork=0
    var gpos=0
    var lifted=ArrayBuffer[List[Int]]()

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
                                                        if(grid(gpos+radj)(lpos+cadj)=='@' || grid(gpos+radj)(lpos+cadj)=='x')
                                                                adjCount+=1
                                                }
                                }

                        // if count < 4 mark as pick
                        if(adjCount<4) {
                                canFork+=1
                                //println(s"${grid(gpos)} $gpos $lpos $adjCount $canFork")
                                lifted+=List(gpos,lpos)
                        }
                }
                lpos+=1
            }
            gpos+=1
    }
    //
    println("Can forklift: "+canFork)
    //println(lifted)

    for(u <- lifted)
        grid(u(0)).update(u(1),'.')

    allFork+=canFork

    if(canFork==0)
        stillLifts=0
    //println(grid)
    //println(stillLifts)
   }

   println("All forklifts: "+allFork)

  }
}

