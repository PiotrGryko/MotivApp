package com.motiv.piotr;

import androidx.fragment.app.*;
import androidx.room.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class PhotosListResponseWithReferences {

    @Embedded private com.motiv.piotr.PhotosListResponse photosListResponse;

    @Relation(entity = com.motiv.piotr.Meta.class, parentColumn = "metaId", entityColumn = "id")
    public java.util.List<com.motiv.piotr.Meta> meta;

    @Relation(
        entity = com.motiv.piotr.Photo.class,
        parentColumn = "id",
        entityColumn = "resultOwnerId"
    )
    public java.util.List<com.motiv.piotr.Photo> result;

    public PhotosListResponse getPhotosListResponse() {
        if (meta.size() > 0) {
            photosListResponse.setMeta(meta.get(0));
        }
        photosListResponse.setResult(result);

        return photosListResponse;
    }

    public void setPhotosListResponse(PhotosListResponse photosListResponse) {
        this.photosListResponse = photosListResponse;
    }
}
