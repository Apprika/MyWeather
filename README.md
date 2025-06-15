### Overview
-------------

This repository forms part of the assessment for DVT.
The focus of the codebase was simplicity, yet showcasing clean and easy-to-follow code. There was no need to overengineer such a simple app.

1. ### Reducing Boilerplate Code and Complexity

	•	Instead of adding layers of abstraction and complexity, I focused on simplifying the codebase wherever possible. This approach reduces overhead for future development and maintenance, leading to more efficient workflows.
	•	The goal was to cut down on unnecessary code and optimize for clarity and maintainability.

2. ### Using Jetpack Compose

	• All the app layouts use JetPack Compose

3. ### End-to-End SDL Understanding

	•	Throughout this project, I took a holistic approach to development, focusing not only on code but also on the Android app lifecycle, performance optimization, and delivering value to stakeholders.
	•	I aimed to demonstrate my ability to balance developer needs with business goals, ensuring that the project aligns with broader organizational objectives.

4. ### Use of CI/CD
    •	The project uses GitHub Actions to build a signed AAB file. It uses GitHub secrets for the signing credentials.
	  
## What I've done
- [x] Clean Architecture, MVVM, Solid 
- [x] Jetpack Compose
- [x] Clear, simple, easy to follow code.
- [x] OpenWeatherMap API to show weather forecasts for 5 days.
- [x] Hide all API keys and signing credentials.
- [x] Jacoco test coverage (Unfortunately, time was a constraint for unit testing)
- [x] Github actions to sign and build the app (the deploy step was intentionally left out) 

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

* OpenWeatherMap Api Key
* Android Device - minSdkVersion 29 (Emulators are weird with location requests)
* Android Studio

## Additional Comments
