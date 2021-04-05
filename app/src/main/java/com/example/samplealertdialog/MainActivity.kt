package com.example.samplealertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDialog1: Button = findViewById(R.id.btn_dialog1)
        val btnDialog2: Button = findViewById(R.id.btn_dialog2)
        val btnDialog3: Button = findViewById(R.id.btn_dialog3)

        //
        val addInfoDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you this thing?")
            .setIcon(R.drawable.vector_star)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You like this", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You don't like this", Toast.LENGTH_SHORT).show()
            }

        btnDialog1.setOnClickListener {
            addInfoDialog.show()
        }


        //
        val options = arrayOf("First", "Second", "Third")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose from this options")
            .setSingleChoiceItems(options, 0) { dialogInterface, i ->
                Toast.makeText(this, "You Clicked On ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Ok") { _, _ ->
                Toast.makeText(this, "You Ok With this", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Nope") { _, _ ->
                Toast.makeText(this, "You Not Ok With this", Toast.LENGTH_SHORT).show()
            }

        btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }



        //
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose from this options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if (isChecked)
                {
                    Toast.makeText(this, "You Checked On ${options[i]}", Toast.LENGTH_SHORT).show()
                }

                else
                {
                    Toast.makeText(this, "You Unchecked On ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Ok") { _, _ ->
                Toast.makeText(this, "You Ok With this", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Nope") { _, _ ->
                Toast.makeText(this, "You Not Ok With this", Toast.LENGTH_SHORT).show()
            }.create()

        btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}