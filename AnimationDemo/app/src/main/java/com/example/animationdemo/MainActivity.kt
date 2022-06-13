package com.example.animationdemo

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import com.example.animationdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)


        /*ObjectAnimator.ofFloat(binding.btnAnimation, View.ROTATION_Y, 0f, 300f).apply {


            duration = 4000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            start()


        }*/


        //First Approach via anim resource

        //val animMove = AnimationUtils.loadAnimation(this, R.anim.move)

        //binding.btnAnimation.animation = AnimationUtils.loadAnimation(this, R.anim.move)// set the animation


        AnimatorSet().apply {

            /*playTogether(


                //Second Approach Via objectAnimator
                ObjectAnimator.ofFloat(binding.btnAnimation, View.SCALE_X, 0f, 4f).apply {

                    duration = 4000
                    repeatCount = ObjectAnimator.INFINITE
                    repeatMode = ObjectAnimator.REVERSE

                },

                ObjectAnimator.ofFloat(binding.btnAnimation, View.SCALE_Y, 0f, 2f).apply {


                    duration = 4000
                    repeatCount = ObjectAnimator.INFINITE
                    repeatMode = ObjectAnimator.REVERSE


                },

                ObjectAnimator.ofFloat(binding.btnAnimation, View.ROTATION, 0f, 300f).apply {


                    duration = 4000
                    repeatCount = ObjectAnimator.INFINITE
                    repeatMode = ObjectAnimator.REVERSE


                }


            )

*/
            play(ObjectAnimator.ofFloat(binding.btnAnimation, View.SCALE_X, 0f, 4f).apply {

                duration = 4000
                repeatCount = 6//7 times repeat
                repeatMode = ObjectAnimator.REVERSE

            }).before(ObjectAnimator.ofFloat(binding.btnAnimation, View.ROTATION, 0f, 300f).apply {


                duration = 4000
                repeatCount = ObjectAnimator.INFINITE
                repeatMode = ObjectAnimator.REVERSE


            })


            start()
        }
    }
}
