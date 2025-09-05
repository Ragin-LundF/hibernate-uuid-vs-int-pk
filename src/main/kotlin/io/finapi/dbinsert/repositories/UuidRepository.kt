package io.finapi.dbinsert.repositories

import io.finapi.dbinsert.models.UuidDbModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UuidRepository: CrudRepository<UuidDbModel, UUID>
