package pwaksman.repository

import pwaksman.entity.Topping

interface ToppingRepository {
    fun findAll(): List<Topping>
}