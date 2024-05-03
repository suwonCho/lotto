package com.csw.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.ImageView
import android.widget.Toast
import com.csw.lotto.ResultActivity.*
import com.csw.lotto.databinding.ActivityResultBinding
import java.text.SimpleDateFormat
import java.util.Date

class ResultActivity : AppCompatActivity() {
    val lottoImageStartId = R.drawable.ball_01
    lateinit var W : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        W = ActivityResultBinding.inflate(layoutInflater)
        setContentView(W.root)

        val result = intent.getIntegerArrayListExtra("result")
        val name = intent.getStringExtra("name")

        result?.let {
            if(!TextUtils.isEmpty(name)){
                W.resultLabel.text = "${name}님의\n${SimpleDateFormat("yyyy년MM월dd일").format(Date())}\n로또 번호입니다."
            }


            updateLottoBallImage(result.sortedBy { it })
        }

        Toast.makeText(applicationContext, "ResultActivity", Toast.LENGTH_LONG).show()
    }

    /**
     * 결과에 따라 로또 공 이미지 업데이트
    */
    fun updateLottoBallImage(result: List<Int>){
        if(result.size < 6) return

        W.imageView01.setImageResource(lottoImageStartId + (result[0] - 1))
        W.imageView02.setImageResource(lottoImageStartId + (result[1] - 1))
        W.imageView03.setImageResource(lottoImageStartId + (result[2] - 1))
        W.imageView04.setImageResource(lottoImageStartId + (result[3] - 1))
        W.imageView05.setImageResource(lottoImageStartId + (result[4] - 1))
        W.imageView06.setImageResource(lottoImageStartId + (result[5] - 1))

        //W.imageView01.invalidate()

//        var im = findViewById<ImageView>(R.id.imageView01)
//        im.setImageResource(lottoImageStartId + (result[0] - 1))
        //im.invalidate()
    }

}