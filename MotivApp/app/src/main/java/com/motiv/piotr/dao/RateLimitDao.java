package com.motiv.piotr.dao;

import androidx.fragment.app.*;
import androidx.room.*;
import com.motiv.piotr.RateLimit;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

@Dao
public interface RateLimitDao {

    @Insert
    public long saveRateLimit(com.motiv.piotr.RateLimit rateLimit);

    @Delete
    public int deleteRateLimit(com.motiv.piotr.RateLimit rateLimit);

    @Query("SELECT * FROM rateLimit")
    public java.util.List<RateLimit> getRateLimits();

    @Query("SELECT * FROM rateLimit WHERE id = :id")
    public RateLimit getRateLimit(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveRateLimits(java.util.List<com.motiv.piotr.RateLimit> rateLimit);
}
