package io.finapi.dbinsert

import io.finapi.dbinsert.models.IntDbModel
import io.finapi.dbinsert.models.Uuid7AutoDbModel
import io.finapi.dbinsert.models.Uuid7DbModel
import io.finapi.dbinsert.models.UuidDbModel
import io.finapi.dbinsert.repositories.IntRepository
import io.finapi.dbinsert.repositories.Uuid7AutoRepository
import io.finapi.dbinsert.repositories.Uuid7Repository
import io.finapi.dbinsert.repositories.UuidRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import kotlin.system.measureTimeMillis
import kotlin.time.measureTimedValue

@ShellComponent
class InsertShellComponent(
    private val intRepository: IntRepository,
    private val uuidRepository: UuidRepository,
    private val uuid7Repository: Uuid7Repository,
    private val uuid7AutoRepository: Uuid7AutoRepository,
    @param:Value($$"${dbinsert.data.size}") private val dataSize: Int,
) {
    @ShellMethod(value = "execute insert of int data")
    fun runIntInsert() {
        val totalTime = measureTimeMillis {
            val creationTimed = measureTimedValue {
                createIntDummyData()
            }
            println("Created ${creationTimed.value.size} INT entries in ${creationTimed.duration} ms")

            val data = creationTimed.value
            val time = measureTimeMillis {
                intRepository.saveAll(data)
            }
            println("Inserted ${data.size} entries with INT in $time ms")
        }
        println("Total time INT Insert: $totalTime ms")
    }

    @ShellMethod(value = "execute insert of uuid data")
    fun runUuidInsert() {
        val totalTime = measureTimeMillis {
            val creationTimed = measureTimedValue {
                createUuidDummyData()
            }
            println("Created ${creationTimed.value.size} UUID entries in ${creationTimed.duration} ms")

            val data = creationTimed.value
            val time = measureTimeMillis {
                uuidRepository.saveAll(data)
            }
            println("Inserted ${data.size} entries with UUID in $time ms")
        }
        println("Total time UUID Insert: $totalTime ms")
    }

    @ShellMethod(value = "execute insert of uuid7 data")
    fun runUuid7Insert() {
        val totalTime = measureTimeMillis {
            val creationTimed = measureTimedValue {
                createUuid7DummyData()
            }
            println("Created ${creationTimed.value.size} UUID7 entries in ${creationTimed.duration} ms")

            val data = creationTimed.value
            val time = measureTimeMillis {
                uuid7Repository.saveAll(data)
            }
            println("Inserted ${data.size} entries with UUID7 in $time ms")
        }
        println("Total time UUID7 Insert: $totalTime ms")
    }

    @ShellMethod(value = "execute insert of uuid7 auto generated data")
    fun runUuid7AutoInsert() {
        val totalTime = measureTimeMillis {
            val creationTimed = measureTimedValue {
                createUuid7AutoDummyData()
            }
            println("Created ${creationTimed.value.size} UUID7 Auto entries in ${creationTimed.duration} ms")

            val data = creationTimed.value
            val time = measureTimeMillis {
                uuid7AutoRepository.saveAll(data)
            }
            println("Inserted ${data.size} entries with UUID7 Auto in $time ms")
        }
        println("Total time UUID7 Auto Insert: $totalTime ms")
    }

    private fun createIntDummyData(): List<IntDbModel> {
        val result = mutableListOf<IntDbModel>()
        repeat(dataSize) { i ->
            result.add(
                IntDbModel(
                    name = "Name $i"
                )
            )
        }
        return result
    }

    private fun createUuidDummyData(): List<UuidDbModel> {
        val result = mutableListOf<UuidDbModel>()
        repeat(dataSize) { i ->
            result.add(
                UuidDbModel(
                    name = "Name $i"
                )
            )
        }
        return result
    }

    private fun createUuid7DummyData(): List<Uuid7DbModel> {
        val result = mutableListOf<Uuid7DbModel>()
        repeat(dataSize) { i ->
            result.add(
                Uuid7DbModel(
                    name = "Name $i"
                )
            )
        }
        return result
    }

    private fun createUuid7AutoDummyData(): List<Uuid7AutoDbModel> {
        val result = mutableListOf<Uuid7AutoDbModel>()
        repeat(dataSize) { i ->
            result.add(
                Uuid7AutoDbModel(
                    name = "Name $i"
                )
            )
        }
        return result
    }
}
