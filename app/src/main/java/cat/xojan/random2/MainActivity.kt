package cat.xojan.random2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val countryList = findViewById(R.id.countryList) as RecyclerView

        countryList.layoutManager = LinearLayoutManager(this)
        countryList.adapter = CountryAdapter(CountryData().sortedList)
    }
}
