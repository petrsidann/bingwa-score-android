package o7;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzzp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class r0 extends j0 {
    public static final Parcelable.Creator<r0> CREATOR = new r1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13774d;

    public r0(String str, String str2, long j10, String str3) {
        this.f13771a = com.google.android.gms.common.internal.r.f(str);
        this.f13772b = str2;
        this.f13773c = j10;
        this.f13774d = com.google.android.gms.common.internal.r.f(str3);
    }

    public static r0 V(JSONObject jSONObject) {
        if (jSONObject.has("enrollmentTimestamp")) {
            return new r0(jSONObject.optString("uid"), jSONObject.optString("displayName"), jSONObject.optLong("enrollmentTimestamp"), jSONObject.optString("phoneNumber"));
        }
        throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
    }

    @Override // o7.j0
    public long S() {
        return this.f13773c;
    }

    @Override // o7.j0
    public String T() {
        return "phone";
    }

    @Override // o7.j0
    public JSONObject U() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "phone");
            jSONObject.putOpt("uid", this.f13771a);
            jSONObject.putOpt("displayName", this.f13772b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f13773c));
            jSONObject.putOpt("phoneNumber", this.f13774d);
            return jSONObject;
        } catch (JSONException e10) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new zzzp(e10);
        }
    }

    @Override // o7.j0
    public String h() {
        return this.f13771a;
    }

    public String r() {
        return this.f13774d;
    }

    @Override // o7.j0
    public String w() {
        return this.f13772b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, h(), false);
        d4.c.E(parcel, 2, w(), false);
        d4.c.x(parcel, 3, S());
        d4.c.E(parcel, 4, r(), false);
        d4.c.b(parcel, iA);
    }
}
