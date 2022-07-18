package pwaksman.repository

import pwaksman.entity.Additional
import java.math.BigDecimal

class AdditionalRepositoryMock : AdditionalRepository {

    override fun findAll(): List<Additional> {
        return additions
    }

    companion object {
        val chips = Additional("chips", BigDecimal("3.73"))
        private val coca = Additional("coca", BigDecimal("2.10"))
        private val pepsi = Additional("pepsi", BigDecimal("2.10"))
        private val iceCream = Additional("ice cream", BigDecimal("4.90"))
        private val orangeJuice = Additional("orange juice", BigDecimal("1.50"))
        private val lemonade = Additional("lemonade", BigDecimal("1.80"))

        val drinks = listOf(coca, pepsi, orangeJuice, lemonade)
        val additions = listOf(chips, coca, pepsi, iceCream, orangeJuice, lemonade)
    }

}