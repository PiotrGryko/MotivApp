package com.motiv.piotr;

import androidx.room.*;

public class UserWithReferences {

    @Embedded private com.motiv.piotr.User user;

    @Relation(entity = com.motiv.piotr.Links.class, parentColumn = "linksId", entityColumn = "id")
    public java.util.List<com.motiv.piotr.Links> links;

    public User getUser() {
        if (links.size() > 0) {
            user.setLinks(links.get(0));
        }

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
