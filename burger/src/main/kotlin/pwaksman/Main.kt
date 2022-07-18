package pwaksman

import pwaksman.builder.*
import pwaksman.entity.Hamburger
import pwaksman.enum.HamburgerType
import pwaksman.repository.AdditionalRepositoryMock

private val toppingChoices = ToppingRandomizer()
private val additionsChoices = AdditionsRandomizer()

fun main() {
    val burgerBuilder = createBurgerBuilder()
    burgerBuilder.basic()
    burgerBuilder.healthy()
    burgerBuilder.combo()
}

private fun createBurgerBuilder(): BurgerBuilder {
    return BurgerBuilderExample()
}

private fun BurgerBuilder.basic() = tryBuildBurger {
    val toppingBuilder = this.ofType(HamburgerType.Basic)
    toppingBuilder.chooseTopping()

    val burger = toppingBuilder.build()
    val orderBuilder = burger.createOrder()
    println(orderBuilder.build())
}

private fun BurgerBuilder.healthy() = tryBuildBurger {
    val toppingBuilder = this.ofType(HamburgerType.Healthy)
    toppingBuilder.chooseTopping()

    val burger = toppingBuilder.build()
    val orderBuilder = burger.createOrder()
    println(orderBuilder.build())
}

private fun BurgerBuilder.combo() = tryBuildBurger {
    val toppingBuilder = this.ofType(HamburgerType.Combo)
    val burger = toppingBuilder.build()

    val orderBuilder = burger.createOrder()
    orderBuilder.addFreeAdditional(AdditionalRepositoryMock.chips)
    orderBuilder.addFreeAdditional(AdditionalRepositoryMock.drinks.random())

    println(orderBuilder.build())
}

private fun BurgerToppingBuilder.chooseTopping() {
    val toppingChoices = toppingChoices.makeChoice()
    for (choiceChoice in toppingChoices)
        this.topping(choiceChoice)
}

private fun Hamburger.createOrder(): OrderBuilder {
    val builder = createOrderBuilder()
    builder.addBurger(this)
    builder.chooseAdditions()

    return builder
}

private fun createOrderBuilder(): OrderBuilder {
    return OrderBuilderExample()
}

private fun OrderBuilder.chooseAdditions() {
    val additions = additionsChoices.makeChoice()
    for (addition in additions)
        this.addAdditional(addition)
}

private fun tryBuildBurger(burgerBuilding: () -> Unit) = try {
    burgerBuilding()
} catch (ex: Exception) {
    println(ex.message)
    println()
}
