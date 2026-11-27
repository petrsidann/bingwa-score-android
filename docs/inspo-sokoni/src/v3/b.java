package v3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d4.a {
    public static final Parcelable.Creator<b> CREATOR = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f17110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0301b f17111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f17115f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f17116l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f17117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C0301b f17118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f17119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f17120d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f17121e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f17122f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f17123g;

        public a() {
            e.a aVarS = e.S();
            aVarS.b(false);
            this.f17117a = aVarS.a();
            C0301b.a aVarS2 = C0301b.S();
            aVarS2.b(false);
            this.f17118b = aVarS2.a();
            d.a aVarS3 = d.S();
            aVarS3.b(false);
            this.f17119c = aVarS3.a();
            c.a aVarS4 = c.S();
            aVarS4.b(false);
            this.f17120d = aVarS4.a();
        }

        public b a() {
            return new b(this.f17117a, this.f17118b, this.f17121e, this.f17122f, this.f17123g, this.f17119c, this.f17120d);
        }

        public a b(boolean z10) {
            this.f17122f = z10;
            return this;
        }

        public a c(C0301b c0301b) {
            this.f17118b = (C0301b) com.google.android.gms.common.internal.r.l(c0301b);
            return this;
        }

        public a d(c cVar) {
            this.f17120d = (c) com.google.android.gms.common.internal.r.l(cVar);
            return this;
        }

        @Deprecated
        public a e(d dVar) {
            this.f17119c = (d) com.google.android.gms.common.internal.r.l(dVar);
            return this;
        }

        public a f(e eVar) {
            this.f17117a = (e) com.google.android.gms.common.internal.r.l(eVar);
            return this;
        }

        public final a g(String str) {
            this.f17121e = str;
            return this;
        }

        public final a h(int i10) {
            this.f17123g = i10;
            return this;
        }
    }

    /* JADX INFO: renamed from: v3.b$b, reason: collision with other inner class name */
    public static final class C0301b extends d4.a {
        public static final Parcelable.Creator<C0301b> CREATOR = new w();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f17124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f17126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f17127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f17128e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f17129f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f17130l;

        /* JADX INFO: renamed from: v3.b$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f17131a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f17132b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f17133c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f17134d = true;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f17135e = null;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public List f17136f = null;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public boolean f17137g = false;

            public C0301b a() {
                return new C0301b(this.f17131a, this.f17132b, this.f17133c, this.f17134d, this.f17135e, this.f17136f, this.f17137g);
            }

            public a b(boolean z10) {
                this.f17131a = z10;
                return this;
            }
        }

        public C0301b(boolean z10, String str, String str2, boolean z11, String str3, List list, boolean z12) {
            boolean z13 = true;
            if (z11 && z12) {
                z13 = false;
            }
            com.google.android.gms.common.internal.r.b(z13, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.f17124a = z10;
            if (z10) {
                com.google.android.gms.common.internal.r.m(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.f17125b = str;
            this.f17126c = str2;
            this.f17127d = z11;
            Parcelable.Creator<b> creator = b.CREATOR;
            ArrayList arrayList = null;
            if (list != null && !list.isEmpty()) {
                arrayList = new ArrayList(list);
                Collections.sort(arrayList);
            }
            this.f17129f = arrayList;
            this.f17128e = str3;
            this.f17130l = z12;
        }

        public static a S() {
            return new a();
        }

        public boolean T() {
            return this.f17127d;
        }

        public List<String> U() {
            return this.f17129f;
        }

        public String V() {
            return this.f17128e;
        }

        public String W() {
            return this.f17126c;
        }

        public String X() {
            return this.f17125b;
        }

        public boolean Y() {
            return this.f17124a;
        }

        @Deprecated
        public boolean Z() {
            return this.f17130l;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0301b)) {
                return false;
            }
            C0301b c0301b = (C0301b) obj;
            return this.f17124a == c0301b.f17124a && com.google.android.gms.common.internal.p.b(this.f17125b, c0301b.f17125b) && com.google.android.gms.common.internal.p.b(this.f17126c, c0301b.f17126c) && this.f17127d == c0301b.f17127d && com.google.android.gms.common.internal.p.b(this.f17128e, c0301b.f17128e) && com.google.android.gms.common.internal.p.b(this.f17129f, c0301b.f17129f) && this.f17130l == c0301b.f17130l;
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.p.c(Boolean.valueOf(this.f17124a), this.f17125b, this.f17126c, Boolean.valueOf(this.f17127d), this.f17128e, this.f17129f, Boolean.valueOf(this.f17130l));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int iA = d4.c.a(parcel);
            d4.c.g(parcel, 1, Y());
            d4.c.E(parcel, 2, X(), false);
            d4.c.E(parcel, 3, W(), false);
            d4.c.g(parcel, 4, T());
            d4.c.E(parcel, 5, V(), false);
            d4.c.G(parcel, 6, U(), false);
            d4.c.g(parcel, 7, Z());
            d4.c.b(parcel, iA);
        }
    }

    public static final class c extends d4.a {
        public static final Parcelable.Creator<c> CREATOR = new x();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f17138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17139b;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f17140a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f17141b;

            public c a() {
                return new c(this.f17140a, this.f17141b);
            }

            public a b(boolean z10) {
                this.f17140a = z10;
                return this;
            }
        }

        public c(boolean z10, String str) {
            if (z10) {
                com.google.android.gms.common.internal.r.l(str);
            }
            this.f17138a = z10;
            this.f17139b = str;
        }

        public static a S() {
            return new a();
        }

        public String T() {
            return this.f17139b;
        }

        public boolean U() {
            return this.f17138a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f17138a == cVar.f17138a && com.google.android.gms.common.internal.p.b(this.f17139b, cVar.f17139b);
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.p.c(Boolean.valueOf(this.f17138a), this.f17139b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int iA = d4.c.a(parcel);
            d4.c.g(parcel, 1, U());
            d4.c.E(parcel, 2, T(), false);
            d4.c.b(parcel, iA);
        }
    }

    @Deprecated
    public static final class d extends d4.a {
        public static final Parcelable.Creator<d> CREATOR = new y();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f17142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f17143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f17144c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f17145a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public byte[] f17146b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f17147c;

            public d a() {
                return new d(this.f17145a, this.f17146b, this.f17147c);
            }

            public a b(boolean z10) {
                this.f17145a = z10;
                return this;
            }
        }

        public d(boolean z10, byte[] bArr, String str) {
            if (z10) {
                com.google.android.gms.common.internal.r.l(bArr);
                com.google.android.gms.common.internal.r.l(str);
            }
            this.f17142a = z10;
            this.f17143b = bArr;
            this.f17144c = str;
        }

        public static a S() {
            return new a();
        }

        public byte[] T() {
            return this.f17143b;
        }

        public String U() {
            return this.f17144c;
        }

        public boolean V() {
            return this.f17142a;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f17142a == dVar.f17142a && Arrays.equals(this.f17143b, dVar.f17143b) && ((str = this.f17144c) == (str2 = dVar.f17144c) || (str != null && str.equals(str2)));
        }

        public int hashCode() {
            return (Arrays.hashCode(new Object[]{Boolean.valueOf(this.f17142a), this.f17144c}) * 31) + Arrays.hashCode(this.f17143b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int iA = d4.c.a(parcel);
            d4.c.g(parcel, 1, V());
            d4.c.k(parcel, 2, T(), false);
            d4.c.E(parcel, 3, U(), false);
            d4.c.b(parcel, iA);
        }
    }

    public static final class e extends d4.a {
        public static final Parcelable.Creator<e> CREATOR = new z();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f17148a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f17149a = false;

            public e a() {
                return new e(this.f17149a);
            }

            public a b(boolean z10) {
                this.f17149a = z10;
                return this;
            }
        }

        public e(boolean z10) {
            this.f17148a = z10;
        }

        public static a S() {
            return new a();
        }

        public boolean T() {
            return this.f17148a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof e) && this.f17148a == ((e) obj).f17148a;
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.p.c(Boolean.valueOf(this.f17148a));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int iA = d4.c.a(parcel);
            d4.c.g(parcel, 1, T());
            d4.c.b(parcel, iA);
        }
    }

    public b(e eVar, C0301b c0301b, String str, boolean z10, int i10, d dVar, c cVar) {
        this.f17110a = (e) com.google.android.gms.common.internal.r.l(eVar);
        this.f17111b = (C0301b) com.google.android.gms.common.internal.r.l(c0301b);
        this.f17112c = str;
        this.f17113d = z10;
        this.f17114e = i10;
        if (dVar == null) {
            d.a aVarS = d.S();
            aVarS.b(false);
            dVar = aVarS.a();
        }
        this.f17115f = dVar;
        if (cVar == null) {
            c.a aVarS2 = c.S();
            aVarS2.b(false);
            cVar = aVarS2.a();
        }
        this.f17116l = cVar;
    }

    public static a S() {
        return new a();
    }

    public static a Y(b bVar) {
        com.google.android.gms.common.internal.r.l(bVar);
        a aVarS = S();
        aVarS.c(bVar.T());
        aVarS.f(bVar.W());
        aVarS.e(bVar.V());
        aVarS.d(bVar.U());
        aVarS.b(bVar.f17113d);
        aVarS.h(bVar.f17114e);
        String str = bVar.f17112c;
        if (str != null) {
            aVarS.g(str);
        }
        return aVarS;
    }

    public C0301b T() {
        return this.f17111b;
    }

    public c U() {
        return this.f17116l;
    }

    public d V() {
        return this.f17115f;
    }

    public e W() {
        return this.f17110a;
    }

    public boolean X() {
        return this.f17113d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return com.google.android.gms.common.internal.p.b(this.f17110a, bVar.f17110a) && com.google.android.gms.common.internal.p.b(this.f17111b, bVar.f17111b) && com.google.android.gms.common.internal.p.b(this.f17115f, bVar.f17115f) && com.google.android.gms.common.internal.p.b(this.f17116l, bVar.f17116l) && com.google.android.gms.common.internal.p.b(this.f17112c, bVar.f17112c) && this.f17113d == bVar.f17113d && this.f17114e == bVar.f17114e;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f17110a, this.f17111b, this.f17115f, this.f17116l, this.f17112c, Boolean.valueOf(this.f17113d));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 1, W(), i10, false);
        d4.c.C(parcel, 2, T(), i10, false);
        d4.c.E(parcel, 3, this.f17112c, false);
        d4.c.g(parcel, 4, X());
        d4.c.t(parcel, 5, this.f17114e);
        d4.c.C(parcel, 6, V(), i10, false);
        d4.c.C(parcel, 7, U(), i10, false);
        d4.c.b(parcel, iA);
    }
}
