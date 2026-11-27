package v3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class i extends d4.a {
    public static final Parcelable.Creator<i> CREATOR = new c0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f17165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17167c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f17168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f17170c;

        public i a() {
            return new i(this.f17168a, this.f17169b, this.f17170c);
        }

        public a b(m mVar) {
            this.f17168a = mVar;
            return this;
        }

        public final a c(String str) {
            this.f17169b = str;
            return this;
        }

        public final a d(int i10) {
            this.f17170c = i10;
            return this;
        }
    }

    public i(m mVar, String str, int i10) {
        this.f17165a = (m) com.google.android.gms.common.internal.r.l(mVar);
        this.f17166b = str;
        this.f17167c = i10;
    }

    public static a S() {
        return new a();
    }

    public static a U(i iVar) {
        com.google.android.gms.common.internal.r.l(iVar);
        a aVarS = S();
        aVarS.b(iVar.T());
        aVarS.d(iVar.f17167c);
        String str = iVar.f17166b;
        if (str != null) {
            aVarS.c(str);
        }
        return aVarS;
    }

    public m T() {
        return this.f17165a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return com.google.android.gms.common.internal.p.b(this.f17165a, iVar.f17165a) && com.google.android.gms.common.internal.p.b(this.f17166b, iVar.f17166b) && this.f17167c == iVar.f17167c;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f17165a, this.f17166b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 1, T(), i10, false);
        d4.c.E(parcel, 2, this.f17166b, false);
        d4.c.t(parcel, 3, this.f17167c);
        d4.c.b(parcel, iA);
    }
}
