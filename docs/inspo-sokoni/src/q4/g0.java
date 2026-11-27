package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g0 extends d4.a {
    public static final Parcelable.Creator<g0> CREATOR = new i1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14715a;

    public g0(List list) {
        this.f14715a = list;
    }

    public List<h0> S() {
        return this.f14715a;
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        List list2 = this.f14715a;
        return (list2 == null && g0Var.f14715a == null) || (list2 != null && (list = g0Var.f14715a) != null && list2.containsAll(list) && g0Var.f14715a.containsAll(this.f14715a));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(new HashSet(this.f14715a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.I(parcel, 1, S(), false);
        d4.c.b(parcel, iA);
    }
}
