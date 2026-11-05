# Bayani Defense Android project

This project packages the supplied Bayani Defense HTML game inside the Android APK.
It loads `app/src/main/assets/index.html` locally using Android WebView; it does not
open the GitHub Pages URL.

## Build without Android Studio

1. Create a new GitHub repository, for example `BayaniDefense-Android`.
2. Upload the contents of this project to the repository root (including `.github`).
3. Open **Actions** and run **Build Bayani Defense APK**.
4. Download the `Bayani-Defense-APK` artifact and extract `app-debug.apk`.

The first build is a debug APK for testing. Debug APKs may trigger Play Protect
warnings because they are test builds signed with a development certificate.
Do not distribute a debug build as a public release.

The game HTML is stored locally in the APK. Google Fonts are still requested
online by the original HTML; if offline, the browser will use the built-in
fallback fonts. The core game itself is packaged locally.
