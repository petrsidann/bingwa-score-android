package xb;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f18458c = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f18460b;

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18461a;

        public b(long j10) {
            this.f18461a = j10;
        }

        public void a() {
            long j10 = this.f18461a;
            long jMax = Math.max(2 * j10, j10);
            if (g.this.f18460b.compareAndSet(this.f18461a, jMax)) {
                g.f18458c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{g.this.f18459a, Long.valueOf(jMax)});
            }
        }

        public long b() {
            return this.f18461a;
        }
    }

    public g(String str, long j10) {
        AtomicLong atomicLong = new AtomicLong();
        this.f18460b = atomicLong;
        j6.m.e(j10 > 0, "value must be positive");
        this.f18459a = str;
        atomicLong.set(j10);
    }

    public b d() {
        return new b(this.f18460b.get());
    }
}
