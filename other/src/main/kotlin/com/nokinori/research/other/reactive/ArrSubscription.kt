package com.nokinori.research.other.reactive

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class ArrSubscription<T>(
    private val subscriber: Subscriber<in T>,
    private val array: List<T>
) : Subscription {
    private var lastIndex: Int = 0
    var requested = 0
    var canceled = false

    override fun cancel() {
        canceled = true
    }

    override fun request(n: Long) {
        try {

            if (canceled) return

            val inital = requested

            requested += n.toInt()

            if (inital != 0) return

            var sent = 0
            val array = array.subList(lastIndex, array.size)

            if (array.size == lastIndex) {
                subscriber.onComplete()
                return
            }

            while (sent < requested && lastIndex in array.indices) {
                subscriber.onNext(array[lastIndex])
                sent++
                lastIndex++
            }
        } catch (t: Throwable) {
            subscriber.onError(t)
        }
    }
}