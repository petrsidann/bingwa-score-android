package kb;

import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class b implements fb.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FirebaseAuth f12183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FirebaseAuth.a f12184b;

    public b(FirebaseAuth firebaseAuth) {
        this.f12183a = firebaseAuth;
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
        FirebaseAuth.a aVar = this.f12184b;
        if (aVar != null) {
            this.f12183a.s(aVar);
            this.f12184b = null;
        }
    }

    @Override // fb.c.d
    public void onListen(Object obj, final fb.c.b bVar) {
        final HashMap map = new HashMap();
        map.put("appName", this.f12183a.l().q());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        FirebaseAuth.a aVar = new FirebaseAuth.a() { // from class: kb.a
            @Override // com.google.firebase.auth.FirebaseAuth.a
            public final void a(FirebaseAuth firebaseAuth) {
                b.b(atomicBoolean, map, bVar, firebaseAuth);
            }
        };
        this.f12184b = aVar;
        this.f12183a.d(aVar);
    }
}
