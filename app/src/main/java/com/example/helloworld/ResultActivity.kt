package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult=findViewById<TextView>(R.id.tv_result)
        val tvClassification=findViewById<TextView>(R.id.tv_classification)

        val result=intent.getFloatExtra("EXTRA_RESULT",0.1f)

        tvResult.text=result.toString()

        val classification= if (result in 0f..18.5f/*<=18.5 && result>0*/)
    	{ "UNDERWEIGHT" }
    else if (result>18.5 && result<25)
    	{ "HEATHY WEIGHT" }
    else if (result>=25 && result<30)
    	{ "OVERWEIGHT" }
    else
    	{ "OBESITY" }

        tvClassification.text=getString(R.string.message_classification, classification)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}