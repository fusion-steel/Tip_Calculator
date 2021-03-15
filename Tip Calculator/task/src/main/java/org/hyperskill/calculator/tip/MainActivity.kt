package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etBase: EditText = findViewById(R.id.edit_text)
        val sliderTip: Slider = findViewById(R.id.slider)

        etBase.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                computeTipAndTotal()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        sliderTip.addOnChangeListener(Slider.OnChangeListener {
            _, _, _ ->
            computeTipAndTotal() })
    }

    private fun computeTipAndTotal() {
        if (edit_text.text.isEmpty()) {
            text_view.text = ""
            return
        }
        val baseAmount = edit_text.text.toString().toDouble()
        val sliderTipValue = slider.value.toDouble()
        val tipAmount = baseAmount * sliderTipValue / 100.0
//        if (sliderTipValue == 0.00) {
//            text_view.text = "Tip amount: ${"%.2f".format(sliderTipValue)}"
//            return
//        }
//        text_view.text = "${"%.2f".format(sliderTipValue)}% tip: ${"%.2f".format(tipAmount)}"
        text_view.text = "Tip amount: ${"%.2f".format(tipAmount)}"
    }
}
