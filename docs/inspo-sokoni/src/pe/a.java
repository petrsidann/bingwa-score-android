package pe;

import java.io.EOFException;
import kotlin.jvm.internal.k;
import oe.d;
import oe.v;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f14569a = v.a("0123456789abcdef");

    public static final byte[] a() {
        return f14569a;
    }

    public static final String b(d dVar, long j10) throws EOFException {
        k.e(dVar, "<this>");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (dVar.E(j11) == 13) {
                String strF0 = dVar.f0(j11);
                dVar.skip(2L);
                return strF0;
            }
        }
        String strF1 = dVar.f0(j10);
        dVar.skip(1L);
        return strF1;
    }
}
