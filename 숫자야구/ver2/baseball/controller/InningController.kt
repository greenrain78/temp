package baseball.controller

import baseball.model.Hit
import baseball.model.Inning
import camp.nextstep.edu.missionutils.Randoms

class InningController {
    fun getInningRandom(): Inning {
        val hitList:MutableList<Hit> = mutableListOf()
        while (hitList.size < 3) {
            val randomHit = Hit(num=Randoms.pickNumberInRange(1, 9))
            if (!hitList.contains(randomHit)) {
                hitList.add(randomHit)
            }
        }
        return Inning(hits = hitList)
    }
}