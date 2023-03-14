package com.coka.AppUtils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.coka.progressdialog.ProgressDialogHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvShowDialog = findViewById<TextView>(R.id.tvShowDialog)

        tvShowDialog.setOnClickListener{
            ProgressDialogHolder.getInstance(this).showDialog("")
        }

    }
}