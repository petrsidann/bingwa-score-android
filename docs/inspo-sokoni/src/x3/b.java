package x3;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class b extends d4.a {
    public static final Parcelable.Creator<b> CREATOR = new d();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f17955l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f17956m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f17957n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f17958o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f17959p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f17960q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f17961r = 6;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f17962s = 7;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f17963t = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f17967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bundle f17969f;

    public b(int i10, String str, int i11, long j10, byte[] bArr, Bundle bundle) {
        this.f17968e = i10;
        this.f17964a = str;
        this.f17965b = i11;
        this.f17966c = j10;
        this.f17967d = bArr;
        this.f17969f = bundle;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.f17964a + ", method: " + this.f17965b + " ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f17964a, false);
        d4.c.t(parcel, 2, this.f17965b);
        d4.c.x(parcel, 3, this.f17966c);
        d4.c.k(parcel, 4, this.f17967d, false);
        d4.c.j(parcel, 5, this.f17969f, false);
        d4.c.t(parcel, 1000, this.f17968e);
        d4.c.b(parcel, iA);
    }
}
