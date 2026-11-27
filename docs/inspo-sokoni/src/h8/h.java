package h8;

import d9.d0;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public interface h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<h> f9741a = new Comparator() { // from class: h8.g
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return h.i((h) obj, (h) obj2);
        }
    };

    static /* synthetic */ int i(h hVar, h hVar2) {
        return hVar.getKey().compareTo(hVar2.getKey());
    }

    s a();

    r b();

    boolean c();

    boolean d();

    boolean e();

    boolean f();

    v g();

    k getKey();

    boolean j();

    boolean k();

    d0 l(q qVar);

    v m();
}
