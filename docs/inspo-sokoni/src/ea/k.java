package ea;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f7514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f7515b;

    public k(j jVar, Runnable runnable) {
        this.f7514a = jVar;
        this.f7515b = runnable;
    }

    public Integer a() {
        j jVar = this.f7514a;
        if (jVar != null) {
            return Integer.valueOf(jVar.a());
        }
        return null;
    }

    public boolean b() {
        j jVar = this.f7514a;
        return jVar != null && jVar.b();
    }
}
