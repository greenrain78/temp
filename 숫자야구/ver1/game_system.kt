package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
class GameSystem() {
    private val computer: List<Int> = getRandomNumList()
    var isEnd: Boolean = false

    private fun getRandomNumList(): List<Int> {
        val numList:MutableList<Int> = mutableListOf()
        while (numList.size < 3) {
            val randomNumber = pickNumberInRange(1, 9)
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber)
            }
        }
        return numList
//        val arr = (0 until 10).toList().shuffled() // 내가 짠 코드
//        return arr.subList(0, 3)
    }
    fun input(numList: List<Int>): Pair<Int, Int>{
        checkNumList(numList=numList)
        return calculateScore(numList=numList)
    }
    private fun checkNumList(numList: List<Int>) {
        require(numList.size == numList.distinct().size) {"$numList 입력 값에 중복된 원소가 존재합니다."}
    }
    private fun calculateScore(numList: List<Int>): Pair<Int, Int>{
        var strike: Int = 0
        var ball: Int = 0
        for(i in 0 until numList.count()){
            if (numList[i] == computer[i]){
                strike++
            }else if (computer.contains(numList[i])){
                ball++
            }
        }
        if (strike == 3) {
            isEnd = true
        }
        return Pair(strike, ball)
    }
}