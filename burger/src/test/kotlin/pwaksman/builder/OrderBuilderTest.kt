package pwaksman.builder

import io.kotlintest.shouldNotThrowAny
import io.kotlintest.shouldThrow
import org.junit.Test
import org.junit.jupiter.api.Assertions
import pwaksman.entity.Additional
import pwaksman.entity.Hamburger
import pwaksman.enum.HamburgerType
import pwaksman.exceptions.InvalidOrder
import java.math.BigDecimal

class OrderBuilderTest {

    @Test
    fun `should fail when building an empty order`() {
        val builder = OrderBuilderExample()

        shouldThrow<InvalidOrder> {
            builder.build()
        }
    }

    @Test
    fun `should create order`() {
        val builder = OrderBuilderExample()

        shouldNotThrowAny {
            builder.addBurger(burger)
            builder.addAdditional(additional)
            builder.addFreeAdditional(additional)

            val order = builder.build()
            Assertions.assertEquals(burger.price.add(additional.price), order.grandTotal)
        }
    }

    companion object {
        private val burger = Hamburger(
            type = HamburgerType.Basic,
            price = BigDecimal("1.00"),
            toppingChoices = emptyList(),
        )

        private val additional = Additional(name = "some addition", price = BigDecimal("0.50"))
    }
}