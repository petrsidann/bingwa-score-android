package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f9135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xc.l<Throwable, lc.q> f9136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f9137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f9138e;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(Object obj, m mVar, xc.l<? super Throwable, lc.q> lVar, Object obj2, Throwable th) {
        this.f9134a = obj;
        this.f9135b = mVar;
        this.f9136c = lVar;
        this.f9137d = obj2;
        this.f9138e = th;
    }

    public /* synthetic */ b0(Object obj, m mVar, xc.l lVar, Object obj2, Throwable th, int i10, kotlin.jvm.internal.g gVar) {
        this(obj, (i10 & 2) != 0 ? null : mVar, (i10 & 4) != 0 ? null : lVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ b0 b(b0 b0Var, Object obj, m mVar, xc.l lVar, Object obj2, Throwable th, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = b0Var.f9134a;
        }
        if ((i10 & 2) != 0) {
            mVar = b0Var.f9135b;
        }
        m mVar2 = mVar;
        if ((i10 & 4) != 0) {
            lVar = b0Var.f9136c;
        }
        xc.l lVar2 = lVar;
        if ((i10 & 8) != 0) {
            obj2 = b0Var.f9137d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th = b0Var.f9138e;
        }
        return b0Var.a(obj, mVar2, lVar2, obj4, th);
    }

    public final b0 a(Object obj, m mVar, xc.l<? super Throwable, lc.q> lVar, Object obj2, Throwable th) {
        return new b0(obj, mVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f9138e != null;
    }

    public final void d(p<?> pVar, Throwable th) {
        m mVar = this.f9135b;
        if (mVar != null) {
            pVar.o(mVar, th);
        }
        xc.l<Throwable, lc.q> lVar = this.f9136c;
        if (lVar != null) {
            pVar.p(lVar, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return kotlin.jvm.internal.k.a(this.f9134a, b0Var.f9134a) && kotlin.jvm.internal.k.a(this.f9135b, b0Var.f9135b) && kotlin.jvm.internal.k.a(this.f9136c, b0Var.f9136c) && kotlin.jvm.internal.k.a(this.f9137d, b0Var.f9137d) && kotlin.jvm.internal.k.a(this.f9138e, b0Var.f9138e);
    }

    public int hashCode() {
        Object obj = this.f9134a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        m mVar = this.f9135b;
        int iHashCode2 = (iHashCode + (mVar == null ? 0 : mVar.hashCode())) * 31;
        xc.l<Throwable, lc.q> lVar = this.f9136c;
        int iHashCode3 = (iHashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f9137d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f9138e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f9134a + ", cancelHandler=" + this.f9135b + ", onCancellation=" + this.f9136c + ", idempotentResume=" + this.f9137d + ", cancelCause=" + this.f9138e + ')';
    }
}
