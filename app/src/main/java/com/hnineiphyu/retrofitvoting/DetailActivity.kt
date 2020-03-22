package com.hnineiphyu.retrofitvoting

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class QueenVoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vote_queen)

        val ImageURL = intent.getStringExtra("IMAGEURL")
        Log.d("image", ImageURL.toString())

        val imgurl = findViewById<ImageView>(R.id.queen_image)

        //Glide.with(this).load(ImageURL).into(imgurl)

        val QueenName = intent.getStringExtra("QUEEN_NAME")
        Log.d("name", QueenName)

        val name = findViewById<TextView>(R.id.queen_name)
        name.text = QueenName

        val QueenClass = intent.getStringExtra("QUEEN_CLASS")

//        val queenclass = findViewById<TextView>(R.id.txt_class).apply {
//            this.text = QueenClass
//        }
    }
}



