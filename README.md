# Card Info Application
 This is an application used to get the card details of a user.
 
## Features
* Manual digit input
* Retrieve card information
* Scan bank card

## Details
* A single Activity application, conforming to the MVVM application architecture and solid principle.
* Consists of four Fragments managed by the navigation graph.
* Calls to the web are made using a Retrofit service , the API used is binlist API.
* DI used is dagger hilt
* Consists of helper extension

* Card scanning is implemented using the Google Mobile Vision library, scanning is done offline. OCR related code is situated in the OCR package and consists of configuration and data processing logic.
*Todo :Unit test and Tests

  * [Android Jetpack](https://developer.android.com/jetpack/?gclid=Cj0KCQjwhJrqBRDZARIsALhp1WQBmjQ4WUpnRT4ETGGR1T_rQG8VU3Ta_kVwiznZASR5y4fgPDRYFqkaAhtfEALw_wcB) - Official suite of libraries, tools, and guidance to help developers write high-quality apps.
  * [Android KTX](https://developer.android.com/kotlin/ktx)
  * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
  * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
  * [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation)
  * [Retrofit 2](https://github.com/square/retrofit) - A type-safe HTTP client for Android and Java.
  * [Google Text Recognition](https://developers.google.com/vision/android/text-overview) Text Recognition API that recognizes text in any Latin based language.
  * [Binlist base url](https://lookup.binlist.net)
