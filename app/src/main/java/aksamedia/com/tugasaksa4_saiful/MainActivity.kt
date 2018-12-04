package aksamedia.com.tugasaksa4_saiful

import aksamedia.com.tugasaksa4_saiful.adapter.TeamAdapter
import aksamedia.com.tugasaksa4_saiful.api.ApiRepository
import aksamedia.com.tugasaksa4_saiful.contract.MainView
import aksamedia.com.tugasaksa4_saiful.model.League
import aksamedia.com.tugasaksa4_saiful.model.Team
import aksamedia.com.tugasaksa4_saiful.presenter.MainPresenter
import android.app.SearchManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import com.google.gson.Gson
import com.mancj.materialsearchbar.MaterialSearchBar
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh
import android.support.v4.view.MenuItemCompat.getActionView
import android.support.v7.widget.SearchView
import android.view.MenuItem


class MainActivity : AppCompatActivity(),AnkoLogger, MainView {

    private lateinit var presenter: MainPresenter
    private lateinit var adapter: TeamAdapter
    private lateinit var spinnerAdapter:ArrayAdapter<String>
    private var data_tim: MutableList<Team> = mutableListOf()
    private var data_liga:MutableList<String> = mutableListOf()
    private lateinit var namaLiga :String

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupSpiner()
        setupRecyclerview()
        setupPresenter()

        presenter.getListLiga()

        listLiga.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                namaLiga = listLiga.selectedItem.toString()
                namaLiga = namaLiga.replace(" ","_",true)
                presenter.getTeamList(namaLiga)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        swipeRefresh.onRefresh {
            presenter.getListLiga()
            presenter.getTeamList(namaLiga)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchItem : MenuItem = menu.findItem(R.id.action_search)
        val searchView : SearchView = searchItem.actionView as SearchView

        searchView.queryHint = "Search teams ..."

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                adapter.getFilter().filter(newText)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    fun setupSpiner() {
        spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, data_liga)
        listLiga.adapter = spinnerAdapter
    }

    fun setupRecyclerview(){
        adapter = TeamAdapter(this, data_tim){
            startActivity<TeamDetailActivity>("id" to "${it.teamId}")
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    fun setupPresenter(){
        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this, request, gson)
    }

    override fun showLoading() {
        loadingBar.visibility= View.VISIBLE
    }

    override fun hideLoading() {
        loadingBar.visibility= View.INVISIBLE
    }

    override fun showTeamList(data: List<Team>) {
        swipeRefresh.isRefreshing = false
        data_tim.clear()
        data_tim.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun showListLiga(data: List<League>) {
        swipeRefresh.isRefreshing = false
        data_liga.clear()
        for (i in 0 until data.size){
            data_liga.add(data[i].strLeague.toString())
        }
        spinnerAdapter.notifyDataSetChanged()
    }
}
