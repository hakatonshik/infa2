package com.denchik.informatics

import android.content.Context
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream

object ResourcesIO {


    fun LoadFile(context : Context, fileName: String): String? {
        val file =
            context.getResources().openRawResource(R.raw.webs)
        return readTextFile(file)

    }
    fun readTextFile(inputStream: InputStream): String? {
        val outputStream = ByteArrayOutputStream()
        val buf = ByteArray(1024)
        var len: Int
        try {
            while (inputStream.read(buf).also { len = it } != -1) {
                outputStream.write(buf, 0, len)
            }
            outputStream.close()
            inputStream.close()
        } catch (e: IOException) {
        }
        return outputStream.toString()
    }
}