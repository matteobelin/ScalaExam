import munit.FunSuite

class GroundTest extends FunSuite {

  test("mow déplace deux tondeuses selon les instructions données") {
    val programme =
      """5 5
        |1 2 N
        |GAGAGAGAA
        |3 3 E
        |AADAADADDA""".stripMargin

    val ground = new Ground()
    val resultat = ground.mow(programme)

    val attendu = List(
      Position(1, 3, Cardinal.N),
      Position(5, 1, Cardinal.E)
    )

    assertEquals(resultat, attendu)
  }
}
