package d9;

import com.google.protobuf.c2;
import com.google.protobuf.g1;
import com.google.protobuf.p0;
import com.google.protobuf.q0;
import com.google.protobuf.x0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class s extends com.google.protobuf.z<s, b> implements x0 {
    public static final int ADD_TARGET_FIELD_NUMBER = 2;
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final s DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 4;
    private static volatile g1<s> PARSER = null;
    public static final int REMOVE_TARGET_FIELD_NUMBER = 3;
    private Object targetChange_;
    private int targetChangeCase_ = 0;
    private q0<String, String> labels_ = q0.d();
    private String database_ = "";

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6589a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6589a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6589a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6589a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6589a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6589a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6589a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6589a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<s, b> implements x0 {
        public b() {
            super(s.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(Map<String, String> map) {
            v();
            ((s) this.f5995b).j0().putAll(map);
            return this;
        }

        public b F(a0 a0Var) {
            v();
            ((s) this.f5995b).m0(a0Var);
            return this;
        }

        public b H(String str) {
            v();
            ((s) this.f5995b).n0(str);
            return this;
        }

        public b I(int i10) {
            v();
            ((s) this.f5995b).o0(i10);
            return this;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p0<String, String> f6590a;

        static {
            c2.b bVar = c2.b.f5675p;
            f6590a = p0.d(bVar, "", bVar, "");
        }
    }

    static {
        s sVar = new s();
        DEFAULT_INSTANCE = sVar;
        com.google.protobuf.z.a0(s.class, sVar);
    }

    public static s i0() {
        return DEFAULT_INSTANCE;
    }

    public static b l0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6589a[fVar.ordinal()]) {
            case 1:
                return new s();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002<\u0000\u00037\u0000\u00042", new Object[]{"targetChange_", "targetChangeCase_", "database_", a0.class, "labels_", c.f6590a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<s> bVar = PARSER;
                if (bVar == null) {
                    synchronized (s.class) {
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

    public final Map<String, String> j0() {
        return k0();
    }

    public final q0<String, String> k0() {
        if (!this.labels_.i()) {
            this.labels_ = this.labels_.m();
        }
        return this.labels_;
    }

    public final void m0(a0 a0Var) {
        a0Var.getClass();
        this.targetChange_ = a0Var;
        this.targetChangeCase_ = 2;
    }

    public final void n0(String str) {
        str.getClass();
        this.database_ = str;
    }

    public final void o0(int i10) {
        this.targetChangeCase_ = 3;
        this.targetChange_ = Integer.valueOf(i10);
    }
}
