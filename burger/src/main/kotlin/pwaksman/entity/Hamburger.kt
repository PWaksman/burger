package pwaksman.entity

import pwaksman.enum.HamburgerType
import java.math.BigDecimal

data class Hamburger(
    val type: HamburgerType,
    val price: BigDecimal,
    val toppingChoices: List<Topping>,
)