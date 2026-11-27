package p7;

import com.google.android.gms.internal.p002firebaseauthapi.zzahg;

/* JADX INFO: loaded from: classes.dex */
public final class c2 implements o7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o7.b f14193d;

    public c2(zzahg zzahgVar) {
        this.f14191b = zzahgVar.zzg() ? zzahgVar.zzc() : zzahgVar.zzb();
        this.f14192c = zzahgVar.zzb();
        o7.b a2Var = null;
        if (!zzahgVar.zzh()) {
            this.f14190a = 3;
            this.f14193d = null;
            return;
        }
        String strZzd = zzahgVar.zzd();
        strZzd.hashCode();
        int i10 = 5;
        switch (strZzd) {
            case "REVERT_SECOND_FACTOR_ADDITION":
                i10 = 6;
                break;
            case "PASSWORD_RESET":
                i10 = 0;
                break;
            case "VERIFY_EMAIL":
                i10 = 1;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                break;
            case "EMAIL_SIGNIN":
                i10 = 4;
                break;
            case "RECOVER_EMAIL":
                i10 = 2;
                break;
            default:
                i10 = 3;
                break;
        }
        this.f14190a = i10;
        if (i10 == 4 || i10 == 3) {
            this.f14193d = null;
            return;
        }
        if (zzahgVar.zzf()) {
            a2Var = new d2(zzahgVar.zzb(), o0.b(zzahgVar.zza()));
        } else if (zzahgVar.zzg()) {
            a2Var = new b2(zzahgVar.zzc(), zzahgVar.zzb());
        } else if (zzahgVar.zze()) {
            a2Var = new a2(zzahgVar.zzb());
        }
        this.f14193d = a2Var;
    }

    @Override // o7.d
    public final int a() {
        return this.f14190a;
    }

    @Override // o7.d
    public final o7.b b() {
        return this.f14193d;
    }
}
