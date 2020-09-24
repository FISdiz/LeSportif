package cl.maps.google.model.remote

import cl.maps.google.model.Quote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface QuoteAPI {
      @GET("quotes/")
      @Headers("Authorization: Token token=\"7fdf59b437d9144877d04cf063176830\"")
      fun listQuote(): Call<Quote>

}