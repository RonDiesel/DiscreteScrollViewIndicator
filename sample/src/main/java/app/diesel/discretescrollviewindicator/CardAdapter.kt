package app.diesel.discretescrollviewindicator;

import android.content.Context
import android.graphics.Bitmap
import android.support.v4.app.FragmentManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import app.diesel.discrete_scrollview_indicator.DiscreteScrollViewIndicator
import com.bumptech.glide.Glide
import com.yarolegovich.discretescrollview.DiscreteScrollView

class CardAdapter(private val  cnt : Context) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {


    var items : List<String>  = listOf("http://s1.1zoom.me/big0/930/Coast_Sunrises_and_sunsets_Waves_USA_Ocean_Kaneohe_521540_1280x775.jpg", "http://bipbap.ru/wp-content/uploads/2017/09/Cool-High-Resolution-Wallpaper-1920x1080.jpg", "http://bm.img.com.ua/nxs/img/prikol/images/large/3/9/315193.jpg", "https://millionstatusov.ru/pic/statpic/all/58e61335ec518.jpg")





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(cnt).inflate(R.layout.item_card, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(cnt).load(items[position]).into(holder.image)
    }




    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.findViewById<ImageView>(R.id.image)
    }
}