package io.finapi.dbinsert

import io.finapi.dbinsert.models.IntDbModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IntRepository: CrudRepository<IntDbModel, Int>
