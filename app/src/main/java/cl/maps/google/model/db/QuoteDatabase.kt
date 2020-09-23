package cl.maps.google.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase(){

    abstract fun getQuoteDao(): DaoQuote

    companion object{
        //singleton prevents multiple instances of database opening at the same time
        @Volatile
        private var INSTANCE: QuoteDatabase?= null

        fun getDatabase(context: Context): QuoteDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, QuoteDatabase::class.java, "quote_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}