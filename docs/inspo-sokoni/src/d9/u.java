package d9;

import com.google.protobuf.c2;
import com.google.protobuf.g1;
import com.google.protobuf.p0;
import com.google.protobuf.q0;
import com.google.protobuf.x0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class u extends com.google.protobuf.z<u, b> implements x0 {
    private static final u DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile g1<u> PARSER;
    private q0<String, d0> fields_ = q0.d();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6600a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6600a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6600a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6600a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6600a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6600a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6600a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6600a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<u, b> implements x0 {
        public b() {
            super(u.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public boolean E(String str) {
            str.getClass();
            return ((u) this.f5995b).h0().containsKey(str);
        }

        public b F(Map<String, d0> map) {
            v();
            ((u) this.f5995b).k0().putAll(map);
            return this;
        }

        public b H(String str, d0 d0Var) {
            str.getClass();
            d0Var.getClass();
            v();
            ((u) this.f5995b).k0().put(str, d0Var);
            return this;
        }

        public b I(String str) {
            str.getClass();
            v();
            ((u) this.f5995b).k0().remove(str);
            return this;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p0<String, d0> f6601a = p0.d(c2.b.f5675p, "", c2.b.f5677r, d0.s0());
    }

    static {
        u uVar = new u();
        DEFAULT_INSTANCE = uVar;
        com.google.protobuf.z.a0(u.class, uVar);
    }

    public static u f0() {
        return DEFAULT_INSTANCE;
    }

    public static b n0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6600a[fVar.ordinal()]) {
            case 1:
                return new u();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", c.f6601a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<u> bVar = PARSER;
                if (bVar == null) {
                    synchronized (u.class) {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new com.google.protobuf.z.b<>(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                        break;
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int g0() {
        return l0().size();
    }

    public Map<String, d0> h0() {
        return Collections.unmodifiableMap(l0());
    }

    public d0 i0(String str, d0 d0Var) {
        str.getClass();
        q0<String, d0> q0VarL0 = l0();
        return q0VarL0.containsKey(str) ? q0VarL0.get(str) : d0Var;
    }

    public d0 j0(String str) {
        str.getClass();
        q0<String, d0> q0VarL0 = l0();
        if (q0VarL0.containsKey(str)) {
            return q0VarL0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public final Map<String, d0> k0() {
        return m0();
    }

    public final q0<String, d0> l0() {
        return this.fields_;
    }

    public final q0<String, d0> m0() {
        if (!this.fields_.i()) {
            this.fields_ = this.fields_.m();
        }
        return this.fields_;
    }
}
