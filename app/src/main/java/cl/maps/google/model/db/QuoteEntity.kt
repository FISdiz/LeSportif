package cl.maps.google.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote_table")
data class QuoteEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val body: String
)