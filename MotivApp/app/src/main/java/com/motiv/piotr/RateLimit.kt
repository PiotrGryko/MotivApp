 
package com.motiv.piotr
import androidx.annotation.NonNull
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import io.realm.*
import java.util.*
import java.util.concurrent.*

public open class RateLimit : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("limit")

    private var limit: Int = 0

    @SerializedName("reset")

    private var reset: Int = 0

    @SerializedName("remaining")

    private var remaining: Int = 0

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getLimit(): Int {
        return this.limit
    } fun setLimit(limit: Int) {
        this.limit = limit
    } fun getReset(): Int {
        return this.reset
    } fun setReset(reset: Int) {
        this.reset = reset
    } fun getRemaining(): Int {
        return this.remaining
    } fun setRemaining(remaining: Int) {
        this.remaining = remaining
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): RateLimit {
            return gson.fromJson(json, RateLimit::class.java)
        }

        fun toJson(obj: RateLimit): String {
            return gson.toJson(obj, RateLimit::class.java)
        }

        fun toJsonArray(obj: RateLimit): String {
            return gson.toJson(obj, Array<RateLimit>::class.java)
        }

        fun fromJsonArray(json: String): Array<RateLimit> {
            return gson.fromJson(json, Array<RateLimit>::class.java)
        }
    }
}
