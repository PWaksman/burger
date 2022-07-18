package pwaksman.repository

import pwaksman.entity.BurgerConfig
import pwaksman.enum.HamburgerType
import java.math.BigDecimal

class BurgerConfigRepositoryMock : BurgerConfigRepository {

    override fun findAll(): List<BurgerConfig> {
        return listOf(
            basic,
            healthy,
            combo,
        )
    }

    companion object {
        private val basic = BurgerConfig(toppingAllowed = 4, type = HamburgerType.Basic, BigDecimal("5.50"))
        private val healthy = BurgerConfig(toppingAllowed = 6, type = HamburgerType.Healthy, BigDecimal("6.00"))
        private val combo = BurgerConfig(toppingAllowed = 0, type = HamburgerType.Combo, BigDecimal("8.50"))
    }

}