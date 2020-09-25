package cl.maps.google.model.remote

import cl.maps.google.model.Quote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface QuoteAPI {
      @GET("quotes/")
      @Headers(API_KEY2)
      fun listQuote(): Call<Quote>

}