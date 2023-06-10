package org.d3if3120.assesment2.data

import org.d3if3120.assesment2.model.ModelSuhu
import org.d3if3120.assesment2.R

class DataSuhu {
    fun loadDataSuhu():List<ModelSuhu>{
        return listOf<ModelSuhu>(
            ModelSuhu(R.string.penjelasan_suhu1,R.drawable.celcius),
            ModelSuhu(R.string.penjelasan_suhu2,R.drawable.farenheit),
            ModelSuhu(R.string.penjelasan_suhu3,R.drawable.reamur),
            ModelSuhu(R.string.penjelasan_suhu4,R.drawable.kelvin)
        )
    }
}