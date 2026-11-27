package ld;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient oc.i f12728a;

    public i(oc.i iVar) {
        this.f12728a = iVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f12728a.toString();
    }
}
