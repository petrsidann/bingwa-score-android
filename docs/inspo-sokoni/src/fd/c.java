package fd;

import bd.h;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final long b(long j10) {
        return a.d((j10 << 1) + 1);
    }

    public static final long c(long j10) {
        return a.d(j10 << 1);
    }

    public static final long d(long j10, d unit) {
        k.e(unit, "unit");
        d dVar = d.NANOSECONDS;
        long jB = e.b(4611686018426999999L, dVar, unit);
        boolean z10 = false;
        if ((-jB) <= j10 && j10 <= jB) {
            z10 = true;
        }
        return z10 ? c(e.b(j10, unit, dVar)) : b(h.f(e.a(j10, unit, d.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }
}
