package and5.abrar.newslist.api

import and5.abrar.newslist.model.RespondDataNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("news")
    fun getAllNews(): Call<List<RespondDataNewsItem>>
}