package cd;

/* JADX INFO: loaded from: classes2.dex */
public interface f<R> extends b<R>, lc.b<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // cd.b
    boolean isSuspend();
}
