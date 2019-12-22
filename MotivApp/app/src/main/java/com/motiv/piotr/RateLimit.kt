 
package com.motiv.piotr
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.fragment.app.*
import androidx.room.*
import com.bumptech.glide.Glide
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import java.util.*
import java.util.concurrent.*
import javax.inject.*
@Entity(tableName = "ratelimit")
public class RateLimit {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "limit")
    @SerializedName("limit")
    private var limit: Int = 0
    @ColumnInfo(name = "reset")
    @SerializedName("reset")
    private var reset: Int = 0
    @ColumnInfo(name = "remaining")
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
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.getContext())
            .load(url)
            .into(view)
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
