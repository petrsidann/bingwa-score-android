package h9;

import e9.x;
import e9.y;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a<E> extends x<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f9800c = new C0160a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<E> f9801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x<E> f9802b;

    /* JADX INFO: renamed from: h9.a$a, reason: collision with other inner class name */
    public class C0160a implements y {
        @Override // e9.y
        public <T> x<T> create(e9.e eVar, l9.a<T> aVar) {
            Type typeD = aVar.d();
            if (!(typeD instanceof GenericArrayType) && (!(typeD instanceof Class) || !((Class) typeD).isArray())) {
                return null;
            }
            Type typeG = g9.b.g(typeD);
            return new a(eVar, eVar.l(l9.a.b(typeG)), g9.b.k(typeG));
        }
    }

    public a(e9.e eVar, x<E> xVar, Class<E> cls) {
        this.f9802b = new n(eVar, xVar, cls);
        this.f9801a = cls;
    }

    @Override // e9.x
    public Object c(m9.a aVar) throws IOException {
        if (aVar.l0() == m9.b.NULL) {
            aVar.h0();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.d();
        while (aVar.I()) {
            arrayList.add(this.f9802b.c(aVar));
        }
        aVar.z();
        int size = arrayList.size();
        if (!this.f9801a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f9801a, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.f9801a, size);
        for (int i10 = 0; i10 < size; i10++) {
            Array.set(objNewInstance, i10, arrayList.get(i10));
        }
        return objNewInstance;
    }

    @Override // e9.x
    public void e(m9.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.L();
            return;
        }
        cVar.k();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f9802b.e(cVar, (E) Array.get(obj, i10));
        }
        cVar.z();
    }
}
