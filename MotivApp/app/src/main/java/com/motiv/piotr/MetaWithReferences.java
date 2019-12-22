package com.motiv.piotr;

import androidx.room.*;

public class MetaWithReferences {

    @Embedded private com.motiv.piotr.Meta meta;

    @Relation(
        entity = com.motiv.piotr.RateLimit.class,
        parentColumn = "rateLimitId",
        entityColumn = "id"
    )
    public java.util.List<com.motiv.piotr.RateLimit> rateLimit;

    public Meta getMeta() {
        if (rateLimit.size() > 0) {
            meta.setRateLimit(rateLimit.get(0));
        }

        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
