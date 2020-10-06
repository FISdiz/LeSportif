package cl.maps.google.model


import com.google.gson.annotations.SerializedName

data class QuoteX(
    @SerializedName("author")
    val author: String,
    @SerializedName("author_permalink")
    val authorPermalink: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("dialogue")
    val dialogue: Boolean,
    @SerializedName("downvotes_count")
    val downvotesCount: Int,
    @SerializedName("favorites_count")
    val favoritesCount: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("private")
    val `private`: Boolean,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("upvotes_count")
    val upvotesCount: Int,
    @SerializedName("url")
    val url: String,
    var favorite: Boolean
)