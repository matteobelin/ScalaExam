import Cardinal.{E, N, S, W}

class Mower {

  def movement(char: Char,position: Position, maxGround: MaxGround): Position = char match {
    case 'G' => turnLeft(position)
    case 'D' => turnRight(position)
    case 'A' => moveForward(position, maxGround)
    case _ => throw new IllegalArgumentException("Mouvement inconnu")
  }

  private def turnLeft(position: Position): Position = {
    val newCardinal = position.cardinal match
      case N => W
      case W => S
      case S => E
      case E => N
    position.copy(cardinal = newCardinal)
  }


  private def turnRight(position: Position): Position = {
    val newCardinal = position.cardinal match
      case N => E
      case E => S
      case S => W
      case W => N
    position.copy(cardinal = newCardinal)
  }

  private def moveForward(position: Position, maxGround: MaxGround): Position = {
    val newPosition = position.cardinal match {
      case N => position.copy(y = position.y + 1)
      case S => position.copy(y = position.y - 1)
      case E => position.copy(x = position.x + 1)
      case W => position.copy(x = position.x - 1)
    }
    if maxGround.inGround(newPosition.x, newPosition.y) then newPosition else position
  }
}
