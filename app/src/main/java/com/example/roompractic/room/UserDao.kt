package com.example.roompractic.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUsr(data: UserDataModel)

    @Query("SELECT * FROM user ORDER BY id ASC")
    fun readAllData(): LiveData<List<UserDataModel>>

    @Update
    suspend fun updateUser(user: UserDataModel)
}