package cl.maps.google.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.maps.google.model.db.QuoteEntity
import cl.maps.google.model.db.Repository

class QuoteViewModel(application: Application): AndroidViewModel(application) {
    private var repository: Repository = Repository(application)
    var listQuote = repository.listQuote

    init {
        repository.loadApiData()

    }

    fun getDetails(param1: String): LiveData<QuoteEntity> {
        return repository.getDetails(param1)
    }
}