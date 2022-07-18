package pwaksman.repository

import pwaksman.entity.BurgerConfig

interface BurgerConfigRepository {
    fun findAll(): List<BurgerConfig>
}