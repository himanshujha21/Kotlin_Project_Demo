package com.example.dynamicappexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dynamicappexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider.AndroidViewModelFactory(this.application)
            .create(MainViewModel::class.java)



        /*val retrofitData = RetrofitHelper.getInstance().getPosts()

        retrofitData.enqueue(object : Callback<List<MyPostsItem>?> {
            override fun onResponse(
                call: Call<List<MyPostsItem>?>, response: Response<List<MyPostsItem>?>
            ) {
                val responseBody = response.body()
                if (responseBody != null) {


                    val myStringBuilder = StringBuilder()
                    for (myPost in responseBody) {
                        binding.progressBar.visibility = View.VISIBLE;


                        myStringBuilder.append(myPost.title)
                        myStringBuilder.append("\n")
                        binding.tvTitle.text = myStringBuilder
                        binding.progressBar.visibility = View.INVISIBLE

                    }
                }


            }

            override fun onFailure(call: Call<List<MyPostsItem>?>, t: Throwable) {

            }
        })

*/
    }


}