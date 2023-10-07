package baseball.app

import baseball.controller.InningController
import baseball.model.Inning
import baseball.model.Score
import baseball.view.GameScreenView

class BaseballGame {
    private val controller = InningController()
    private val screen = GameScreenView()
    private val computer: Inning = controller.getInningRandom()
    private var isEnd: Boolean = false

    fun run() {
        while (!this.isEnd){
            val userNum:Int = screen.inputInningForWait()
            val score: Score = Score(rightInning = computer, askInning = Inning(userNum))
            screen.printScore(score=score)
            if (score.strike == Inning.MAX_HITS) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                this.isEnd = screen.inputIsEndGameForWait()
            }
        }
    }
}