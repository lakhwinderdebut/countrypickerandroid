package com.debut.countrycodepicker

import android.support.v4.app.FragmentManager
import com.debut.countrycodepicker.fragment.CountryPickerDialog
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
object CountryPicker {
    fun showCountryPicker(manager: FragmentManager?, callBack: CountryCallBack?) {
        if (manager == null || callBack == null) {
            // if callback lsitener or support fragmanet is null then no dialog shown
            throw IllegalArgumentException("No argument can be null")
        } else {
            val countryPicker = CountryPickerDialog()
            countryPicker.show(manager, countryPicker::class.java.simpleName)
            countryPicker.setListener(callBack)
        }
    }
}