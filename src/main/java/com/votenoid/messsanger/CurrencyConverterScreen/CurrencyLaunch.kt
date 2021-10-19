package com.votenoid.messsanger.CurrencyConverterScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.votenoid.messsanger.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrencyLaunch : AppCompatActivity() {
    lateinit var bodyText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.currency_converter)

        bodyText = findViewById(R.id.body)

        var retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var placeHolderApi: JsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        var call = placeHolderApi.users
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {

                    response.body()!!.forEach {
                        bodyText.append("bla bla")

                    }
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                bodyText.setText("hello hello")
            }
        })

    }
}