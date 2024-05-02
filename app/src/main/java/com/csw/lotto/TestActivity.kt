package com.csw.lotto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import com.csw.lotto.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    lateinit var W : ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        W = ActivityTestBinding.inflate(layoutInflater)
        setContentView(W.root)

        W.button.setOnClickListener {
            val intent = Intent(this@TestActivity, MainActivity::class.java)
            startActivity(intent)
        }

        W.button3.setOnClickListener {
            val intent = Intent(this@TestActivity, NameActivity::class.java)
            startActivity(intent)
        }

        W.button4.setOnClickListener {
            val intent = Intent(this@TestActivity, ResultActivity::class.java)
            startActivity(intent)
        }
    }


    fun goConstellation(view: View) {

        val intent = Intent(this@TestActivity, ConstllationActivity::class.java)
        startActivity(intent)
    }


    fun callWeb(view: View) {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"))
        startActivity(intent)
    }

}   //end class