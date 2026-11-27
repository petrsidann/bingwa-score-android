package kb;

import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class x2 implements fb.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FirebaseAuth f12298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FirebaseAuth.b f12299b;

    public x2(FirebaseAuth firebaseAuth) {
        this.f12298a = firebaseAuth;
    }

    public static /* synthetic */ void b(AtomicBoolean atomicBoolean, Map map, fb.c.b bVar, FirebaseAuth firebaseAuth) {
        if (atomicBoolean.get()) {
            atomicBoolean.set(false);
            return;
        }
        o7.a0 a0VarM = firebaseAuth.m();
        map.put("user", a0VarM == null ? null : z2.c(z2.j(a0VarM)));
        bVar.a(map);
    }

    @Override // fb.c.d
    public void onCancel(Object obj) {
        FirebaseAuth.b bVar = this.f12299b;
        if (bVar != null) {
            this.f12298a.t(bVar);
            this.f12299b = null;
        }
    }

    @Override // fb.c.d
    public void onListen(Object obj, final fb.c.b bVar) {
        final HashMap map = new HashMap();
        map.put("appName", this.f12298a.l().q());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        FirebaseAuth.b bVar2 = new FirebaseAuth.b() { // from class: kb.w2
            @Override // com.google.firebase.auth.FirebaseAuth.b
            public final void a(FirebaseAuth firebaseAuth) {
                x2.b(atomicBoolean, map, bVar, firebaseAuth);
            }
        };
        this.f12299b = bVar2;
        this.f12298a.e(bVar2);
    }
}
