package io.finapi.dbinsert.models

import io.finapi.dbinsert.generator.Uuid7IdGenerated
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "UUID7_AUTO_TABLE")
data class Uuid7AutoDbModel (
    @Id
    @Uuid7IdGenerated
    var id: UUID? = null,

    @Column(name = "NAME", updatable = false, length = 100, nullable = false, insertable = true)
    val name: String
)
