 
package com.motiv.piotr
import androidx.annotation.NonNull
import androidx.room.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import java.util.*
import java.util.concurrent.*
import kotlin.collections.List
@Entity(tableName = "photoslistresponse")
public class PhotosListResponse {

    @NonNull
    @PrimaryKey

    private var id: String = UUID.randomUUID().toString()
    @ColumnInfo(name = "metaId")@ForeignKey(entity = com.motiv.piotr.Meta::class, parentColumns = ["id"], childColumns = ["metaId"])
    private
    var metaId: String = ""
    @Ignore
    @SerializedName("result")
    private var result: List<com.motiv.piotr.Photo> = listOf()
    @Ignore
    @SerializedName("_meta")
    private var meta: com.motiv.piotr.Meta = com.motiv.piotr.Meta()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getResult(): List<com.motiv.piotr.Photo> {
        return this.result
    } fun setResult(result: List<com.motiv.piotr.Photo>) {
        this.result = result
    } fun getMeta(): com.motiv.piotr.Meta {
        return this.meta
    } fun setMeta(meta: com.motiv.piotr.Meta) {
        this.meta = meta
    } companion object {
        val gson: Gson = Gson()
        fun fromJson(json: String): PhotosListResponse {
            return gson.fromJson(json, PhotosListResponse::class.java)
        }

        fun toJson(obj: PhotosListResponse): String {
            return gson.toJson(obj, PhotosListResponse::class.java)
        }

        fun toJsonArray(obj: PhotosListResponse): String {
            return gson.toJson(obj, Array<PhotosListResponse>::class.java)
        }

        fun fromJsonArray(json: String): Array<PhotosListResponse> {
            return gson.fromJson(json, Array<PhotosListResponse>::class.java)
        }
    } public fun getMetaId(): String { return this.metaId; }; public fun setMetaId(metaId: String) { this.metaId = metaId; }
}
