package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var addButton: Button
    lateinit var myGoal: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var Goals = arrayListOf<String>(
            "learn Swimming",
            "Go to GYM",
            "Study French",
            "Learn R",
            "Start business",
            "Family time",
            "Read a book everyday"
        )

        val myRv = findViewById<RecyclerView>(R.id.rvMain)
        myRv.adapter = RecyclerViewAdapter(Goals)
        myRv.layoutManager = LinearLayoutManager(this)

        addButton = findViewById(R.id.button)
        myGoal = findViewById(R.id.editText)

        addButton.setOnClickListener {
            var newGoal = myGoal.text.toString()
            var myLayout = findViewById<ConstraintLayout>(R.id.clMain)

            if (newGoal.isEmpty()){
                Snackbar.make(myLayout, "You should enter a Goal", Snackbar.LENGTH_LONG).show()
            }
            else{
                Goals.add(myGoal.text.toString())
                Snackbar.make(myLayout, "your new goal is Added", Snackbar.LENGTH_LONG).show()
                myGoal.setText("")
            }
           }

    }


}