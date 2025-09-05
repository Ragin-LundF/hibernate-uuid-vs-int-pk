package io.finapi.dbinsert.generator

import com.github.f4b6a3.uuid.UuidCreator
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.enhanced.SequenceStyleGenerator
import java.io.Serial
import java.util.UUID

class UuidV7Generator : SequenceStyleGenerator() {
    override fun generate(session: SharedSessionContractImplementor, obj: Any): UUID {
        return UuidCreator.getTimeOrderedEpoch()
    }

    companion object {
        @Serial
        private const val serialVersionUID: Long = 2797218664996911556L
    }
}
