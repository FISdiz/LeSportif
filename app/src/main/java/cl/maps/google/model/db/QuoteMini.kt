package cl.maps.google.model.db

data class QuoteMini (
    val id: Int,
    val author: String,
    val body: String,
    var favorite: Boolean
)