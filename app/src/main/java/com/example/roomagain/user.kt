package com.example.roomagain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
class user(val userName:String = "", val userAdd:String = "") {
    @PrimaryKey(autoGenerate = true)
    var id :Int = 0
}