package gd;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class x2 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient y1 f9271a;

    public x2(String str) {
        this(str, null);
    }

    public x2(String str, y1 y1Var) {
        super(str);
        this.f9271a = y1Var;
    }
}
