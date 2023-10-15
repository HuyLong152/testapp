package com.example.roomagain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomagain.user

@Database(entities = [user::class], version = 1)
abstract class userDatabase:RoomDatabase() {
    abstract fun userDao():userDAO
    companion object{
        @Volatile
        private var instance : userDatabase? =null
        fun getInstance(context : Context) : userDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(context,userDatabase::class.java,"userDB").allowMainThreadQueries().build()
            }
            return  instance!!
        }
    }
}