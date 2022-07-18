package pwaksman.builder

import pwaksman.entity.Additional
import pwaksman.entity.FreeAdditional
import pwaksman.entity.Hamburger
import pwaksman.entity.Order
import pwaksman.exceptions.InvalidOrder

class OrderBuilderExample : OrderBuilder {
    private val burgers: MutableList<Hamburger> = ArrayList()
    private val additions: MutableList<Additional> = ArrayList()

    override fun addBurger(hamburger: Hamburger): OrderBuilder = apply {
        burgers += hamburger
    }

    override fun addAdditional(additional: Additional): OrderBuilder = apply {
        additions += additional
    }

    override fun addFreeAdditional(additional: Additional): OrderBuilder = apply {
        additions += FreeAdditional(additional)
    }

    override fun build(): Order {
        if (burgers.isEmpty() && additions.isEmpty())
            throw InvalidOrder("Order cannot be empty")

        return Order(
            burgers = burgers,
            additions = additions,
        )
    }

}