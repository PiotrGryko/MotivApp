 
package com.motiv.piotr.dao
import androidx.room.*
import com.motiv.piotr.RateLimit
import kotlin.collections.List
@Dao
public interface RateLimitDao {

    @Insert
    public fun saveRateLimit(rateLimit: com.motiv.piotr.RateLimit): Long@Delete
    public fun deleteRateLimit(rateLimit: com.motiv.piotr.RateLimit): Int@Query("SELECT * FROM rateLimit")
    public fun getRateLimits(): List<RateLimit>@Query("SELECT * FROM rateLimit WHERE id = :id")
    public fun getRateLimit(id: String): RateLimit@Insert(onConflict = OnConflictStrategy.REPLACE)
    public fun saveRateLimits(rateLimit: List<com.motiv.piotr.RateLimit>): Unit
}
