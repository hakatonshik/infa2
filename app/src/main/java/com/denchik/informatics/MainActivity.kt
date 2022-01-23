package com.denchik.informatics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn7class = findViewById<Button>(R.id.btn7class).setOnClickListener { switchToMaterial((7)) }
        val btn8class = findViewById<Button>(R.id.btn8class).setOnClickListener { switchToMaterial((8)) }
        val btn9class = findViewById<Button>(R.id.btn9class).setOnClickListener { switchToMaterial((9)) }
        val btnEGE = findViewById<Button>(R.id.btnEGE).setOnClickListener { switchToMaterial((10)) }
        val btnAbout = findViewById<Button>(R.id.btnAbout).setOnClickListener { startActivity(Intent(this, AboutActivity::class.java))}
    }

    fun switchToMaterial(klass : Int)
    {
        var intent = Intent(this, showmaterial::class.java).apply {
            putExtra("class", klass)
        }
        startActivity(intent)
    }
}