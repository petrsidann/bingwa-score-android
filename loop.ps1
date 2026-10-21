# BingwaLoop: build -> agent eyes (PNGs) -> human eyes (appetize tab)
$env:JAVA_HOME='C:\Users\User\.jdks\jdk17.0.20_10'
./gradlew :app:assembleDebug :app:recordPaparazziDebug --no-daemon -q
if ($LASTEXITCODE -ne 0) { "LOOP RED - stop, fix first error"; exit 1 }
New-Item -ItemType Directory -Force docs\gate | Out-Null
# Stage 19.7 — the agent eyes are the recorded goldens, named after the test
# that drew them (the Paparazzi report keeps content-hash names and is noise
# in a gate folder).
Copy-Item app\src\test\snapshots\images\*.png docs\gate\ -Force -ErrorAction SilentlyContinue
"AGENT EYES ready: docs\gate\*.png"
if ($env:APPETIZE_TOKEN) {
  $r = curl.exe -s -u "$($env:APPETIZE_TOKEN):" -F "file=@app\build\outputs\apk\debug\app-debug.apk" -F "platform=android" https://appetize.io/v1/apps
  ($r | ConvertFrom-Json).publicUrl | Set-Clipboard
  "HUMAN EYES: appetize URL copied to clipboard - paste in browser, refresh per loop"
}
