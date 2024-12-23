package com.iron.kotlin.demo.configs

import com.iron.kotlin.demo.subscribe.SqsSubscriber
import mu.KotlinLogging
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "demo.event.subscribe.sqs", name = ["enabled"], havingValue = "true")
@EnableConfigurationProperties(SqsEventSubscriberConfig.Property::class)
class SqsEventSubscriberConfig {
    private val logger = KotlinLogging.logger {}

    @ConstructorBinding
    @ConfigurationProperties(prefix = "demo.event.subscribe.sqs")
    data class Property(
        val url: String? = null,
        val region: String? = null,
        val queue: String? = null
    )

    @Bean
    fun sqsSubscriber(property: Property): SqsSubscriber {
        logger.info { "## property : $property" }
        return SqsSubscriber()
    }
}