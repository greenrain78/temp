package baseball.model

class Hit(num: Int) {
    val num: Int
    init {
        require(num in 0 until 10){"$num 가 1자리 수가 아닙니다."}
        this.num = num
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is Hit) return false

        val otherClass = other as Hit
        return this.num == otherClass.num
    }
    override fun toString(): String {
        return "Hit($num)"
    }
}