package cat.xojan.random2

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class CountryAdapter(val items: List<Country>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.item_country, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = view.findViewById(R.id.country_title) as TextView
        private val flag: ImageView = view.findViewById(R.id.country_flag) as ImageView

        fun bind(item: Country) {
            itemView?.setOnClickListener {
                val intent = Intent(itemView.context, PlayerActivity::class.java)
                intent.putExtra("extra_country", item)
                itemView.context.startActivity(intent)
            }
            title.text = item.title

            val url: String = "https://www.countries-ofthe-world.com/flags-normal/flag-of-" +
                    item.title.replace(" ", "-") + ".png"
            Picasso.with(itemView.context)
                    .load(url)
                    .into(flag)
        }
    }
}