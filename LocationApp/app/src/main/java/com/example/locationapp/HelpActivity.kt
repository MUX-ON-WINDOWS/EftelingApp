package com.example.locationapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HelpActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

    }

    fun mainactivity(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun infoactivity(view: View) {
        startActivity(Intent(this, InfoActivity::class.java))
    }
}