package com.example.myapplication








import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat








class MainActivity : AppCompatActivity() {
    private lateinit var tipBar: SeekBar
    private lateinit var tipRate: TextView
    private lateinit var tipPercentage: TextView
    private lateinit var billTotal: TextView
    private lateinit var billEnter: EditText
    private lateinit var grandTotal: TextView
    private var bill = 0.0








    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Set Vars
        tipRate = findViewById(R.id.TipRating)
        tipPercentage = findViewById(R.id.tipCent)
        tipBar = findViewById(R.id.tipBar)
        billEnter = findViewById(R.id.billEnter)
        billTotal = findViewById(R.id.billNum)
        grandTotal = findViewById(R.id.Total)











        billEnter.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                bill = p0.toString().toDouble()
                billTotal.text = bill.toString()
                grandTotal.text = (bill * (100 + tipBar.progress).toInt().toDouble() / 100).toString()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })




        tipBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tipPercentage.text = tipBar.progress.toString()
            }


            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }




            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                rateTip()
            }




        }


        )







    } // On Create


    fun rateTip(){ //Sets the text of the "Tip Rating"
        if (tipBar.progress >= 30){
            tipRate.text = "EXCELLENT"
            tipRate.setTextColor(resources.getColor(c))
        } else if (tipBar.progress >= 20){
            tipRate.text = "Good"
        } else if (tipBar.progress >= 10){
            tipRate.text = "Bad"
        }else {
            tipRate.text = "Poor"
        }


    }
}
