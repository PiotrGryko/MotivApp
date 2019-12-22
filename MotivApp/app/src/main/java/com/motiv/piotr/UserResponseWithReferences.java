package com.motiv.piotr;

import androidx.room.*;

public class UserResponseWithReferences {

    @Embedded private com.motiv.piotr.UserResponse userResponse;

    @Relation(entity = com.motiv.piotr.User.class, parentColumn = "resultId", entityColumn = "id")
    public java.util.List<com.motiv.piotr.User> result;

    @Relation(entity = com.motiv.piotr.Meta.class, parentColumn = "metaId", entityColumn = "id")
    public java.util.List<com.motiv.piotr.Meta> meta;

    public UserResponse getUserResponse() {
        if (result.size() > 0) {
            userResponse.setResult(result.get(0));
        }
        if (meta.size() > 0) {
            userResponse.setMeta(meta.get(0));
        }

        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
