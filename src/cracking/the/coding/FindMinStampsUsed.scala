package cracking.the.coding

object FindMinStampsUsed extends App {

  val parcelValue = 200
  val stampValues = Seq(5, 10, 20, 50)

  val combination = for {
    fifty <- 0 to parcelValue/50
    twenty <- 0 to parcelValue/20
    ten <- 0 to parcelValue/10
    five <- 0 to parcelValue/5
    if fifty * 50 + twenty * 20 + ten * 10  + five * 5 == parcelValue
  } yield (fifty, twenty, ten, five)

  combination foreach println

}
