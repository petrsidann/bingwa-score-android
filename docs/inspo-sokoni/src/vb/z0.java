package vb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f17553c = Logger.getLogger(z0.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static z0 f17554d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<y0> f17555a = new LinkedHashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<y0> f17556b = Collections.emptyList();

    public class a implements Comparator<y0> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(y0 y0Var, y0 y0Var2) {
            return y0Var.c() - y0Var2.c();
        }
    }

    public static final class b implements k1.b<y0> {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // vb.k1.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(y0 y0Var) {
            return y0Var.c();
        }

        @Override // vb.k1.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(y0 y0Var) {
            return y0Var.b();
        }
    }

    public static synchronized z0 b() {
        if (f17554d == null) {
            List<y0> listE = k1.e(y0.class, c(), y0.class.getClassLoader(), new b(null));
            f17554d = new z0();
            for (y0 y0Var : listE) {
                f17553c.fine("Service loader found " + y0Var);
                f17554d.a(y0Var);
            }
            f17554d.f();
        }
        return f17554d;
    }

    public static List<Class<?>> c() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(yb.g.class);
        } catch (ClassNotFoundException e10) {
            f17553c.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e10);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e11) {
            f17553c.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e11);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e12) {
            f17553c.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e12);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(y0 y0Var) {
        j6.m.e(y0Var.b(), "isAvailable() returned false");
        this.f17555a.add(y0Var);
    }

    public y0 d() {
        List<y0> listE = e();
        if (listE.isEmpty()) {
            return null;
        }
        return listE.get(0);
    }

    public synchronized List<y0> e() {
        return this.f17556b;
    }

    public final synchronized void f() {
        ArrayList arrayList = new ArrayList(this.f17555a);
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        this.f17556b = Collections.unmodifiableList(arrayList);
    }
}
