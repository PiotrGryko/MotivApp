 
package com.motiv.piotr
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.fragment.app.*
import com.bumptech.glide.Glide
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import io.realm.*
import java.util.*
import java.util.concurrent.*
import javax.inject.*

public open class Links : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("edit")

    private var edit: com.motiv.piotr.Link = com.motiv.piotr.Link()

    @SerializedName("self")

    private var self: com.motiv.piotr.Link = com.motiv.piotr.Link()

    @SerializedName("avatar")

    private var avatar: com.motiv.piotr.Link = com.motiv.piotr.Link()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getEdit(): com.motiv.piotr.Link {
        return this.edit
    } fun setEdit(edit: com.motiv.piotr.Link) {
        this.edit = edit
    } fun getSelf(): com.motiv.piotr.Link {
        return this.self
    } fun setSelf(self: com.motiv.piotr.Link) {
        this.self = self
    } fun getAvatar(): com.motiv.piotr.Link {
        return this.avatar
    } fun setAvatar(avatar: com.motiv.piotr.Link) {
        this.avatar = avatar
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.getContext())
            .load(url)
            .into(view)
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): Links {
            return gson.fromJson(json, Links::class.java)
        }

        fun toJson(obj: Links): String {
            return gson.toJson(obj, Links::class.java)
        }

        fun toJsonArray(obj: Links): String {
            return gson.toJson(obj, Array<Links>::class.java)
        }

        fun fromJsonArray(json: String): Array<Links> {
            return gson.fromJson(json, Array<Links>::class.java)
        }
    }
}
