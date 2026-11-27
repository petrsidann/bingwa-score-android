package z6;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import r6.t;
import r6.x;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<d, z6.c<?, ?>> f20338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<c, z6.b<?>> f20339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<d, j<?, ?>> f20340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<c, i<?>> f20341d;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<d, z6.c<?, ?>> f20342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<c, z6.b<?>> f20343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<d, j<?, ?>> f20344c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<c, i<?>> f20345d;

        public b() {
            this.f20342a = new HashMap();
            this.f20343b = new HashMap();
            this.f20344c = new HashMap();
            this.f20345d = new HashMap();
        }

        public b(o oVar) {
            this.f20342a = new HashMap(oVar.f20338a);
            this.f20343b = new HashMap(oVar.f20339b);
            this.f20344c = new HashMap(oVar.f20340c);
            this.f20345d = new HashMap(oVar.f20341d);
        }

        public o e() {
            return new o(this);
        }

        public <SerializationT extends n> b f(z6.b<SerializationT> bVar) throws GeneralSecurityException {
            c cVar = new c(bVar.c(), bVar.b());
            if (this.f20343b.containsKey(cVar)) {
                z6.b<?> bVar2 = this.f20343b.get(cVar);
                if (!bVar2.equals(bVar) || !bVar.equals(bVar2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + cVar);
                }
            } else {
                this.f20343b.put(cVar, bVar);
            }
            return this;
        }

        public <KeyT extends r6.f, SerializationT extends n> b g(z6.c<KeyT, SerializationT> cVar) throws GeneralSecurityException {
            d dVar = new d(cVar.b(), cVar.c());
            if (this.f20342a.containsKey(dVar)) {
                z6.c<?, ?> cVar2 = this.f20342a.get(dVar);
                if (!cVar2.equals(cVar) || !cVar.equals(cVar2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + dVar);
                }
            } else {
                this.f20342a.put(dVar, cVar);
            }
            return this;
        }

        public <SerializationT extends n> b h(i<SerializationT> iVar) throws GeneralSecurityException {
            c cVar = new c(iVar.c(), iVar.b());
            if (this.f20345d.containsKey(cVar)) {
                i<?> iVar2 = this.f20345d.get(cVar);
                if (!iVar2.equals(iVar) || !iVar.equals(iVar2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + cVar);
                }
            } else {
                this.f20345d.put(cVar, iVar);
            }
            return this;
        }

        public <ParametersT extends t, SerializationT extends n> b i(j<ParametersT, SerializationT> jVar) throws GeneralSecurityException {
            d dVar = new d(jVar.b(), jVar.c());
            if (this.f20344c.containsKey(dVar)) {
                j<?, ?> jVar2 = this.f20344c.get(dVar);
                if (!jVar2.equals(jVar) || !jVar.equals(jVar2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + dVar);
                }
            } else {
                this.f20344c.put(dVar, jVar);
            }
            return this;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends n> f20346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g7.a f20347b;

        public c(Class<? extends n> cls, g7.a aVar) {
            this.f20346a = cls;
            this.f20347b = aVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f20346a.equals(this.f20346a) && cVar.f20347b.equals(this.f20347b);
        }

        public int hashCode() {
            return Objects.hash(this.f20346a, this.f20347b);
        }

        public String toString() {
            return this.f20346a.getSimpleName() + ", object identifier: " + this.f20347b;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<?> f20348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<? extends n> f20349b;

        public d(Class<?> cls, Class<? extends n> cls2) {
            this.f20348a = cls;
            this.f20349b = cls2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return dVar.f20348a.equals(this.f20348a) && dVar.f20349b.equals(this.f20349b);
        }

        public int hashCode() {
            return Objects.hash(this.f20348a, this.f20349b);
        }

        public String toString() {
            return this.f20348a.getSimpleName() + " with serialization type: " + this.f20349b.getSimpleName();
        }
    }

    public o(b bVar) {
        this.f20338a = new HashMap(bVar.f20342a);
        this.f20339b = new HashMap(bVar.f20343b);
        this.f20340c = new HashMap(bVar.f20344c);
        this.f20341d = new HashMap(bVar.f20345d);
    }

    public <SerializationT extends n> r6.f e(SerializationT serializationt, x xVar) throws GeneralSecurityException {
        c cVar = new c(serializationt.getClass(), serializationt.a());
        if (this.f20339b.containsKey(cVar)) {
            return this.f20339b.get(cVar).d(serializationt, xVar);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + cVar + " available");
    }
}
