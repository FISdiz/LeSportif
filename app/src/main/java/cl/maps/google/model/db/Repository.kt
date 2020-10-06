package cl.maps.google.model.db

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import cl.maps.google.model.Quote
import cl.maps.google.model.QuoteX
import cl.maps.google.model.remote.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(context: Context) {

    var quoteDatabase = QuoteDatabase.getDatabase(context)
    var listQuote = quoteDatabase.getQuoteDao().getMinimalQuote()

    fun loadApiData() {
        val call = RetrofitClient.retrofitInstance().listQuote()

        call.enqueue(object : Callback<Quote> {
            override fun onResponse(call: Call<Quote>, response: Response<Quote>) {
                Log.d("Adapter", "${response.code()}")
                Log.d("Adapter", "${response.body()}")
                saveDatabase(quoteConverter(response.body()!!.quotes))
            }

            override fun onFailure(call: Call<Quote>, t: Throwable) {
                Log.d("Adapter", "Error al cargar frases $t")
            }
        })
    }

    fun quoteConverter(listQuote: List<QuoteX>): List<QuoteEntity> {
        return listQuote.map { quote -> QuoteEntity(quote.id, quote.author, quote.body, quote.favorite) }
    }

    fun saveDatabase(listQuoteEntity: List<QuoteEntity>) {
        CoroutineScope(Dispatchers.IO).launch {
            quoteDatabase.getQuoteDao().insertQuote(listQuoteEntity)
        }
    }

    fun getDetails(param1: String): LiveData<QuoteEntity> {
        return quoteDatabase.getQuoteDao().getQuote(param1.toInt())
    }
}
