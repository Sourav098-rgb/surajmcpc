package com.example.surajmcpc

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


var text5:Int=0
class Dialog_box : AppCompatActivity() {
    var btn: Button?=null
    var text1: TextView?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dialog_box)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn=findViewById(R.id.Button)
        text1=findViewById(R.id.textview)
        btn?.setOnClickListener {
            var dialog= Dialog(this)
            dialog.setContentView(R.layout.activity_dialog_box)
            val btn1=dialog.findViewById<Button>(R.id.bnt_sum)
            val btn2=dialog.findViewById<Button>(R.id.bnt_sub)
            val btn3=dialog.findViewById<Button>(R.id.bnt_reset)
            val text=dialog.findViewById<EditText>(R.id.TEXT)
            btn1.setOnClickListener {
                if(text.toString().isNullOrEmpty()){
                    text.setText("0")
                }
                text5=text.toString().toInt()+text1.text.toString().toInt()
                text1.setText(text5.toString())
                dialog.dismiss()

            }
            btn2.setOnClickListener {
                if (text.toString().isNullOrEmpty()){
                    text.setText("0")
                }
                text5=text1.toString().toInt()-text.toString().toInt()
                text1.setOnClickListener(text5.toString())
                dialog.dismiss()
            }
            btn3.setOnClickListener {
                text5=0
                text1?.setOnClickListener(text5.toString())
                dialog.dismiss()
            }
            dialog.show()


        }
    }
}