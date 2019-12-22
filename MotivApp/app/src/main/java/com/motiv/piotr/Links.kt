 
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
@Entity(tableName = "links")
public class Links {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "editId")@ForeignKey(entity = com.motiv.piotr.Link::class, parentColumns = ["id"], childColumns = ["editId"])
    private
    var editId: String = ""
    @ColumnInfo(name = "selfId")@ForeignKey(entity = com.motiv.piotr.Link::class, parentColumns = ["id"], childColumns = ["selfId"])
    private
    var selfId: String = ""
    @ColumnInfo(name = "avatarId")@ForeignKey(entity = com.motiv.piotr.Link::class, parentColumns = ["id"], childColumns = ["avatarId"])
    private
    var avatarId: String = ""
    @Ignore
    @SerializedName("edit")
    private var edit: com.motiv.piotr.Link = com.motiv.piotr.Link()
    @Ignore
    @SerializedName("self")
    private var self: com.motiv.piotr.Link = com.motiv.piotr.Link()
    @Ignore
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
        Picasso.with(view.getContext()).load(url).into(view)
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
    } public fun getEditId(): String { return this.editId; }; public fun setEditId(editId: String) { this.editId = editId; } public fun getSelfId(): String { return this.selfId; }; public fun setSelfId(selfId: String) { this.selfId = selfId; } public fun getAvatarId(): String { return this.avatarId; }; public fun setAvatarId(avatarId: String) { this.avatarId = avatarId; }
}
