package pwaksman.builder

import pwaksman.entity.Additional
import pwaksman.entity.Hamburger
import pwaksman.entity.Order

interface OrderBuilder {
    fun addBurger(hamburger: Hamburger): OrderBuilder
    fun addAdditional(additional: Additional): OrderBuilder
    fun addFreeAdditional(additional: Additional): OrderBuilder
    fun build(): Order
}