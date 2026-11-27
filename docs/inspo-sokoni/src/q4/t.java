package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class t extends d4.a {
    public static final Parcelable.Creator<t> CREATOR = new u0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f14779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f14780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f14781f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f14782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f14783m;

    public t(String str, String str2, byte[] bArr, h hVar, g gVar, i iVar, e eVar, String str3) {
        boolean z10 = true;
        if ((hVar == null || gVar != null || iVar != null) && ((hVar != null || gVar == null || iVar != null) && (hVar != null || gVar != null || iVar == null))) {
            z10 = false;
        }
        com.google.android.gms.common.internal.r.a(z10);
        this.f14776a = str;
        this.f14777b = str2;
        this.f14778c = bArr;
        this.f14779d = hVar;
        this.f14780e = gVar;
        this.f14781f = iVar;
        this.f14782l = eVar;
        this.f14783m = str3;
    }

    public String S() {
        return this.f14783m;
    }

    public e T() {
        return this.f14782l;
    }

    public String U() {
        return this.f14776a;
    }

    public byte[] V() {
        return this.f14778c;
    }

    public String W() {
        return this.f14777b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return com.google.android.gms.common.internal.p.b(this.f14776a, tVar.f14776a) && com.google.android.gms.common.internal.p.b(this.f14777b, tVar.f14777b) && Arrays.equals(this.f14778c, tVar.f14778c) && com.google.android.gms.common.internal.p.b(this.f14779d, tVar.f14779d) && com.google.android.gms.common.internal.p.b(this.f14780e, tVar.f14780e) && com.google.android.gms.common.internal.p.b(this.f14781f, tVar.f14781f) && com.google.android.gms.common.internal.p.b(this.f14782l, tVar.f14782l) && com.google.android.gms.common.internal.p.b(this.f14783m, tVar.f14783m);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14776a, this.f14777b, this.f14778c, this.f14780e, this.f14779d, this.f14781f, this.f14782l, this.f14783m);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, U(), false);
        d4.c.E(parcel, 2, W(), false);
        d4.c.k(parcel, 3, V(), false);
        d4.c.C(parcel, 4, this.f14779d, i10, false);
        d4.c.C(parcel, 5, this.f14780e, i10, false);
        d4.c.C(parcel, 6, this.f14781f, i10, false);
        d4.c.C(parcel, 7, T(), i10, false);
        d4.c.E(parcel, 8, S(), false);
        d4.c.b(parcel, iA);
    }
}
