package pwaksman

import pwaksman.entity.Additional
import pwaksman.repository.AdditionalRepository
import pwaksman.repository.AdditionalRepositoryMock
import kotlin.random.Random

class AdditionsRandomizer {
    private val additionalRepository: AdditionalRepository by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        AdditionalRepositoryMock()
    }

    private val choices: List<Additional> by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        additionalRepository.findAll()
    }

    fun makeChoice(): List<Additional> {
        if (Random.nextInt(5) != 2) return emptyList()

        val additions = ArrayList<Additional>()
        for (counter in 0..Random.nextInt(0, 2))
            additions += choices.random()

        return additions
    }
}