package o7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;

/* JADX INFO: loaded from: classes.dex */
public class z0 extends h {
    public static final Parcelable.Creator<z0> CREATOR = new u1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13795b;

    public z0(String str, String str2) {
        this.f13794a = com.google.android.gms.common.internal.r.f(str);
        this.f13795b = com.google.android.gms.common.internal.r.f(str2);
    }

    public static zzaic V(z0 z0Var, String str) {
        com.google.android.gms.common.internal.r.l(z0Var);
        return new zzaic(null, z0Var.f13794a, z0Var.S(), null, z0Var.f13795b, null, str, null, null);
    }

    @Override // o7.h
    public String S() {
        return "twitter.com";
    }

    @Override // o7.h
    public String T() {
        return "twitter.com";
    }

    @Override // o7.h
    public final h U() {
        return new z0(this.f13794a, this.f13795b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f13794a, false);
        d4.c.E(parcel, 2, this.f13795b, false);
        d4.c.b(parcel, iA);
    }
}
