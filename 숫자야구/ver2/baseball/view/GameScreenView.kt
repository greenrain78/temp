package baseball.view

import baseball.model.Score
import camp.nextstep.edu.missionutils.Console

class GameScreenView {
    fun inputInningForWait(): Int {
        try {
            print("숫자를 입력해주세요 : ")
            return Console.readLine()?.toInt() ?: throw IllegalArgumentException("제대로 입력하세요.")
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("올바른 숫자를 입력하세요.")
        }
    }
    fun inputIsEndGameForWait(): Boolean {
        try {
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val userInput: Int = Console.readLine()?.toInt() ?: throw IllegalArgumentException("제대로 입력하세요.")
            require(userInput in 1 .. 2){"$userInput 가 1 또는 2가 아닙니다."}
            return userInput == 2
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("올바른 숫자를 입력하세요.")
        }
    }
    fun printScore(score: Score) {
        var message: String = ""
        if (score.ball != 0){
            message += "${score.ball} 볼 "
        }
        if (score.strike != 0){
            message += "${score.strike} 스트라이크 "
        }

        if (message.isEmpty()) {
            println("낫띵")
        }else {
            println(message)
        }
    }
}