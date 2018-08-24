package com.luowei.logwhere

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.luowei.logwherelibrary.logDebug

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logDebug("hello Main")
        ClassA().hello()
        ClassB().hello()
    }
}
