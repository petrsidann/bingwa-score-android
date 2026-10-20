.cline/skills/android-re/SKILL.md
---
name: android-re
description: Reverse-engineer Android APKs with jadx/apktool to extract exact regexes, enums, pipelines. Never invent missing files; log SOURCE LIMITATION.
---
jadx -d out target.apk ; grep exact literals ; map enums ; extract flows verbatim.
