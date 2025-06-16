### Overview
-------------

This repository forms part of the assessment for DVT. The focus of the codebase was simplicity, yet showcasing clean and easy-to-follow code.
Instead of adding layers of abstraction and complexity, I focused on simplifying the codebase wherever possible. This approach reduces overhead for future development and maintenance, leading to more efficient workflows.
The goal was to cut down on unnecessary code and optimize for clarity and maintainability. All the app layouts use JetPack Compose
The project uses GitHub Actions to build a signed AAB file. It uses GitHub secrets for the signing credentials.
	  
## Methodologies
- [x] Clean Architecture, MVVM, Solid 
- [x] Jetpack Compose
- [x] Clear, simple, easy to follow code.
- [x] OpenWeatherMap API to show weather forecasts for 5 days.
- [x] Hide all API keys and signing credentials.
- [x] Github actions to sign and build the app AAB (the deploy step was intentionally left out) 

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
* OpenWeatherMap Api Key (in keys.properties file)
* Android Device - minSdkVersion 29 (Emulators are weird with location requests)

## Additional Comments
* Instead of the background on the whole screen. I ended up putting it per forecast. It made more sense since each day can have different weather. 

## Screenshots

| Forecast     | Location Request | Generic Error |
|--------------|------------------|---------------|
| ![PHOTO-2025-06-15-22-07-46](https://github.com/user-attachments/assets/53ae5269-6d01-490a-bcd9-92db9d1612ed) | ![request_location](https://github.com/user-attachments/assets/fbbff72b-6398-4a97-b620-5a0996c358cc)     |![location_error](https://github.com/user-attachments/assets/9021351b-8236-4d65-94aa-e819188b71e6)  |









