package com.example.houyuapp.presentation.list

import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.houyuapp.R
import com.example.houyuapp.data.local.DogAPI
import com.example.houyuapp.domain.entity.Dog
import com.example.houyuapp.domain.entity.RestDogResponse
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DogListActivity : AppCompatActivity() {
    private val BASE_URL : String = "https://raw.githubusercontent.com/Houyu0926/Houyu_app/master/"

    private var recyclerView: RecyclerView? = null
    private var mAdapter: ListAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        makeApiCall()
    }

    fun showList(dogList: MutableList<Dog?>?){
        recyclerView = findViewById(R.id.recycler_view) as RecyclerView

        recyclerView!!.setHasFixedSize(true)
        // use a linear layout manager
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager



        mAdapter = ListAdapter(dogList, applicationContext, object : ListAdapter.OnItemClickListener {
            override fun onItemClick(item: Dog?) {
                onItemClick(item)
            }
        })
        recyclerView!!.adapter = mAdapter
    }



    fun makeApiCall() {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val dogApi: DogAPI = retrofit.create(DogAPI::class.java)

        val call: Call<RestDogResponse> = dogApi.breedResponse()
        call.enqueue(object : Callback<RestDogResponse> {
            override fun onResponse(
                call: Call<RestDogResponse?>?,
                response: Response<RestDogResponse?>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val dogList: MutableList<Dog?>? = response.body()!!.getInformation()
                    showList(dogList)
                }
            }

            override fun onFailure(call: Call<RestDogResponse?>?, t: Throwable?) {
                showError()
            }
        })
    }

    private fun showError(){
        Toast.makeText(getApplicationContext(), "API error !", Toast.LENGTH_SHORT).show()
    }

}



