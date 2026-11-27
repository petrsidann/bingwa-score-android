package o7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class j extends h {
    public static final Parcelable.Creator<j> CREATOR = new z1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13748e;

    public j(String str, String str2) {
        this(str, str2, null, null, false);
    }

    public j(String str, String str2, String str3, String str4, boolean z10) {
        this.f13744a = com.google.android.gms.common.internal.r.f(str);
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.f13745b = str2;
        this.f13746c = str3;
        this.f13747d = str4;
        this.f13748e = z10;
    }

    public static boolean W(String str) {
        f fVarC;
        return (TextUtils.isEmpty(str) || (fVarC = f.c(str)) == null || fVarC.b() != 4) ? false : true;
    }

    @Override // o7.h
    public String S() {
        return "password";
    }

    @Override // o7.h
    public String T() {
        return !TextUtils.isEmpty(this.f13745b) ? "password" : "emailLink";
    }

    @Override // o7.h
    public final h U() {
        return new j(this.f13744a, this.f13745b, this.f13746c, this.f13747d, this.f13748e);
    }

    public final j V(a0 a0Var) {
        this.f13747d = a0Var.zze();
        this.f13748e = true;
        return this;
    }

    public final String X() {
        return this.f13747d;
    }

    public final boolean Y() {
        return !TextUtils.isEmpty(this.f13746c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f13744a, false);
        d4.c.E(parcel, 2, this.f13745b, false);
        d4.c.E(parcel, 3, this.f13746c, false);
        d4.c.E(parcel, 4, this.f13747d, false);
        d4.c.g(parcel, 5, this.f13748e);
        d4.c.b(parcel, iA);
    }

    public final String zzc() {
        return this.f13744a;
    }

    public final String zzd() {
        return this.f13745b;
    }

    public final String zze() {
        return this.f13746c;
    }

    public final boolean zzg() {
        return this.f13748e;
    }
}
