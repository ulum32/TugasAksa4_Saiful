package aksamedia.com.tugasaksa4_saiful

import aksamedia.com.tugasaksa4_saiful.adapter.PlayerAdapter
import aksamedia.com.tugasaksa4_saiful.api.ApiRepository
import aksamedia.com.tugasaksa4_saiful.contract.DetailView
import aksamedia.com.tugasaksa4_saiful.model.Player
import aksamedia.com.tugasaksa4_saiful.model.Team
import aksamedia.com.tugasaksa4_saiful.model.TeamDetail
import aksamedia.com.tugasaksa4_saiful.presenter.DetailPresenter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_team_detail.*

class TeamDetailActivity : AppCompatActivity(), DetailView {

    private lateinit var presenter: DetailPresenter
    private lateinit var adapter: PlayerAdapter
    private lateinit var id:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        val intent = intent
        id = intent.getStringExtra("id")

//        setupRecyclerview()
        setupPresenter()
        presenter.getDetailTeam(id)
    }

    fun setupRecyclerview(){
//        adapter = PlayerAdapter(this, )
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = adapter
    }

    fun setupPresenter(){
        val request = ApiRepository()
        val gson = Gson()
        presenter = DetailPresenter(this, request, gson)
    }

    override fun showLoading() {
        loadingBar.visibility= View.VISIBLE
    }

    override fun hideLoading() {
        loadingBar.visibility= View.INVISIBLE
    }

    override fun showPlayer(data: List<Player>) {
    }

    override fun showDetailTeam(data: List<TeamDetail>) {
        supportActionBar?.title = data[0].teamName.toString()
        Glide.with(this).load(data[0].teamBadge.toString()).into(teamBadge);
        teamName.text = data[0].teamName.toString()
        teamDesc.text = data[0].teamName.toString()
    }
}
