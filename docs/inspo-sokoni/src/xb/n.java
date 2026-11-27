package xb;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f18760f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r2 f18761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1 f18762b = f1.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e1 f18763c = f1.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e1 f18764d = f1.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f18765e;

    public class a implements b {
        @Override // xb.n.b
        public n a() {
            return new n(r2.f18900a);
        }
    }

    public interface b {
        n a();
    }

    public n(r2 r2Var) {
        this.f18761a = r2Var;
    }

    public void a(boolean z10) {
        (z10 ? this.f18763c : this.f18764d).add(1L);
    }

    public void b() {
        this.f18762b.add(1L);
        this.f18765e = this.f18761a.a();
    }
}
