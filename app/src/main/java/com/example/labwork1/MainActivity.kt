package com.example.labwork1

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var textView7: TextView? = null
    private var textView11: TextView? = null
    private var textView12: TextView? = null
    private var pathFile: String? = null
    var nameOfFile: String = "myText.txt"
    private val baseContextOfFile = """
        2,3, 1, 6,
        6, 8,
        4, 5
    """.trimIndent()
    private var fileToWrite: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) //will hide the title
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        pathFile = getExternalFilesDir(null)?.absolutePath.toString()
        pathToFile.append(pathFile)



        //Завдання 1
        val userInputA: EditText = findViewById(R.id.editText)
        val userInputB: EditText = findViewById(R.id.editText2)
        val userInputC: EditText = findViewById(R.id.editText4)
        val userInputD: EditText = findViewById(R.id.editText3)

        val buttonResult1: Button = findViewById(R.id.buttonResult1)
        textView7 = findViewById(R.id.textView7)
        textView7?.text = ""
        textView7?.movementMethod = ScrollingMovementMethod()

        buttonResult1.setOnClickListener {

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

        buttonFromFile1.setOnClickListener {

            try {
                textView7?.text = " "

                try {
                    val sdPath = File("$pathFile/$nameOfFile")
                    if (!sdPath.exists()){
                        createFile()
                    }

                    val strSdPath: String = File(sdPath.absolutePath.toString()).toString()
                    val file = File(strSdPath)

                    val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }


                    val array: List<String> = inputAsString.split(",")

                    val a = array[0].toDouble()
                    val b = array[1].toDouble()
                    val c = array[2].toDouble()
                    val d = array[3].toDouble()

                    userInputA.setText(a.toString())
                    userInputB.setText(b.toString())
                    userInputC.setText(c.toString())
                    userInputD.setText(d.toString())

                    val resultFirst = Calculator()
                    val res1 = resultFirst.calculateFirst(a, b, c, d).toDouble()

                    textView7?.append("%.2f".format(res1))
                    textView7?.append("\n")

                } catch (e: IOException) {
                    e.printStackTrace()
                }


            } catch (e: Exception) {
                textView7?.append("Неможливо! \n")
            }
        }


        //Завдання 2

        val userInputR: EditText = findViewById(R.id.editText5)
        val userInputX: EditText = findViewById(R.id.editText6)

        val buttonResult2: Button = findViewById(R.id.buttonResult2)
        textView11 = findViewById(R.id.textView11)
        textView11?.text = ""
        textView11?.movementMethod = ScrollingMovementMethod()

        buttonResult2.setOnClickListener {

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

        buttonFromFile2.setOnClickListener {

            try {
                textView11?.text = " "


                try {
                    val sdPath = File("$pathFile/$nameOfFile")
                    if (!sdPath.exists()){
                        createFile()
                    }

                    val strSdPath: String = File(sdPath.absolutePath.toString()).toString()
                    val file = File(strSdPath)

                    val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }


                    val array: List<String> = inputAsString.split(",")


                    val r = array[4].toDouble()
                    val x = array[5].toDouble()

                    userInputX.setText(x.toString())
                    userInputR.setText(r.toString())


                    val resultFirst = Calculator()
                    val res2 = resultFirst.calculateSecond(x, r).toDouble()

                    textView11?.append("%.2f".format(res2))
                    textView11?.append("\n")

                } catch (e: IOException) {
                    e.printStackTrace()
                }


            } catch (e: Exception) {
                textView11?.append("Неможливо! \n")
            }
        }

        //Завдання 3

        val userInputN: EditText = findViewById(R.id.editText9)
        val userInputP: EditText = findViewById(R.id.editText10)

        val buttonResult3: Button = findViewById(R.id.buttonResult3)
        textView12 = findViewById(R.id.textView12)
        textView12?.text = ""
        textView12?.movementMethod = ScrollingMovementMethod()

        buttonResult3.setOnClickListener {

            try {

                textView12?.text = " "

                val n = userInputN.text.toString().toDouble()
                val p = userInputP.text.toString().toDouble()

                val resultThird = Calculator()
                val res3 = resultThird.calculateThird(n, p)

                textView12?.append("%.2f".format(res3))
                textView12?.append("\n")


            } catch (e: Exception) {
                textView12?.append("Неможливо! \n")
            }
        }

        buttonFromFile3.setOnClickListener {

            try {
                textView12?.text = " "

                try {
                    val sdPath = File("$pathFile/$nameOfFile")
                    if (!sdPath.exists()){
                        createFile()
                    }

                    val strSdPath: String = File(sdPath.absolutePath.toString()).toString()
                    val file = File(strSdPath)

                    val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }


                    val array: List<String> = inputAsString.split(",")


                    val n = array[6]
                    val p = array[7]

                    userInputN.setText(n)
                    userInputP.setText(p)

                    val resultThird = Calculator()
                    val res3 = resultThird.calculateThird(n.toDouble(), p.toDouble())

                    textView12?.append(res3.toString())

                } catch (e: IOException) {
                    e.printStackTrace()
                }

            } catch (e: Exception) {
                textView12?.append("Неможливо! \n")
            }
        }
    }

    fun createFile(){
        if (!File("$pathFile/$nameOfFile").exists()){
            val inFile = File("$pathFile/$nameOfFile")
            PrintWriter(inFile).use { out -> out.println(baseContextOfFile) }
            Toast.makeText(
                this,
                "File was created!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


}
