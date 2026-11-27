package r6;

import com.google.crypto.tink.shaded.protobuf.s0;
import e7.a0;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f15066a = Logger.getLogger(w.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference<i> f15067b = new AtomicReference<>(new i());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentMap<String, b> f15068c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentMap<String, Boolean> f15069d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentMap<String, Object> f15070e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentMap<Class<?>, v<?, ?>> f15071f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentMap<String, k> f15072g = new ConcurrentHashMap();

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z6.d f15073a;

        public a(z6.d dVar) {
            this.f15073a = dVar;
        }
    }

    public interface b {
    }

    public static <KeyProtoT extends s0> b a(z6.d<KeyProtoT> dVar) {
        return new a(dVar);
    }

    public static synchronized <KeyProtoT extends s0, KeyFormatProtoT extends s0> void b(String str, Map<String, z6.d.a.C0343a<KeyFormatProtoT>> map, boolean z10) {
        if (z10) {
            try {
                ConcurrentMap<String, Boolean> concurrentMap = f15069d;
                if (concurrentMap.containsKey(str) && !concurrentMap.get(str).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type " + str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            if (f15067b.get().j(str)) {
                for (Map.Entry<String, z6.d.a.C0343a<KeyFormatProtoT>> entry : map.entrySet()) {
                    if (!f15072g.containsKey(entry.getKey())) {
                        throw new GeneralSecurityException("Attempted to register a new key template " + entry.getKey() + " from an existing key manager of type " + str);
                    }
                }
            } else {
                for (Map.Entry<String, z6.d.a.C0343a<KeyFormatProtoT>> entry2 : map.entrySet()) {
                    if (f15072g.containsKey(entry2.getKey())) {
                        throw new GeneralSecurityException("Attempted overwrite of a registered key template " + entry2.getKey());
                    }
                }
            }
        }
    }

    public static Class<?> c(Class<?> cls) {
        v<?, ?> vVar = f15071f.get(cls);
        if (vVar == null) {
            return null;
        }
        return vVar.a();
    }

    public static <P> P d(e7.y yVar, Class<P> cls) {
        return (P) e(yVar.S(), yVar.T(), cls);
    }

    public static <P> P e(String str, com.google.crypto.tink.shaded.protobuf.i iVar, Class<P> cls) {
        return f15067b.get().c(str, cls).d(iVar);
    }

    public static <P> P f(String str, byte[] bArr, Class<P> cls) {
        return (P) e(str, com.google.crypto.tink.shaded.protobuf.i.k(bArr), cls);
    }

    public static g<?> g(String str) {
        return f15067b.get().f(str);
    }

    public static synchronized Map<String, k> h() {
        return Collections.unmodifiableMap(f15072g);
    }

    public static synchronized s0 i(a0 a0Var) {
        g<?> gVarG;
        gVarG = g(a0Var.S());
        if (!f15069d.get(a0Var.S()).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + a0Var.S());
        }
        return gVarG.a(a0Var.T());
    }

    public static synchronized e7.y j(a0 a0Var) {
        g<?> gVarG;
        gVarG = g(a0Var.S());
        if (!f15069d.get(a0Var.S()).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + a0Var.S());
        }
        return gVarG.b(a0Var.T());
    }

    public static synchronized <KeyProtoT extends s0> void k(z6.d<KeyProtoT> dVar, boolean z10) {
        try {
            if (dVar == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            AtomicReference<i> atomicReference = f15067b;
            i iVar = new i(atomicReference.get());
            iVar.g(dVar);
            String strD = dVar.d();
            b(strD, z10 ? dVar.f().c() : Collections.emptyMap(), z10);
            if (!atomicReference.get().j(strD)) {
                f15068c.put(strD, a(dVar));
                if (z10) {
                    l(strD, dVar.f().c());
                }
            }
            f15069d.put(strD, Boolean.valueOf(z10));
            atomicReference.set(iVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static <KeyFormatProtoT extends s0> void l(String str, Map<String, z6.d.a.C0343a<KeyFormatProtoT>> map) {
        for (Map.Entry<String, z6.d.a.C0343a<KeyFormatProtoT>> entry : map.entrySet()) {
            f15072g.put(entry.getKey(), k.a(str, entry.getValue().f20310a.i(), entry.getValue().f20311b));
        }
    }

    public static synchronized <B, P> void m(v<B, P> vVar) {
        try {
            if (vVar == null) {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
            Class<P> clsB = vVar.b();
            ConcurrentMap<Class<?>, v<?, ?>> concurrentMap = f15071f;
            if (concurrentMap.containsKey(clsB)) {
                v<?, ?> vVar2 = concurrentMap.get(clsB);
                if (!vVar.getClass().getName().equals(vVar2.getClass().getName())) {
                    f15066a.warning("Attempted overwrite of a registered PrimitiveWrapper for type " + clsB);
                    throw new GeneralSecurityException(String.format("PrimitiveWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", clsB.getName(), vVar2.getClass().getName(), vVar.getClass().getName()));
                }
            }
            concurrentMap.put(clsB, vVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static <B, P> P n(u<B> uVar, Class<P> cls) throws GeneralSecurityException {
        v<?, ?> vVar = f15071f.get(cls);
        if (vVar == null) {
            throw new GeneralSecurityException("No wrapper found for " + uVar.g().getName());
        }
        if (vVar.a().equals(uVar.g())) {
            return (P) vVar.c(uVar);
        }
        throw new GeneralSecurityException("Wrong input primitive class, expected " + vVar.a() + ", got " + uVar.g());
    }
}
