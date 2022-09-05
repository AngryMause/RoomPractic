package com.example.roompractic.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUsr(data: Data)

    @Query("SELECT * FROM user ORDER BY id ASC")
    fun readAllData(): LiveData<List<Data>>

    @Update
    suspend fun updateUser(user: Data)

    @Delete
    suspend fun deleteUser(user: Data)

}