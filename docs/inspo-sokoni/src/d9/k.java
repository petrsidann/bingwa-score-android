package d9;

import com.google.protobuf.c2;
import com.google.protobuf.g1;
import com.google.protobuf.p0;
import com.google.protobuf.q0;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class k extends com.google.protobuf.z<k, b> implements x0 {
    public static final int CREATE_TIME_FIELD_NUMBER = 3;
    private static final k DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile g1<k> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 4;
    private int bitField0_;
    private u1 createTime_;
    private q0<String, d0> fields_ = q0.d();
    private String name_ = "";
    private u1 updateTime_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6561a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6561a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6561a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6561a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6561a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6561a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6561a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6561a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<k, b> implements x0 {
        public b() {
            super(k.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(Map<String, d0> map) {
            v();
            ((k) this.f5995b).j0().putAll(map);
            return this;
        }

        public b F(String str) {
            v();
            ((k) this.f5995b).p0(str);
            return this;
        }

        public b H(u1 u1Var) {
            v();
            ((k) this.f5995b).q0(u1Var);
            return this;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p0<String, d0> f6562a = p0.d(c2.b.f5675p, "", c2.b.f5677r, d0.s0());
    }

    static {
        k kVar = new k();
        DEFAULT_INSTANCE = kVar;
        com.google.protobuf.z.a0(k.class, kVar);
    }

    public static k h0() {
        return DEFAULT_INSTANCE;
    }

    public static b o0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6561a[fVar.ordinal()]) {
            case 1:
                return new k();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u00022\u0003ဉ\u0000\u0004ဉ\u0001", new Object[]{"bitField0_", "name_", "fields_", c.f6562a, "createTime_", "updateTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<k> bVar = PARSER;
                if (bVar == null) {
                    synchronized (k.class) {
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

    public Map<String, d0> i0() {
        return Collections.unmodifiableMap(m0());
    }

    public final Map<String, d0> j0() {
        return n0();
    }

    public String k0() {
        return this.name_;
    }

    public u1 l0() {
        u1 u1Var = this.updateTime_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public final q0<String, d0> m0() {
        return this.fields_;
    }

    public final q0<String, d0> n0() {
        if (!this.fields_.i()) {
            this.fields_ = this.fields_.m();
        }
        return this.fields_;
    }

    public final void p0(String str) {
        str.getClass();
        this.name_ = str;
    }

    public final void q0(u1 u1Var) {
        u1Var.getClass();
        this.updateTime_ = u1Var;
        this.bitField0_ |= 2;
    }
}
