package com.nokinori.research.other.reactive

import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber
import java.util.function.Function

class MapPublisher<IN, OUT>(
    private val parent: Publisher<IN>,
    private val mapper: Function<IN, OUT>
) : MyFlux<OUT>() {

    override fun subscribe(actual: Subscriber<in OUT>) {
        parent.subscribe(MapSubscriber(mapper, actual))
    }
}