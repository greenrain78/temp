package baseball.model

class Score (rightInning: Inning, askInning: Inning){
    var strike: Int = 0
    var ball: Int = 0
    var isEnd: Boolean = false
    init {
        for(i in 0 until Inning.MAX_HITS){
            if (askInning[i] == rightInning[i]){
                strike++
            }else if (rightInning.contains(askInning[i])){
                ball++
            }
        }
        if (strike == Inning.MAX_HITS) {
            isEnd = true
        }
    }

    override fun toString(): String {
        return "Score(strike: $strike, ball: $ball, isEnd: $isEnd)"
    }
}