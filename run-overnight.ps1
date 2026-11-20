$ErrorActionPreference = "Stop"
for ($i = 0; $i -lt 4; $i++) {
  $q = Get-Content docs/overnight/QUEUE.md -Raw
  if ($q -notmatch "S7[1-4].*pending") { "QUEUE EMPTY"; break }
  # each invocation = fresh context window = a new chat, unattended
  qwen --approval-mode auto_edit -p (Get-Content docs/overnight/RESUME.md -Raw)
  if (Select-String -Path docs/overnight/LOG.md -Pattern "BLOCKED|REVERTED" -Quiet) { "PIPELINE STOPPED ON RAIL"; break }
}
Get-Content docs/overnight/REPORT.md
