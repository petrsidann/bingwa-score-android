package qc;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f14929a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14930b = new a(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f14931c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f14932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f14933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f14934c;

        public a(Method method, Method method2, Method method3) {
            this.f14932a = method;
            this.f14933b = method2;
            this.f14934c = method3;
        }
    }

    public final a a(qc.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f14931c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f14930b;
            f14931c = aVar3;
            return aVar3;
        }
    }

    public final String b(qc.a continuation) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        kotlin.jvm.internal.k.e(continuation, "continuation");
        a aVarA = f14931c;
        if (aVarA == null) {
            aVarA = a(continuation);
        }
        if (aVarA == f14930b || (method = aVarA.f14932a) == null || (objInvoke = method.invoke(continuation.getClass(), new Object[0])) == null || (method2 = aVarA.f14933b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVarA.f14934c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
