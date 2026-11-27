package o7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;

/* JADX INFO: loaded from: classes.dex */
public class d0 extends h {
    public static final Parcelable.Creator<d0> CREATOR = new k1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13697a;

    public d0(String str) {
        this.f13697a = com.google.android.gms.common.internal.r.f(str);
    }

    public static zzaic V(d0 d0Var, String str) {
        com.google.android.gms.common.internal.r.l(d0Var);
        return new zzaic(null, d0Var.f13697a, d0Var.S(), null, null, null, str, null, null);
    }

    @Override // o7.h
    public String S() {
        return "github.com";
    }

    @Override // o7.h
    public String T() {
        return "github.com";
    }

    @Override // o7.h
    public final h U() {
        return new d0(this.f13697a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f13697a, false);
        d4.c.b(parcel, iA);
    }
}
