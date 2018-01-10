package com.debut.countrycodepicker.fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.debut.countrycodepicker.R
import com.debut.countrycodepicker.adapter.CountriesAdapter
import com.debut.countrycodepicker.data.Country
import com.debut.countrycodepicker.listeners.CountryCallBack
import java.util.*
import kotlin.collections.ArrayList

/* Author: Lakhwinder Singh
 * Email: lakhwinder.singh@debutinfotech.com
 *
 *  Copyright (c) 2017 Lakhwinder Singh
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
class CountryPickerDialog : BottomSheetDialogFragment(), CountryCallBack {
    private lateinit var callBack: CountryCallBack

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(context, R.layout.dialog_country_picker, container)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val array = resources.getStringArray(R.array.CountryCodes)
        val adapter = CountriesAdapter(context, this, populateList(array))
        val layoutManager = LinearLayoutManager(context)
        val recycler_countries = view?.findViewById<RecyclerView>(R.id.recycler_countries)
        recycler_countries?.layoutManager = layoutManager
        recycler_countries?.adapter = adapter
    }


    override fun onCountrySelected(country: Country) {
        callBack.onCountrySelected(country)
        dismiss()
    }

    /**
     * Create arraylist for the adapter
     */
    private fun populateList(countries: Array<String>): ArrayList<Country> {
        val list = ArrayList<Country>()
        for (value in countries) {
            val codeNameArray = value.split(",")
            val stringBuilder = StringBuilder()
            stringBuilder.append(getCountryZipCode(codeNameArray[1].trim()))
            val code = codeNameArray[0].trim()
            val imageName = codeNameArray[1].trim()
            val imageBuilder = StringBuilder()
            imageBuilder.append("flags/flag_").append(imageName.toLowerCase()).append(".png")
            val inputStream = context.assets.open(imageBuilder.toString())
            val bitmap = BitmapFactory.decodeStream(inputStream)
            val country = Country(stringBuilder.toString(), code, bitmap)
            list.add(country)
        }
        return list
    }

    /**
     * Get Country name by passing iso of the country
     */
    private fun getCountryZipCode(ssid: String): String {
        val loc = Locale("", ssid)
        return loc.displayCountry.trim { it <= ' ' }
    }

    /**
     * set listener for getting callback results
     */
    fun setListener(callBack: CountryCallBack) {
        this.callBack = callBack
    }
}