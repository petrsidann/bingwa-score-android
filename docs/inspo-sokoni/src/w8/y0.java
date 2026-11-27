package w8;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class y0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference<y0> f17810d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f17811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v0 f17812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f17813c;

    public y0(SharedPreferences sharedPreferences, Executor executor) {
        this.f17813c = executor;
        this.f17811a = sharedPreferences;
    }

    public static synchronized y0 b(Context context, Executor executor) {
        y0 y0Var;
        WeakReference<y0> weakReference = f17810d;
        y0Var = weakReference != null ? weakReference.get() : null;
        if (y0Var == null) {
            y0Var = new y0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
            y0Var.d();
            f17810d = new WeakReference<>(y0Var);
        }
        return y0Var;
    }

    public synchronized boolean a(x0 x0Var) {
        return this.f17812b.b(x0Var.e());
    }

    public synchronized x0 c() {
        return x0.a(this.f17812b.f());
    }

    public final synchronized void d() {
        this.f17812b = v0.d(this.f17811a, "topic_operation_queue", ",", this.f17813c);
    }

    public synchronized boolean e(x0 x0Var) {
        return this.f17812b.g(x0Var.e());
    }
}
