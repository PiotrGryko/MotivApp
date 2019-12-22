 
package com.motiv.piotr
import androidx.room.*
import kotlin.collections.List

public class MetaWithReferences {

    @Embedded
    private lateinit var meta: com.motiv.piotr.Meta

    @Relation(entity = com.motiv.piotr.RateLimit::class, parentColumn = "rateLimitId", entityColumn = "id")

    public var rateLimit: List<com.motiv.piotr.RateLimit> = arrayListOf()

    fun getMeta(): Meta {
        if (rateLimit.size > 0) {
            meta.setRateLimit(rateLimit.get(0))
        }

        return meta
    } public fun setMeta(meta: Meta) { this.meta = meta; }
}
