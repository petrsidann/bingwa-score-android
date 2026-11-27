package vb;

/* JADX INFO: loaded from: classes2.dex */
public class n1 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1 f17462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1 f17463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17464c;

    public n1(l1 l1Var) {
        this(l1Var, null);
    }

    public n1(l1 l1Var, a1 a1Var) {
        this(l1Var, a1Var, true);
    }

    public n1(l1 l1Var, a1 a1Var, boolean z10) {
        super(l1.g(l1Var), l1Var.l());
        this.f17462a = l1Var;
        this.f17463b = a1Var;
        this.f17464c = z10;
        fillInStackTrace();
    }

    public final l1 a() {
        return this.f17462a;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f17464c ? super.fillInStackTrace() : this;
    }
}
