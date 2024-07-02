package com.example.ordertaker_aethan

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val checkBox1kanin = findViewById<CheckBox>(R.id.checkBox1kanin)
        val checkBox2kanin = findViewById<CheckBox>(R.id.checkBox2kanin)
        val radioGroupUlam = findViewById<RadioGroup>(R.id.radioGroupUlam)
        val spinnerDesserts = findViewById<Spinner>(R.id.spinnerDesserts)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString()
            val orders = mutableListOf<String>()

            if (checkBox1kanin.isChecked) orders.add("1 kanin")
            if (checkBox2kanin.isChecked) orders.add("2 kanin")

            val selectedUlamId = radioGroupUlam.checkedRadioButtonId
            if (selectedUlamId != -1) {
                val selectedUlam = findViewById<RadioButton>(selectedUlamId).text.toString()
                orders.add(selectedUlam)
            }

            val selectedDessert = spinnerDesserts.selectedItem.toString()
            orders.add(selectedDessert)

            val result = "Name: $name\nOrder: ${orders.joinToString(", ")}"
            textViewResult.text = result
        }
    }
}

