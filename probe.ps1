 $tests = @(
  @("gemini",     "https://generativelanguage.googleapis.com/v1beta/openai/chat/completions", $env:GEMINI_API_KEY,   "gemini-2.0-flash"),
  @("openrouter", "https://openrouter.ai/api/v1/chat/completions",                           $env:OPENROUTER_API_KEY,"qwen/qwen3-coder:free"),
  @("nvidia",     "https://integrate.api.nvidia.com/v1/chat/completions",                    $env:NVIDIA_API_KEY,    "meta/llama-3.3-70b-instruct"),
  @("cerebras",   "https://api.cerebras.ai/v1/chat/completions",                             $env:CEREBRAS_API_KEY,  "llama-3.3-70b")
)
foreach ($t in $tests) {
  $name, $url, $key, $model = $t
  try {
    $body = @{ model=$model; messages=@(@{ role="user"; content="say OK" }) } | ConvertTo-Json -Depth 5
    $r = Invoke-RestMethod $url -Method Post -Headers @{ Authorization = "Bearer $key" } -ContentType "application/json" -Body $body -TimeoutSec 60
    "$name : ALIVE -> $($r.choices[0].message.content)"
  } catch {
    $code = $_.Exception.Response.StatusCode.value__
    $err = ""; try { $err = (New-Object IO.StreamReader($_.Exception.Response.GetResponseStream())).ReadToEnd() } catch {}
    if ($err.Length -gt 220) { $err = $err.Substring(0,220) }
    "$name : DEAD $code -> $err"
  }
}