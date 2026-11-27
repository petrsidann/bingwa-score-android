package nb;

import android.os.Handler;
import android.os.Looper;
import b8.r1;
import b8.x1;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import mb.y;
import mb.z;

/* JADX INFO: loaded from: classes2.dex */
public class o implements f, fb.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f13532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FirebaseFirestore f13533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f13535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f13536e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public z.v f13538l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<z.u> f13539m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Semaphore f13537f = new Semaphore(0);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f13540n = new Handler(Looper.getMainLooper());

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13541a;

        static {
            int[] iArr = new int[z.w.values().length];
            f13541a = iArr;
            try {
                iArr[z.w.DELETE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13541a[z.w.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13541a[z.w.SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface b {
        void a(com.google.firebase.firestore.l lVar);
    }

    public o(b bVar, FirebaseFirestore firebaseFirestore, String str, Long l10, Long l11) {
        this.f13532a = bVar;
        this.f13533b = firebaseFirestore;
        this.f13534c = str;
        this.f13535d = l10;
        this.f13536e = l11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ y g(final fb.c.b bVar, com.google.firebase.firestore.l lVar) {
        r1 r1VarD;
        this.f13532a.a(lVar);
        final HashMap map = new HashMap();
        map.put("appName", this.f13533b.A().q());
        this.f13540n.post(new Runnable() { // from class: nb.n
            @Override // java.lang.Runnable
            public final void run() {
                bVar.a(map);
            }
        });
        try {
            if (!this.f13537f.tryAcquire(this.f13535d.longValue(), TimeUnit.MILLISECONDS)) {
                return y.b(new com.google.firebase.firestore.f("timed out", com.google.firebase.firestore.f.a.DEADLINE_EXCEEDED));
            }
            if (!this.f13539m.isEmpty() && this.f13538l != z.v.FAILURE) {
                for (z.u uVar : this.f13539m) {
                    com.google.firebase.firestore.c cVarY = this.f13533b.y(uVar.d());
                    int i10 = a.f13541a[uVar.e().ordinal()];
                    if (i10 == 1) {
                        lVar.b(cVarY);
                    } else if (i10 == 2) {
                        Map<String, Object> mapB = uVar.b();
                        Objects.requireNonNull(mapB);
                        lVar.i(cVarY, mapB);
                    } else if (i10 == 3) {
                        z.n nVarC = uVar.c();
                        Objects.requireNonNull(nVarC);
                        if (nVarC.b() != null && nVarC.b().booleanValue()) {
                            r1VarD = r1.c();
                        } else if (nVarC.c() != null) {
                            List<List<String>> listC = nVarC.c();
                            Objects.requireNonNull(listC);
                            r1VarD = r1.d(ob.b.c(listC));
                        } else {
                            r1VarD = null;
                        }
                        Map<String, Object> mapB2 = uVar.b();
                        Objects.requireNonNull(mapB2);
                        Map<String, Object> map2 = mapB2;
                        if (r1VarD == null) {
                            lVar.f(cVarY, map2);
                        } else {
                            lVar.g(cVarY, map2, r1VarD);
                        }
                    }
                }
                return y.a();
            }
            return y.a();
        } catch (InterruptedException unused) {
            return y.b(new com.google.firebase.firestore.f("interrupted", com.google.firebase.firestore.f.a.DEADLINE_EXCEEDED));
        }
    }

    public static /* synthetic */ void h(fb.c.b bVar, HashMap map) {
        bVar.a(map);
        bVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(final fb.c.b bVar, Task task) {
        final HashMap map = new HashMap();
        if (task.getException() != null || ((y) task.getResult()).f13128a != null) {
            Exception exception = task.getException() != null ? task.getException() : ((y) task.getResult()).f13128a;
            map.put("appName", this.f13533b.A().q());
            map.put("error", ob.a.a(exception));
        } else if (task.getResult() != null) {
            map.put("complete", Boolean.TRUE);
        }
        this.f13540n.post(new Runnable() { // from class: nb.m
            @Override // java.lang.Runnable
            public final void run() {
                o.h(bVar, map);
            }
        });
    }

    @Override // nb.f
    public void a(z.v vVar, List<z.u> list) {
        this.f13538l = vVar;
        this.f13539m = list;
        this.f13537f.release();
    }

    @Override // fb.c.d
    public void onCancel(Object obj) {
        this.f13537f.release();
    }

    @Override // fb.c.d
    public void onListen(Object obj, final fb.c.b bVar) {
        this.f13533b.X(new x1.b().b(this.f13536e.intValue()).a(), new com.google.firebase.firestore.l.a() { // from class: nb.k
            @Override // com.google.firebase.firestore.l.a
            public final Object a(com.google.firebase.firestore.l lVar) {
                return this.f13524a.g(bVar, lVar);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: nb.l
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f13526a.i(bVar, task);
            }
        });
    }
}
