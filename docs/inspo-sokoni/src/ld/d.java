package ld;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f12716a = new h0("CLOSED");

    public static final <N extends e<N>> N b(N n10) {
        while (true) {
            Object objF = n10.f();
            if (objF == f12716a) {
                return n10;
            }
            e eVar = (e) objF;
            if (eVar != null) {
                n10 = (N) eVar;
            } else if (n10.j()) {
                return n10;
            }
        }
    }

    public static final <S extends e0<S>> Object c(S s10, long j10, xc.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s10.f12721c >= j10 && !s10.h()) {
                return f0.a(s10);
            }
            Object objF = s10.f();
            if (objF == f12716a) {
                return f0.a(f12716a);
            }
            S sInvoke = (S) ((e) objF);
            if (sInvoke == null) {
                sInvoke = pVar.invoke(Long.valueOf(s10.f12721c + 1), s10);
                if (s10.l(sInvoke)) {
                    if (s10.h()) {
                        s10.k();
                    }
                }
            }
            s10 = (Object) sInvoke;
        }
    }
}
