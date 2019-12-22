package com.motiv.piotr;

import androidx.fragment.app.*;
import androidx.room.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class UsersListResponseWithReferences {

    @Embedded private com.motiv.piotr.UsersListResponse usersListResponse;

    @Relation(entity = com.motiv.piotr.Meta.class, parentColumn = "metaId", entityColumn = "id")
    public java.util.List<com.motiv.piotr.Meta> meta;

    @Relation(
        entity = com.motiv.piotr.User.class,
        parentColumn = "id",
        entityColumn = "resultOwnerId"
    )
    public java.util.List<com.motiv.piotr.User> result;

    public UsersListResponse getUsersListResponse() {
        if (meta.size() > 0) {
            usersListResponse.setMeta(meta.get(0));
        }
        usersListResponse.setResult(result);

        return usersListResponse;
    }

    public void setUsersListResponse(UsersListResponse usersListResponse) {
        this.usersListResponse = usersListResponse;
    }
}
