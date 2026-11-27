package ra;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b0 f15194c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LongSparseArray<MotionEvent> f15195a = new LongSparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityQueue<Long> f15196b = new PriorityQueue<>();

    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final AtomicLong f15197b = new AtomicLong(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f15198a;

        public a(long j10) {
            this.f15198a = j10;
        }

        public static a b() {
            return c(f15197b.incrementAndGet());
        }

        public static a c(long j10) {
            return new a(j10);
        }

        public long d() {
            return this.f15198a;
        }
    }

    public static b0 a() {
        if (f15194c == null) {
            f15194c = new b0();
        }
        return f15194c;
    }

    public MotionEvent b(a aVar) {
        while (!this.f15196b.isEmpty() && this.f15196b.peek().longValue() < aVar.f15198a) {
            this.f15195a.remove(this.f15196b.poll().longValue());
        }
        if (!this.f15196b.isEmpty() && this.f15196b.peek().longValue() == aVar.f15198a) {
            this.f15196b.poll();
        }
        MotionEvent motionEvent = this.f15195a.get(aVar.f15198a);
        this.f15195a.remove(aVar.f15198a);
        return motionEvent;
    }

    public a c(MotionEvent motionEvent) {
        a aVarB = a.b();
        this.f15195a.put(aVarB.f15198a, MotionEvent.obtain(motionEvent));
        this.f15196b.add(Long.valueOf(aVarB.f15198a));
        return aVarB;
    }
}
