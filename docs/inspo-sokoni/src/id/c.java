package id;

import ld.h0;
import ld.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j<Object> f10599a = new j<>(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10600b = k0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10601c = k0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h0 f10602d = new h0("BUFFERED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h0 f10603e = new h0("SHOULD_BUFFER");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h0 f10604f = new h0("S_RESUMING_BY_RCV");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h0 f10605g = new h0("RESUMING_BY_EB");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h0 f10606h = new h0("POISONED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final h0 f10607i = new h0("DONE_RCV");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final h0 f10608j = new h0("INTERRUPTED_SEND");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final h0 f10609k = new h0("INTERRUPTED_RCV");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final h0 f10610l = new h0("CHANNEL_CLOSED");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final h0 f10611m = new h0("SUSPEND");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final h0 f10612n = new h0("SUSPEND_NO_WAITER");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final h0 f10613o = new h0("FAILED");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final h0 f10614p = new h0("NO_RECEIVE_RESULT");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final h0 f10615q = new h0("CLOSE_HANDLER_CLOSED");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final h0 f10616r = new h0("CLOSE_HANDLER_INVOKED");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final h0 f10617s = new h0("NO_CLOSE_CAUSE");

    /* JADX INFO: Add missing generic type declarations: [E] */
    public /* synthetic */ class a<E> extends kotlin.jvm.internal.j implements xc.p<Long, j<E>, j<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10618a = new a();

        public a() {
            super(2, c.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        public final j<E> d(long j10, j<E> jVar) {
            return c.x(j10, jVar);
        }

        @Override // xc.p
        public /* bridge */ /* synthetic */ Object invoke(Long l10, Object obj) {
            return d(l10.longValue(), (j) obj);
        }
    }

    public static final long A(int i10) {
        if (i10 == 0) {
            return 0L;
        }
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        return Long.MAX_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean B(gd.o<? super T> oVar, T t10, xc.l<? super Throwable, lc.q> lVar) {
        Object objK = oVar.k(t10, null, lVar);
        if (objK == null) {
            return false;
        }
        oVar.n(objK);
        return true;
    }

    public static /* synthetic */ boolean C(gd.o oVar, Object obj, xc.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        return B(oVar, obj, lVar);
    }

    public static final long v(long j10, boolean z10) {
        return (z10 ? 4611686018427387904L : 0L) + j10;
    }

    public static final long w(long j10, int i10) {
        return (((long) i10) << 60) + j10;
    }

    public static final <E> j<E> x(long j10, j<E> jVar) {
        return new j<>(j10, jVar, jVar.u(), 0);
    }

    public static final <E> cd.f<j<E>> y() {
        return a.f10618a;
    }

    public static final h0 z() {
        return f10610l;
    }
}
