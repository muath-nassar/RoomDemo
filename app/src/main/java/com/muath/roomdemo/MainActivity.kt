package com.muath.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.muath.roomdemo.db.AppDatabase
import com.muath.roomdemo.db.MyDbSingleton
import com.muath.roomdemo.models.Post

class MainActivity : AppCompatActivity() {
    lateinit var tvShow: TextView
    lateinit var btnAdd: Button
    lateinit var btnShow: Button
    val posts = mutableListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        val dao = MyDbSingleton.db?.postDao()

        btnAdd.setOnClickListener {
            val post = Post(0,"Ahmad","Dummy Data")
            Thread{
                dao!!.insertAll(post)
            }.start()

        }
        btnShow.setOnClickListener {
            Thread{
                val ps =  dao?.getAll()
                posts.clear()
                if (ps != null) {
                    posts.addAll(ps)
                }
                var text = ""
                for (p in posts){
                    text+="$p \n"
                }
                runOnUiThread{
                    tvShow.text = text
                }
            }.start()



        }
    }

    private fun bindView() {
        tvShow = findViewById(R.id.textView)
        btnShow = findViewById(R.id.button2)
        btnAdd = findViewById(R.id.button)
    }
}