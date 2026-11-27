package id;

/* JADX INFO: loaded from: classes2.dex */
public interface u<E> {

    public static final class a {
        public static /* synthetic */ boolean a(u uVar, Throwable th, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i10 & 1) != 0) {
                th = null;
            }
            return uVar.e(th);
        }
    }

    Object d(E e10, oc.e<? super lc.q> eVar);

    boolean e(Throwable th);

    void j(xc.l<? super Throwable, lc.q> lVar);

    Object l(E e10);

    boolean m();
}
