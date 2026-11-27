package k8;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import vb.l1;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final vb.a1.g<String> f11844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final vb.a1.g<String> f11845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final vb.a1.g<String> f11846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile String f11847j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l8.g f11848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c8.a<c8.j> f11849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c8.a<String> f11850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0 f11851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i0 f11853f;

    /* JADX INFO: Add missing generic type declarations: [RespT] */
    public class a<RespT> extends vb.g.a<RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j0 f11854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vb.g[] f11855b;

        public a(j0 j0Var, vb.g[] gVarArr) {
            this.f11854a = j0Var;
            this.f11855b = gVarArr;
        }

        @Override // vb.g.a
        public void a(l1 l1Var, vb.a1 a1Var) {
            try {
                this.f11854a.b(l1Var);
            } catch (Throwable th) {
                y.this.f11848a.u(th);
            }
        }

        @Override // vb.g.a
        public void b(vb.a1 a1Var) {
            try {
                this.f11854a.c(a1Var);
            } catch (Throwable th) {
                y.this.f11848a.u(th);
            }
        }

        @Override // vb.g.a
        public void c(RespT respt) {
            try {
                this.f11854a.d(respt);
                this.f11855b[0].c(1);
            } catch (Throwable th) {
                y.this.f11848a.u(th);
            }
        }

        @Override // vb.g.a
        public void d() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [ReqT, RespT] */
    public class b<ReqT, RespT> extends vb.b0<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.g[] f11857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Task f11858b;

        public b(vb.g[] gVarArr, Task task) {
            this.f11857a = gVarArr;
            this.f11858b = task;
        }

        @Override // vb.b0, vb.f1, vb.g
        public void b() {
            if (this.f11857a[0] == null) {
                this.f11858b.addOnSuccessListener(y.this.f11848a.o(), new OnSuccessListener() { // from class: k8.z
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        ((vb.g) obj).b();
                    }
                });
            } else {
                super.b();
            }
        }

        @Override // vb.b0, vb.f1
        public vb.g<ReqT, RespT> f() {
            l8.b.d(this.f11857a[0] != null, "ClientCall used before onOpen() callback", new Object[0]);
            return this.f11857a[0];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RespT] */
    public class c<RespT> extends vb.g.a<RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f11860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vb.g f11861b;

        public c(e eVar, vb.g gVar) {
            this.f11860a = eVar;
            this.f11861b = gVar;
        }

        @Override // vb.g.a
        public void a(l1 l1Var, vb.a1 a1Var) {
            this.f11860a.a(l1Var);
        }

        @Override // vb.g.a
        public void c(RespT respt) {
            this.f11860a.b(respt);
            this.f11861b.c(1);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [RespT] */
    public class d<RespT> extends vb.g.a<RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f11863a;

        public d(TaskCompletionSource taskCompletionSource) {
            this.f11863a = taskCompletionSource;
        }

        @Override // vb.g.a
        public void a(l1 l1Var, vb.a1 a1Var) {
            if (!l1Var.o()) {
                this.f11863a.setException(y.this.f(l1Var));
            } else {
                if (this.f11863a.getTask().isComplete()) {
                    return;
                }
                this.f11863a.setException(new com.google.firebase.firestore.f("Received onClose with status OK, but no message.", com.google.firebase.firestore.f.a.INTERNAL));
            }
        }

        @Override // vb.g.a
        public void c(RespT respt) {
            this.f11863a.setResult(respt);
        }
    }

    public static abstract class e<T> {
        public abstract void a(l1 l1Var);

        public abstract void b(T t10);
    }

    static {
        vb.a1.d<String> dVar = vb.a1.f17241e;
        f11844g = vb.a1.g.e("x-goog-api-client", dVar);
        f11845h = vb.a1.g.e("google-cloud-resource-prefix", dVar);
        f11846i = vb.a1.g.e("x-goog-request-params", dVar);
        f11847j = "gl-java/";
    }

    public y(l8.g gVar, c8.a<c8.j> aVar, c8.a<String> aVar2, h8.f fVar, i0 i0Var, h0 h0Var) {
        this.f11848a = gVar;
        this.f11853f = i0Var;
        this.f11849b = aVar;
        this.f11850c = aVar2;
        this.f11851d = h0Var;
        this.f11852e = String.format("projects/%s/databases/%s", fVar.l(), fVar.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(vb.g[] gVarArr, j0 j0Var, Task task) {
        vb.g gVar = (vb.g) task.getResult();
        gVarArr[0] = gVar;
        gVar.e(new a(j0Var, gVarArr), l());
        j0Var.a();
        gVarArr[0].c(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(TaskCompletionSource taskCompletionSource, Object obj, Task task) {
        vb.g gVar = (vb.g) task.getResult();
        gVar.e(new d(taskCompletionSource), l());
        gVar.c(2);
        gVar.d(obj);
        gVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(e eVar, Object obj, Task task) {
        vb.g gVar = (vb.g) task.getResult();
        gVar.e(new c(eVar, gVar), l());
        gVar.c(1);
        gVar.d(obj);
        gVar.b();
    }

    public static void p(String str) {
        f11847j = str;
    }

    public final com.google.firebase.firestore.f f(l1 l1Var) {
        return q.g(l1Var) ? new com.google.firebase.firestore.f("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", com.google.firebase.firestore.f.a.i(l1Var.m().i()), l1Var.l()) : l8.g0.u(l1Var);
    }

    public final String g() {
        return String.format("%s fire/%s grpc/", f11847j, "25.1.2");
    }

    public void h() {
        this.f11849b.b();
        this.f11850c.b();
    }

    public final vb.a1 l() {
        vb.a1 a1Var = new vb.a1();
        a1Var.p(f11844g, g());
        a1Var.p(f11845h, this.f11852e);
        a1Var.p(f11846i, this.f11852e);
        i0 i0Var = this.f11853f;
        if (i0Var != null) {
            i0Var.a(a1Var);
        }
        return a1Var;
    }

    public <ReqT, RespT> vb.g<ReqT, RespT> m(vb.b1<ReqT, RespT> b1Var, final j0<RespT> j0Var) {
        final vb.g[] gVarArr = {null};
        Task<vb.g<ReqT, RespT>> taskI = this.f11851d.i(b1Var);
        taskI.addOnCompleteListener(this.f11848a.o(), new OnCompleteListener() { // from class: k8.v
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f11822a.i(gVarArr, j0Var, task);
            }
        });
        return new b(gVarArr, taskI);
    }

    public <ReqT, RespT> Task<RespT> n(vb.b1<ReqT, RespT> b1Var, final ReqT reqt) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f11851d.i(b1Var).addOnCompleteListener(this.f11848a.o(), new OnCompleteListener() { // from class: k8.x
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f11839a.j(taskCompletionSource, reqt, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    public <ReqT, RespT> void o(vb.b1<ReqT, RespT> b1Var, final ReqT reqt, final e<RespT> eVar) {
        this.f11851d.i(b1Var).addOnCompleteListener(this.f11848a.o(), new OnCompleteListener() { // from class: k8.w
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f11830a.k(eVar, reqt, task);
            }
        });
    }

    public void q() {
        this.f11851d.u();
    }
}
