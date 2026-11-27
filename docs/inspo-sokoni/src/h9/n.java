package h9;

import e9.x;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
public final class n<T> extends x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e9.e f9879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x<T> f9880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f9881c;

    public n(e9.e eVar, x<T> xVar, Type type) {
        this.f9879a = eVar;
        this.f9880b = xVar;
        this.f9881c = type;
    }

    public static Type f(Type type, Object obj) {
        if (obj != null) {
            return ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type;
        }
        return type;
    }

    public static boolean g(x<?> xVar) {
        x<?> xVarF;
        while ((xVar instanceof l) && (xVarF = ((l) xVar).f()) != xVar) {
            xVar = xVarF;
        }
        return xVar instanceof k.b;
    }

    @Override // e9.x
    public T c(m9.a aVar) {
        return this.f9880b.c(aVar);
    }

    @Override // e9.x
    public void e(m9.c cVar, T t10) {
        x<T> xVarL = this.f9880b;
        Type typeF = f(this.f9881c, t10);
        if (typeF != this.f9881c) {
            xVarL = this.f9879a.l(l9.a.b(typeF));
            if ((xVarL instanceof k.b) && !g(this.f9880b)) {
                xVarL = this.f9880b;
            }
        }
        xVarL.e(cVar, t10);
    }
}
