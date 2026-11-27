package v3;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17183a;

    public static final n c(o oVar) {
        String strB = oVar.b();
        n nVar = new n();
        if (strB != null) {
            nVar.f17183a = com.google.android.gms.common.internal.r.f(strB);
        }
        return nVar;
    }

    public final n a(String str) {
        this.f17183a = com.google.android.gms.common.internal.r.f(str);
        return this;
    }

    public final o b() {
        return new o(this.f17183a);
    }
}
