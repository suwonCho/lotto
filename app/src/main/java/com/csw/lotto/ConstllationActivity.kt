package com.csw.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.csw.lotto.ConstllationActivity
import com.csw.lotto.databinding.ActivityConstllationBinding

class ConstllationActivity : AppCompatActivity() {
    lateinit var w : ActivityConstllationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_constllation)
        w = ActivityConstllationBinding.inflate(layoutInflater)
        setContentView(w.root)

        w.goResultButton.setOnClickListener{
            startActivity((Intent(this, ResultActivity::class.java.javaClass)))
        }

//        w.goResultButton.setOnClickListener()



        Toast.makeText(applicationContext, "ConstllationActivity", Toast.LENGTH_LONG).show()
    }

//    void OnClick(l:ViewOnClickListener)
//    {
//
//    }

}