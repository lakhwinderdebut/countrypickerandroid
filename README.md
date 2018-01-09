# Country Picker Android

Country Code Picker for Android in Kotlin language It will show a bootomSheet
dialog with list country names and flags, once you selected the country the 
call back will pass you the country object which includes the Country name, Country code, flag bitmap

# How To Use

```CountryPicker.showCountryPicker(supportFragmentManager,object :CountryCallBack{
      override fun onCountrySelected(country: Country) { 
           Snackbar.make(view, "Country : ${country.name} and Country Code : ${country.countryCode}"
            Snackbar.LENGTH_LONG).show()
          }
        }
      )```
