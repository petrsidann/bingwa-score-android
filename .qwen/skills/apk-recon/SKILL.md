---
name: apk-recon
description: Extract UI mechanics (palette, dimens, motion, hierarchy) from a reference APK into docs/inspo/. Use before any transcription stage. Read-only toward the target app; we reimplement, never copy code or assets.
---
# APK Recon
Inputs: tools/recon/target.apk (pulled from device), device connected via adb.
Workflow:
1. adb shell pm list packages -3 | findstr -i <brand>  -> confirm package; adb shell pm path <pkg>; adb pull <path> tools/recon/target.apk
2. java -jar C:\recon\apktool.jar d tools/recon/target.apk -o tools/recon/res -f
3. C:\recon\jadx\bin\jadx.bat -d tools/recon/src tools/recon/target.apk  (no deobfuscation flags; read-only)
4. Harvest: tools/recon/res/res/values/colors.xml, dimens.xml, styles.xml; res/anim + res/animator (every file); res/drawable shape/gradient xml; AndroidManifest.xml activity list.
5. jadx grep (print hits with file:line): dampingRatio | stiffness | Color(0x | TweenSpec | spring( | HorizontalPager | RenderEffect | Blur | LinearGradient | cornerSize | ripple
6. Device walk: for each screen (owner navigates or adb input taps): adb shell uiautomator dump /sdcard/ui.xml; adb pull; adb shell screencap -p /sdcard/s.png; adb pull -> docs/inspo/shots/<screen>.png + ui-<screen>.xml
7. Synthesize docs/inspo/RECON.md (screen map, mechanics notes) + docs/inspo/tokens.json {palette[], radii[], paddings[], motion[{name,curve,duration}], typography[]} derived ONLY from steps 4-6 values. Cite source file per entry.
8. Commit docs/inspo/** + tools/recon/README.md (commands used). Never commit the APK or decompiled source.
Rules: no code/asset copying into app source; tokens.json is reference for reimplementation only.
