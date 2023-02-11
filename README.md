# Budget Application By Osmar Jz

## App Description [In progress]

The goal for the first MVP of this app has intend to be a basic personal finance app in which any person (primary young people) can track all their expenses and their incomes to understand how they manage their money focusing in the basics concepts of the personal finance.

The first version of this logo is simple, in order that any people feel related to the concept of save money, once they understand what are their expenses and incomes, and how can be related to see how much money they saved or not.

This Logo was took it from this web and you can se the credits of this here [Iconos8.es](https://iconos8.es/illustrations/illustration/flame-hands-drawing-a-dollar-sign-on-the-piggy-bank-and-putting-coins-in-it)

I decide make this application supporting only portrait oriented (at least for this first version) and developed for Android OS because many people have a device with this OS and any can related. I focus more in latest versions of Android OS primary because this app has some UI built with Jetpack Compose, so to ensure the best experience I strong suggest install this app in devices with Android 9.0 or later versions.

## Dependencies

At this moment the project is built using Android Views and Jetpack Compose, and Room for the local storage. So besides of the basic dependencies this are also important:

```sh
--------- Jetpack compose
implementation 'androidx.compose.material:material:1.1.1'
// Integration with activities
implementation 'androidx.activity:activity-compose:1.5.1'
--------- Android Studio Preview support
implementation "androidx.compose.ui:ui:$compose_ui_version"
debugImplementation "androidx.customview:customview:1.2.0-alpha01"
debugImplementation "androidx.customview:customview-poolingcontainer:1.0.0-alpha01"
debugImplementation "androidx.compose.ui:ui-tooling:$compose_ui_version"
--------- Room components
implementation 'androidx.room:room-ktx:2.4.3'
kapt 'androidx.room:room-compiler:2.4.3'
--------- Lifecycle components
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
implementation "androidx.lifecycle:lifecycle-common-java8:2.5.1"

```

You can see the full list in the build.gradle file.
