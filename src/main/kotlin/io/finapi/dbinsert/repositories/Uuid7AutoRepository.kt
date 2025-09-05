package io.finapi.dbinsert.repositories

import io.finapi.dbinsert.models.Uuid7AutoDbModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface Uuid7AutoRepository: CrudRepository<Uuid7AutoDbModel, UUID>
