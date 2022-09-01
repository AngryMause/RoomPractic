package com.example.roompractic.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUsr(data: Data)

    @Query("SELECT * FROM user ORDER BY id ASC")
     fun readAllData(): LiveData<List<Data>>
}