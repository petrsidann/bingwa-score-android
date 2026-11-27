package qc;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements oc.e<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14928a = new c();

    @Override // oc.e
    public oc.i getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // oc.e
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
