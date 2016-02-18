package com.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.config.EnableIntegration
import org.springframework.integration.core.GenericSelector
import org.springframework.integration.core.MessageSource
import org.springframework.integration.dsl.IntegrationFlow
import org.springframework.integration.dsl.IntegrationFlows
import org.springframework.integration.dsl.SourcePollingChannelAdapterSpec
import org.springframework.integration.dsl.channel.MessageChannels
import org.springframework.integration.dsl.core.Pollers
import org.springframework.integration.dsl.support.Consumer
import org.springframework.integration.endpoint.MethodInvokingMessageSource
import java.util.concurrent.atomic.AtomicInteger

@SpringBootApplication
@EnableIntegration
open class DemoApplication {

    @Bean
    open fun integerMessageSource(): MessageSource<Any?> {
        val source = MethodInvokingMessageSource()
        source.setObject(AtomicInteger())
        source.setMethodName("getAndIncrement")
        return source
    }

    @Bean
    open fun inputChannel(): DirectChannel {
        return DirectChannel()
    }

    @Bean
    open fun myFlow(messageSource: MessageSource<Any?>, inputChannel: DirectChannel): IntegrationFlow {
        return IntegrationFlows.from(messageSource, Consumer<SourcePollingChannelAdapterSpec> { c -> c.poller(Pollers.fixedRate(100))})
                    .channel(inputChannel)
                    .filter(GenericSelector<Integer> { p -> p > 0 })
                    .transform(Object::toString)
                    .channel(MessageChannels.queue())
                    .get();
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}
