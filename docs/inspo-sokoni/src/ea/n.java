package ea;

/* JADX INFO: loaded from: classes.dex */
public interface n {

    public class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f7524a;

        public a(i iVar) {
            this.f7524a = iVar;
        }

        @Override // ea.j
        public int a() {
            return this.f7524a.f7502c;
        }

        @Override // ea.j
        public boolean b() {
            return this.f7524a.D();
        }
    }

    static n c(String str, int i10, int i11) {
        return i10 == 1 ? new r(str, i11) : new p(str, i10, i11);
    }

    default void a(i iVar, Runnable runnable) {
        b(new k(iVar == null ? null : new a(iVar), runnable));
    }

    void b(k kVar);

    void d();

    void start();
}
