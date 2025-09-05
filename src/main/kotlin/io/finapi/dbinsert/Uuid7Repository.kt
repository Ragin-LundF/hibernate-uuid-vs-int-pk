package io.finapi.dbinsert

import io.finapi.dbinsert.models.Uuid7DbModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface Uuid7Repository: CrudRepository<Uuid7DbModel, UUID>
