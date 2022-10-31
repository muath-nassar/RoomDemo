package com.muath.roomdemo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey(autoGenerate = true) var id : Int,
    @ColumnInfo(name = "author") var author : String,
    @ColumnInfo(name = "content") var content : String
)
