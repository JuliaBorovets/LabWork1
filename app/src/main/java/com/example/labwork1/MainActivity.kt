package com.example.labwork1

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private var textView7: TextView? = null
    private var textView11: TextView? = null

    private var textView12: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        //Завдання 1
        val userInputA: EditText = findViewById(R.id.editText)
        val userInputB: EditText = findViewById(R.id.editText2)
        val userInputC: EditText = findViewById(R.id.editText4)
        val userInputD: EditText = findViewById(R.id.editText3)

        val button1: Button = findViewById(R.id.button)
        textView7 = findViewById(R.id.textView7)
        textView7?.text = ""
        textView7?.movementMethod = ScrollingMovementMethod()

        button1.setOnClickListener {

            try {
                textView7?.text = " "

                val a = userInputA.text.toString().toDouble()
                val b = userInputB.text.toString().toDouble()
                val c = userInputC.text.toString().toDouble()
                val d = userInputD.text.toString().toDouble()

                val resultFirst = Calculator()
                val res1 = resultFirst.calculateFirst(a, b, c, d).toDouble()

                textView7?.append("%.2f".format(res1))
                textView7?.append("\n")

            } catch (e: Exception) {
                textView7?.append("Неможливо! \n")
            }
        }

        //Завдання 2

        val userInputR: EditText = findViewById(R.id.editText5)
        val userInputX: EditText = findViewById(R.id.editText6)

        val button2: Button = findViewById(R.id.button2)
        textView11 = findViewById(R.id.textView11)
        textView11?.text = ""
        textView11?.movementMethod = ScrollingMovementMethod()

        button2.setOnClickListener {

            try {
                textView11?.text = " "

                val x = userInputX.text.toString().toDouble()
                val r = userInputR.text.toString().toDouble()

                val resultSecond = Calculator()
                val res2 = resultSecond.calculateSecond(x, r).toDouble()

                textView11?.append("%.2f".format(res2))
                textView11?.append("\n")


            } catch (e: Exception) {
                textView11?.append("Неможливо! \n")
            }
        }

        //Завдання 3

        val userInputN: EditText = findViewById(R.id.editText9)
        val userInputP: EditText = findViewById(R.id.editText10)

        val button3: Button = findViewById(R.id.button3)
        textView12 = findViewById(R.id.textView12)
        textView12?.text = ""
        textView12?.movementMethod = ScrollingMovementMethod()

        button3.setOnClickListener {

            try {

                textView12?.text = " "

                val n = userInputN.text.toString().toInt()
                val p = userInputP.text.toString().toInt()

                val resultThird = Calculator()
                val res3 = resultThird.calculateThird(n, p)

                textView12?.append("%.2f".format(res3))
                textView12?.append("\n")


            } catch (e: Exception) {
                textView12?.append("Неможливо! \n")
            }
        }
    }
}
