package io.finapi.dbinsert.models

import com.github.f4b6a3.uuid.UuidCreator
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "INT_TABLE")
data class IntDbModel (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "int_table_gen")
    @SequenceGenerator(name = "int_table_gen", sequenceName = "int_table_seq", allocationSize = 10000)
    @Column(name = "ID", nullable = false)
    var id: Long? = null,

    @Column(name = "UID", updatable = false, length = 36, nullable = false, insertable = true)
    val uid: UUID = UuidCreator.getTimeOrderedEpoch(),

    @Column(name = "NAME", updatable = false, length = 100, nullable = false, insertable = true)
    val name: String
)
