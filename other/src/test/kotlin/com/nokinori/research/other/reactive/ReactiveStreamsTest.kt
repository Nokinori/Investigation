package com.nokinori.research.other.reactive

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux

class ReactiveStreamsTest {

    @Test
    fun `get Item`() {
        val publisher = ArrPublisher(listOf(1, 2, 3, 4, 5, 6, 7))
        val subscriber = ArrSubscriber<Any>()

        Flux.from(publisher)
            .map { it }
            .filter { it / 2L == 0L }
            .subscribe(subscriber)
    }

    @Test
    fun `my operator`() {
        val mapInner = MapPublisher(ArrPublisher(listOf(1L, 2L, 3L))) {
            println("in map inner")
            it.toString()
        }

        val mapOuter = MapPublisher(mapInner) {
            println("im map out")
            it.toLong()
        }

        mapOuter
            .subscribe(ArrSubscriber())
    }

    @Test
    fun `my flow`() {
        MyFlux.fromArray<Long>(listOf(1, 2, 3))
            .map {
                println("in map 1")
                it.toString()
            }
            .map {
                println("in map 2")
                it.toInt()
            }
            .subscribe(ArrSubscriber())
    }
}