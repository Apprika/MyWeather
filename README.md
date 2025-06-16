### Overview
-------------

The focus of the codebase was simplicity, yet showcasing clean and easy-to-follow code. The main goal was to make it easily maintainable and scalable. Anyone should be able to look at the code and figure out exactly what each piece of code does.
	  
## Methodologies

- [x] Jetpack Compose.
- [x] Clear, simple, easy to follow code.
- [x] Clean Architecture, MVVM, S.O.L.I.D principles.
- [x] OpenWeatherMap API to show weather forecasts for 5 days.
- [x] Hide all API keys and signing credentials. <a href="https://github.com/Apprika/MyWeather/blob/master/keys.properties" target="_blank">keys.properties</a> (should not be committed but just for this demo)
- [x] Github Actions to sign and build the app AAB (the deploy step was intentionally left out) <a href="https://github.com/Apprika/MyWeather/blob/master/.github/workflows/main.yml" target="_blank">main.yaml</a>
- [x] Git branching strategy using master and develop branches. With branch protection on the master branch. No direct commits allowed, only P.R.s

## Languages, libraries and tools used

* Kotlin.
* Jetpack Compose.
* Jetpack Libraries.
* Retrofit.
* Hilt.
* Google Play Services.
* Stream Support.
* Gson.
* Accompanist for permissions.
* And More.

## Requirements

* Android Studio
* OpenWeatherMap Api Key
* Android Device - minSdkVersion 27 :warning: **Warning:** Emulators are weird with location requests

## Additional Comments
* > :memo: **Note:** Instead of the background on the whole forecast screen, I ended up putting it per forecast (i.e on each card). Since each day can have different weather. In one week we can have multiple weather phenomena.

## Screenshots 
<img src="https://github.com/user-attachments/assets/53ae5269-6d01-490a-bcd9-92db9d1612ed" width="250" height="500">
<img src="https://github.com/user-attachments/assets/fbbff72b-6398-4a97-b620-5a0996c358cc" width="200" height="500">
<img src="https://github.com/user-attachments/assets/9021351b-8236-4d65-94aa-e819188b71e6" width="200" height="500">







