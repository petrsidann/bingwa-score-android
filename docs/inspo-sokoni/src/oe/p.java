package oe;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f13895a = new p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13896b = 65536;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f13897c = new o(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReference<o>[] f13899e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f13898d = iHighestOneBit;
        AtomicReference<o>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i10 = 0; i10 < iHighestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference<>();
        }
        f13899e = atomicReferenceArr;
    }

    public static final void b(o segment) {
        AtomicReference<o> atomicReferenceA;
        o oVar;
        o andSet;
        kotlin.jvm.internal.k.e(segment, "segment");
        if (!(segment.f13893f == null && segment.f13894g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.f13891d || (andSet = (atomicReferenceA = f13895a.a()).getAndSet((oVar = f13897c))) == oVar) {
            return;
        }
        int i10 = andSet != null ? andSet.f13890c : 0;
        if (i10 >= f13896b) {
            atomicReferenceA.set(andSet);
            return;
        }
        segment.f13893f = andSet;
        segment.f13889b = 0;
        segment.f13890c = i10 + 8192;
        atomicReferenceA.set(segment);
    }

    public static final o c() {
        AtomicReference<o> atomicReferenceA = f13895a.a();
        o oVar = f13897c;
        o andSet = atomicReferenceA.getAndSet(oVar);
        if (andSet == oVar) {
            return new o();
        }
        if (andSet == null) {
            atomicReferenceA.set(null);
            return new o();
        }
        atomicReferenceA.set(andSet.f13893f);
        andSet.f13893f = null;
        andSet.f13890c = 0;
        return andSet;
    }

    public final AtomicReference<o> a() {
        return f13899e[(int) (Thread.currentThread().getId() & (((long) f13898d) - 1))];
    }
}
