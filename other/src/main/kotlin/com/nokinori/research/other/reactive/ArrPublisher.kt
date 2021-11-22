package com.nokinori.research.other.reactive

import org.reactivestreams.Subscriber

class ArrPublisher<T>(private val array: List<T>) : MyFlux<T>() {

    override fun subscribe(subscriber: Subscriber<in T>) {
        println("ArrPublisher.subscribe")
        subscriber.onSubscribe(ArrSubscription(subscriber, array))
    }

}