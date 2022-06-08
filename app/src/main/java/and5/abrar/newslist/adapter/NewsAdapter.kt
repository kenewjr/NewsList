package and5.abrar.newslist.adapter

import and5.abrar.newslist.R
import and5.abrar.newslist.model.RespondDataNewsItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter :RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)

    private var listdatanews : List<RespondDataNewsItem>? = null
    fun setDataNews(news : List<RespondDataNewsItem>){
        this.listdatanews = news
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewitem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news,parent, false)
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listdatanews!![position].image)
            .into(holder.itemView.gambarNews)
        holder.itemView.judulNews.text = listdatanews!![position].title
        holder.itemView.tanggalNews.text = listdatanews!![position].createdAt
        holder.itemView.author.text = listdatanews!![position].author
    }

    override fun getItemCount(): Int {
        return if (listdatanews == null){
            0
        }else{
            listdatanews!!.size
        }
    }
}