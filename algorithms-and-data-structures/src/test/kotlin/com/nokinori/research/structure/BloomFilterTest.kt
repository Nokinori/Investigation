package com.nokinori.research.structure

import com.github.javafaker.Faker
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BloomFilterTest {

    @Test
    fun `positive contain`() {
        val bloomFilter = BloomFilterImpl<String>()

        val element = "one"
        bloomFilter.add(element)
        val mightContain = bloomFilter.mightContain(element)

        Assertions.assertTrue(mightContain)
    }

    @Test
    fun `many positive`() {
        val bloomFilter = BloomFilterImpl<String>()
        val faker = Faker()
        repeat(50) {
            val element = faker.beer().name()
            bloomFilter.add(element)
            val mightContain = bloomFilter.mightContain(element)

            Assertions.assertTrue(mightContain)
        }
    }

    @Test
    fun `false positive`() {
        val bloomFilter = BloomFilterImpl<String>(hashStrategy = object : HashStrategy {
            override fun numsOfHashFunctions(): Int = 3
            override fun hash(data: ByteArray): LongArray = longArrayOf(1, 5, 6)
        })

        val element1 = "one"
        val element2 = "two"

        bloomFilter.add(element1)
        bloomFilter.add(element2)

        val mightContain = bloomFilter.mightContain(element1)
        val mightContain1 = bloomFilter.mightContain(element2)
        Assertions.assertTrue(mightContain)
        Assertions.assertTrue(mightContain1)
    }
}