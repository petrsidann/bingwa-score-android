package p7;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class j1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j1 f14266c = new j1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f14267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f14268b;

    public j1() {
        this(p0.j(), a0.b());
    }

    public j1(p0 p0Var, a0 a0Var) {
        this.f14267a = p0Var;
        this.f14268b = a0Var;
    }

    public static j1 f() {
        return f14266c;
    }

    public final void a(Context context) {
        this.f14267a.a(context);
    }

    public final void b(FirebaseAuth firebaseAuth) {
        this.f14267a.h(firebaseAuth);
    }

    public final boolean c(Activity activity, TaskCompletionSource<o7.i> taskCompletionSource, FirebaseAuth firebaseAuth) {
        return this.f14268b.i(activity, taskCompletionSource, firebaseAuth);
    }

    public final boolean d(Activity activity, TaskCompletionSource<o7.i> taskCompletionSource, FirebaseAuth firebaseAuth, o7.a0 a0Var) {
        return this.f14268b.j(activity, taskCompletionSource, firebaseAuth, a0Var);
    }

    public final Task<String> e() {
        return this.f14267a.i();
    }
}
