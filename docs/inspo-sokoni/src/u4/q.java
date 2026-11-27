package u4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class q extends d4.a {
    public static final Parcelable.Creator<q> CREATOR = new p();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f16722a;

    public q(Bundle bundle) {
        this.f16722a = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.j(parcel, 1, this.f16722a, false);
        d4.c.b(parcel, iA);
    }
}
