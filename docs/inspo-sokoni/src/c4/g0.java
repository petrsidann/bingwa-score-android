package c4;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.y1;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends d4.a {
    public static final Parcelable.Creator<g0> CREATOR = new h0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f3370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3372d;

    public g0(String str, IBinder iBinder, boolean z10, boolean z11) {
        this.f3369a = str;
        y yVar = null;
        if (iBinder != null) {
            try {
                m4.a aVarZzd = y1.b(iBinder).zzd();
                byte[] bArr = aVarZzd == null ? null : (byte[]) m4.b.f(aVarZzd);
                if (bArr != null) {
                    yVar = new y(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e10) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e10);
            }
        }
        this.f3370b = yVar;
        this.f3371c = z10;
        this.f3372d = z11;
    }

    public g0(String str, x xVar, boolean z10, boolean z11) {
        this.f3369a = str;
        this.f3370b = xVar;
        this.f3371c = z10;
        this.f3372d = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.f3369a;
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, str, false);
        x xVar = this.f3370b;
        if (xVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            xVar = null;
        }
        d4.c.s(parcel, 2, xVar, false);
        d4.c.g(parcel, 3, this.f3371c);
        d4.c.g(parcel, 4, this.f3372d);
        d4.c.b(parcel, iA);
    }
}
