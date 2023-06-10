package org.d3if3120.assesment2.ui.penemuSuhu

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3120.assesment2.model.PenemuSuhu
import org.d3if3120.assesment2.network.ApiStatus
import org.d3if3120.assesment2.network.ServiceAPI
import org.d3if3120.assesment2.network.UpdateWorker
import java.util.concurrent.TimeUnit

class PenemuSuhuViewModel : ViewModel() {
    private val data = MutableLiveData<List<PenemuSuhu>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(ServiceAPI.sukuService.getSuku())
                status.postValue(ApiStatus.SUCCES)
            } catch (e: Exception) {
                Log.d("SuhuViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<PenemuSuhu>> = data

    fun scheduleUpdater(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(app).enqueueUniqueWork(
            UpdateWorker.WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }

    fun getStatus(): LiveData<ApiStatus> = status
}