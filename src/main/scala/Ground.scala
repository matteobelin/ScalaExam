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
          val initialPosition = Position(x.toInt, y.toInt, Cardinal.valueOf(cardinal))
          executeInstructions(instrution.trim, initialPosition, maxGround, new Mower())
        case _ => throw new IllegalArgumentException("argument non valide")
      }
      .toList
  }

    @tailrec
    private def executeInstructions(instructions: String, position: Position, maxGround: MaxGround, mower: Mower): Position = {
      if instructions.isEmpty then position
      else executeInstructions(instructions.tail, mower.movement(instructions.head, position, maxGround), maxGround, mower)
    }
}


