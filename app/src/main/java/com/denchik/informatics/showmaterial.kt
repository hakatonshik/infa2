package com.denchik.informatics

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import kotlin.properties.Delegates

class showmaterial : AppCompatActivity() {

    private lateinit var resources: Resources
    private lateinit var output: String
    private var  klass by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showmaterial)
        klass = intent.getIntExtra("class", 0)
        var classText = findViewById<TextView>(R.id.class_text).apply {
            text = if(klass.toString() == "10") "10/11 класс (ЕГЭ)"
            else "$klass класс"
        }
        resources = getResources()
        try {
            output = ResourcesIO.LoadFile(this, "webs.txt")!!
            //output to LogCat
            Log.i("test", output)
        } catch (e: IOException) {
            val toast = Toast.makeText(this, "Ошибка: Файлы приложения повреждены", Toast.LENGTH_LONG)
            toast.show()
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter(fillWebs(output))


    }

    private fun fillWebs(input : String): List<web> {
        var s = input.split("\n")
        var data = mutableListOf<web>()
        s.forEach {
            if(it.startsWith(klass.toString())) {
                var u = it.split(';')
                data.add(web(u[0].toInt(), u[1], u[2]))
            }
            else if (klass == 10 && it.startsWith(11.toString()))
            {
                var u = it.split(';')
                data.add(web(u[0].toInt(), u[1], u[2]))
            }
        }
        return data
    }
}