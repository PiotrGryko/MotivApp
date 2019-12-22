package com.motiv.piotr.dao;

import androidx.room.*;
import com.motiv.piotr.UserResponseWithReferences;

@Dao
public interface UserResponseDao {

    @Insert
    public long saveUserResponse(com.motiv.piotr.UserResponse userResponse);

    @Delete
    public int deleteUserResponse(com.motiv.piotr.UserResponse userResponse);

    @Query("SELECT * FROM userResponse")
    @Transaction
    public java.util.List<UserResponseWithReferences> getUserResponses();

    @Query("SELECT * FROM userResponse WHERE id = :id")
    @Transaction
    public UserResponseWithReferences getUserResponse(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveUserResponses(java.util.List<com.motiv.piotr.UserResponse> userResponse);
}
