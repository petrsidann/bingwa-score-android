package gd;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class z1 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient y1 f9277a;

    public z1(String str, Throwable th, y1 y1Var) {
        super(str);
        this.f9277a = y1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof z1) {
                z1 z1Var = (z1) obj;
                if (!kotlin.jvm.internal.k.a(z1Var.getMessage(), getMessage()) || !kotlin.jvm.internal.k.a(z1Var.f9277a, this.f9277a) || !kotlin.jvm.internal.k.a(z1Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.k.b(message);
        int iHashCode = ((message.hashCode() * 31) + this.f9277a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f9277a;
    }
}
