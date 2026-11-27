package p7;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzbg;
import com.google.android.gms.internal.p002firebaseauthapi.zzbj;
import com.google.android.gms.internal.p002firebaseauthapi.zzbz;
import com.google.android.gms.internal.p002firebaseauthapi.zzke;
import com.google.android.gms.internal.p002firebaseauthapi.zzkh;
import com.google.android.gms.internal.p002firebaseauthapi.zzkq;
import com.google.android.gms.internal.p002firebaseauthapi.zzmi;
import com.google.android.gms.internal.p002firebaseauthapi.zzp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class y1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static y1 f14340c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzmi f14342b;

    public y1(Context context, String str, boolean z10) {
        zzmi zzmiVarZza;
        this.f14341a = str;
        try {
            zzke.zza();
            zzmi.zza zzaVarZza = new zzmi.zza().zza(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", str)).zza(zzkq.zza);
            zzaVarZza.zza(String.format("android-keystore://firebear_master_key_id.%s", str));
            zzmiVarZza = zzaVarZza.zza();
        } catch (IOException | GeneralSecurityException e10) {
            Log.e("FirebearCryptoHelper", "Exception encountered during crypto setup:\n" + e10.getMessage());
            zzmiVarZza = null;
        }
        this.f14342b = zzmiVarZza;
    }

    public static y1 c(Context context, String str) {
        y1 y1Var = f14340c;
        if (y1Var == null || !zzp.zza(y1Var.f14341a, str)) {
            f14340c = new y1(context, str, true);
        }
        return f14340c;
    }

    public final String a() {
        if (this.f14342b == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zzbz zzbzVarZza = zzbg.zza(byteArrayOutputStream);
        try {
            synchronized (this.f14342b) {
                this.f14342b.zza().zza().zza(zzbzVarZza);
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e10) {
            Log.e("FirebearCryptoHelper", "Exception encountered when attempting to get Public Key:\n" + e10.getMessage());
            return null;
        }
    }

    public final String b(String str) {
        String str2;
        zzmi zzmiVar = this.f14342b;
        if (zzmiVar == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
            return null;
        }
        try {
            synchronized (zzmiVar) {
                str2 = new String(((zzbj) this.f14342b.zza().zza(zzkh.zza(), zzbj.class)).zza(Base64.decode(str, 8), null), "UTF-8");
            }
            return str2;
        } catch (UnsupportedEncodingException | GeneralSecurityException e10) {
            Log.e("FirebearCryptoHelper", "Exception encountered while decrypting bytes:\n" + e10.getMessage());
            return null;
        }
    }
}
