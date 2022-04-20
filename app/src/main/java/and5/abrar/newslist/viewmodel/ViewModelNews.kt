package and5.abrar.newslist.viewmodel

import and5.abrar.newslist.api.ApiClient
import and5.abrar.newslist.model.RespondDataNewsItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelNews:ViewModel() {
    lateinit var liveDataNews : MutableLiveData<List<RespondDataNewsItem>>
    init {
        liveDataNews = MutableLiveData()
    }
    fun getLiveNewsObserver() : MutableLiveData<List<RespondDataNewsItem>>{
        return  liveDataNews
    }
    fun panggilApiNews(){
      ApiClient.instance.getAllNews()
          .enqueue(object : Callback<List<RespondDataNewsItem>>{
              override fun onResponse(
                  call: Call<List<RespondDataNewsItem>>,
                  response: Response<List<RespondDataNewsItem>>
              ) {
                  if (response.isSuccessful){
                      liveDataNews.postValue(response.body())
                  }else{
                      liveDataNews.postValue(null)
                  }

              }

              override fun onFailure(call: Call<List<RespondDataNewsItem>>, t: Throwable) {
                  liveDataNews.postValue(null)
              }

          })
    }
}