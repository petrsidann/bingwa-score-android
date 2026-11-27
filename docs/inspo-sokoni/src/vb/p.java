package vb;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f17467b = new p(new m.a(), m.b.f17449a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<String, o> f17468a = new ConcurrentHashMap();

    public p(o... oVarArr) {
        for (o oVar : oVarArr) {
            this.f17468a.put(oVar.a(), oVar);
        }
    }

    public static p a() {
        return f17467b;
    }

    public o b(String str) {
        return this.f17468a.get(str);
    }
}
