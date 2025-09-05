package io.finapi.dbinsert.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "UUID_TABLE")
data class Uuid7DbModel (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(name = "NAME", updatable = false, length = 100, nullable = false, insertable = true)
    val name: String
)
