# Country Picker Android

Country Code Picker for Android in Kotlin language. It will show a [bootomSheet](https://material.io/guidelines/components/bottom-sheets.html)
dialog with list of countries with their names and flags, once you selected the country the 
[callback](https://github.com/debutdeveloper/countrypickerandroid/blob/master/countrycodepicker/src/main/java/com/debut/countrycodepicker/listeners/CountryCallBack.kt)
will provide you the [country](https://github.com/debutdeveloper/countrypickerandroid/blob/master/countrycodepicker/src/main/java/com/debut/countrycodepicker/data/Country.kt) object, which includes the Country name, phoneCode,  flagBitmap

# Getting Started

Add a gradle dependency

      # Root Level Gradle Dependency
      allprojects {
        repositories { 
            jcenter()
            maven { url "https://jitpack.io" }
        }
      }
      
      # Module Level Gradle Dependency
      dependencies {
           compile "com.github.debutdeveloper:countrypickerandroid:dcbbda7fda"
           compile "com.android.support:design:26.1.0"
      }
      
   
    
    

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

<a href="https://imgflip.com/gif/22fadq"><img src="https://i.imgflip.com/22fadq.gif" title="made at imgflip.com"/></a>

