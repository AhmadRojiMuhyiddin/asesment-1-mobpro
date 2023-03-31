package org.deif3120.convertdollartorupiah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.deif3120.convertdollartorupiah.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConvert.setOnClickListener {
            val dollar = binding.dollarInp.text.toString().trim()
            var rp = 0

            when{
                TextUtils.isEmpty(dollar) -> {
                    Toast.makeText(this,"masukan jumlah dollar!", Toast.LENGTH_SHORT).show()
                    binding.dollarInp.requestFocus()
                }
                else -> {
                    rp = dollar.toInt() * 15041
                    val df = DecimalFormat("#,##0.00")
                    binding.tvRupiah.text=df.format(rp)

                }
            }
        }
    }
}