package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class k extends d4.a {
    public static final Parcelable.Creator<k> CREATOR = new v1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f14732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f14733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h1 f14734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f14735d;

    public k(String str, Boolean bool, String str2, String str3) {
        b bVarD;
        d0 d0VarD = null;
        if (str == null) {
            bVarD = null;
        } else {
            try {
                bVarD = b.d(str);
            } catch (b.a | d0.a | g1 e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        this.f14732a = bVarD;
        this.f14733b = bool;
        this.f14734c = str2 == null ? null : h1.d(str2);
        if (str3 != null) {
            d0VarD = d0.d(str3);
        }
        this.f14735d = d0VarD;
    }

    public String S() {
        b bVar = this.f14732a;
        if (bVar == null) {
            return null;
        }
        return bVar.toString();
    }

    public Boolean T() {
        return this.f14733b;
    }

    public d0 U() {
        d0 d0Var = this.f14735d;
        if (d0Var != null) {
            return d0Var;
        }
        Boolean bool = this.f14733b;
        if (bool == null || !bool.booleanValue()) {
            return null;
        }
        return d0.RESIDENT_KEY_REQUIRED;
    }

    public String V() {
        if (U() == null) {
            return null;
        }
        return U().toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return com.google.android.gms.common.internal.p.b(this.f14732a, kVar.f14732a) && com.google.android.gms.common.internal.p.b(this.f14733b, kVar.f14733b) && com.google.android.gms.common.internal.p.b(this.f14734c, kVar.f14734c) && com.google.android.gms.common.internal.p.b(U(), kVar.U());
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14732a, this.f14733b, this.f14734c, U());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 2, S(), false);
        d4.c.i(parcel, 3, T(), false);
        h1 h1Var = this.f14734c;
        d4.c.E(parcel, 4, h1Var == null ? null : h1Var.toString(), false);
        d4.c.E(parcel, 5, V(), false);
        d4.c.b(parcel, iA);
    }
}
