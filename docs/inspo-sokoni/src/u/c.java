package u;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import p6.e;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d<T> f15962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public u.d<Void> f15963c = u.d.B();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15964d;

        public void a() {
            this.f15961a = null;
            this.f15962b = null;
            this.f15963c.x(null);
        }

        public boolean b(T t10) {
            this.f15964d = true;
            d<T> dVar = this.f15962b;
            boolean z10 = dVar != null && dVar.b(t10);
            if (z10) {
                d();
            }
            return z10;
        }

        public boolean c() {
            this.f15964d = true;
            d<T> dVar = this.f15962b;
            boolean z10 = dVar != null && dVar.a(true);
            if (z10) {
                d();
            }
            return z10;
        }

        public final void d() {
            this.f15961a = null;
            this.f15962b = null;
            this.f15963c = null;
        }

        public boolean e(Throwable th) {
            this.f15964d = true;
            d<T> dVar = this.f15962b;
            boolean z10 = dVar != null && dVar.c(th);
            if (z10) {
                d();
            }
            return z10;
        }

        public void finalize() {
            u.d<Void> dVar;
            d<T> dVar2 = this.f15962b;
            if (dVar2 != null && !dVar2.isDone()) {
                dVar2.c(new b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f15961a));
            }
            if (this.f15964d || (dVar = this.f15963c) == null) {
                return;
            }
            dVar.x(null);
        }
    }

    public static final class b extends Throwable {
        public b(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: renamed from: u.c$c, reason: collision with other inner class name */
    public interface InterfaceC0292c<T> {
        Object a(a<T> aVar);
    }

    public static final class d<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<a<T>> f15965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u.a<T> f15966b = new a();

        public class a extends u.a<T> {
            public a() {
            }

            @Override // u.a
            public String u() {
                a<T> aVar = d.this.f15965a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f15961a + "]";
            }
        }

        public d(a<T> aVar) {
            this.f15965a = new WeakReference<>(aVar);
        }

        public boolean a(boolean z10) {
            return this.f15966b.cancel(z10);
        }

        public boolean b(T t10) {
            return this.f15966b.x(t10);
        }

        public boolean c(Throwable th) {
            return this.f15966b.y(th);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            a<T> aVar = this.f15965a.get();
            boolean zCancel = this.f15966b.cancel(z10);
            if (zCancel && aVar != null) {
                aVar.a();
            }
            return zCancel;
        }

        @Override // p6.e
        public void d(Runnable runnable, Executor executor) {
            this.f15966b.d(runnable, executor);
        }

        @Override // java.util.concurrent.Future
        public T get() {
            return this.f15966b.get();
        }

        @Override // java.util.concurrent.Future
        public T get(long j10, TimeUnit timeUnit) {
            return this.f15966b.get(j10, timeUnit);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f15966b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f15966b.isDone();
        }

        public String toString() {
            return this.f15966b.toString();
        }
    }

    public static <T> e<T> a(InterfaceC0292c<T> interfaceC0292c) {
        a<T> aVar = new a<>();
        d<T> dVar = new d<>(aVar);
        aVar.f15962b = dVar;
        aVar.f15961a = interfaceC0292c.getClass();
        try {
            Object objA = interfaceC0292c.a(aVar);
            if (objA != null) {
                aVar.f15961a = objA;
            }
        } catch (Exception e10) {
            dVar.c(e10);
        }
        return dVar;
    }
}
