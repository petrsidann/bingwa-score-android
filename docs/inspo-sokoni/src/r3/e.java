package r3;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.auth.zza;
import com.google.android.gms.internal.auth.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class e extends zza implements g {
    public e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // r3.g
    public final void H0(d dVar, String str) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, dVar);
        parcelZza.writeString(str);
        zzc(2, parcelZza);
    }

    @Override // r3.g
    public final void Q0(boolean z10) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, z10);
        zzc(1, parcelZza);
    }

    @Override // r3.g
    public final void t(d dVar, Account account) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, dVar);
        zzc.zzd(parcelZza, account);
        zzc(3, parcelZza);
    }
}
