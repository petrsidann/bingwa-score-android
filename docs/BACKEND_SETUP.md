# Backend Setup — turning PART B live

PART B ships **offline-safe**: every remote call sits behind
`OfflineFallback.guard(...)`, every feature flag defaults to **OFF**, and
`RemoteConfig.baseUrl` is blank until you provision a real endpoint. With
nothing configured the app behaves exactly as PART A shipped it and makes
**zero** network calls.

This document is the exact checklist to flip it live.

---

## 1. Environment variables

Set these in `app/build.gradle.kts` under `defaultConfig`, or better, read them
from `local.properties` so secrets never enter git.

| Variable | Purpose | Where it lands |
|---|---|---|
| `BASE_URL` | REST root for offers/features/auth/messages | `buildConfigField("String", "API_BASE_URL", …)` → `RemoteConfig.baseUrl` |
| `FCM_PROJECT_ID` | Firebase Cloud Messaging project | `google-services.json` → `FcmService` |
| `SUPABASE_URL` | (Alternative to FCM) auth + row storage | backend only; app talks to `BASE_URL` |
| `SUPABASE_KEY` | Supabase anon/service key | backend only |
| `RELAY_SERVER_URL` | WebSocket relay host | `RemoteConfig.socketUrl` (derived from `BASE_URL`) |
| `RELAY_SERVER_KEY` | Relay auth token | sent as `Authorization: Bearer` |

**Important:** `RemoteConfig.baseUrl` treats an empty value **or** anything
containing `example.com` as "not configured". So a placeholder URL is safe —
the app still runs fully offline.

```kotlin
// app/build.gradle.kts
val baseUrl = (project.findProperty("BASE_URL") as String?)
    ?: "\"https://api.bingwascore.com/\""
buildConfigField("String", "API_BASE_URL", baseUrl)
```

---

## 2. Firebase Cloud Messaging (push)

1. Create a Firebase project → add an Android app with package
   `com.bingwascore.app`.
2. Download `google-services.json` into `app/`.
3. Apply the plugin: `id("com.google.gms.google-services")` in `app/build.gradle.kts`
   (add the version to `libs.versions.toml`).
4. Generate a service-account key for the relay server.

Until this lands, `FcmService.registerToken(...)` still works: it stores the
token locally and reports `registeredLocallyOnly = true`.

---

## 3. Relay server (WebSocket + SSE)

The app expects these endpoints. They are declared in `SocketEvents`:

| Event | Direction | Meaning |
|---|---|---|
| `task.airtime_balance.get_ack` | server → app | Acknowledges an airtime-balance request |
| `app_state.set` | server → app | `{serverId, message, state}` — routed through `DeviceRelay.handleAppStateSet` |
| `task.ack` | server → app | Generic task acknowledgement |
| `ping` | server → app | Heartbeat |

Frames are JSON: `{"event":"<name>", …}`. The app ignores unknown events.

- WebSocket URL is derived as `BASE_URL` with `http`→`ws`, plus `/socket`.
- SSE URL is `BASE_URL` + `/events`; payloads arrive as `data: <json>` lines.

---

## 4. REST endpoints

`ApiService` expects exactly these paths:

| Method | Path | Purpose |
|---|---|---|
| `GET` | `/api/offers/verified` | Verified offer catalogue |
| `GET` | `/api/features` | All features |
| `GET` | `/api/features/{code}` | One feature by code |
| `GET` | `/api/features/{id}/passes` | Passes for a feature |
| `POST` | `/api/messages/send` | `FcmMessageRequest` → push to one device |

`AuthRepository` expects:

| Method | Path | Purpose |
|---|---|---|
| `POST` | `/api/auth/sign-in` | `{phone, pin}` → session |
| `POST` | `/api/auth/sign-up` | `{phone, pin}` → session |
| `POST` | `/api/auth/email-otp` | `{email}` → `{challengeId}` |
| `POST` | `/api/auth/verify-otp` | `{challengeId, code}` → session |
| `POST` | `/api/auth/refresh` | `{refreshToken}` → session |

Session JSON: `{userId, phone, accessToken, refreshToken, expiresAt}`.

Every call is bounded by `OfflineFallback.TIMEOUT_MILLIS` (12s). A slow or dead
server degrades to the local Room data — it can never hang the UI.

---

## 5. Feature flags

All flags live in `RemoteConfig` and **default OFF**. `isActive(flag)` requires
the master switch AND the specific flag AND a configured `BASE_URL`.

| Flag | Default | Gates |
|---|---|---|
| `remoteFeaturesEnabled` | `false` | Master switch for all of the below |
| `offerSyncEnabled` | `false` | `getVerifiedOffers` / features / passes |
| `relaySocketEnabled` | `false` | WebSocket connection |
| `sseEnabled` | `false` | SSE subscription |
| `pushEnabled` | `false` | FCM token upload |
| `relayDialEnabled` | `false` | Applying `app_state.set` relay commands |
| `serverAuthEnabled` | `false` | Server-side auth (OTP / refresh) |

Flip them at runtime for a smoke test:

```kotlin
remoteConfig.applyOverrides(remote = true, offers = true, socket = true)
```

`resetToDefaults()` restores every flag to OFF.

---

## 6. Go-live checklist

1. `BASE_URL` points at a reachable HTTPS host.
2. The five REST auth paths and five feature paths respond with the shapes above.
3. Relay server accepts the WebSocket and emits the four event names.
4. `google-services.json` in place, `FCM_PROJECT_ID` set.
5. Flags enabled **one at a time**, starting with `offerSyncEnabled`.
6. Watch `adb logcat -s NETWORK SOCKET PUSH RELAY` — every fallback logs its
   reason, so a misconfiguration is visible without a crash.

---

## Rollback

Set `remoteFeaturesEnabled = false` (or ship with a blank `BASE_URL`). The app
reverts to fully local behaviour instantly — no data migration involved.