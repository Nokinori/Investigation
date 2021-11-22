package com.nokinori.research.other.reactive

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.function.Function

@Suppress("ReactiveStreamsSubscriberImplementation")
class MapSubscriber<IN, OUT>(
    private val mapper: Function<in IN, out OUT>,
    private val actual: Subscriber<OUT>
) : Subscriber<IN>, Subscription {

    lateinit var upstream: Subscription
    var terminated: Boolean = false


    override fun onComplete() {
        if (terminated) return
        actual.onComplete()
    }

    override fun onSubscribe(s: Subscription) {
        this.upstream = s
        actual.onSubscribe(s)
    }

    override fun onNext(input: IN) {
        if (terminated) return

        try {
            val out: OUT = mapper.apply(input)
            actual.onNext(out)
        } catch (e: Throwable) {
            cancel()
            onError(e)
            return
        }
    }

    override fun onError(t: Throwable?) {
        if (terminated) return
        actual.onError(t)
    }

    override fun cancel() {
        upstream.cancel()
    }

    override fun request(n: Long) {
        upstream.request(n)
    }
}