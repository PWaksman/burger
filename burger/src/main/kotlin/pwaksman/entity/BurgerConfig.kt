package pwaksman.entity

import pwaksman.enum.HamburgerType
import java.math.BigDecimal

data class BurgerConfig(
    val toppingAllowed: Int,
    val type: HamburgerType,
    val price: BigDecimal,
)