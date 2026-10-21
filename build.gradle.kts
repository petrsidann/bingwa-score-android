plugins {
    id("com.android.application") version "8.5.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.20" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.20" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("com.google.devtools.ksp") version "2.0.20-1.0.24" apply false
    // Stage 19.7: eyes. NOTE: the decision tree named 0.15.1/0.15.0 but those
    // versions do not exist upstream; latest stable resolvable here is 1.3.5.
    id("app.cash.paparazzi") version "1.3.5" apply false
}
