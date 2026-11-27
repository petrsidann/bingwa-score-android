package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class e extends d4.a {
    public static final Parcelable.Creator<e> CREATOR = new l1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f14695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1 f14696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f14697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q1 f14698d;

    public e(g0 g0Var, o1 o1Var, f fVar, q1 q1Var) {
        this.f14695a = g0Var;
        this.f14696b = o1Var;
        this.f14697c = fVar;
        this.f14698d = q1Var;
    }

    public f S() {
        return this.f14697c;
    }

    public g0 T() {
        return this.f14695a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return com.google.android.gms.common.internal.p.b(this.f14695a, eVar.f14695a) && com.google.android.gms.common.internal.p.b(this.f14696b, eVar.f14696b) && com.google.android.gms.common.internal.p.b(this.f14697c, eVar.f14697c) && com.google.android.gms.common.internal.p.b(this.f14698d, eVar.f14698d);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14695a, this.f14696b, this.f14697c, this.f14698d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 1, T(), i10, false);
        d4.c.C(parcel, 2, this.f14696b, i10, false);
        d4.c.C(parcel, 3, S(), i10, false);
        d4.c.C(parcel, 4, this.f14698d, i10, false);
        d4.c.b(parcel, iA);
    }
}
