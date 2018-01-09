package com.debut.countrycodepickersample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.debut.countrycodepicker.CountryPicker
import com.debut.countrycodepicker.data.Country
import com.debut.countrycodepicker.listeners.CountryCallBack
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            CountryPicker.show(supportFragmentManager, object : CountryCallBack {
                override fun onCountrySelected(country: Country) {
                    Snackbar.make(fab, "Country : ${country.name} and Country Code : ${country.countryCode}", Snackbar.LENGTH_LONG).show()
                }
            })
        }
    }


}
