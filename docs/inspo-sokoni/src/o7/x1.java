package o7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.p002firebaseauthapi.zzae;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;

/* JADX INFO: loaded from: classes.dex */
public class x1 extends m0 {
    public static final Parcelable.Creator<x1> CREATOR = new y1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzaic f13789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f13791f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f13792l;

    public x1(String str, String str2, String str3, zzaic zzaicVar, String str4, String str5, String str6) {
        this.f13786a = zzae.zzb(str);
        this.f13787b = str2;
        this.f13788c = str3;
        this.f13789d = zzaicVar;
        this.f13790e = str4;
        this.f13791f = str5;
        this.f13792l = str6;
    }

    public static zzaic Y(x1 x1Var, String str) {
        com.google.android.gms.common.internal.r.l(x1Var);
        zzaic zzaicVar = x1Var.f13789d;
        return zzaicVar != null ? zzaicVar : new zzaic(x1Var.W(), x1Var.V(), x1Var.S(), null, x1Var.X(), null, str, x1Var.f13790e, x1Var.f13792l);
    }

    public static x1 Z(zzaic zzaicVar) {
        com.google.android.gms.common.internal.r.m(zzaicVar, "Must specify a non-null webSignInCredential");
        return new x1(null, null, null, zzaicVar, null, null, null);
    }

    public static x1 a0(String str, String str2, String str3, String str4) {
        com.google.android.gms.common.internal.r.g(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new x1(str, str2, str3, null, null, null, str4);
    }

    public static x1 b0(String str, String str2, String str3, String str4, String str5) {
        com.google.android.gms.common.internal.r.g(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new x1(str, str2, str3, null, str4, str5, null);
    }

    @Override // o7.h
    public String S() {
        return this.f13786a;
    }

    @Override // o7.h
    public String T() {
        return this.f13786a;
    }

    @Override // o7.h
    public final h U() {
        return new x1(this.f13786a, this.f13787b, this.f13788c, this.f13789d, this.f13790e, this.f13791f, this.f13792l);
    }

    @Override // o7.m0
    public String V() {
        return this.f13788c;
    }

    @Override // o7.m0
    public String W() {
        return this.f13787b;
    }

    @Override // o7.m0
    public String X() {
        return this.f13791f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, S(), false);
        d4.c.E(parcel, 2, W(), false);
        d4.c.E(parcel, 3, V(), false);
        d4.c.C(parcel, 4, this.f13789d, i10, false);
        d4.c.E(parcel, 5, this.f13790e, false);
        d4.c.E(parcel, 6, X(), false);
        d4.c.E(parcel, 7, this.f13792l, false);
        d4.c.b(parcel, iA);
    }
}
