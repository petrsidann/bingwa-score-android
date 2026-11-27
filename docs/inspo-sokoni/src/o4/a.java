package o4;

import android.app.Activity;
import com.google.android.gms.internal.fido.zzaa;
import com.google.android.gms.internal.fido.zzab;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.g f13649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f13650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzaa f13651c;

    static {
        com.google.android.gms.common.api.a.g gVar = new com.google.android.gms.common.api.a.g();
        f13649a = gVar;
        f13650b = new com.google.android.gms.common.api.a("Fido.U2F_ZERO_PARTY_API", new zzab(), gVar);
        f13651c = new zzaa();
    }

    public static p4.a a(Activity activity) {
        return new p4.a(activity);
    }
}
