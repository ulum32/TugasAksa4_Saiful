package aksamedia.com.tugasaksa4_saiful.adapter

import aksamedia.com.tugasaksa4_saiful.R
import aksamedia.com.tugasaksa4_saiful.model.Team
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.team_item.view.*

class TeamAdapter(private val context: Context, private var items: List<Team>, private val listener: (Team) -> Unit)
    : RecyclerView.Adapter<TeamAdapter.ViewHolder>(), Filterable {

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    items = dataFiltered
                } else {
                    val filteredList = arrayListOf<Team>()
                    for (row in dataFiltered) {

                        if (row.teamName!!.toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(row)
                        }
                    }

                    items = filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = items
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
                items = filterResults.values as List<Team>
                notifyDataSetChanged()
            }
        }
    }

    val dataFiltered = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.team_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bindItem(items: Team, listener: (Team) -> Unit) {
            itemView.clubName.text = items.teamName
            items.teamBadge.let {
                Glide.with(itemView).load(it).into(itemView.imageFlag)
            }
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}