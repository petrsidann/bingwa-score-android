package bd;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3079e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f3080f = new f(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final f a() {
            return f.f3080f;
        }
    }

    public f(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // bd.d
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            if (!isEmpty() || !((f) obj).isEmpty()) {
                f fVar = (f) obj;
                if (e() != fVar.e() || h() != fVar.h()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // bd.d
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (e() * 31) + h();
    }

    @Override // bd.d
    public boolean isEmpty() {
        return e() > h();
    }

    public Integer l() {
        return Integer.valueOf(h());
    }

    public Integer n() {
        return Integer.valueOf(e());
    }

    @Override // bd.d
    public String toString() {
        return e() + ".." + h();
    }
}
