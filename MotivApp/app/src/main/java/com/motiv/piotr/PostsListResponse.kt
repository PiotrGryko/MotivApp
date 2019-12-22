 
package com.motiv.piotr
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import com.squareup.picasso.Picasso
import io.realm.*
import java.util.*
import java.util.concurrent.*
import kotlin.collections.List

public open class PostsListResponse : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("result")

    private var result: RealmList<com.motiv.piotr.Post> = RealmList()

    @SerializedName("_meta")

    private var meta: com.motiv.piotr.Meta = com.motiv.piotr.Meta()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getResult(): List<com.motiv.piotr.Post> {
        return this.result
    } fun setResult(result: RealmList<com.motiv.piotr.Post>) {
        this.result = result
    } fun getMeta(): com.motiv.piotr.Meta {
        return this.meta
    } fun setMeta(meta: com.motiv.piotr.Meta) {
        this.meta = meta
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Picasso.with(view.getContext()).load(url).into(view)
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): PostsListResponse {
            return gson.fromJson(json, PostsListResponse::class.java)
        }

        fun toJson(obj: PostsListResponse): String {
            return gson.toJson(obj, PostsListResponse::class.java)
        }

        fun toJsonArray(obj: PostsListResponse): String {
            return gson.toJson(obj, Array<PostsListResponse>::class.java)
        }

        fun fromJsonArray(json: String): Array<PostsListResponse> {
            return gson.fromJson(json, Array<PostsListResponse>::class.java)
        }
    }
}
