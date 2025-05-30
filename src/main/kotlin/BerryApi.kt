// define func sig for retrofit to create the real implementation in build time

import retrofit2.http.GET
import retrofit2.Call
import UrlConstants

interface BerryApi {
    @GET(UrlConstants.BERRIES_URL)
    fun getBerries (
        optionalParams: Map<String, String>
    ): Call<BerryListResponse>
}