package w8;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class q0 implements Parcelable.Creator<com.google.firebase.messaging.d> {
    public static void c(com.google.firebase.messaging.d dVar, Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.j(parcel, 2, dVar.f5587a, false);
        d4.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.google.firebase.messaging.d createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        Bundle bundleF = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            if (d4.b.w(iD) != 2) {
                d4.b.L(parcel, iD);
            } else {
                bundleF = d4.b.f(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new com.google.firebase.messaging.d(bundleF);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.google.firebase.messaging.d[] newArray(int i10) {
        return new com.google.firebase.messaging.d[i10];
    }
}
