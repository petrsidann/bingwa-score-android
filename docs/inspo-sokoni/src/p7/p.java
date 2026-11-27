package p7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class p extends o7.l0 {
    public static final Parcelable.Creator<p> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<o7.r0> f14299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<o7.x0> f14300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f14301e;

    public p() {
    }

    public p(String str, String str2, List<o7.r0> list, List<o7.x0> list2, i iVar) {
        this.f14297a = str;
        this.f14298b = str2;
        this.f14299c = list;
        this.f14300d = list2;
        this.f14301e = iVar;
    }

    public static p T(String str, i iVar) {
        com.google.android.gms.common.internal.r.f(str);
        p pVar = new p();
        pVar.f14297a = str;
        pVar.f14301e = iVar;
        return pVar;
    }

    public static p U(List<o7.j0> list, String str) {
        List list2;
        Parcelable parcelable;
        com.google.android.gms.common.internal.r.l(list);
        com.google.android.gms.common.internal.r.f(str);
        p pVar = new p();
        pVar.f14299c = new ArrayList();
        pVar.f14300d = new ArrayList();
        for (o7.j0 j0Var : list) {
            if (j0Var instanceof o7.r0) {
                list2 = pVar.f14299c;
                parcelable = (o7.r0) j0Var;
            } else {
                if (!(j0Var instanceof o7.x0)) {
                    throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: " + j0Var.T());
                }
                list2 = pVar.f14300d;
                parcelable = (o7.x0) j0Var;
            }
            list2.add(parcelable);
        }
        pVar.f14298b = str;
        return pVar;
    }

    public final i S() {
        return this.f14301e;
    }

    public final String V() {
        return this.f14297a;
    }

    public final boolean W() {
        return this.f14297a != null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f14297a, false);
        d4.c.E(parcel, 2, this.f14298b, false);
        d4.c.I(parcel, 3, this.f14299c, false);
        d4.c.I(parcel, 4, this.f14300d, false);
        d4.c.C(parcel, 5, this.f14301e, i10, false);
        d4.c.b(parcel, iA);
    }

    public final String zzc() {
        return this.f14298b;
    }
}
