package aksamedia.com.tugasaksa4_saiful

import aksamedia.com.tugasaksa4_saiful.adapter.PlayerAdapter
import aksamedia.com.tugasaksa4_saiful.api.ApiRepository
import aksamedia.com.tugasaksa4_saiful.contract.DetailView
import aksamedia.com.tugasaksa4_saiful.model.Player.Player
import aksamedia.com.tugasaksa4_saiful.model.TeamDetail.TeamDetail
import aksamedia.com.tugasaksa4_saiful.presenter.DetailPresenter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_team_detail.*

class TeamDetailActivity : AppCompatActivity(), DetailView {

    private lateinit var presenter: DetailPresenter
    private lateinit var adapter: PlayerAdapter
    private var dataPlayer:MutableList<Player> = mutableListOf()
    private lateinit var id:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        val intent = intent
        id = intent.getStringExtra("id")

        setupRecyclerview()
        setupPresenter()
        presenter.getDetailTeam(id)
        presenter.getPlayer(id)
    }

    fun setupRecyclerview(){
        adapter = PlayerAdapter(this, dataPlayer)
        recyclePlayer.layoutManager = GridLayoutManager(this,3)
        recyclePlayer.adapter = adapter
    }

    fun setupPresenter(){
        val request = ApiRepository()
        val gson = Gson()
        presenter = DetailPresenter(this, request, gson)
    }

    override fun showLoading() {
        progressBar.visibility= View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility= View.INVISIBLE
    }

    override fun showDetailTeam(data: List<TeamDetail>) {
        supportActionBar?.title = data[0].teamName.toString()
        Glide.with(this).load(data[0].teamBadge.toString()).into(teamBadge);
        teamName.text = data[0].teamName.toString()
        teamDesc.text = data[0].teamDesc.toString()
    }

    override fun showPlayer(data: List<Player>) {
        dataPlayer.clear()
        dataPlayer.addAll(data)
        adapter.notifyDataSetChanged()
    }

}
