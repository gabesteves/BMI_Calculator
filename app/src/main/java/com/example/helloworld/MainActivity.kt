package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val edtheight: EditText = findViewById(R.id.inputHeight)
        val edtweight: EditText = findViewById(R.id.inputWeight)

        btnCalculate.setOnClickListener {
            val heightStr = edtheight.text.toString()
            val weightStr = edtweight.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                val height: Float = heightStr.toFloat()
                val weight: Float = weightStr.toFloat()

                val calcHeight: Float = height * height
                val result: Float = weight / calcHeight

                val intent = Intent(this, ResultActivity::class.java)

                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }

                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill up all the datas.", Toast.LENGTH_LONG).show()
            }

        }
    }
}