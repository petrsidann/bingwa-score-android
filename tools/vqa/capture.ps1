param([string]$Flow="tools/vqa/flow.txt",[string]$Out="tools/vqa/shots",[string]$Pkg="com.bingwascore.app.debug")
New-Item -ItemType Directory -Force -Path $Out | Out-Null
adb install -r app\build\outputs\apk\debug\app-debug.apk
adb shell am force-stop $Pkg
adb shell monkey -p $Pkg -c android.intent.category.LAUNCHER 1 | Out-Null
foreach ($line in (Get-Content $Flow)) {
  if ($line -match '^\s*(#|$)') { continue }
  $p = $line -split '\s+'
  switch ($p[0]) {
    "wait" { Start-Sleep -Milliseconds ([int]$p[1]) }
    "tap"  { adb shell input tap $p[1] $p[2]; Start-Sleep -Milliseconds 450 }
    "swipe"{ adb shell input swipe $p[1] $p[2] $p[3] $p[4] $p[5]; Start-Sleep -Milliseconds 250 }
    "shot" { adb shell screencap -p /sdcard/vqa.png; adb pull /sdcard/vqa.png "$Out/$($p[1]).png" | Out-Null }
  }
}
Get-ChildItem $Out | Select-Object -ExpandProperty Name
