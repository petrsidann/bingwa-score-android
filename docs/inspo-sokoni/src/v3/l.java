package v3;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class l extends d4.a {
    public static final Parcelable.Creator<l> CREATOR = new e0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f17176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17177f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f17178l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f17179m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final q4.t f17180n;

    public l(String str, String str2, String str3, String str4, Uri uri, String str5, String str6, String str7, q4.t tVar) {
        this.f17172a = com.google.android.gms.common.internal.r.f(str);
        this.f17173b = str2;
        this.f17174c = str3;
        this.f17175d = str4;
        this.f17176e = uri;
        this.f17177f = str5;
        this.f17178l = str6;
        this.f17179m = str7;
        this.f17180n = tVar;
    }

    public String S() {
        return this.f17175d;
    }

    public String T() {
        return this.f17174c;
    }

    public String U() {
        return this.f17178l;
    }

    public String V() {
        return this.f17172a;
    }

    public String W() {
        return this.f17177f;
    }

    public Uri X() {
        return this.f17176e;
    }

    public q4.t Y() {
        return this.f17180n;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return com.google.android.gms.common.internal.p.b(this.f17172a, lVar.f17172a) && com.google.android.gms.common.internal.p.b(this.f17173b, lVar.f17173b) && com.google.android.gms.common.internal.p.b(this.f17174c, lVar.f17174c) && com.google.android.gms.common.internal.p.b(this.f17175d, lVar.f17175d) && com.google.android.gms.common.internal.p.b(this.f17176e, lVar.f17176e) && com.google.android.gms.common.internal.p.b(this.f17177f, lVar.f17177f) && com.google.android.gms.common.internal.p.b(this.f17178l, lVar.f17178l) && com.google.android.gms.common.internal.p.b(this.f17179m, lVar.f17179m) && com.google.android.gms.common.internal.p.b(this.f17180n, lVar.f17180n);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f17172a, this.f17173b, this.f17174c, this.f17175d, this.f17176e, this.f17177f, this.f17178l, this.f17179m, this.f17180n);
    }

    @Deprecated
    public String r() {
        return this.f17179m;
    }

    public String w() {
        return this.f17173b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, V(), false);
        d4.c.E(parcel, 2, w(), false);
        d4.c.E(parcel, 3, T(), false);
        d4.c.E(parcel, 4, S(), false);
        d4.c.C(parcel, 5, X(), i10, false);
        d4.c.E(parcel, 6, W(), false);
        d4.c.E(parcel, 7, U(), false);
        d4.c.E(parcel, 8, r(), false);
        d4.c.C(parcel, 9, Y(), i10, false);
        d4.c.b(parcel, iA);
    }
}
