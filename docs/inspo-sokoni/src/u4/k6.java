package u4;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzoy;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f16411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f16412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i6 f16413d;

    public k6(i6 i6Var, String str, Bundle bundle) {
        this.f16413d = i6Var;
        com.google.android.gms.common.internal.r.f(str);
        this.f16410a = str;
        this.f16411b = new Bundle();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0084  */
    public final Bundle a() {
        byte b10;
        if (this.f16412c == null) {
            String string = this.f16413d.F().getString(this.f16410a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i10);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int iHashCode = string3.hashCode();
                            if (iHashCode != 100) {
                                if (iHashCode != 108) {
                                    if (iHashCode != 115) {
                                        if (iHashCode != 3352) {
                                            if (iHashCode == 3445 && string3.equals("la")) {
                                                b10 = 4;
                                            } else {
                                                b10 = -1;
                                            }
                                        } else if (string3.equals("ia")) {
                                            b10 = 3;
                                        } else {
                                            b10 = -1;
                                        }
                                    } else if (string3.equals("s")) {
                                        b10 = 0;
                                    } else {
                                        b10 = -1;
                                    }
                                } else if (string3.equals("l")) {
                                    b10 = 2;
                                } else {
                                    b10 = -1;
                                }
                            } else if (string3.equals("d")) {
                                b10 = 1;
                            } else {
                                b10 = -1;
                            }
                            if (b10 == 0) {
                                bundle.putString(string2, jSONObject.getString("v"));
                            } else if (b10 == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else if (b10 == 2) {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            } else if (b10 != 3) {
                                if (b10 != 4) {
                                    this.f16413d.zzj().C().b("Unrecognized persisted bundle type. Type", string3);
                                } else if (zzoy.zza() && this.f16413d.a().p(p0.R0)) {
                                    JSONArray jSONArray2 = new JSONArray(jSONObject.getString("v"));
                                    int length = jSONArray2.length();
                                    long[] jArr = new long[length];
                                    for (int i11 = 0; i11 < length; i11++) {
                                        jArr[i11] = jSONArray2.optLong(i11);
                                    }
                                    bundle.putLongArray(string2, jArr);
                                }
                            } else if (zzoy.zza() && this.f16413d.a().p(p0.R0)) {
                                JSONArray jSONArray3 = new JSONArray(jSONObject.getString("v"));
                                int length2 = jSONArray3.length();
                                int[] iArr = new int[length2];
                                for (int i12 = 0; i12 < length2; i12++) {
                                    iArr[i12] = jSONArray3.optInt(i12);
                                }
                                bundle.putIntArray(string2, iArr);
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.f16413d.zzj().C().a("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.f16412c = bundle;
                } catch (JSONException unused2) {
                    this.f16413d.zzj().C().a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.f16412c == null) {
                this.f16412c = this.f16411b;
            }
        }
        return new Bundle((Bundle) com.google.android.gms.common.internal.r.l(this.f16412c));
    }

    public final void b(Bundle bundle) {
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        SharedPreferences.Editor editorEdit = this.f16413d.F().edit();
        if (bundle2.size() == 0) {
            editorEdit.remove(this.f16410a);
        } else {
            editorEdit.putString(this.f16410a, c(bundle2));
        }
        editorEdit.apply();
        this.f16412c = bundle2;
    }

    public final String c(Bundle bundle) {
        x5 x5VarC;
        Class<?> cls;
        String str;
        JSONArray jSONArray = new JSONArray();
        for (String str2 : bundle.keySet()) {
            Object obj = bundle.get(str2);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str2);
                    if (zzoy.zza() && this.f16413d.a().p(p0.R0)) {
                        if (obj instanceof String) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "l");
                        } else {
                            if (obj instanceof int[]) {
                                jSONObject.put("v", Arrays.toString((int[]) obj));
                                str = "ia";
                            } else if (obj instanceof long[]) {
                                jSONObject.put("v", Arrays.toString((long[]) obj));
                                str = "la";
                            } else if (obj instanceof Double) {
                                jSONObject.put("v", String.valueOf(obj));
                                jSONObject.put("t", "d");
                            } else {
                                x5VarC = this.f16413d.zzj().C();
                                cls = obj.getClass();
                                x5VarC.b("Cannot serialize bundle value to SharedPreferences. Type", cls);
                            }
                            jSONObject.put("t", str);
                        }
                        jSONArray.put(jSONObject);
                    } else {
                        jSONObject.put("v", String.valueOf(obj));
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                            jSONArray.put(jSONObject);
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                            jSONArray.put(jSONObject);
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                            jSONArray.put(jSONObject);
                        } else {
                            x5VarC = this.f16413d.zzj().C();
                            cls = obj.getClass();
                            x5VarC.b("Cannot serialize bundle value to SharedPreferences. Type", cls);
                        }
                    }
                } catch (JSONException e10) {
                    this.f16413d.zzj().C().b("Cannot serialize bundle value to SharedPreferences", e10);
                }
            }
        }
        return jSONArray.toString();
    }
}
