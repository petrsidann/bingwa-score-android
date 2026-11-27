package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class x extends c0 {
    public static final Parcelable.Creator<x> CREATOR = new x0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f14802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f14804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f14805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e0 f14806f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h1 f14807l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f14808m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Long f14809n;

    public x(byte[] bArr, Double d10, String str, List list, Integer num, e0 e0Var, String str2, d dVar, Long l10) {
        this.f14801a = (byte[]) com.google.android.gms.common.internal.r.l(bArr);
        this.f14802b = d10;
        this.f14803c = (String) com.google.android.gms.common.internal.r.l(str);
        this.f14804d = list;
        this.f14805e = num;
        this.f14806f = e0Var;
        this.f14809n = l10;
        if (str2 != null) {
            try {
                this.f14807l = h1.d(str2);
            } catch (g1 e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            this.f14807l = null;
        }
        this.f14808m = dVar;
    }

    public List<v> S() {
        return this.f14804d;
    }

    public d T() {
        return this.f14808m;
    }

    public byte[] U() {
        return this.f14801a;
    }

    public Integer V() {
        return this.f14805e;
    }

    public String W() {
        return this.f14803c;
    }

    public Double X() {
        return this.f14802b;
    }

    public e0 Y() {
        return this.f14806f;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Arrays.equals(this.f14801a, xVar.f14801a) && com.google.android.gms.common.internal.p.b(this.f14802b, xVar.f14802b) && com.google.android.gms.common.internal.p.b(this.f14803c, xVar.f14803c) && (((list = this.f14804d) == null && xVar.f14804d == null) || (list != null && (list2 = xVar.f14804d) != null && list.containsAll(list2) && xVar.f14804d.containsAll(this.f14804d))) && com.google.android.gms.common.internal.p.b(this.f14805e, xVar.f14805e) && com.google.android.gms.common.internal.p.b(this.f14806f, xVar.f14806f) && com.google.android.gms.common.internal.p.b(this.f14807l, xVar.f14807l) && com.google.android.gms.common.internal.p.b(this.f14808m, xVar.f14808m) && com.google.android.gms.common.internal.p.b(this.f14809n, xVar.f14809n);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(Integer.valueOf(Arrays.hashCode(this.f14801a)), this.f14802b, this.f14803c, this.f14804d, this.f14805e, this.f14806f, this.f14807l, this.f14808m, this.f14809n);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.k(parcel, 2, U(), false);
        d4.c.o(parcel, 3, X(), false);
        d4.c.E(parcel, 4, W(), false);
        d4.c.I(parcel, 5, S(), false);
        d4.c.w(parcel, 6, V(), false);
        d4.c.C(parcel, 7, Y(), i10, false);
        h1 h1Var = this.f14807l;
        d4.c.E(parcel, 8, h1Var == null ? null : h1Var.toString(), false);
        d4.c.C(parcel, 9, T(), i10, false);
        d4.c.z(parcel, 10, this.f14809n, false);
        d4.c.b(parcel, iA);
    }
}
