package baseball

import camp.nextstep.edu.missionutils.Console.readLine
// 해당 라이브러리를 써야하지만 java 9 경고가 나와서 임시 비활성화

import java.util.Random

val random = Random()
const val MAX_NUM = 1000
fun main() {

    val game = GameBoard()
    do {
        game.run()
    } while (isRestartGame())
}

fun isRestartGame():Boolean {
    try {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val userInput: Int = readLine()?.toInt() ?: throw IllegalArgumentException("제대로 입력하세요.")
        require(userInput in 1 .. 2){"$userInput 가 1 또는 2가 아닙니다."}
        return if (userInput == 1) {
            true
        }else {
            false
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("올바른 숫자를 입력하세요.")
    }
}