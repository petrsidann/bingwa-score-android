package o7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class o0 extends h implements Cloneable {
    public static final Parcelable.Creator<o0> CREATOR = new p1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13768e;

    public o0(String str, String str2, String str3, boolean z10, String str4) {
        com.google.android.gms.common.internal.r.b(((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) ? false : true, "Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.");
        this.f13764a = str;
        this.f13765b = str2;
        this.f13766c = str3;
        this.f13767d = z10;
        this.f13768e = str4;
    }

    public static o0 W(String str, String str2) {
        return new o0(str, str2, null, true, null);
    }

    public static o0 Z(String str, String str2) {
        return new o0(null, null, str, true, str2);
    }

    @Override // o7.h
    public String S() {
        return "phone";
    }

    @Override // o7.h
    public String T() {
        return "phone";
    }

    @Override // o7.h
    public final h U() {
        return (o0) clone();
    }

    public String V() {
        return this.f13765b;
    }

    public final o0 X(boolean z10) {
        this.f13767d = false;
        return this;
    }

    public final String Y() {
        return this.f13766c;
    }

    public final boolean a0() {
        return this.f13767d;
    }

    public /* synthetic */ Object clone() {
        return new o0(this.f13764a, V(), this.f13766c, this.f13767d, this.f13768e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f13764a, false);
        d4.c.E(parcel, 2, V(), false);
        d4.c.E(parcel, 4, this.f13766c, false);
        d4.c.g(parcel, 5, this.f13767d);
        d4.c.E(parcel, 6, this.f13768e, false);
        d4.c.b(parcel, iA);
    }

    public final String zzc() {
        return this.f13764a;
    }

    public final String zzd() {
        return this.f13768e;
    }
}
