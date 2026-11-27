package r6;

import com.google.crypto.tink.shaded.protobuf.s0;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f15031b = Logger.getLogger(i.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<String, b> f15032a;

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z6.d f15033a;

        public a(z6.d dVar) {
            this.f15033a = dVar;
        }

        @Override // r6.i.b
        public <Q> g<Q> a(Class<Q> cls) throws GeneralSecurityException {
            try {
                return new h(this.f15033a, cls);
            } catch (IllegalArgumentException e10) {
                throw new GeneralSecurityException("Primitive type not supported", e10);
            }
        }

        @Override // r6.i.b
        public g<?> b() {
            z6.d dVar = this.f15033a;
            return new h(dVar, dVar.b());
        }

        @Override // r6.i.b
        public Class<?> c() {
            return this.f15033a.getClass();
        }

        @Override // r6.i.b
        public Set<Class<?>> d() {
            return this.f15033a.i();
        }
    }

    public interface b {
        <P> g<P> a(Class<P> cls);

        g<?> b();

        Class<?> c();

        Set<Class<?>> d();
    }

    public i() {
        this.f15032a = new ConcurrentHashMap();
    }

    public i(i iVar) {
        this.f15032a = new ConcurrentHashMap(iVar.f15032a);
    }

    public static <T> T a(T t10) {
        t10.getClass();
        return t10;
    }

    public static <KeyProtoT extends s0> b b(z6.d<KeyProtoT> dVar) {
        return new a(dVar);
    }

    public static String i(Set<Class<?>> set) {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (Class<?> cls : set) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(cls.getCanonicalName());
            z10 = false;
        }
        return sb2.toString();
    }

    public <P> g<P> c(String str, Class<P> cls) {
        return e(str, (Class) a(cls));
    }

    public final synchronized b d(String str) {
        if (!this.f15032a.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return this.f15032a.get(str);
    }

    public final <P> g<P> e(String str, Class<P> cls) throws GeneralSecurityException {
        b bVarD = d(str);
        if (cls == null) {
            return (g<P>) bVarD.b();
        }
        if (bVarD.d().contains(cls)) {
            return bVarD.a(cls);
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + bVarD.c() + ", supported primitives: " + i(bVarD.d()));
    }

    public g<?> f(String str) {
        return d(str).b();
    }

    public synchronized <KeyProtoT extends s0> void g(z6.d<KeyProtoT> dVar) {
        if (!dVar.a().d()) {
            throw new GeneralSecurityException("failed to register key manager " + dVar.getClass() + " as it is not FIPS compatible.");
        }
        h(b(dVar), false);
    }

    public final synchronized <P> void h(b bVar, boolean z10) {
        String strC = bVar.b().c();
        b bVar2 = this.f15032a.get(strC);
        if (bVar2 != null && !bVar2.c().equals(bVar.c())) {
            f15031b.warning("Attempted overwrite of a registered key manager for key type " + strC);
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strC, bVar2.c().getName(), bVar.c().getName()));
        }
        if (z10) {
            this.f15032a.put(strC, bVar);
        } else {
            this.f15032a.putIfAbsent(strC, bVar);
        }
    }

    public boolean j(String str) {
        return this.f15032a.containsKey(str);
    }
}
