package h6;

/* JADX INFO: loaded from: classes.dex */
public final class k implements o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f9673c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile o f9674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f9675b = f9673c;

    public k(o oVar) {
        this.f9674a = oVar;
    }

    public static o b(o oVar) {
        return oVar instanceof k ? oVar : new k(oVar);
    }

    @Override // h6.o
    public final Object a() {
        Object objA = this.f9675b;
        Object obj = f9673c;
        if (objA == obj) {
            synchronized (this) {
                objA = this.f9675b;
                if (objA == obj) {
                    objA = this.f9674a.a();
                    Object obj2 = this.f9675b;
                    if (obj2 != obj && obj2 != objA) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + objA + ". This is likely due to a circular dependency.");
                    }
                    this.f9675b = objA;
                    this.f9674a = null;
                }
            }
        }
        return objA;
    }
}
