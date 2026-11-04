if (Test-Path 'C:\Users\User\.jdks\jdk17.0.20_10') { $env:JAVA_HOME = 'C:\Users\User\.jdks\jdk17.0.20_10' }
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
Set-Location $PSScriptRoot
.\gradlew :app:compileDebugKotlin :app:testDebugUnitTest :app:assembleDebug --no-daemon -q 2>&1 | Out-File -FilePath compile_errors.txt -Encoding utf8
Write-Host "BUILD DONE - read compile_errors.txt"