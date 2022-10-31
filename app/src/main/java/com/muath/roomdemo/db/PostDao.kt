package com.muath.roomdemo.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.muath.roomdemo.models.Post

@Dao
interface PostDao {
    @Query("SELECT * FROM post")
    fun getAll(): List<Post>

    @Insert
    fun insertAll(vararg users: Post)

    @Delete
    fun delete(user: Post)
}