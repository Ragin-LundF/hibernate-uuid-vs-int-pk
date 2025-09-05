package io.finapi.dbinsert

import io.finapi.dbinsert.models.IntDbModel
import io.finapi.dbinsert.models.Uuid7DbModel
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import kotlin.system.measureTimeMillis

@ShellComponent
class InsertShellComponent(
    private val intRepository: IntRepository,
    private val uuidRepository: UuidRepository,
) {
    @ShellMethod(value = "execute insert of int data")
    fun runIntInsert() {
        val data = createIntDummyData()
        val time = measureTimeMillis {
            intRepository.saveAll(data)
        }
        println("Inserted ${data.size} entries in $time ms")
    }

    @ShellMethod(value = "execute insert of uuid data")
    fun runUuidInsert() {
        val data = createUuidDummyData()
        val time = measureTimeMillis {
            uuidRepository.saveAll(data)
        }
        println("Inserted ${data.size} entries in $time ms")
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

    private fun createUuidDummyData(): List<Uuid7DbModel> {
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
