package pwaksman.entity

import java.math.BigDecimal
import kotlin.random.Random

data class Order(
    val burgers: List<Hamburger>,
    val additions: List<Additional>,
) {
    val grandTotal: BigDecimal by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        calculateGranTotal()
    }

    private fun calculateGranTotal(): BigDecimal {
        val total = burgers.grandTotal()

        return total.add(additions.sumOf { it.price })
    }

    private fun List<Hamburger>.grandTotal(): BigDecimal = this.sumOf { burger ->
        burger.price + burger.toppingChoices.sumOf { it.price }
    }

    override fun toString(): String {
        val order = StringBuilder("Order number: " + Random.nextInt(1, 99999))
        order.appendLine()

        for (burger in burgers) {
            order.appendLine("${burger.type} burger: ${burger.price}")

            if (burger.toppingChoices.any()) {
                order.appendLine("  topping:")
                for (topping in burger.toppingChoices)
                    order.appendLine("    ${topping.name}: ${topping.price}")
            }
        }

        if (additions.any()) {
            order.appendLine("additions:")
            for (addition in additions)
                order.appendLine("  ${addition.name}: ${addition.price}")
        }

        order.appendLine("Grand total: $grandTotal")

        return order.toString()
    }
}