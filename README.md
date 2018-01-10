# Country Picker Android

Country Code Picker for Android in Kotlin language It will show a bootomSheet
dialog with list country names and flags, once you selected the country the 
call back will pass you the country object which includes the Country name, Country code, flag bitmap

# Getting Started

Add a gradle dependency

    
    compile 'com.github.debutdeveloper:countrypickerandroid:c2f13328b4'
    

# How To Use in Kotlin


```
       CountryPicker.show(supportFragmentManager, object : CountryCallBack {
                       override fun onCountrySelected(country: Country) {
                           Snackbar.make(fab, "Country : ${country.name} and Country Code : ${country.countryCode}", Snackbar.LENGTH_LONG).show()
                       }
                   })
```

# How to use in Java

First add kotlin support in your project.

[Add Kotlin support in Android Project](https://kotlinlang.org/docs/tutorials/kotlin-android.html)

```
CountryPicker.INSTANCE.show(getActivity().getSupportFragmentManager(), new CountryCallBack() {
                @Override
                public void onCountrySelected(Country country) {
                    String messsage = "Country = " + country.component1() + " code = " + country.component2();
                    Utils.getInstance().showSnackbar(view, messsage);
                }
            });
            
```

