package org.delivery.account.config.objectmapper

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ObjectMapperConfig {

    @Bean
    fun objectMapper(): ObjectMapper {
        // kotlin module
        val kotlinModule = KotlinModule.Builder().apply {
            withReflectionCacheSize(512)
            configure(KotlinFeature.NullToEmptyCollection, false) // empty list . null
            configure(KotlinFeature.NullToEmptyMap, false) // map . null
            configure(KotlinFeature.NullIsSameAsDefault, false) // null로 초기화
            configure(KotlinFeature.SingletonSupport, false)
            configure(KotlinFeature.StrictNullChecks, false) // null 검사 off
        }.build()

        val objectMapper: ObjectMapper = ObjectMapper().apply {
            registerModule(Jdk8Module())
            registerModule(JavaTimeModule())

            registerModule(kotlinModule)

            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)

            // 날짜 관련 직렬화
            disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)

            // 스네이크 케이스
            propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
        }

        return objectMapper
    }
}