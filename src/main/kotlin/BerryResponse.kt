// represent berry and berry list response from raw json

data class Berry(
    val name: String,
    val url: String,
)

data class BerryListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Berry>
)