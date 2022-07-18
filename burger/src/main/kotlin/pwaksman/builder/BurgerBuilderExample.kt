package pwaksman.builder

import pwaksman.entity.BurgerConfig
import pwaksman.enum.HamburgerType
import pwaksman.repository.BurgerConfigRepository
import pwaksman.repository.BurgerConfigRepositoryMock

class BurgerBuilderExample : BurgerBuilder {

    private val configRepository: BurgerConfigRepository by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        BurgerConfigRepositoryMock()
    }

    private val typeConfig: List<BurgerConfig> by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        configRepository.findAll()
    }

    override fun ofType(type: HamburgerType): BurgerToppingBuilder =
        BurgerToppingBuilderExample(typeConfig.find { it.type == type }!!)

}