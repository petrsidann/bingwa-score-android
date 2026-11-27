package r7;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class p<V> extends u.a<V> implements ScheduledFuture<V> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ScheduledFuture<?> f15126m;

    public class a implements b<V> {
        public a() {
        }

        @Override // r7.p.b
        public void a(Throwable th) {
            p.this.y(th);
        }

        @Override // r7.p.b
        public void set(V v10) {
            p.this.x(v10);
        }
    }

    public interface b<T> {
        void a(Throwable th);

        void set(T t10);
    }

    public interface c<T> {
        ScheduledFuture<?> a(b<T> bVar);
    }

    public p(c<V> cVar) {
        this.f15126m = cVar.a(new a());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.f15126m.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f15126m.getDelay(timeUnit);
    }

    @Override // u.a
    public void i() {
        this.f15126m.cancel(A());
    }
}
