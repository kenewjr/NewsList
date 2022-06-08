package and5.abrar.newslist

import and5.abrar.newslist.adapter.NewsAdapter
import and5.abrar.newslist.viewmodel.ViewModelNews
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var  adapterNews: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyler()
        getDataNews()
    }
    private fun recyler(){
        rvNews.layoutManager = LinearLayoutManager(this)
        adapterNews = NewsAdapter()
        rvNews.adapter = adapterNews

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getDataNews(){
        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)
        viewModel.getLiveNewsObserver().observe(this) {
            if (it != null) {
                adapterNews.setDataNews(it)
                adapterNews.notifyDataSetChanged()
            }
        }
        viewModel.panggilApiNews()
    }
}