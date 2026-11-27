package p7;

import com.google.android.gms.internal.p002firebaseauthapi.zzzp;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f4.a f14282a = new f4.a("GetTokenResultFactory", new String[0]);

    public static o7.c0 a(String str) {
        Map map;
        try {
            map = l0.b(str);
        } catch (zzzp e10) {
            f14282a.b("Error parsing token claims", e10, new Object[0]);
            map = new HashMap();
        }
        return new o7.c0(str, map);
    }
}
