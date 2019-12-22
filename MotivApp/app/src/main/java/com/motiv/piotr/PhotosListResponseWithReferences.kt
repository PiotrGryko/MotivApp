 
package com.motiv.piotr
import androidx.fragment.app.*
import androidx.room.*
import dagger.*
import dagger.android.*
import dagger.android.support.*
import javax.inject.*
import kotlin.collections.List

public class PhotosListResponseWithReferences {

    @Embedded
    private lateinit var photosListResponse: com.motiv.piotr.PhotosListResponse

    @Relation(entity = com.motiv.piotr.Meta::class, parentColumn = "metaId", entityColumn = "id")

    public var meta: List<com.motiv.piotr.Meta> = arrayListOf()
    @Relation(entity = com.motiv.piotr.Photo::class, parentColumn = "id", entityColumn = "resultOwnerId")
    public var result: List<com.motiv.piotr.Photo> = arrayListOf()

    fun getPhotosListResponse(): PhotosListResponse {
        if (meta.size > 0) {
            photosListResponse.setMeta(meta.get(0))
        }
        photosListResponse.setResult(result)

        return photosListResponse
    } public fun setPhotosListResponse(photosListResponse: PhotosListResponse) { this.photosListResponse = photosListResponse; }
}
