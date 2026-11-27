package o7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;

/* JADX INFO: loaded from: classes.dex */
public class l extends h {
    public static final Parcelable.Creator<l> CREATOR = new a2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13752a;

    public l(String str) {
        this.f13752a = com.google.android.gms.common.internal.r.f(str);
    }

    public static zzaic V(l lVar, String str) {
        com.google.android.gms.common.internal.r.l(lVar);
        return new zzaic(null, lVar.f13752a, lVar.S(), null, null, null, str, null, null);
    }

    @Override // o7.h
    public String S() {
        return "facebook.com";
    }

    @Override // o7.h
    public String T() {
        return "facebook.com";
    }

    @Override // o7.h
    public final h U() {
        return new l(this.f13752a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f13752a, false);
        d4.c.b(parcel, iA);
    }
}
