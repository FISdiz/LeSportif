package cl.maps.google.model.remote

import cl.maps.google.model.remote.QuoteXX
import retrofit2.Call
import retrofit2.http.GET

interface QuoteAPI {
      @GET("all.json")
      fun listQuote(): Call<List<QuoteXX>>
}