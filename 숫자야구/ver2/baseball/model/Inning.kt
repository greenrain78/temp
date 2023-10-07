package baseball.model

import kotlin.math.pow


class Inning {
    companion object {
        const val MAX_HITS: Int = 3
    }
    private val hits: List<Hit>

    constructor(hitNum: Int) :this(hits = with(hitNum) {
        val maxNum = 10.0.pow(MAX_HITS).toInt()
        require(hitNum in 0 until maxNum){"$hitNum 가 지정 범위(0<= x < ${maxNum})에 존재하지 않습니다."}

        List(MAX_HITS) { i ->
            Hit(
                num = hitNum.div(10.0.pow(MAX_HITS - i -1).toInt()).rem(10)
            )
        }

    })

    constructor(hits: List<Hit>) {
        require(hits.size == MAX_HITS) {"타수가 $MAX_HITS 이 아닙니다."}
        require(hits.size == hits.distinctBy{it -> it.num}.count()) {"중복된 값이 존재하면 안됩니다."} // 별도로 분리? override
        this.hits = hits
    }

    override fun toString(): String {
        return "이닝: ${hits.toString()}"
    }
    fun contains(hit: Hit): Boolean {
        return this.hits.contains(hit)
    }

    operator fun get(idx: Int): Hit {
        return this.hits[idx]

    }

}