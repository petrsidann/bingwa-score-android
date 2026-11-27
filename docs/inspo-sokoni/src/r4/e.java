package r4;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class e extends d4.a {
    public static final Parcelable.Creator<e> CREATOR = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f15023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15025c;

    public e(b bVar, String str, String str2) {
        this.f15023a = (b) r.l(bVar);
        this.f15025c = str;
        this.f15024b = str2;
    }

    public String S() {
        return this.f15024b;
    }

    public String T() {
        return this.f15025c;
    }

    public b U() {
        return this.f15023a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        String str = this.f15025c;
        if (str == null) {
            if (eVar.f15025c != null) {
                return false;
            }
        } else if (!str.equals(eVar.f15025c)) {
            return false;
        }
        if (!this.f15023a.equals(eVar.f15023a)) {
            return false;
        }
        String str2 = this.f15024b;
        String str3 = eVar.f15024b;
        if (str2 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str2.equals(str3)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f15025c;
        int iHashCode = (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f15023a.hashCode();
        String str2 = this.f15024b;
        return (iHashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("keyHandle", Base64.encodeToString(this.f15023a.S(), 11));
            if (this.f15023a.T() != c.UNKNOWN) {
                jSONObject.put("version", this.f15023a.T().toString());
            }
            if (this.f15023a.U() != null) {
                jSONObject.put("transports", this.f15023a.U().toString());
            }
            String str = this.f15025c;
            if (str != null) {
                jSONObject.put("challenge", str);
            }
            String str2 = this.f15024b;
            if (str2 != null) {
                jSONObject.put("appId", str2);
            }
            return jSONObject.toString();
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 2, U(), i10, false);
        d4.c.E(parcel, 3, T(), false);
        d4.c.E(parcel, 4, S(), false);
        d4.c.b(parcel, iA);
    }
}
