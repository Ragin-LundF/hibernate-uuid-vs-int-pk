package io.finapi.dbinsert

import io.finapi.dbinsert.models.IntDbModel
import io.finapi.dbinsert.models.Uuid7DbModel
import io.finapi.dbinsert.models.UuidDbModel
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import kotlin.system.measureTimeMillis
import kotlin.time.measureTimedValue

@ShellComponent
class InsertShellComponent(
    private val intRepository: IntRepository,
    private val uuidRepository: UuidRepository,
    private val uuid7Repository: Uuid7Repository,
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

    private fun createIntDummyData(): List<IntDbModel> {
        val result = mutableListOf<IntDbModel>()
        repeat(NUMBER_ENTRIES) { i ->
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
        repeat(NUMBER_ENTRIES) { i ->
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
        repeat(NUMBER_ENTRIES) { i ->
            result.add(
                Uuid7DbModel(
                    name = "Name $i"
                )
            )
        }
        return result
    }

    companion object {
        private const val NUMBER_ENTRIES = 1_000_000
    }
}
