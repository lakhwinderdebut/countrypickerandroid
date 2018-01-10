# Country Picker Android

Country Code Picker for Android in Kotlin language. It will show a [bootomSheet](https://material.io/guidelines/components/bottom-sheets.html)
dialog with list of countries with their names and flags, once you selected the country the 
[callback](https://github.com/debutdeveloper/countrypickerandroid/blob/master/countrycodepicker/src/main/java/com/debut/countrycodepicker/listeners/CountryCallBack.kt)
will provide you the [country](https://github.com/debutdeveloper/countrypickerandroid/blob/master/countrycodepicker/src/main/java/com/debut/countrycodepicker/data/Country.kt) object, which includes the Country name, phoneCode,  flagBitmap

# Getting Started

Add a gradle dependency

    
    compile 'com.github.debutdeveloper:countrypickerandroid:c2f13328b4'
    

# How To Use in Kotlin


```
CountryPicker.show(supportFragmentManager, object : CountryCallBack {
        override fun onCountrySelected(country: Country) {
             Snackbar.make(fab, "Country : ${country.name} and Country Code : ${country.countryCode}",
             Snackbar.LENGTH_LONG).show()
                 }
              })
```

# How To Use in Java

First add kotlin support in your project.

[Add Kotlin support in Android Project](https://kotlinlang.org/docs/tutorials/kotlin-android.html)

```
CountryPicker.INSTANCE.show(getActivity().getSupportFragmentManager(), new CountryCallBack() {
                @Override
                public void onCountrySelected(Country country) {
                    String messsage = "Country = " + country.component1() + 
                    " code = " + country.component2();
                    Utils.getInstance().showSnackbar(view, messsage);
                }
            });
            
```

[](<iframe src="https://giphy.com/embed/26wkRzrjojvNsOamQ" width="240" height="480" frameBorder="0" class="giphy-embed" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/26wkRzrjojvNsOamQ">via GIPHY</a></p>)

