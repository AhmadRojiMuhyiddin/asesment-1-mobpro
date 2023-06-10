package org.d3if3120.assesment2.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3120.assesment2.model.PenemuSuhu
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface SuhuApi {
    @GET("penemu.JSON")
    suspend fun getSuku(): List<PenemuSuhu>
}


object ServiceAPI {
    private const val BASE_URL_SUHU = "https://raw.githubusercontent.com/" +
            "AhmadRojiMuhyiddin/asesment-1-mobpro/PenemuSuhu_API/"
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofitSuhu = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL_SUHU)
        .build()

    //Retrofit Create


    val sukuService: SuhuApi by lazy {
        retrofitSuhu.create(SuhuApi::class.java)
    }

    //Function


    fun getSuhuUrl(imageId: String): String {
        return "$BASE_URL_SUHU$imageId.jpg"
    }
}


enum class ApiStatus { LOADING, SUCCES,FAILED}
