package baseball

import baseball.app.BaseballGame
import baseball.controller.InningController
import baseball.model.Inning
import baseball.model.Score
import baseball.view.GameScreenView

fun main() {
    val game = BaseballGame()
   game.run()

}