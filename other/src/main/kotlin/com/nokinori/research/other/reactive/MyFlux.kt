package com.nokinori.research.other.reactive

import org.reactivestreams.Publisher
import java.util.function.Function

@Suppress("ReactiveStreamsPublisherImplementation")
abstract class MyFlux<T> : Publisher<T> {

    fun <R> map(mapper: Function<T, R>): MyFlux<R> = MapPublisher(this, mapper)

    companion object {

        fun <T> fromArray(elements: List<T>): ArrPublisher<T> = ArrPublisher(elements)

    }
}