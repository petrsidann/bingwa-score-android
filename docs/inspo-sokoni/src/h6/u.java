package h6;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class u extends a implements w {
    public u(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h6.w
    public final void M(Bundle bundle, y yVar) {
        Parcel parcelB = b();
        q.c(parcelB, bundle);
        parcelB.writeStrongBinder(yVar);
        f(2, parcelB);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h6.w
    public final void d0(Bundle bundle, y yVar) {
        Parcel parcelB = b();
        q.c(parcelB, bundle);
        parcelB.writeStrongBinder(yVar);
        f(3, parcelB);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h6.w
    public final void h(Bundle bundle, f0 f0Var) {
        Parcel parcelB = b();
        q.c(parcelB, bundle);
        parcelB.writeStrongBinder(f0Var);
        f(6, parcelB);
    }
}
