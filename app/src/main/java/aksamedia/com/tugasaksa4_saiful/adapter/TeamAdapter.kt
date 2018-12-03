package aksamedia.com.tugasaksa4_saiful.adapter

import aksamedia.com.tugasaksa4_saiful.R
import aksamedia.com.tugasaksa4_saiful.model.Team
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.team_item.view.*

class TeamAdapter(private val context: Context, private val items: List<Team>)
    : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.team_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bindItem(items: Team) {
            itemView.clubName.text = items.teamName
            items.teamBadge.let {
                Glide.with(itemView).load(it).into(itemView.imageFlag)
            }
        }
    }
}