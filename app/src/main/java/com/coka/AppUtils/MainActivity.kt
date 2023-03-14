package com.coka.AppUtils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.coka.base_mvp.base.BaseActivity
import com.coka.progressdialog.ProgressDialogHolder

class MainActivity : BaseActivity() {
    override fun initView() {
        val tvShowDialog = findViewById<TextView>(R.id.tvShowDialog)
        tvShowDialog.setOnClickListener{
            ProgressDialogHolder.getInstance(this).showDialog("")
        }
    }

    override fun initData() {
       //cal api
    }

    override fun getLayoutId(): Int =R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}