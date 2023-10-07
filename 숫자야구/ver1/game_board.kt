package baseball

import camp.nextstep.edu.missionutils.Console.readLine


class GameBoard() {
    private var system: GameSystem = GameSystem()

    fun reset() {
        system = GameSystem()
    }
    fun run() {
        println("숫자 야구 게임을 시작합니다.")

        while (!system.isEnd){
            val userNum:Int = inputUserNum()
            val (strike, ball) = system.input(numList = splitNum(userNum))
            printScore(strike = strike, ball = ball)
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        reset()
    }
    private fun inputUserNum(): Int {
        try {
            print("숫자를 입력해주세요 : ")
            val userNum: Int = readLine()?.toInt() ?: throw IllegalArgumentException("제대로 입력하세요.")
            require(userNum in 0 until MAX_NUM){"$userNum 가 지정 범위(0<= x < $MAX_NUM)에 존재하지 않습니다."}
            return userNum
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("올바른 숫자를 입력하세요.")
        }
    }
    private fun splitNum(num: Int) : List<Int> {
        require(num in 0 until MAX_NUM){"$num 가 지정 범위(0<= x < $MAX_NUM)에 존재하지 않습니다."}
        return listOf(
            num.div(100).rem(10),
            num.div(10).rem(10),
            num.div(1).rem(10),
        )
    }
    fun printScore(strike: Int, ball: Int) {
        var message: String = ""
        if (ball != 0){
            message += "$ball 볼 "
        }
        if (strike != 0){
            message += "$strike 스트라이크 "
        }

        if (message.isEmpty()) {
            println("낫띵")
        }else {
            println(message)
        }
    }
}