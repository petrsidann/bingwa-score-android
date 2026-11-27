package o7;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzaia;
import com.google.android.gms.internal.p002firebaseauthapi.zzzp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class x0 extends j0 {
    public static final Parcelable.Creator<x0> CREATOR = new t1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzaia f13785d;

    public x0(String str, String str2, long j10, zzaia zzaiaVar) {
        this.f13782a = com.google.android.gms.common.internal.r.f(str);
        this.f13783b = str2;
        this.f13784c = j10;
        this.f13785d = (zzaia) com.google.android.gms.common.internal.r.m(zzaiaVar, "totpInfo cannot be null.");
    }

    public static x0 V(JSONObject jSONObject) {
        if (!jSONObject.has("enrollmentTimestamp")) {
            throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a TotpMultiFactorInfo instance.");
        }
        long jOptLong = jSONObject.optLong("enrollmentTimestamp");
        if (jSONObject.opt("totpInfo") == null) {
            throw new IllegalArgumentException("A totpInfo is required to build a TotpMultiFactorInfo instance.");
        }
        return new x0(jSONObject.optString("uid"), jSONObject.optString("displayName"), jOptLong, new zzaia());
    }

    @Override // o7.j0
    public long S() {
        return this.f13784c;
    }

    @Override // o7.j0
    public String T() {
        return "totp";
    }

    @Override // o7.j0
    public JSONObject U() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "totp");
            jSONObject.putOpt("uid", this.f13782a);
            jSONObject.putOpt("displayName", this.f13783b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f13784c));
            jSONObject.putOpt("totpInfo", this.f13785d);
            return jSONObject;
        } catch (JSONException e10) {
            Log.d("TotpMultiFactorInfo", "Failed to jsonify this object");
            throw new zzzp(e10);
        }
    }

    @Override // o7.j0
    public String h() {
        return this.f13782a;
    }

    @Override // o7.j0
    public String w() {
        return this.f13783b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, h(), false);
        d4.c.E(parcel, 2, w(), false);
        d4.c.x(parcel, 3, S());
        d4.c.C(parcel, 4, this.f13785d, i10, false);
        d4.c.b(parcel, iA);
    }
}
