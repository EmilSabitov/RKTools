# RKTools

![Imgur](https://i.imgur.com/0uROqrG.png)

[![](https://jitpack.io/v/JasonPoster/RKTools.svg)](https://jitpack.io/#JasonPoster/RKTools)
[![API](https://img.shields.io/badge/API-23%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=23)


------------


### Features

Few useful features for Android (MD5, bitmapDrawable converter, levenshtein distance, e.t.c)

### Installation 
Gradle

  ```cpp
  allprojects {
        repositories {
            maven {url "https://jitpack.io"}
        }
    }
```
```cpp
    implementation 'com.github.JasonPoster:RKTools:0.8.3'

```

### Some code samples
// Converting bitmap to byte[]
```cpp
XRKToolsLib xrkToolsLib = new XRKToolsLib();
rkToolsLib.getBytesFromBitmap(bitmap, key)
```


// Converting Drawable to Bitmap
```cpp
XRKToolsLib xrkToolsLib = new XRKToolsLib(); 
xrkToolsLib.drawableToBitmap(context,key,drawable)
```
// Current Date in human readable format
```cpp
xrkToolsLib.getCurrentDate(key)
``` 
