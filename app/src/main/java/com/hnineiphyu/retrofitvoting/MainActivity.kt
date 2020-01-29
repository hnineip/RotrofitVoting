package com.hnineiphyu.retrofitvoting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.retrofitvoting.adapter.QueenAdapter
import com.hnineiphyu.retrofitvoting.api.QueenApiInterface
import com.hnineiphyu.retrofitvoting.model.QueenModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var BASE_URL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"
    lateinit var recyclerQueen: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getQueen()
    }

    fun LoadQueenList(queenList:List<QueenModel>){
        recyclerQueen = findViewById(R.id.recyclerQueen)
        recyclerQueen.apply {
            layoutManager = LinearLayoutManager(context)
            var queenadater = QueenAdapter(queenList, context)
            adapter = queenadater
         }
        }

    fun getQueen(){
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(QueenApiInterface::class.java)

        var apiCall = retrofitService.getQueen()

        apiCall.enqueue(object : Callback<List<QueenModel>>{
           override fun onFailure(call: Call<List<QueenModel>>, t: Throwable) {

           }

           override fun onResponse(
               call: Call<List<QueenModel>>,
               response: Response<List<QueenModel>>
           ) {
               var queenlist = response.body()!!
               LoadQueenList(queenlist)
           }
       })

    }
}
