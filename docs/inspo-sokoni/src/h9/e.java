package h9;

import e9.r;
import e9.x;
import e9.y;

/* JADX INFO: loaded from: classes.dex */
public final class e implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g9.c f9812a;

    public e(g9.c cVar) {
        this.f9812a = cVar;
    }

    public x<?> a(g9.c cVar, e9.e eVar, l9.a<?> aVar, f9.b bVar) {
        x<?> mVar;
        Object objA = cVar.b(l9.a.a(bVar.value())).a();
        boolean zNullSafe = bVar.nullSafe();
        if (objA instanceof x) {
            mVar = (x) objA;
        } else if (objA instanceof y) {
            mVar = ((y) objA).create(eVar, aVar);
        } else {
            boolean z10 = objA instanceof r;
            if (!z10 && !(objA instanceof e9.j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            mVar = new m<>(z10 ? (r) objA : null, objA instanceof e9.j ? (e9.j) objA : null, eVar, aVar, null, zNullSafe);
            zNullSafe = false;
        }
        return (mVar == null || !zNullSafe) ? mVar : mVar.b();
    }

    @Override // e9.y
    public <T> x<T> create(e9.e eVar, l9.a<T> aVar) {
        f9.b bVar = (f9.b) aVar.c().getAnnotation(f9.b.class);
        if (bVar == null) {
            return null;
        }
        return (x<T>) a(this.f9812a, eVar, aVar, bVar);
    }
}
