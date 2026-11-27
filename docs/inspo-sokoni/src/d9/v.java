package d9;

import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;

/* JADX INFO: loaded from: classes.dex */
public final class v extends com.google.protobuf.z<v, b> implements x0 {
    private static final v DEFAULT_INSTANCE;
    public static final int EXISTS_FIELD_NUMBER = 1;
    private static volatile g1<v> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 2;
    private int conditionTypeCase_ = 0;
    private Object conditionType_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6602a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6602a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6602a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6602a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6602a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6602a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6602a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6602a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<v, b> implements x0 {
        public b() {
            super(v.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(boolean z10) {
            v();
            ((v) this.f5995b).l0(z10);
            return this;
        }

        public b F(u1 u1Var) {
            v();
            ((v) this.f5995b).m0(u1Var);
            return this;
        }
    }

    public enum c {
        EXISTS(1),
        UPDATE_TIME(2),
        CONDITIONTYPE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6607a;

        c(int i10) {
            this.f6607a = i10;
        }

        public static c h(int i10) {
            if (i10 == 0) {
                return CONDITIONTYPE_NOT_SET;
            }
            if (i10 == 1) {
                return EXISTS;
            }
            if (i10 != 2) {
                return null;
            }
            return UPDATE_TIME;
        }
    }

    static {
        v vVar = new v();
        DEFAULT_INSTANCE = vVar;
        com.google.protobuf.z.a0(v.class, vVar);
    }

    public static v h0() {
        return DEFAULT_INSTANCE;
    }

    public static b k0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6602a[fVar.ordinal()]) {
            case 1:
                return new v();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001:\u0000\u0002<\u0000", new Object[]{"conditionType_", "conditionTypeCase_", u1.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<v> bVar = PARSER;
                if (bVar == null) {
                    synchronized (v.class) {
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

    public c g0() {
        return c.h(this.conditionTypeCase_);
    }

    public boolean i0() {
        if (this.conditionTypeCase_ == 1) {
            return ((Boolean) this.conditionType_).booleanValue();
        }
        return false;
    }

    public u1 j0() {
        return this.conditionTypeCase_ == 2 ? (u1) this.conditionType_ : u1.g0();
    }

    public final void l0(boolean z10) {
        this.conditionTypeCase_ = 1;
        this.conditionType_ = Boolean.valueOf(z10);
    }

    public final void m0(u1 u1Var) {
        u1Var.getClass();
        this.conditionType_ = u1Var;
        this.conditionTypeCase_ = 2;
    }
}
