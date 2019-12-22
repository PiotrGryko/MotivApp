 
package com.motiv.piotr
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.room.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import com.squareup.picasso.Picasso
import java.util.*
import java.util.concurrent.*
@Entity(tableName = "userresponse")
public class UserResponse {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "resultId")@ForeignKey(entity = com.motiv.piotr.User::class, parentColumns = ["id"], childColumns = ["resultId"])
    private
    var resultId: String = ""
    @ColumnInfo(name = "metaId")@ForeignKey(entity = com.motiv.piotr.Meta::class, parentColumns = ["id"], childColumns = ["metaId"])
    private
    var metaId: String = ""
    @Ignore
    @SerializedName("result")
    private var result: com.motiv.piotr.User = com.motiv.piotr.User()
    @Ignore
    @SerializedName("_meta")
    private var meta: com.motiv.piotr.Meta = com.motiv.piotr.Meta()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getResult(): com.motiv.piotr.User {
        return this.result
    } fun setResult(result: com.motiv.piotr.User) {
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
        fun fromJson(json: String): UserResponse {
            return gson.fromJson(json, UserResponse::class.java)
        }

        fun toJson(obj: UserResponse): String {
            return gson.toJson(obj, UserResponse::class.java)
        }

        fun toJsonArray(obj: UserResponse): String {
            return gson.toJson(obj, Array<UserResponse>::class.java)
        }

        fun fromJsonArray(json: String): Array<UserResponse> {
            return gson.fromJson(json, Array<UserResponse>::class.java)
        }
    } public fun getResultId(): String { return this.resultId; }; public fun setResultId(resultId: String) { this.resultId = resultId; } public fun getMetaId(): String { return this.metaId; }; public fun setMetaId(metaId: String) { this.metaId = metaId; }
}
