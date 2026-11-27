package c4;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.u0;
import com.google.android.gms.common.internal.y1;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class x extends y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3397a;

    public x(byte[] bArr) {
        com.google.android.gms.common.internal.r.a(bArr.length == 25);
        this.f3397a = Arrays.hashCode(bArr);
    }

    public static byte[] f(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public final boolean equals(Object obj) {
        m4.a aVarZzd;
        if (obj != null && (obj instanceof u0)) {
            try {
                u0 u0Var = (u0) obj;
                if (u0Var.zzc() == this.f3397a && (aVarZzd = u0Var.zzd()) != null) {
                    return Arrays.equals(i(), (byte[]) m4.b.f(aVarZzd));
                }
                return false;
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f3397a;
    }

    public abstract byte[] i();

    @Override // com.google.android.gms.common.internal.u0
    public final int zzc() {
        return this.f3397a;
    }

    @Override // com.google.android.gms.common.internal.u0
    public final m4.a zzd() {
        return m4.b.i(i());
    }
}
