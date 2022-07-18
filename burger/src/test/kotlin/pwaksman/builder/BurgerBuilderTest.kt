package pwaksman.builder

import io.kotlintest.shouldNotThrowAny
import org.junit.Test
import pwaksman.enum.HamburgerType

class BurgerBuilderTest {

    @Test
    fun `should return top builder`() {
        val builder = BurgerBuilderExample()

        shouldNotThrowAny {
            builder.ofType(HamburgerType.Basic)
        }
    }
}