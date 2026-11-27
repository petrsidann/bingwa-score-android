package kb;

import android.app.Activity;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class y2 implements fb.c.d {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final HashMap<Integer, com.google.firebase.auth.b.a> f12303p = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Activity> f12304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FirebaseAuth f12305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o7.r0 f12307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f12309f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final o7.l0 f12310l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f12311m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f12312n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public fb.c.b f12313o;

    public class a extends com.google.firebase.auth.b.AbstractC0099b {
        public a() {
        }

        @Override // com.google.firebase.auth.b.AbstractC0099b
        public void onCodeAutoRetrievalTimeOut(String str) {
            HashMap map = new HashMap();
            map.put("verificationId", str);
            map.put("name", "Auth#phoneCodeAutoRetrievalTimeout");
            if (y2.this.f12313o != null) {
                y2.this.f12313o.a(map);
            }
        }

        @Override // com.google.firebase.auth.b.AbstractC0099b
        public void onCodeSent(String str, com.google.firebase.auth.b.a aVar) {
            int iHashCode = aVar.hashCode();
            y2.f12303p.put(Integer.valueOf(iHashCode), aVar);
            HashMap map = new HashMap();
            map.put("verificationId", str);
            map.put("forceResendingToken", Integer.valueOf(iHashCode));
            map.put("name", "Auth#phoneCodeSent");
            if (y2.this.f12313o != null) {
                y2.this.f12313o.a(map);
            }
        }

        @Override // com.google.firebase.auth.b.AbstractC0099b
        public void onVerificationCompleted(o7.o0 o0Var) {
            int iHashCode = o0Var.hashCode();
            y2.this.f12309f.a(o0Var);
            HashMap map = new HashMap();
            map.put("token", Integer.valueOf(iHashCode));
            if (o0Var.V() != null) {
                map.put("smsCode", o0Var.V());
            }
            map.put("name", "Auth#phoneVerificationCompleted");
            if (y2.this.f12313o != null) {
                y2.this.f12313o.a(map);
            }
        }

        @Override // com.google.firebase.auth.b.AbstractC0099b
        public void onVerificationFailed(h7.l lVar) {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            a1.g gVarE = v.e(lVar);
            map2.put("code", gVarE.f12075a.replaceAll("ERROR_", "").toLowerCase(Locale.ROOT).replaceAll("_", "-"));
            map2.put("message", gVarE.getMessage());
            map2.put("details", gVarE.f12076b);
            map.put("error", map2);
            map.put("name", "Auth#phoneVerificationFailed");
            if (y2.this.f12313o != null) {
                y2.this.f12313o.a(map);
            }
        }
    }

    public interface b {
        void a(o7.o0 o0Var);
    }

    public y2(Activity activity, a1.b bVar, a1.e0 e0Var, o7.l0 l0Var, o7.r0 r0Var, b bVar2) {
        AtomicReference<Activity> atomicReference = new AtomicReference<>(null);
        this.f12304a = atomicReference;
        atomicReference.set(activity);
        this.f12310l = l0Var;
        this.f12307d = r0Var;
        this.f12305b = u.K0(bVar);
        this.f12306c = e0Var.f();
        this.f12308e = Math.toIntExact(e0Var.g().longValue());
        if (e0Var.b() != null) {
            this.f12311m = e0Var.b();
        }
        if (e0Var.c() != null) {
            this.f12312n = Integer.valueOf(Math.toIntExact(e0Var.c().longValue()));
        }
        this.f12309f = bVar2;
    }

    @Override // fb.c.d
    public void onCancel(Object obj) {
        this.f12313o = null;
        this.f12304a.set(null);
    }

    @Override // fb.c.d
    public void onListen(Object obj, fb.c.b bVar) {
        com.google.firebase.auth.b.a aVar;
        this.f12313o = bVar;
        a aVar2 = new a();
        if (this.f12311m != null) {
            this.f12305b.o().c(this.f12306c, this.f12311m);
        }
        com.google.firebase.auth.a.C0098a c0098a = new com.google.firebase.auth.a.C0098a(this.f12305b);
        c0098a.b(this.f12304a.get());
        c0098a.c(aVar2);
        String str = this.f12306c;
        if (str != null) {
            c0098a.g(str);
        }
        o7.l0 l0Var = this.f12310l;
        if (l0Var != null) {
            c0098a.f(l0Var);
        }
        o7.r0 r0Var = this.f12307d;
        if (r0Var != null) {
            c0098a.e(r0Var);
        }
        c0098a.h(Long.valueOf(this.f12308e), TimeUnit.MILLISECONDS);
        Integer num = this.f12312n;
        if (num != null && (aVar = f12303p.get(num)) != null) {
            c0098a.d(aVar);
        }
        com.google.firebase.auth.b.b(c0098a.a());
    }
}
