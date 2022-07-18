package pwaksman.repository

import pwaksman.entity.Topping
import java.math.BigDecimal

class ToppingRepositoryMock : ToppingRepository {

    override fun findAll(): List<Topping> = choices

    companion object {
        private val cheese = Topping("cheese", BigDecimal("0.97"))
        private val sauces = Topping("sauces", BigDecimal("0.90"))
        private val lettuce = Topping("lettuce", BigDecimal("0.65"))
        private val tomato = Topping("tomato", BigDecimal("1.07"))
        private val onion = Topping("onion", BigDecimal("0.38"))
        private val cheddar = Topping("cheddar", BigDecimal("1.51"))
        private val bacon = Topping("bacon", BigDecimal("2.00"))
        private val houseSpecial = Topping("houseSpecial", BigDecimal("0.75"))

        val choices = listOf(
            cheese,
            sauces,
            lettuce,
            tomato,
            onion,
            cheddar,
            bacon,
            houseSpecial,
        )
    }
}