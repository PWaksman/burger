package pwaksman

import pwaksman.entity.Topping
import pwaksman.repository.ToppingRepository
import pwaksman.repository.ToppingRepositoryMock
import kotlin.random.Random

class ToppingRandomizer {
    private val toppingRepository: ToppingRepository by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        ToppingRepositoryMock()
    }

    private val choices: List<Topping> by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        toppingRepository.findAll()
    }

    fun makeChoice(): List<Topping> {
        val toppingList = ArrayList<Topping>()

        for (counter in 1..Random.nextInt(0, 8))
            toppingList += choices.random()

        return toppingList
    }

}