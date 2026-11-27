package v3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class f extends d4.a {
    public static final Parcelable.Creator<f> CREATOR = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17157f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17161d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f17162e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f17163f;

        public f a() {
            return new f(this.f17158a, this.f17159b, this.f17160c, this.f17161d, this.f17162e, this.f17163f);
        }

        public a b(String str) {
            this.f17159b = str;
            return this;
        }

        public a c(String str) {
            this.f17161d = str;
            return this;
        }

        @Deprecated
        public a d(boolean z10) {
            this.f17162e = z10;
            return this;
        }

        public a e(String str) {
            com.google.android.gms.common.internal.r.l(str);
            this.f17158a = str;
            return this;
        }

        public final a f(String str) {
            this.f17160c = str;
            return this;
        }

        public final a g(int i10) {
            this.f17163f = i10;
            return this;
        }
    }

    public f(String str, String str2, String str3, String str4, boolean z10, int i10) {
        com.google.android.gms.common.internal.r.l(str);
        this.f17152a = str;
        this.f17153b = str2;
        this.f17154c = str3;
        this.f17155d = str4;
        this.f17156e = z10;
        this.f17157f = i10;
    }

    public static a S() {
        return new a();
    }

    public static a X(f fVar) {
        com.google.android.gms.common.internal.r.l(fVar);
        a aVarS = S();
        aVarS.e(fVar.V());
        aVarS.c(fVar.U());
        aVarS.b(fVar.T());
        aVarS.d(fVar.f17156e);
        aVarS.g(fVar.f17157f);
        String str = fVar.f17154c;
        if (str != null) {
            aVarS.f(str);
        }
        return aVarS;
    }

    public String T() {
        return this.f17153b;
    }

    public String U() {
        return this.f17155d;
    }

    public String V() {
        return this.f17152a;
    }

    @Deprecated
    public boolean W() {
        return this.f17156e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return com.google.android.gms.common.internal.p.b(this.f17152a, fVar.f17152a) && com.google.android.gms.common.internal.p.b(this.f17155d, fVar.f17155d) && com.google.android.gms.common.internal.p.b(this.f17153b, fVar.f17153b) && com.google.android.gms.common.internal.p.b(Boolean.valueOf(this.f17156e), Boolean.valueOf(fVar.f17156e)) && this.f17157f == fVar.f17157f;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f17152a, this.f17153b, this.f17155d, Boolean.valueOf(this.f17156e), Integer.valueOf(this.f17157f));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, V(), false);
        d4.c.E(parcel, 2, T(), false);
        d4.c.E(parcel, 3, this.f17154c, false);
        d4.c.E(parcel, 4, U(), false);
        d4.c.g(parcel, 5, W());
        d4.c.t(parcel, 6, this.f17157f);
        d4.c.b(parcel, iA);
    }
}
