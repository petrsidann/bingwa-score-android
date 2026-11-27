package p6;

import j6.m;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final class c extends d {

    public static final class a<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future<V> f14148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<? super V> f14149b;

        public a(Future<V> future, b<? super V> bVar) {
            this.f14148a = future;
            this.f14149b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thA;
            Future<V> future = this.f14148a;
            if ((future instanceof q6.a) && (thA = q6.b.a((q6.a) future)) != null) {
                this.f14149b.a(thA);
                return;
            }
            try {
                this.f14149b.onSuccess(c.b(this.f14148a));
            } catch (Error e10) {
                e = e10;
                this.f14149b.a(e);
            } catch (RuntimeException e11) {
                e = e11;
                this.f14149b.a(e);
            } catch (ExecutionException e12) {
                this.f14149b.a(e12.getCause());
            }
        }

        public String toString() {
            return j6.g.b(this).k(this.f14149b).toString();
        }
    }

    public static <V> void a(e<V> eVar, b<? super V> bVar, Executor executor) {
        m.o(bVar);
        eVar.d(new a(eVar, bVar), executor);
    }

    public static <V> V b(Future<V> future) {
        m.x(future.isDone(), "Future was expected to be done: %s", future);
        return (V) h.a(future);
    }
}
