 
package com.motiv.piotr
import androidx.annotation.NonNull
import androidx.fragment.app.*
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
import kotlin.collections.List

public open class UsersListResponse : RealmObject() {

    @NonNull private var id: String = UUID.randomUUID().toString()

    @SerializedName("result")

    private var result: RealmList<com.motiv.piotr.User> = RealmList()

    @SerializedName("_meta")

    private var meta: com.motiv.piotr.Meta = com.motiv.piotr.Meta()

    fun getId(): String {
        return this.id
    } fun setId(id: String) {
        this.id = id
    } fun getResult(): List<com.motiv.piotr.User> {
        return this.result
    } fun setResult(result: RealmList<com.motiv.piotr.User>) {
        this.result = result
    } fun getMeta(): com.motiv.piotr.Meta {
        return this.meta
    } fun setMeta(meta: com.motiv.piotr.Meta) {
        this.meta = meta
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
    }
}
