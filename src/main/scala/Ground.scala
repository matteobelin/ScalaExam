import scala.annotation.tailrec

class Ground {
  def mow(string : String): List[Position] = {
    val lines = string.linesIterator.toList
    val Array(maxX, maxY) = lines.head.trim.split("\\s+").map(_.toInt)
    val maxGround = MaxGround(maxX, maxY)

    lines.tail
      .grouped(2)
      .map {
        case List(position, instrution) =>
          val Array(x, y, cardinal) = position.trim.split("\\s+")
          val positionInitiale = Position(x.toInt, y.toInt, Cardinal.valueOf(cardinal))
          executerInstructions(instrution.trim, positionInitiale, maxGround, new Mower())
        case _ => throw new IllegalArgumentException("argument non valide")
      }
      .toList
  }

    @tailrec
    private def executerInstructions(instructions: String, position: Position, maxGround: MaxGround, tondeuse: Mower): Position = {
      if instructions.isEmpty then position
      else executerInstructions(instructions.tail, tondeuse.movement(instructions.head, position, maxGround), maxGround, tondeuse)
    }
}


