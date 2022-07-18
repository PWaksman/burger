package pwaksman.builder

import pwaksman.enum.HamburgerType

interface BurgerBuilder {
    fun ofType(type: HamburgerType): BurgerToppingBuilder

}