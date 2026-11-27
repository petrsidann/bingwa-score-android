package o7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaj;
import com.google.android.gms.internal.p002firebaseauthapi.zzam;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class m1 extends d4.a {
    public static final Parcelable.Creator<m1> CREATOR = new o1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13755c;

    public m1(String str, String str2, String str3) {
        this.f13753a = str;
        this.f13754b = str2;
        this.f13755c = str3;
    }

    public static zzaj<m1> S(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return zzaj.zza(new ArrayList());
        }
        zzam zzamVarZzg = zzaj.zzg();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            zzamVarZzg.zza(new m1(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName")));
        }
        return zzamVarZzg.zza();
    }

    public static final m1 T(JSONObject jSONObject) {
        return new m1(jSONObject.getString("credentialId"), jSONObject.getString("name"), jSONObject.getString("displayName"));
    }

    public static final JSONObject U(m1 m1Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("credentialId", m1Var.f13753a);
        jSONObject.put("name", m1Var.f13754b);
        jSONObject.put("displayName", m1Var.f13755c);
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f13753a, false);
        d4.c.E(parcel, 2, this.f13754b, false);
        d4.c.E(parcel, 3, this.f13755c, false);
        d4.c.b(parcel, iA);
    }
}
