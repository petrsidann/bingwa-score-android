package h6;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class z extends a implements b0 {
    public z(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IIntegrityService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h6.b0
    public final void g1(Bundle bundle, d0 d0Var) {
        Parcel parcelB = b();
        q.c(parcelB, bundle);
        parcelB.writeStrongBinder(d0Var);
        f(2, parcelB);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h6.b0
    public final void h(Bundle bundle, f0 f0Var) {
        Parcel parcelB = b();
        q.c(parcelB, bundle);
        parcelB.writeStrongBinder(f0Var);
        f(3, parcelB);
    }
}
