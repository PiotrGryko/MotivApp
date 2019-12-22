 
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
import kotlin.collections.List
@Entity(tableName = "userslistresponse")
public class UsersListResponse {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "metaId")@ForeignKey(entity = com.motiv.piotr.Meta::class, parentColumns = ["id"], childColumns = ["metaId"])
    private
    var metaId: String = ""
    @Ignore
    @SerializedName("result")
    private var result: List<com.motiv.piotr.User> = listOf()
    @Ignore
    @SerializedName("_meta")
    private var meta: com.motiv.piotr.Meta = com.motiv.piotr.Meta()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getResult(): List<com.motiv.piotr.User> {
        return this.result
    } fun setResult(result: List<com.motiv.piotr.User>) {
        this.result = result
    } fun getMeta(): com.motiv.piotr.Meta {
        return this.meta
    } fun setMeta(meta: com.motiv.piotr.Meta) {
        this.meta = meta
    } @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.getContext())
            .load(url)
            .into(view)
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): UsersListResponse {
            return gson.fromJson(json, UsersListResponse::class.java)
        }

        fun toJson(obj: UsersListResponse): String {
            return gson.toJson(obj, UsersListResponse::class.java)
        }

        fun toJsonArray(obj: UsersListResponse): String {
            return gson.toJson(obj, Array<UsersListResponse>::class.java)
        }

        fun fromJsonArray(json: String): Array<UsersListResponse> {
            return gson.fromJson(json, Array<UsersListResponse>::class.java)
        }
    } public fun getMetaId(): String { return this.metaId; }; public fun setMetaId(metaId: String) { this.metaId = metaId; }
}
