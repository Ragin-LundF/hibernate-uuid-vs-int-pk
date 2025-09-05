package io.finapi.dbinsert.generator

import org.hibernate.annotations.IdGeneratorType


@IdGeneratorType(UuidV7Generator::class)
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class Uuid7IdGenerated
