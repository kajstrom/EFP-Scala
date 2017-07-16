package fi.kajstrom.efpscala.E57

class Game(answers: Seq[Question]) {
  private var score = 0
  private var active = false
  private var currentQuestion: Option[Question] = None

  def start(): Unit = {
    score = 0
    active = true
  }

  def nextQuestion(): Question = {
    guardAgainsPlayingInActiveGame()

    val r = scala.util.Random
    currentQuestion = Option(answers(r.nextInt(answers.length)))

    currentQuestion.get
  }

  def answer(answer: Int): Boolean = {
    guardAgainsPlayingInActiveGame()

    if (currentQuestion.get.isCorrect(answer)) {
      score += 1

      true
    } else {
      active = false

      false
    }
  }

  def getScore: Int = score

  private def guardAgainsPlayingInActiveGame(): Unit = {
    if (!active) {
      throw new RuntimeException("Cannot play an inactive game")
    }
  }
}
