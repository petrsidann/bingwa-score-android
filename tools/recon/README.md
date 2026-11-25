# Recon Toolchain

Commands used for APK reconnaissance:

```powershell
# Pull APK from device
adb shell pm path <package>
adb pull <path> tools/recon/target.apk

# Decompile with apktool (resources/manifest)
java -jar C:\recon\apktool.jar d tools/recon/target.apk -o tools/recon/res -f

# Decompile with jadx (Java sources)
C:\recon\jadx\bin\jadx.bat -d tools/recon/src tools/recon/target.apk

# UI automation dump
adb shell uiautomator dump /sdcard/window.xml
adb pull /sdcard/window.xml docs/inspo/shots/

# Screenshot
adb exec-out screencap -p > docs/inspo/shots/screen.png
```

## Notes
- target.apk, src/, res/ are gitignored
- All harvested artifacts go to docs/inspo/
- No decompiled code is copied into app/ source
