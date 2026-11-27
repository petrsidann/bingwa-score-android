package z6;

import com.google.crypto.tink.shaded.protobuf.s0;
import e7.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class d<KeyProtoT extends s0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<KeyProtoT> f20306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, k<?, KeyProtoT>> f20307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<?> f20308c;

    public static abstract class a<KeyFormatProtoT extends s0, KeyProtoT extends s0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<KeyFormatProtoT> f20309a;

        /* JADX INFO: renamed from: z6.d$a$a, reason: collision with other inner class name */
        public static final class C0343a<KeyFormatProtoT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public KeyFormatProtoT f20310a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public r6.k.b f20311b;

            public C0343a(KeyFormatProtoT keyformatprotot, r6.k.b bVar) {
                this.f20310a = keyformatprotot;
                this.f20311b = bVar;
            }
        }

        public a(Class<KeyFormatProtoT> cls) {
            this.f20309a = cls;
        }

        public abstract KeyProtoT a(KeyFormatProtoT keyformatprotot);

        public final Class<KeyFormatProtoT> b() {
            return this.f20309a;
        }

        public Map<String, C0343a<KeyFormatProtoT>> c() {
            return Collections.emptyMap();
        }

        public abstract KeyFormatProtoT d(com.google.crypto.tink.shaded.protobuf.i iVar);

        public abstract void e(KeyFormatProtoT keyformatprotot);
    }

    @SafeVarargs
    public d(Class<KeyProtoT> cls, k<?, KeyProtoT>... kVarArr) {
        this.f20306a = cls;
        HashMap map = new HashMap();
        for (k<?, KeyProtoT> kVar : kVarArr) {
            if (map.containsKey(kVar.b())) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + kVar.b().getCanonicalName());
            }
            map.put(kVar.b(), kVar);
        }
        this.f20308c = kVarArr.length > 0 ? kVarArr[0].b() : Void.class;
        this.f20307b = Collections.unmodifiableMap(map);
    }

    public w6.b.EnumC0311b a() {
        return w6.b.EnumC0311b.f17650a;
    }

    public final Class<?> b() {
        return this.f20308c;
    }

    public final Class<KeyProtoT> c() {
        return this.f20306a;
    }

    public abstract String d();

    public final <P> P e(KeyProtoT keyprotot, Class<P> cls) {
        k<?, KeyProtoT> kVar = this.f20307b.get(cls);
        if (kVar != null) {
            return (P) kVar.a(keyprotot);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract a<?, KeyProtoT> f();

    public abstract y.c g();

    public abstract KeyProtoT h(com.google.crypto.tink.shaded.protobuf.i iVar);

    public final Set<Class<?>> i() {
        return this.f20307b.keySet();
    }

    public abstract void j(KeyProtoT keyprotot);
}
