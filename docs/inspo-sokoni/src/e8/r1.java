package e8;

/* JADX INFO: loaded from: classes.dex */
public class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f7313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h8.q f7314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7315c;

    public r1(q1 q1Var, h8.q qVar, boolean z10) {
        this.f7313a = q1Var;
        this.f7314b = qVar;
        this.f7315c = z10;
    }

    public /* synthetic */ r1(q1 q1Var, h8.q qVar, boolean z10, p1 p1Var) {
        this(q1Var, qVar, z10);
    }

    public void a(h8.q qVar) {
        this.f7313a.b(qVar);
    }

    public void b(h8.q qVar, i8.p pVar) {
        this.f7313a.c(qVar, pVar);
    }

    public r1 c(int i10) {
        return new r1(this.f7313a, null, true);
    }

    public r1 d(h8.q qVar) {
        h8.q qVar2 = this.f7314b;
        r1 r1Var = new r1(this.f7313a, qVar2 == null ? null : qVar2.d(qVar), false);
        r1Var.k();
        return r1Var;
    }

    public r1 e(String str) {
        h8.q qVar = this.f7314b;
        r1 r1Var = new r1(this.f7313a, qVar == null ? null : qVar.h(str), false);
        r1Var.l(str);
        return r1Var;
    }

    public RuntimeException f(String str) {
        String str2;
        h8.q qVar = this.f7314b;
        if (qVar == null || qVar.r()) {
            str2 = "";
        } else {
            str2 = " (found in field " + this.f7314b.toString() + ")";
        }
        return new IllegalArgumentException("Invalid data. " + str + str2);
    }

    public u1 g() {
        return this.f7313a.f7305a;
    }

    public h8.q h() {
        return this.f7314b;
    }

    public boolean i() {
        return this.f7315c;
    }

    public boolean j() {
        int i10 = p1.f7292a[this.f7313a.f7305a.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return true;
        }
        if (i10 == 4 || i10 == 5) {
            return false;
        }
        throw l8.b.a("Unexpected case for UserDataSource: %s", this.f7313a.f7305a.name());
    }

    public final void k() {
        if (this.f7314b == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f7314b.u(); i10++) {
            l(this.f7314b.q(i10));
        }
    }

    public final void l(String str) {
        if (str.isEmpty()) {
            throw f("Document fields must not be empty");
        }
        if (j() && str.startsWith("__") && str.endsWith("__")) {
            throw f("Document fields cannot begin and end with \"__\"");
        }
    }
}
