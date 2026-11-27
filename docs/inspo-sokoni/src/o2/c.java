package o2;

import android.content.Context;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.k;
import m2.j;
import mc.o;

/* JADX INFO: loaded from: classes.dex */
public final class c implements n2.a {
    public static final void d(o0.a callback) {
        k.e(callback, "$callback");
        callback.accept(new j(o.g()));
    }

    @Override // n2.a
    public void a(Context context, Executor executor, final o0.a<j> callback) {
        k.e(context, "context");
        k.e(executor, "executor");
        k.e(callback, "callback");
        executor.execute(new Runnable() { // from class: o2.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(callback);
            }
        });
    }

    @Override // n2.a
    public void b(o0.a<j> callback) {
        k.e(callback, "callback");
    }
}
