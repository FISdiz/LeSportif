package cl.maps.google.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoQuote {

       //Guarda y recupera informacion desde la entidad
        @Query("SELECT * FROM quote_table")
        fun getAllQuote() : LiveData<List<QuoteEntity>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertQuote(heroList: List<QuoteEntity>)

        @Query("SELECT id, body, author FROM quote_table")
        fun getMinimalQuote() : LiveData<List<QuoteMini>>

        @Query("SELECT * FROM quote_table WHERE id = :id")
        fun getQuote(id: Int) : LiveData<QuoteEntity>

    }