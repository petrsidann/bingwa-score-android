package vb;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class q1 extends s.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f17492a = Logger.getLogger(q1.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<s> f17493b = new ThreadLocal<>();

    @Override // vb.s.c
    public s a() {
        s sVar = f17493b.get();
        return sVar == null ? s.f17501c : sVar;
    }

    @Override // vb.s.c
    public void b(s sVar, s sVar2) {
        ThreadLocal<s> threadLocal;
        if (a() != sVar) {
            f17492a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (sVar2 != s.f17501c) {
            threadLocal = f17493b;
        } else {
            threadLocal = f17493b;
            sVar2 = null;
        }
        threadLocal.set(sVar2);
    }

    @Override // vb.s.c
    public s c(s sVar) {
        s sVarA = a();
        f17493b.set(sVar);
        return sVarA;
    }
}
