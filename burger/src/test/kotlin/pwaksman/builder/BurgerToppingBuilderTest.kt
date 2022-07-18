package pwaksman.builder

import io.kotlintest.shouldNotThrowAny
import io.kotlintest.shouldThrow
import org.junit.Test
import org.junit.jupiter.api.Assertions
import pwaksman.entity.BurgerConfig
import pwaksman.entity.Topping
import pwaksman.enum.HamburgerType
import pwaksman.exceptions.InvalidBurgerToppingCount
import java.math.BigDecimal

class BurgerToppingBuilderTest {

    @Test
    fun `should throw invalid topping count`(){
        val builder = BurgerToppingBuilderExample(config)

        shouldThrow<InvalidBurgerToppingCount> {
            builder.topping(topping)
            builder.topping(topping)
            builder.topping(topping)
            builder.topping(topping)
            builder.build()
        }
    }

    @Test
    fun `should build the burger`(){
        val builder = BurgerToppingBuilderExample(config)

        shouldNotThrowAny {
            builder.topping(topping)
            val burger = builder.build()

            Assertions.assertEquals(burger.toppingChoices.size, 1)
            Assertions.assertEquals(burger.price, config.price)
            Assertions.assertEquals(burger.type, config.type)
        }
    }

    companion object {
        private val config = BurgerConfig(
            type = HamburgerType.Basic,
            toppingAllowed = 3,
            price = BigDecimal("1.00")
        )

        private val topping = Topping("some topping", BigDecimal("0.50"))
    }
}