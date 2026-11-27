package g8;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface m {

    public enum a {
        NONE,
        PARTIAL,
        FULL
    }

    void a(h8.t tVar);

    void b(e8.g1 g1Var);

    void c(h8.p pVar);

    List<h8.k> d(e8.g1 g1Var);

    void e(s7.c<h8.k, h8.h> cVar);

    Collection<h8.p> f();

    String g();

    List<h8.t> h(String str);

    void i();

    void j(String str, h8.p.a aVar);

    a k(e8.g1 g1Var);

    h8.p.a l(String str);

    h8.p.a m(e8.g1 g1Var);

    void n(h8.p pVar);

    void start();
}
