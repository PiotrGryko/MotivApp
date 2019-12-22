package com.motiv.piotr.dao;

import androidx.room.*;
import com.motiv.piotr.UsersListResponseWithReferences;

@Dao
public interface UsersListResponseDao {

    @Insert
    public long saveUsersListResponse(com.motiv.piotr.UsersListResponse usersListResponse);

    @Delete
    public int deleteUsersListResponse(com.motiv.piotr.UsersListResponse usersListResponse);

    @Query("SELECT * FROM usersListResponse")
    @Transaction
    public java.util.List<UsersListResponseWithReferences> getUsersListResponses();

    @Query("SELECT * FROM usersListResponse WHERE id = :id")
    @Transaction
    public UsersListResponseWithReferences getUsersListResponse(java.lang.String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveUsersListResponses(
            java.util.List<com.motiv.piotr.UsersListResponse> usersListResponse);
}
