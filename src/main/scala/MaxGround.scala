case class MaxGround (maxX : Int, maxY : Int){
  def inGround(x : Int, y : Int): Boolean = {
    x >= 0 && x <= maxX && y >= 0 && y <= maxY
  }
}
