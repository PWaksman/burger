package pwaksman.repository

import pwaksman.entity.Additional

interface AdditionalRepository {
    fun findAll(): List<Additional>
}