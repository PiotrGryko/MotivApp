package com.motiv.piotr;

import androidx.fragment.app.*;
import androidx.room.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class LinksWithReferences {

    @Embedded private com.motiv.piotr.Links links;

    @Relation(entity = com.motiv.piotr.Link.class, parentColumn = "editId", entityColumn = "id")
    public java.util.List<com.motiv.piotr.Link> edit;

    @Relation(entity = com.motiv.piotr.Link.class, parentColumn = "selfId", entityColumn = "id")
    public java.util.List<com.motiv.piotr.Link> self;

    @Relation(entity = com.motiv.piotr.Link.class, parentColumn = "avatarId", entityColumn = "id")
    public java.util.List<com.motiv.piotr.Link> avatar;

    public Links getLinks() {
        if (edit.size() > 0) {
            links.setEdit(edit.get(0));
        }
        if (self.size() > 0) {
            links.setSelf(self.get(0));
        }
        if (avatar.size() > 0) {
            links.setAvatar(avatar.get(0));
        }

        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
