package cl.maps.google.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://favqs.com/api/"

class RetrofitClient {
    companion object{
        fun retrofitInstance(): QuoteAPI {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return  retrofit.create(QuoteAPI::class.java)
        }
    }
}