package com.nokinori.research.other.reactive

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

@Suppress("ReactiveStreamsSubscriberImplementation")
class ArrSubscriber<T> : Subscriber<T> {
    lateinit var s: Subscription

    override fun onComplete() {
        println("ReactiveStreamsTest.onComplete")
    }

    override fun onSubscribe(s: Subscription) {
        println("ReactiveStreamsTest.onSubscribe")
        this.s = s
        s.request(3)
    }

    override fun onNext(t: T) {
        println("ReactiveStreamsTest.onNext $t")
        s.request(1)
    }

    override fun onError(t: Throwable) {
        println("ArrSubcriber.onError")
        throw t
    }
}