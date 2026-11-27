package o7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;

/* JADX INFO: loaded from: classes.dex */
public class f0 extends h {
    public static final Parcelable.Creator<f0> CREATOR = new l1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13728b;

    public f0(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        if (str != null && str.length() == 0) {
            throw new IllegalArgumentException("idToken cannot be empty");
        }
        if (str2 != null && str2.length() == 0) {
            throw new IllegalArgumentException("accessToken cannot be empty");
        }
        this.f13727a = str;
        this.f13728b = str2;
    }

    public static zzaic V(f0 f0Var, String str) {
        com.google.android.gms.common.internal.r.l(f0Var);
        return new zzaic(f0Var.f13727a, f0Var.f13728b, f0Var.S(), null, null, null, str, null, null);
    }

    @Override // o7.h
    public String S() {
        return "google.com";
    }

    @Override // o7.h
    public String T() {
        return "google.com";
    }

    @Override // o7.h
    public final h U() {
        return new f0(this.f13727a, this.f13728b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f13727a, false);
        d4.c.E(parcel, 2, this.f13728b, false);
        d4.c.b(parcel, iA);
    }
}
