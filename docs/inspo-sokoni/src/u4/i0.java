package u4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class i0 extends d4.a implements Iterable<String> {
    public static final Parcelable.Creator<i0> CREATOR = new k0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f16326a;

    public i0(Bundle bundle) {
        this.f16326a = bundle;
    }

    public final int S() {
        return this.f16326a.size();
    }

    public final Double U(String str) {
        return Double.valueOf(this.f16326a.getDouble(str));
    }

    public final Bundle V() {
        return new Bundle(this.f16326a);
    }

    public final Long W(String str) {
        return Long.valueOf(this.f16326a.getLong(str));
    }

    public final Object X(String str) {
        return this.f16326a.get(str);
    }

    public final String Y(String str) {
        return this.f16326a.getString(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new l0(this);
    }

    public final String toString() {
        return this.f16326a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.j(parcel, 2, V(), false);
        d4.c.b(parcel, iA);
    }
}
