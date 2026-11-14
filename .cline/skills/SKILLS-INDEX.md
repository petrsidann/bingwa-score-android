# Bingwa Score — Skills Index

LAW: future sessions load ONLY the named skill file, never the whole vendor tree.
Load path: `.cline/skills/<workspace-skill>/SKILL.md` or `.cline/skills/vendor/<repo>/<skill>/SKILL.md`.
This index is curated for a Kotlin + Jetpack Compose Android app. Irrelevant
web/sales/SEO catalog entries were removed in Stage 60 to keep agents focused.

## Workspace skills
- design-pass -> enforces the Bingwa design constitution (tokens only via DesignTokens, two themes, frosted glass via GlassSpec, FORBIDDEN list, true-circle rule) | activate before any UI change or cross-theme audit
- crash-triage -> reproduces crashes/ANRs, captures logcat, traces root cause without regressing U1 USSD or E1 balance/dial; PENDING stays "Queued" | activate on any crash/ANR/uncaught exception
- release-walk -> release checklist (debug+release build, smoke both themes, owner smokes PR artifact, targeted tests, push, confirm hash on origin/main) | activate before a release PR or once a stage is green

## Vendor skills — obra/superpowers (engineering discipline)
- superpowers/systematic-debugging | activate on hard bugs
- superpowers/test-driven-development | activate when adding logic
- superpowers/verification-before-completion | activate before claiming DONE
- superpowers/writing-plans | activate when planning a stage
- superpowers/executing-plans | activate when executing a multi-step plan
- superpowers/finishing-a-development-branch | activate when finishing a stage branch
- superpowers/receiving-code-review | activate when applying review feedback

## Vendor skills — design taste
- taste-skill/taste-skill -> design taste review | activate on UI polish passes
- ai-design-skills/figma-designer -> Figma design workflow | activate when working from a Figma reference

## Vendor skills — tech-leads-club/agent-skills (curated subset)
- agent-skills/coding-guidelines | activate on demand
- agent-skills/docs-writer | activate on docs stages
- agent-skills/gh-fix-ci | activate when CI is red
- agent-skills/gh-address-comments | activate when addressing PR comments
- agent-skills/create-adr | activate when recording an architecture decision

## MCP curation
- context7: confirmed running in Cline MCP settings (library docs lookup). No change.
- Recommended next: github MCP (PR/issue automation) to speed the push->PR->merge loop. Record only; add in a dedicated stage.
- No new MCP servers added in Stage 60.
