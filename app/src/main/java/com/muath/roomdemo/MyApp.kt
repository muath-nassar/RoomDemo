package com.muath.roomdemo

import android.app.Application
import androidx.room.Room
import com.muath.roomdemo.db.AppDatabase
import com.muath.roomdemo.db.MyDbSingleton

class MyApp :Application() {
    override fun onCreate() {
        super.onCreate()
        MyDbSingleton.db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}