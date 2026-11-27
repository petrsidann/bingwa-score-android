package u4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
public final class ab extends r8 {
    public ab(k7 k7Var) {
        super(k7Var);
    }

    public static byte[] q(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 <= 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ h0 c() {
        return super.c();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ s5 d() {
        return super.d();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ i6 e() {
        return super.e();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ ab f() {
        return super.f();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ af g() {
        return super.g();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    @Override // u4.r8
    public final boolean p() {
        return false;
    }

    public final boolean s() {
        NetworkInfo activeNetworkInfo;
        l();
        ConnectivityManager connectivityManager = (ConnectivityManager) zza().getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
                activeNetworkInfo = null;
            }
        } else {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ j4.d zzb() {
        return super.zzb();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ g zzd() {
        return super.zzd();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ v5 zzj() {
        return super.zzj();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ d7 zzl() {
        return super.zzl();
    }
}
