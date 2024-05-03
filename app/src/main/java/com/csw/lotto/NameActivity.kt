package com.csw.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.csw.lotto.databinding.ActivityNameBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.Random

class NameActivity : AppCompatActivity() {

    lateinit var W : ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        W = ActivityNameBinding.inflate(layoutInflater)
        setContentView(W.root)

        W.goButton.setOnClickListener{
            var intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumbers(W.editText.text.toString())))
            intent.putExtra("name", W.editText.text.toString())
            startActivity(intent)
        }

        W.backButton.setOnClickListener {
            finish()
        }



        Toast.makeText(applicationContext, "NameActivity", Toast.LENGTH_LONG).show()
    }


    fun getLottoNumbers(name:String) : MutableList<Int>{
        val list = mutableListOf<Int>()

        for(i in 1..45)
        {
            list.add(i)
        }

        val trg = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + name

        list.shuffle(Random(name.hashCode().toLong()))

        return list.subList(0, 6)
    }
}