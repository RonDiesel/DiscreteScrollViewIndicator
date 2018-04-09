# DiscreteScrollViewIndicator


## Gradle
Add it in your root build.gradle at the end of repositories:

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Add the dependency:
```
dependencies {
        compile 'com.github.ron-diesel:discrete-scrollview-indicator:0.5.2'
}
```





#### Usage:

```xml
<app.diesel.discrete_scrollview_indicator.DiscreteScrollViewIndicator
        android:id="@+id/indicator"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:indicator_size="5dp"
        app:indicator_drawable="@drawable/indicator_default"
        app:indicator_margin="4dp"
        android:gravity="center"
        android:orientation="horizontal" />
```

```kotlin
val adapter = CardAdapter(this)
       discreteScrollView.adapter = adapter
       discreteScrollViewIndicator.setDiscreteScrolView(discreteScrollView)

```
## License
```
Copyright 2018 Rinat Galiev

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
