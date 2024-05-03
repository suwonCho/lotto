package com.csw.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.csw.lotto.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var W : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        W = ActivityMainBinding.inflate(layoutInflater)
        setContentView(W.root)

        W.randomCard.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getReandomLottoNumbers()))
            //intent.putIntegerArrayListExtra("Count", )
            startActivity(intent)
        }

        W.constellationCard.setOnClickListener {
            startActivity(Intent(this, ConstllationActivity::class.java))
        }

        W.nameCard.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }



        Toast.makeText(applicationContext, "MainActivit", Toast.LENGTH_LONG).show()
    }

    fun getRandomLottoNumber() : Int{
        return  Random.nextInt(45) + 1
    }

    fun getReandomLottoNumbers() : MutableList<Int>{
        val lottoNumers = mutableListOf<Int>()

        //셔플을 이용한 번호 생성
        for(i in 1..45)
        {
            lottoNumers.add(i)
        }

        lottoNumers.shuffle()

        return lottoNumers.subList(0, 6)


        //랜덥을 이용한 번호 생성
        for(i in 1..6)
        {
            var number = 0

            //중복 생성 방기 로직
            do{
                number = getRandomLottoNumber()
            } while (lottoNumers.contains(number))

            lottoNumers.add((getRandomLottoNumber()))
        }

        return lottoNumers
    }


}