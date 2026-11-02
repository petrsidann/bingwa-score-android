# Bingwa Score — Skills Index

LAW: future sessions load ONLY the named skill file, never the whole vendor tree.
Load path: `.cline/skills/<workspace-skill>/SKILL.md` or `.cline/skills/vendor/<repo>/<skill>/SKILL.md`.

## Workspace skills
- design-pass -> enforces the Bingwa design constitution (tokens only, two themes, frosted glass via GlassSpec, FORBIDDEN list) on screens/components | activate before any UI change or cross-theme audit
- crash-triage -> reproduces crashes/ANRs, captures logcat, traces root cause without regressing the U1 USSD engine or E1 balance/dial logic; PENDING stays "Queued" | activate on any crash/ANR/uncaught exception
- release-walk -> runs the release checklist (debug build, smoke both themes, merge-gate artifact smoked by owner, unit tests, push, confirm commit on origin/main) | activate before a release PR or once a stage is green

## Vendor skills — obra/superpowers
- superpowers/brainstorming -> idea generation and planning | activate on demand; load only this SKILL.md
- superpowers/diagnosing-superpowers -> diagnose Cline/superpowers issues | activate on demand
- superpowers/dispatching-parallel-agents -> dispatch parallel agent work | activate on demand
- superpowers/executing-plans -> execute multi-step plans | activate on demand
- superpowers/finishing-a-development-branch -> finish a development branch | activate on demand
- superpowers/receiving-code-review -> receive and apply code review | activate on demand
- superpowers/requesting-code-review -> request code review | activate on demand
- superpowers/subagent-driven-development -> subagent-driven development | activate on demand
- superpowers/systematic-debugging -> systematic debugging | activate on demand
- superpowers/test-driven-development -> test-driven development | activate on demand
- superpowers/using-git-worktrees -> git worktrees usage | activate on demand
- superpowers/using-superpowers -> using superpowers | activate on demand
- superpowers/verification-before-completion -> verification before completion | activate on demand
- superpowers/writing-plans -> writing plans | activate on demand
- superpowers/writing-skills -> writing skills | activate on demand

## Vendor skills — elayadesign/ai-design-skills
- ai-design-skills/figma-designer -> Figma design workflow | activate on demand
- ai-design-skills/landing-page-design -> landing page design | activate on demand

## Vendor skills — Leonxlnx/taste-skill
- taste-skill/taste-skill -> design taste review | activate on demand

## Vendor skills — tech-leads-club/agent-skills (catalog)
- agent-skills/component-common-domain-detection -> detect common domains across components | activate on demand
- agent-skills/component-flattening-analysis -> analyze component flattening | activate on demand
- agent-skills/component-identification-sizing -> identify and size components | activate on demand
- agent-skills/coupling-analysis -> analyze component coupling | activate on demand
- agent-skills/decomposition-planning-roadmap -> plan decomposition roadmap | activate on demand
- agent-skills/domain-analysis -> perform domain analysis | activate on demand
- agent-skills/domain-identification-grouping -> identify and group domains | activate on demand
- agent-skills/evolutionary-modular-architecture -> evolutionary modular architecture | activate on demand
- agent-skills/frontend-blueprint -> frontend blueprinting | activate on demand
- agent-skills/legacy-migration-planner -> plan legacy migration | activate on demand
- agent-skills/modular-decomposition -> modular decomposition | activate on demand
- agent-skills/modular-design-principles -> modular design principles | activate on demand
- agent-skills/react-composition-patterns -> React composition patterns | activate on demand
- agent-skills/tactical-ddd -> tactical DDD | activate on demand
- agent-skills/aws-advisor -> AWS advisory | activate on demand
- agent-skills/cloudflare-deploy -> Cloudflare deployment | activate on demand
- agent-skills/netlify-deploy -> Netlify deployment | activate on demand
- agent-skills/render-deploy -> Render deployment | activate on demand
- agent-skills/vercel-deploy -> Vercel deployment | activate on demand
- agent-skills/create-adr -> create ADR | activate on demand
- agent-skills/create-rfc -> create RFC | activate on demand
- agent-skills/create-technical-design-doc -> create technical design doc | activate on demand
- agent-skills/cursor-subagent-creator -> create Cursor subagents | activate on demand
- agent-skills/skill-architect -> architect skills | activate on demand
- agent-skills/subagent-creator -> create subagents | activate on demand
- agent-skills/the-fool -> The Fool | activate on demand
- agent-skills/the-jury -> The Jury | activate on demand
- agent-skills/figma -> Figma integration | activate on demand
- agent-skills/codenavi -> code navigation | activate on demand
- agent-skills/coding-guidelines -> coding guidelines | activate on demand
- agent-skills/confluence-assistant -> Confluence assistant | activate on demand
- agent-skills/docs-writer -> write documentation | activate on demand
- agent-skills/gh-address-comments -> address GitHub comments | activate on demand
- agent-skills/harness-eval -> Harness evaluation | activate on demand
- agent-skills/jira-assistant -> Jira assistant | activate on demand
- agent-skills/nestjs-modular-monolith -> NestJS modular monolith | activate on demand
- agent-skills/not-your-babysitter -> autonomy guidance | activate on demand
- agent-skills/rails-dev -> Rails development | activate on demand
- agent-skills/react-native-expert -> React Native expertise | activate on demand
- agent-skills/shopify-developer -> Shopify development | activate on demand
- agent-skills/spec-driven-eval -> spec-driven evaluation | activate on demand
- agent-skills/tlc-discover -> TLC discover | activate on demand
- agent-skills/tlc-implement -> TLC implement | activate on demand
- agent-skills/tlc-plan -> TLC plan | activate on demand
- agent-skills/tlc-prd -> TLC PRD | activate on demand
- agent-skills/tlc-spec-driven -> TLC spec-driven | activate on demand
- agent-skills/tlc-spec-lean -> TLC spec-lean | activate on demand
- agent-skills/ai-cold-outreach -> AI cold outreach | activate on demand
- agent-skills/ai-pricing -> AI pricing | activate on demand
- agent-skills/ai-sdr -> AI SDR | activate on demand
- agent-skills/ai-seo -> AI SEO | activate on demand
- agent-skills/ai-ugc-ads -> AI UGC ads | activate on demand
- agent-skills/content-to-pipeline -> content to pipeline | activate on demand
- agent-skills/expansion-retention -> expansion and retention | activate on demand
- agent-skills/gtm-engineering -> GTM engineering | activate on demand
- agent-skills/gtm-metrics -> GTM metrics | activate on demand
- agent-skills/lead-enrichment -> lead enrichment | activate on demand
- agent-skills/multi-platform-launch -> multi-platform launch | activate on demand
- agent-skills/paid-creative-ai -> paid creative AI | activate on demand
- agent-skills/partner-affiliate -> partner affiliate | activate on demand
- agent-skills/positioning-icp -> positioning and ICP | activate on demand
- agent-skills/sales-motion-design -> sales motion design | activate on demand
- agent-skills/social-selling -> social selling | activate on demand
- agent-skills/solo-founder-gtm -> solo founder GTM | activate on demand
- agent-skills/video-outreach -> video outreach | activate on demand
- agent-skills/learning-opportunities -> learning opportunities | activate on demand
- agent-skills/sentry -> Sentry integration | activate on demand
- agent-skills/core-web-vitals -> Core Web Vitals | activate on demand
- agent-skills/perf-astro -> Astro performance | activate on demand
- agent-skills/perf-lighthouse -> Lighthouse performance | activate on demand
- agent-skills/perf-web-optimization -> web performance optimization | activate on demand
- agent-skills/react-best-practices -> React best practices | activate on demand
- agent-skills/seo -> SEO | activate on demand
- agent-skills/the-judge -> The Judge | activate on demand
- agent-skills/tlc-generative-engine-optimization -> generative engine optimization | activate on demand
- agent-skills/web-accessibility -> web accessibility | activate on demand
- agent-skills/web-best-practices -> web best practices | activate on demand
- agent-skills/web-quality-audit -> web quality audit | activate on demand
- agent-skills/security-best-practices -> security best practices | activate on demand
- agent-skills/security-ownership-map -> security ownership map | activate on demand
- agent-skills/security-threat-model -> security threat model | activate on demand
- agent-skills/chrome-devtools -> Chrome DevTools | activate on demand
- agent-skills/excalidraw-studio -> Excalidraw studio | activate on demand
- agent-skills/gh-fix-ci -> fix GitHub CI | activate on demand
- agent-skills/mermaid-studio -> Mermaid studio | activate on demand
- agent-skills/nx-ci-monitor -> Nx CI monitor | activate on demand
- agent-skills/nx-generate -> Nx generate | activate on demand
- agent-skills/nx-run-tasks -> Nx run tasks | activate on demand
- agent-skills/nx-workspace -> Nx workspace | activate on demand
- agent-skills/demo -> demo skill | activate on demand
- agent-skills/playwright-skill -> Playwright automation | activate on demand

## MCP curation
- context7: confirmed running in Cline MCP settings (no change).
- No new MCP servers added this stage.
- Wishlist (recorded here only, not added): playwright, github.
- agent-skills/figma-implement-design -> implement Figma designs | activate on demand
- agent-skills/frontend-design -> frontend design | activate on demand
- agent-skills/web-design-guidelines -> web design guidelines | activate on demand