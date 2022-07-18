package pwaksman.exceptions

import pwaksman.enum.HamburgerType

class InvalidBurgerToppingCount(type: HamburgerType, count: Int)
    : Exception("Burger $type topping count exceeded: $count")
