package aksamedia.com.tugasaksa4_saiful.adapter

import aksamedia.com.tugasaksa4_saiful.R
import aksamedia.com.tugasaksa4_saiful.model.Player
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.player_item.view.*
import kotlinx.android.synthetic.main.team_item.view.*

class PlayerAdapter(private val context: Context, private val items: List<Player>)
    : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.player_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bindItem(items: Player) {
            items.playerPhoto?.let{
                Glide.with(itemView).load(it).into(itemView.photoPlayer)
            }
            itemView.namePlayer.text = items.playerName
        }
    }
}