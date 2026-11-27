package oe;

import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f13903d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f13904e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f13906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f13907c;

    public static final class a extends u {
        @Override // oe.u
        public void c() {
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public long a() {
        if (this.f13905a) {
            return this.f13906b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean b() {
        return this.f13905a;
    }

    public void c() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f13905a && this.f13906b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long d() {
        return this.f13907c;
    }
}
