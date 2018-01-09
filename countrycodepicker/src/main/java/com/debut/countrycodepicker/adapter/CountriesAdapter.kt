package com.debut.countrycodepicker.adapter

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.debut.countrycodepicker.R
import com.debut.countrycodepicker.data.Country
import com.debut.countrycodepicker.listeners.CountryCallBack


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
class CountriesAdapter(private val context: Context, val callback: CountryCallBack, val list: ArrayList<Country>) : RecyclerView.Adapter<CountriesAdapter.CountryItemHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CountryItemHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false)
        return CountryItemHolder(view)
    }

    override fun onBindViewHolder(holder: CountryItemHolder?, position: Int) {
        holder?.mCountryName?.text = list[position].name
        holder?.mImgFlag?.setImageBitmap(list[position].flag)
    }


    inner class CountryItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val mCountryName: TextView = itemView.findViewById(R.id.txt_country_name)
        val mImgFlag: ImageView = itemView.findViewById(R.id.img_flag)
        private val mCountryContainer: ConstraintLayout = itemView.findViewById(R.id.country_container)

        init {
            mCountryContainer.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            callback.onCountrySelected(list[adapterPosition])
        }
    }
}