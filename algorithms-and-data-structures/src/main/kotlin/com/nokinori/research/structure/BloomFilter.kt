package com.nokinori.research.structure

import com.sangupta.murmur.Murmur3
import io.whitfin.siphash.SipHasher
import java.io.ByteArrayOutputStream
import java.io.ObjectOutputStream

/**
 * A Bloom filter is a data structure designed to tell you, rapidly and memory-efficiently, whether an element is present in a set.
 *
 * The price paid for this efficiency is that a Bloom filter is a probabilistic data structure.
 * It tells us that the element either definitely is not in the set or may be in the set.
 */
interface BloomFilter<T : Any> {
    /**
     * To add an element to the Bloom filter, we simply hash it a few times.
     * Then set the bits in the bit vector at the index of those hashes to 1.
     */
    fun add(obj: T)
    fun mightContain(obj: T): Boolean
    fun expectedFalsePositiveProbability(): Double
}

class BloomFilterImpl<T : Any>(
    private val size: Int = 16,
    private val hashStrategy: HashStrategy = DefaultHashStrategy()
) : BloomFilter<T> {
    private val arr: ByteArray = ByteArray(size)

    override fun add(obj: T) {
        val hashes = hashStrategy.hash(asByteArray(obj))

        for (it in hashes) {
            val i = indexFor(it)
            arr[i] = 1
        }
    }

    override fun mightContain(obj: T): Boolean {
        val hashes = hashStrategy.hash(asByteArray(obj))
        var contain = true
        for (it in hashes) {
            val i = indexFor(it)
            if (arr[i] == 0.toByte()) {
                contain = false
                continue
            }
        }
        return contain
    }

    override fun expectedFalsePositiveProbability() =
        Math.pow((bitsCount() / size).toDouble(), hashStrategy.numsOfHashFunctions().toDouble())

    /**
     * Number of set beats.
     */
    private fun bitsCount() = arr.sum()

    /**
     * Resolve index for a bit in array.
     */
    private fun indexFor(hash: Long): Int {
        val i = hash and (arr.size - 1L)
        return i.toInt()
    }

    private fun asByteArray(obj: T): ByteArray = ByteArrayOutputStream()
        .use { byteArrayOutputStream ->
            ObjectOutputStream(byteArrayOutputStream).use {
                it.writeObject(obj)
                it.flush()
            }
            byteArrayOutputStream
        }
        .toByteArray()
}

interface HashStrategy {
    fun numsOfHashFunctions(): Int
    fun hash(data: ByteArray): LongArray
}

class DefaultHashStrategy : HashStrategy {
    override fun numsOfHashFunctions(): Int = 2
    override fun hash(data: ByteArray): LongArray {

        val hashX8632 = Murmur3.hash_x64_128(data, data.size, 0)[1]
        val hashCode = SipHasher.hash("0123456789ABCDEF".toByteArray(), data)

        return longArrayOf(hashX8632, hashCode)
    }
}