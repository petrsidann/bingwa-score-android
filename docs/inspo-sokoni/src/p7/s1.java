package p7;

import com.google.android.gms.internal.p002firebaseauthapi.zzaic;

/* JADX INFO: loaded from: classes.dex */
public final class s1 {
    public static zzaic a(o7.h hVar, String str) {
        com.google.android.gms.common.internal.r.l(hVar);
        if (o7.f0.class.isAssignableFrom(hVar.getClass())) {
            return o7.f0.V((o7.f0) hVar, str);
        }
        if (o7.l.class.isAssignableFrom(hVar.getClass())) {
            return o7.l.V((o7.l) hVar, str);
        }
        if (o7.z0.class.isAssignableFrom(hVar.getClass())) {
            return o7.z0.V((o7.z0) hVar, str);
        }
        if (o7.d0.class.isAssignableFrom(hVar.getClass())) {
            return o7.d0.V((o7.d0) hVar, str);
        }
        if (o7.s0.class.isAssignableFrom(hVar.getClass())) {
            return o7.s0.V((o7.s0) hVar, str);
        }
        if (o7.x1.class.isAssignableFrom(hVar.getClass())) {
            return o7.x1.Y((o7.x1) hVar, str);
        }
        throw new IllegalArgumentException("Unsupported credential type.");
    }
}
