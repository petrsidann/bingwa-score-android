package com.dexterous.flutterlocalnotifications;

import androidx.annotation.Keep;
import e9.e;
import e9.k;
import e9.n;
import e9.o;
import e9.p;
import e9.x;
import e9.y;
import g9.m;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class RuntimeTypeAdapterFactory<T> implements y {
    private final Class<?> baseType;
    private final Map<String, Class<?>> labelToSubtype = new LinkedHashMap();
    private final Map<Class<?>, String> subtypeToLabel = new LinkedHashMap();
    private final String typeFieldName;

    /* JADX INFO: Add missing generic type declarations: [R] */
    public class a<R> extends x<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f3506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f3507b;

        public a(Map map, Map map2) {
            this.f3506a = map;
            this.f3507b = map2;
        }

        @Override // e9.x
        public R c(m9.a aVar) {
            k kVarA = m.a(aVar);
            k kVarV = kVarA.i().v(RuntimeTypeAdapterFactory.this.typeFieldName);
            if (kVarV == null) {
                throw new o("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " because it does not define a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
            }
            String strK = kVarV.k();
            x xVar = (x) this.f3506a.get(strK);
            if (xVar != null) {
                return (R) xVar.a(kVarA);
            }
            throw new o("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " subtype named " + strK + "; did you forget to register a subtype?");
        }

        @Override // e9.x
        public void e(m9.c cVar, R r10) {
            Class<?> cls = r10.getClass();
            String str = (String) RuntimeTypeAdapterFactory.this.subtypeToLabel.get(cls);
            x xVar = (x) this.f3507b.get(cls);
            if (xVar == null) {
                throw new o("cannot serialize " + cls.getName() + "; did you forget to register a subtype?");
            }
            n nVarI = xVar.d(r10).i();
            if (nVarI.t(RuntimeTypeAdapterFactory.this.typeFieldName)) {
                throw new o("cannot serialize " + cls.getName() + " because it already defines a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
            }
            n nVar = new n();
            nVar.r(RuntimeTypeAdapterFactory.this.typeFieldName, new p(str));
            for (Map.Entry<String, k> entry : nVarI.s()) {
                nVar.r(entry.getKey(), entry.getValue());
            }
            m.b(nVar, cVar);
        }
    }

    private RuntimeTypeAdapterFactory(Class<?> cls, String str) {
        if (str == null || cls == null) {
            throw null;
        }
        this.baseType = cls;
        this.typeFieldName = str;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls) {
        return new RuntimeTypeAdapterFactory<>(cls, "type");
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls, String str) {
        return new RuntimeTypeAdapterFactory<>(cls, str);
    }

    @Override // e9.y
    public <R> x<R> create(e eVar, l9.a<R> aVar) {
        if (aVar.c() != this.baseType) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Class<?>> entry : this.labelToSubtype.entrySet()) {
            x<T> xVarM = eVar.m(this, l9.a.a(entry.getValue()));
            linkedHashMap.put(entry.getKey(), xVarM);
            linkedHashMap2.put(entry.getValue(), xVarM);
        }
        return new a(linkedHashMap, linkedHashMap2).b();
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls) {
        return registerSubtype(cls, cls.getSimpleName());
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls, String str) {
        if (cls == null || str == null) {
            throw null;
        }
        if (this.subtypeToLabel.containsKey(cls) || this.labelToSubtype.containsKey(str)) {
            throw new IllegalArgumentException("types and labels must be unique");
        }
        this.labelToSubtype.put(str, cls);
        this.subtypeToLabel.put(cls, str);
        return this;
    }
}
