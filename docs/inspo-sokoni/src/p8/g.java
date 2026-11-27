package p8;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import q7.w;

/* JADX INFO: loaded from: classes.dex */
public class g implements h {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f14364m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ThreadFactory f14365n = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h7.f f14366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s8.c f14367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r8.c f14368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f14369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w<r8.b> f14370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f14371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f14372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ExecutorService f14373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f14374i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f14375j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set<q8.a> f14376k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<o> f14377l;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f14378a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f14378a.getAndIncrement())));
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14380b;

        static {
            int[] iArr = new int[s8.f.b.values().length];
            f14380b = iArr;
            try {
                iArr[s8.f.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14380b[s8.f.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14380b[s8.f.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[s8.d.b.values().length];
            f14379a = iArr2;
            try {
                iArr2[s8.d.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14379a[s8.d.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public g(final h7.f fVar, o8.b<m8.i> bVar, ExecutorService executorService, Executor executor) {
        this(executorService, executor, fVar, new s8.c(fVar.m(), bVar), new r8.c(fVar), p.c(), new w(new o8.b() { // from class: p8.d
            @Override // o8.b
            public final Object get() {
                return g.y(fVar);
            }
        }), new n());
    }

    public g(ExecutorService executorService, Executor executor, h7.f fVar, s8.c cVar, r8.c cVar2, p pVar, w<r8.b> wVar, n nVar) {
        this.f14372g = new Object();
        this.f14376k = new HashSet();
        this.f14377l = new ArrayList();
        this.f14366a = fVar;
        this.f14367b = cVar;
        this.f14368c = cVar2;
        this.f14369d = pVar;
        this.f14370e = wVar;
        this.f14371f = nVar;
        this.f14373h = executorService;
        this.f14374i = executor;
    }

    public static g p() {
        return q(h7.f.o());
    }

    public static g q(h7.f fVar) {
        r.b(fVar != null, "Null is not a valid value of FirebaseApp.");
        return (g) fVar.k(h.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        x(false);
    }

    public static /* synthetic */ r8.b y(h7.f fVar) {
        return new r8.b(fVar);
    }

    public final String A(r8.d dVar) {
        if ((!this.f14366a.q().equals("CHIME_ANDROID_SDK") && !this.f14366a.y()) || !dVar.m()) {
            return this.f14371f.a();
        }
        String strF = o().f();
        return TextUtils.isEmpty(strF) ? this.f14371f.a() : strF;
    }

    public final r8.d B(r8.d dVar) throws i {
        s8.d dVarD = this.f14367b.d(l(), dVar.d(), t(), m(), (dVar.d() == null || dVar.d().length() != 11) ? null : o().i());
        int i10 = b.f14379a[dVarD.e().ordinal()];
        if (i10 == 1) {
            return dVar.s(dVarD.c(), dVarD.d(), this.f14369d.b(), dVarD.b().c(), dVarD.b().d());
        }
        if (i10 == 2) {
            return dVar.q("BAD CONFIG");
        }
        throw new i("Firebase Installations Service is unavailable. Please try again later.", i.a.UNAVAILABLE);
    }

    public final void C(Exception exc) {
        synchronized (this.f14372g) {
            Iterator<o> it = this.f14377l.iterator();
            while (it.hasNext()) {
                if (it.next().b(exc)) {
                    it.remove();
                }
            }
        }
    }

    public final void D(r8.d dVar) {
        synchronized (this.f14372g) {
            Iterator<o> it = this.f14377l.iterator();
            while (it.hasNext()) {
                if (it.next().a(dVar)) {
                    it.remove();
                }
            }
        }
    }

    public final synchronized void E(String str) {
        this.f14375j = str;
    }

    public final synchronized void F(r8.d dVar, r8.d dVar2) {
        if (this.f14376k.size() != 0 && !TextUtils.equals(dVar.d(), dVar2.d())) {
            Iterator<q8.a> it = this.f14376k.iterator();
            while (it.hasNext()) {
                it.next().a(dVar2.d());
            }
        }
    }

    @Override // p8.h
    public Task<m> a(final boolean z10) {
        z();
        Task<m> taskF = f();
        this.f14373h.execute(new Runnable() { // from class: p8.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f14362a.x(z10);
            }
        });
        return taskF;
    }

    public final Task<m> f() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new k(this.f14369d, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Task<String> g() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new l(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @Override // p8.h
    public Task<String> getId() {
        z();
        String strN = n();
        if (strN != null) {
            return Tasks.forResult(strN);
        }
        Task<String> taskG = g();
        this.f14373h.execute(new Runnable() { // from class: p8.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f14358a.w();
            }
        });
        return taskG;
    }

    public final void h(o oVar) {
        synchronized (this.f14372g) {
            this.f14377l.add(oVar);
        }
    }

    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void v(boolean z10) {
        r8.d dVarB;
        Exception iOException;
        r8.d dVarR = r();
        try {
            if (dVarR.i() || dVarR.l()) {
                dVarB = B(dVarR);
            } else {
                if (!z10 && !this.f14369d.f(dVarR)) {
                    return;
                }
                dVarB = k(dVarR);
            }
            u(dVarB);
            F(dVarR, dVarB);
            if (dVarB.k()) {
                E(dVarB.d());
            }
            if (dVarB.i()) {
                iOException = new i(i.a.BAD_CONFIG);
            } else {
                if (!dVarB.j()) {
                    D(dVarB);
                    return;
                }
                iOException = new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request.");
            }
            C(iOException);
        } catch (i e10) {
            C(e10);
        }
    }

    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void x(final boolean z10) {
        r8.d dVarS = s();
        if (z10) {
            dVarS = dVarS.p();
        }
        D(dVarS);
        this.f14374i.execute(new Runnable() { // from class: p8.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f14360a.v(z10);
            }
        });
    }

    public final r8.d k(r8.d dVar) throws i {
        s8.f fVarE = this.f14367b.e(l(), dVar.d(), t(), dVar.f());
        int i10 = b.f14380b[fVarE.b().ordinal()];
        if (i10 == 1) {
            return dVar.o(fVarE.c(), fVarE.d(), this.f14369d.b());
        }
        if (i10 == 2) {
            return dVar.q("BAD CONFIG");
        }
        if (i10 != 3) {
            throw new i("Firebase Installations Service is unavailable. Please try again later.", i.a.UNAVAILABLE);
        }
        E(null);
        return dVar.r();
    }

    public String l() {
        return this.f14366a.r().b();
    }

    public String m() {
        return this.f14366a.r().c();
    }

    public final synchronized String n() {
        return this.f14375j;
    }

    public final r8.b o() {
        return this.f14370e.get();
    }

    public final r8.d r() {
        r8.d dVarD;
        synchronized (f14364m) {
            p8.b bVarA = p8.b.a(this.f14366a.m(), "generatefid.lock");
            try {
                dVarD = this.f14368c.d();
                if (bVarA != null) {
                    bVarA.b();
                }
            } catch (Throwable th) {
                if (bVarA != null) {
                    bVarA.b();
                }
                throw th;
            }
        }
        return dVarD;
    }

    public final r8.d s() {
        r8.d dVarD;
        synchronized (f14364m) {
            p8.b bVarA = p8.b.a(this.f14366a.m(), "generatefid.lock");
            try {
                dVarD = this.f14368c.d();
                if (dVarD.j()) {
                    dVarD = this.f14368c.b(dVarD.t(A(dVarD)));
                }
                if (bVarA != null) {
                    bVarA.b();
                }
            } catch (Throwable th) {
                if (bVarA != null) {
                    bVarA.b();
                }
                throw th;
            }
        }
        return dVarD;
    }

    public String t() {
        return this.f14366a.r().g();
    }

    public final void u(r8.d dVar) {
        synchronized (f14364m) {
            p8.b bVarA = p8.b.a(this.f14366a.m(), "generatefid.lock");
            try {
                this.f14368c.b(dVar);
                if (bVarA != null) {
                    bVarA.b();
                }
            } catch (Throwable th) {
                if (bVarA != null) {
                    bVarA.b();
                }
                throw th;
            }
        }
    }

    public final void z() {
        r.g(m(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        r.g(t(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        r.g(l(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        r.b(p.h(m()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        r.b(p.g(l()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }
}
