package cl.maps.google.model


import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("last_page")
    val lastPage: Boolean,
    @SerializedName("page")
    val page: Int,
    @SerializedName("quotes")
    val quotes: List<QuoteX>
)