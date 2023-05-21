package org.d3if3120.assesment2.db


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "suhu")
data class SuhuEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var suhuCelcius: Float,
    var hasilConvertCelcius: String
)