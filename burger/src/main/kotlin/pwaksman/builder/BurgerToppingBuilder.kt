package pwaksman.builder

import pwaksman.entity.Hamburger
import pwaksman.entity.Topping

interface BurgerToppingBuilder {
    fun topping(choice: Topping): BurgerToppingBuilder
    fun build(): Hamburger
}