package com.example.calculatorskin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var operate: Int = 0;
    var hold: Double = 0.0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberPress(view: View){
        val displayView = findViewById<TextView>(R.id.display);
        if(view is Button){
            if(view.text.toString() != "." || (!displayView.text.toString().contains(".") && displayView.text.toString() != "")){
                displayView.text = displayView.text.toString() + view.text.toString();
            }
        }
    }

    fun operatorPress(view: View){
        val displayView = findViewById<TextView>(R.id.display);
        if(view is Button){
            if(view.text.toString() == "del"){
                displayView.text = displayView.text.toString().dropLast(1);
            }else if(view.text.toString() == "c"){
                displayView.text = "";
                operate = 0;
            }else if(view.text.toString() == "/" && operate == 0){
                hold = displayView.text.toString().toDouble();
                displayView.text = "";
                operate = 1;
            }else if(view.text.toString() == "*" && operate == 0){
                hold = displayView.text.toString().toDouble();
                displayView.text = "";
                operate = 2;
            }else if(view.text.toString() == "+" && operate == 0){
                hold = displayView.text.toString().toDouble();
                displayView.text = "";
                operate = 3;
            }else if(view.text.toString() == "-" && operate == 0){
                hold = displayView.text.toString().toDouble();
                displayView.text = "";
                operate = 4;
            }else if(view.text.toString() == "=" && operate > 0 && displayView.text.toString() != ""){
                if(operate == 1){
                    displayView.text = (hold / displayView.text.toString().toDouble()).toString();
                }else if(operate == 2){
                    displayView.text = (hold * displayView.text.toString().toDouble()).toString();
                }else if(operate == 3){
                    displayView.text = (hold + displayView.text.toString().toDouble()).toString();
                }else if(operate == 4){
                    displayView.text = (hold - displayView.text.toString().toDouble()).toString();
                }
                operate = 0;
            }
        }
    }
}