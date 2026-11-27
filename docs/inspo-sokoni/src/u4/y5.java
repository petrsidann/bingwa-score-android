package u4;

/* JADX INFO: loaded from: classes.dex */
public final class y5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f16968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f16969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ v5 f16970f;

    public y5(v5 v5Var, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.f16965a = i10;
        this.f16966b = str;
        this.f16967c = obj;
        this.f16968d = obj2;
        this.f16969e = obj3;
        this.f16970f = v5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v5 v5Var;
        char c10;
        i6 i6VarC = this.f16970f.f16624a.C();
        if (!i6VarC.o()) {
            this.f16970f.u(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.f16970f.f16886c == 0) {
            if (this.f16970f.a().q()) {
                v5Var = this.f16970f;
                c10 = 'C';
            } else {
                v5Var = this.f16970f;
                c10 = 'c';
            }
            v5Var.f16886c = c10;
        }
        if (this.f16970f.f16887d < 0) {
            this.f16970f.f16887d = 114010L;
        }
        String strSubstring = "2" + "01VDIWEA?".charAt(this.f16965a) + this.f16970f.f16886c + this.f16970f.f16887d + ":" + v5.t(true, this.f16966b, this.f16967c, this.f16968d, this.f16969e);
        if (strSubstring.length() > 1024) {
            strSubstring = this.f16966b.substring(0, 1024);
        }
        m6 m6Var = i6VarC.f16330f;
        if (m6Var != null) {
            m6Var.b(strSubstring, 1L);
        }
    }
}
