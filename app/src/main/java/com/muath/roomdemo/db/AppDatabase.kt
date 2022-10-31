package com.muath.roomdemo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muath.roomdemo.models.Post

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun postDao(): PostDao
}