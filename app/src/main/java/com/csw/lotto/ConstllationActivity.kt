package com.csw.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ConstllationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constllation)

        Toast.makeText(applicationContext, "ConstllationActivity", Toast.LENGTH_LONG).show()
    }
}