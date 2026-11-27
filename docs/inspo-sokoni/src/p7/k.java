package p7;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k implements o7.b0 {
    public static final Parcelable.Creator<k> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14270b;

    public k(long j10, long j11) {
        this.f14269a = j10;
        this.f14270b = j11;
    }

    public static k b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new k(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.f14269a);
            jSONObject.put("creationTimestamp", this.f14270b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // o7.b0
    public final long s() {
        return this.f14270b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.x(parcel, 1, x());
        d4.c.x(parcel, 2, s());
        d4.c.b(parcel, iA);
    }

    @Override // o7.b0
    public final long x() {
        return this.f14269a;
    }
}
