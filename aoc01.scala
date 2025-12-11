import scala.io.Source._

object readStd {
  def main(args: Array[String]) = {
    var atclick=50
    var zeros=0

    println("Reading the lines ...")
    println("At click: "+atclick)

    for(line <- stdin.getLines()) {
      val direction=line.substring(0,1)
      var fromPoint=1;

      if(line.length>3) {
        fromPoint=line.length-2
        val timesZero=line.substring(1,fromPoint).toInt
        zeros+=timesZero
      }

      val clicks=line.substring(fromPoint).toInt
      val prevAtClick=atclick

      if(direction=="L")
        atclick=atclick-clicks
      else
        atclick=atclick+clicks

      if(atclick<0) {
        if(prevAtClick!=0)
          zeros+=1
        atclick=100+atclick
      }

      if(atclick>99) {
        atclick=atclick-100
        if(atclick!=0)
          zeros+=1
      }

      if(atclick==0)
        zeros+=1

      println("Line: "+line);
      //println("D: "+direction+" clicks: "+clicks)
      println("At click: "+atclick+" zeros: "+zeros)
      

    }
  }
}
