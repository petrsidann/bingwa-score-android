package vb;

/* JADX INFO: loaded from: classes2.dex */
public class m1 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1 f17450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1 f17451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17452c;

    public m1(l1 l1Var) {
        this(l1Var, null);
    }

    public m1(l1 l1Var, a1 a1Var) {
        this(l1Var, a1Var, true);
    }

    public m1(l1 l1Var, a1 a1Var, boolean z10) {
        super(l1.g(l1Var), l1Var.l());
        this.f17450a = l1Var;
        this.f17451b = a1Var;
        this.f17452c = z10;
        fillInStackTrace();
    }

    public final l1 a() {
        return this.f17450a;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.f17452c ? super.fillInStackTrace() : this;
    }
}
