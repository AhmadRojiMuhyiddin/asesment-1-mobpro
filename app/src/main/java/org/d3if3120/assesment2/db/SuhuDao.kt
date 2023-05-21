package org.d3if3120.assesment2.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SuhuDao {
    //
    @Insert
    fun insert(suhuDao: SuhuEntity)

    @Query("SELECT * FROM suhu ORDER BY id ASC")
    fun getKonversiSuhu(): LiveData<List<SuhuEntity?>>

    @Query("DELETE FROM suhu")
    fun clearData()

    @Update
    fun updateData(suhu: SuhuEntity)

}