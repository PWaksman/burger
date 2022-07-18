package pwaksman.builder

import pwaksman.entity.BurgerConfig
import pwaksman.entity.Hamburger
import pwaksman.entity.Topping
import pwaksman.exceptions.InvalidBurgerToppingCount

class BurgerToppingBuilderExample(
    private val config: BurgerConfig,
) : BurgerToppingBuilder {
    private val choices: MutableList<Topping> = ArrayList()

    override fun topping(choice: Topping): BurgerToppingBuilder = apply {
        choices += choice
    }

    override fun build(): Hamburger {
        if (choices.size > config.toppingAllowed)
            throw InvalidBurgerToppingCount(config.type, choices.size)

        return Hamburger(
            type = config.type,
            price = config.price,
            toppingChoices = choices,
        )
    }

}