package u4;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class me extends d4.a {
    public static final Parcelable.Creator<me> CREATOR = new ef();
    public final String A;
    public final String B;
    public final boolean C;
    public final long D;
    public final int E;
    public final String F;
    public final int G;
    public final long H;
    public final String I;
    public final String J;
    public final long K;
    public final int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f16532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f16533f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f16534l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f16535m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f16536n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f16537o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f16538p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f16539q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f16540r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f16541s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f16542t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f16543u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Boolean f16544v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f16545w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<String> f16546x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f16547y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f16548z;

    public me(String str, String str2, String str3, long j10, String str4, long j11, long j12, String str5, boolean z10, boolean z11, String str6, long j13, int i10, boolean z12, boolean z13, String str7, Boolean bool, long j14, List<String> list, String str8, String str9, String str10, String str11, boolean z14, long j15, int i11, String str12, int i12, long j16, String str13, String str14, long j17, int i13) {
        com.google.android.gms.common.internal.r.f(str);
        this.f16528a = str;
        this.f16529b = TextUtils.isEmpty(str2) ? null : str2;
        this.f16530c = str3;
        this.f16537o = j10;
        this.f16531d = str4;
        this.f16532e = j11;
        this.f16533f = j12;
        this.f16534l = str5;
        this.f16535m = z10;
        this.f16536n = z11;
        this.f16538p = str6;
        this.f16539q = j13;
        this.f16540r = i10;
        this.f16541s = z12;
        this.f16542t = z13;
        this.f16543u = str7;
        this.f16544v = bool;
        this.f16545w = j14;
        this.f16546x = list;
        this.f16547y = null;
        this.f16548z = str9;
        this.A = str10;
        this.B = str11;
        this.C = z14;
        this.D = j15;
        this.E = i11;
        this.F = str12;
        this.G = i12;
        this.H = j16;
        this.I = str13;
        this.J = str14;
        this.K = j17;
        this.L = i13;
    }

    public me(String str, String str2, String str3, String str4, long j10, long j11, String str5, boolean z10, boolean z11, long j12, String str6, long j13, int i10, boolean z12, boolean z13, String str7, Boolean bool, long j14, List<String> list, String str8, String str9, String str10, String str11, boolean z14, long j15, int i11, String str12, int i12, long j16, String str13, String str14, long j17, int i13) {
        this.f16528a = str;
        this.f16529b = str2;
        this.f16530c = str3;
        this.f16537o = j12;
        this.f16531d = str4;
        this.f16532e = j10;
        this.f16533f = j11;
        this.f16534l = str5;
        this.f16535m = z10;
        this.f16536n = z11;
        this.f16538p = str6;
        this.f16539q = j13;
        this.f16540r = i10;
        this.f16541s = z12;
        this.f16542t = z13;
        this.f16543u = str7;
        this.f16544v = bool;
        this.f16545w = j14;
        this.f16546x = list;
        this.f16547y = str8;
        this.f16548z = str9;
        this.A = str10;
        this.B = str11;
        this.C = z14;
        this.D = j15;
        this.E = i11;
        this.F = str12;
        this.G = i12;
        this.H = j16;
        this.I = str13;
        this.J = str14;
        this.K = j17;
        this.L = i13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 2, this.f16528a, false);
        d4.c.E(parcel, 3, this.f16529b, false);
        d4.c.E(parcel, 4, this.f16530c, false);
        d4.c.E(parcel, 5, this.f16531d, false);
        d4.c.x(parcel, 6, this.f16532e);
        d4.c.x(parcel, 7, this.f16533f);
        d4.c.E(parcel, 8, this.f16534l, false);
        d4.c.g(parcel, 9, this.f16535m);
        d4.c.g(parcel, 10, this.f16536n);
        d4.c.x(parcel, 11, this.f16537o);
        d4.c.E(parcel, 12, this.f16538p, false);
        d4.c.x(parcel, 14, this.f16539q);
        d4.c.t(parcel, 15, this.f16540r);
        d4.c.g(parcel, 16, this.f16541s);
        d4.c.g(parcel, 18, this.f16542t);
        d4.c.E(parcel, 19, this.f16543u, false);
        d4.c.i(parcel, 21, this.f16544v, false);
        d4.c.x(parcel, 22, this.f16545w);
        d4.c.G(parcel, 23, this.f16546x, false);
        d4.c.E(parcel, 24, this.f16547y, false);
        d4.c.E(parcel, 25, this.f16548z, false);
        d4.c.E(parcel, 26, this.A, false);
        d4.c.E(parcel, 27, this.B, false);
        d4.c.g(parcel, 28, this.C);
        d4.c.x(parcel, 29, this.D);
        d4.c.t(parcel, 30, this.E);
        d4.c.E(parcel, 31, this.F, false);
        d4.c.t(parcel, 32, this.G);
        d4.c.x(parcel, 34, this.H);
        d4.c.E(parcel, 35, this.I, false);
        d4.c.E(parcel, 36, this.J, false);
        d4.c.x(parcel, 37, this.K);
        d4.c.t(parcel, 38, this.L);
        d4.c.b(parcel, iA);
    }
}
