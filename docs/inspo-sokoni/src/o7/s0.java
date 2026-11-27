package o7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;

/* JADX INFO: loaded from: classes.dex */
public class s0 extends h {
    public static final Parcelable.Creator<s0> CREATOR = new s1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13775a;

    public s0(String str) {
        this.f13775a = com.google.android.gms.common.internal.r.f(str);
    }

    public static zzaic V(s0 s0Var, String str) {
        com.google.android.gms.common.internal.r.l(s0Var);
        return new zzaic(null, null, s0Var.S(), null, null, s0Var.f13775a, str, null, null);
    }

    @Override // o7.h
    public String S() {
        return "playgames.google.com";
    }

    @Override // o7.h
    public String T() {
        return "playgames.google.com";
    }

    @Override // o7.h
    public final h U() {
        return new s0(this.f13775a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f13775a, false);
        d4.c.b(parcel, iA);
    }
}
