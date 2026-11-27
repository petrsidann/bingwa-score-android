package p7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.internal.p002firebaseauthapi.zzagw;
import com.google.android.gms.internal.p002firebaseauthapi.zzzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f14186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f14188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f4.a f14189d;

    public c1(Context context, String str) {
        com.google.android.gms.common.internal.r.l(context);
        this.f14187b = com.google.android.gms.common.internal.r.f(str);
        this.f14186a = context.getApplicationContext();
        this.f14188c = this.f14186a.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", this.f14187b), 0);
        this.f14189d = new f4.a("StorageHelpers", new String[0]);
    }

    public final zzagw a(o7.a0 a0Var) {
        com.google.android.gms.common.internal.r.l(a0Var);
        String string = this.f14188c.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", a0Var.h()), null);
        if (string != null) {
            return zzagw.zzb(string);
        }
        return null;
    }

    public final o7.a0 b() {
        String string = this.f14188c.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return c(jSONObject);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final i c(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        k kVarB;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z10 = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString("version");
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray3 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray3.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(e.S(jSONArray3.getString(i10)));
            }
            i iVar = new i(h7.f.p(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                iVar.p0(zzagw.zzb(string));
            }
            if (!z10) {
                iVar.q0();
            }
            iVar.v0(str);
            if (jSONObject.has("userMetadata") && (kVarB = k.b(jSONObject.getJSONObject("userMetadata"))) != null) {
                iVar.x0(kVarB);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray2 = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray2.getString(i11));
                    String strOptString = jSONObject2.optString("factorIdKey");
                    arrayList2.add("phone".equals(strOptString) ? o7.r0.V(jSONObject2) : Objects.equals(strOptString, "totp") ? o7.x0.V(jSONObject2) : null);
                }
                iVar.t0(arrayList2);
            }
            if (jSONObject.has("passkeyInfo") && (jSONArray = jSONObject.getJSONArray("passkeyInfo")) != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                    arrayList3.add(o7.m1.T(new JSONObject(jSONArray.getString(i12))));
                }
                iVar.r0(arrayList3);
            }
            return iVar;
        } catch (zzzp | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e10) {
            this.f14189d.j(e10);
            return null;
        }
    }

    public final void d(String str) {
        this.f14188c.edit().remove(str).apply();
    }

    public final void e(o7.a0 a0Var, zzagw zzagwVar) {
        com.google.android.gms.common.internal.r.l(a0Var);
        com.google.android.gms.common.internal.r.l(zzagwVar);
        this.f14188c.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", a0Var.h()), zzagwVar.zzf()).apply();
    }

    public final void f(o7.a0 a0Var) {
        com.google.android.gms.common.internal.r.l(a0Var);
        String strG = g(a0Var);
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        this.f14188c.edit().putString("com.google.firebase.auth.FIREBASE_USER", strG).apply();
    }

    public final String g(o7.a0 a0Var) {
        JSONObject jSONObject = new JSONObject();
        if (!i.class.isAssignableFrom(a0Var.getClass())) {
            return null;
        }
        i iVar = (i) a0Var;
        try {
            jSONObject.put("cachedTokenState", iVar.zze());
            jSONObject.put("applicationName", iVar.n0().q());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (iVar.B0() != null) {
                JSONArray jSONArray = new JSONArray();
                List<e> listB0 = iVar.B0();
                int size = listB0.size();
                if (listB0.size() > 30) {
                    this.f14189d.h("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(listB0.size()));
                    size = 30;
                }
                boolean z10 = false;
                for (int i10 = 0; i10 < size; i10++) {
                    e eVar = listB0.get(i10);
                    if (eVar.i().equals("firebase")) {
                        z10 = true;
                    }
                    if (i10 == size - 1 && !z10) {
                        break;
                    }
                    jSONArray.put(eVar.T());
                }
                if (!z10) {
                    for (int i11 = size - 1; i11 < listB0.size() && i11 >= 0; i11++) {
                        e eVar2 = listB0.get(i11);
                        if (eVar2.i().equals("firebase")) {
                            jSONArray.put(eVar2.T());
                            z10 = true;
                            break;
                        }
                        if (i11 == listB0.size() - 1) {
                            jSONArray.put(eVar2.T());
                        }
                    }
                    if (!z10) {
                        this.f14189d.h("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(listB0.size()), Integer.valueOf(size));
                        if (listB0.size() < 5) {
                            StringBuilder sb2 = new StringBuilder("Provider user info list:\n");
                            Iterator<e> it = listB0.iterator();
                            while (it.hasNext()) {
                                sb2.append(String.format("Provider - %s\n", it.next().i()));
                            }
                            this.f14189d.h(sb2.toString(), new Object[0]);
                        }
                    }
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", iVar.Y());
            jSONObject.put("version", "2");
            if (iVar.U() != null) {
                jSONObject.put("userMetadata", ((k) iVar.U()).a());
            }
            List<o7.j0> listB = ((m) iVar.V()).b();
            if (listB != null && !listB.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i12 = 0; i12 < listB.size(); i12++) {
                    jSONArray2.put(listB.get(i12).U());
                }
                jSONObject.put("userMultiFactorInfo", jSONArray2);
            }
            List<o7.m1> listU0 = iVar.u0();
            if (listU0 != null && !listU0.isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i13 = 0; i13 < listU0.size(); i13++) {
                    jSONArray3.put(o7.m1.U(listU0.get(i13)));
                }
                jSONObject.put("passkeyInfo", jSONArray3);
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            this.f14189d.i("Failed to turn object into JSON", e10, new Object[0]);
            throw new zzzp(e10);
        }
    }
}
