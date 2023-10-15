package com.example.roomagain.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomagain.user

@Dao
interface userDAO {
    @Insert
    fun insertUser(user:user)
    @Query("select * from User")
    fun getListUsers():List<user>
}