package p7;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzagl;
import com.google.android.gms.internal.p002firebaseauthapi.zzahc;
import com.google.android.gms.internal.p002firebaseauthapi.zzzp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e extends d4.a implements o7.b1 {
    public static final Parcelable.Creator<e> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Uri f14203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f14204f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f14205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f14207n;

    public e(zzagl zzaglVar, String str) {
        com.google.android.gms.common.internal.r.l(zzaglVar);
        com.google.android.gms.common.internal.r.f(str);
        this.f14199a = com.google.android.gms.common.internal.r.f(zzaglVar.zzi());
        this.f14200b = str;
        this.f14204f = zzaglVar.zzh();
        this.f14201c = zzaglVar.zzg();
        Uri uriZzc = zzaglVar.zzc();
        if (uriZzc != null) {
            this.f14202d = uriZzc.toString();
            this.f14203e = uriZzc;
        }
        this.f14206m = zzaglVar.zzm();
        this.f14207n = null;
        this.f14205l = zzaglVar.zzj();
    }

    public e(zzahc zzahcVar) {
        com.google.android.gms.common.internal.r.l(zzahcVar);
        this.f14199a = zzahcVar.zzd();
        this.f14200b = com.google.android.gms.common.internal.r.f(zzahcVar.zzf());
        this.f14201c = zzahcVar.zzb();
        Uri uriZza = zzahcVar.zza();
        if (uriZza != null) {
            this.f14202d = uriZza.toString();
            this.f14203e = uriZza;
        }
        this.f14204f = zzahcVar.zzc();
        this.f14205l = zzahcVar.zze();
        this.f14206m = false;
        this.f14207n = zzahcVar.zzg();
    }

    public e(String str, String str2, String str3, String str4, String str5, String str6, boolean z10, String str7) {
        this.f14199a = str;
        this.f14200b = str2;
        this.f14204f = str3;
        this.f14205l = str4;
        this.f14201c = str5;
        this.f14202d = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.f14203e = Uri.parse(this.f14202d);
        }
        this.f14206m = z10;
        this.f14207n = str7;
    }

    public static e S(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new e(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e10) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzzp(e10);
        }
    }

    @Override // o7.b1
    public final String P() {
        return this.f14204f;
    }

    public final String T() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.f14199a);
            jSONObject.putOpt("providerId", this.f14200b);
            jSONObject.putOpt("displayName", this.f14201c);
            jSONObject.putOpt("photoUrl", this.f14202d);
            jSONObject.putOpt("email", this.f14204f);
            jSONObject.putOpt("phoneNumber", this.f14205l);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.f14206m));
            jSONObject.putOpt("rawUserInfo", this.f14207n);
            return jSONObject.toString();
        } catch (JSONException e10) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzzp(e10);
        }
    }

    @Override // o7.b1
    public final String h() {
        return this.f14199a;
    }

    @Override // o7.b1
    public final String i() {
        return this.f14200b;
    }

    @Override // o7.b1
    public final Uri j() {
        if (!TextUtils.isEmpty(this.f14202d) && this.f14203e == null) {
            this.f14203e = Uri.parse(this.f14202d);
        }
        return this.f14203e;
    }

    @Override // o7.b1
    public final boolean n() {
        return this.f14206m;
    }

    @Override // o7.b1
    public final String r() {
        return this.f14205l;
    }

    @Override // o7.b1
    public final String w() {
        return this.f14201c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, h(), false);
        d4.c.E(parcel, 2, i(), false);
        d4.c.E(parcel, 3, w(), false);
        d4.c.E(parcel, 4, this.f14202d, false);
        d4.c.E(parcel, 5, P(), false);
        d4.c.E(parcel, 6, r(), false);
        d4.c.g(parcel, 7, n());
        d4.c.E(parcel, 8, this.f14207n, false);
        d4.c.b(parcel, iA);
    }

    public final String zza() {
        return this.f14207n;
    }
}
