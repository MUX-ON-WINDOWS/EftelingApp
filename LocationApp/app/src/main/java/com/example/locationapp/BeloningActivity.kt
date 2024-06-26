package com.example.locationapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.content.Context
import android.view.Gravity
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity

class BeloningActivity : AppCompatActivity(){

    fun mainactivity(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun stamboomactivity(view: View) {
        startActivity(Intent(this, StamboomActivity::class.java))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beloning)

        val codeWeergevenButton = findViewById<ImageButton>(R.id.redbutton)
        val overlay = findViewById<View>(R.id.overlay)

        codeWeergevenButton.setOnClickListener {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_codeweergeven, findViewById(android.R.id.content), false)

            val closeButton = popupView.findViewById<ImageButton>(R.id.codevoltooid)

            val popupWindow = PopupWindow(
                popupView,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )

            overlay.visibility = View.VISIBLE

            popupWindow.isFocusable = true
            popupWindow.showAtLocation(popupView, Gravity.BOTTOM, 0, 0)

            popupWindow.setOnDismissListener {
                overlay.visibility = View.GONE
            }

            popupWindow.setOnDismissListener {
                val intent = Intent(this@BeloningActivity, OverviewActivity::class.java)
                startActivity(intent)
            }

            closeButton.setOnClickListener {
                popupWindow.dismiss()
            }
        }
    }


}