package co.id.zeelandia.ziapps

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.zeelandia.ziapps.adapter.NPDRequestAdapter
import co.id.zeelandia.ziapps.databinding.ActivityMainBinding
import co.id.zeelandia.ziapps.response.NPDRequestResponse
import co.id.zeelandia.ziapps.services.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    companion object {
        private const val TAG = "MainActivity"
        private const val BEARER_TOKEN = "4|Z7iWLFRvifpnkbIUVglbqReCFP0OzRsyNgncRtPJ"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val layoutManager = LinearLayoutManager(this)
        binding.rvReview.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvReview.addItemDecoration(itemDecoration)
        findNPDRequest()
    }

    private fun findNPDRequest() {
        showLoading(true)
        val client = ApiConfig.getApiService().getAllNPDRequest("Bearer " + BEARER_TOKEN)
        client.enqueue(object : Callback<List<NPDRequestResponse>> {
            override fun onResponse(
                call: Call<List<NPDRequestResponse>>,
                response: Response<List<NPDRequestResponse>>
            ) {
                showLoading(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        //setNPDRequestData(responseBody)
                        val adapter = NPDRequestAdapter(responseBody)
                        binding.rvReview.adapter = adapter
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<List<NPDRequestResponse>>, t: Throwable) {
                showLoading(false)
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
    
//    private fun setNPDRequestData(NPDRequest: List<NPDRequest>) {
//        val listRequest = ArrayList<String>()
//        for (Request in NPDRequest) {
//            listRequest.add(
//                """
//                ${Request.reqDate}
//                - ${Request.reqCustName}
//                - ${Request.reqAppStats}
//                """.trimIndent()
//            )
//        }
//        val adapter = NPDRequestAdapter(listRequest)
//        binding.rvReview.adapter = adapter
//    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            /*
            Gunakan method ini ketika search selesai atau OK
             */
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                searchView.clearFocus()
                return true
            }

            /*
            Gunakan method ini untuk merespon tiap perubahan huruf pada searchView
             */
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            else -> return true
        }
    }
}