package e7;

import com.google.crypto.tink.shaded.protobuf.a1;
import com.google.crypto.tink.shaded.protobuf.t0;

/* JADX INFO: loaded from: classes.dex */
public final class e0 extends com.google.crypto.tink.shaded.protobuf.z<e0, b> implements t0 {
    private static final e0 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile a1<e0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private f0 params_;
    private int version_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7027a;

        static {
            int[] iArr = new int[com.google.crypto.tink.shaded.protobuf.z.f.values().length];
            f7027a = iArr;
            try {
                iArr[com.google.crypto.tink.shaded.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7027a[com.google.crypto.tink.shaded.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7027a[com.google.crypto.tink.shaded.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7027a[com.google.crypto.tink.shaded.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7027a[com.google.crypto.tink.shaded.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7027a[com.google.crypto.tink.shaded.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7027a[com.google.crypto.tink.shaded.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.crypto.tink.shaded.protobuf.z.a<e0, b> implements t0 {
        public b() {
            super(e0.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b x(f0 f0Var) {
            r();
            ((e0) this.f5353b).T(f0Var);
            return this;
        }

        public b y(int i10) {
            r();
            ((e0) this.f5353b).U(i10);
            return this;
        }
    }

    static {
        e0 e0Var = new e0();
        DEFAULT_INSTANCE = e0Var;
        com.google.crypto.tink.shaded.protobuf.z.K(e0.class, e0Var);
    }

    public static b R() {
        return DEFAULT_INSTANCE.r();
    }

    public static e0 S(com.google.crypto.tink.shaded.protobuf.i iVar, com.google.crypto.tink.shaded.protobuf.q qVar) {
        return (e0) com.google.crypto.tink.shaded.protobuf.z.F(DEFAULT_INSTANCE, iVar, qVar);
    }

    public f0 P() {
        f0 f0Var = this.params_;
        return f0Var == null ? f0.N() : f0Var;
    }

    public int Q() {
        return this.version_;
    }

    public final void T(f0 f0Var) {
        f0Var.getClass();
        this.params_ = f0Var;
    }

    public final void U(int i10) {
        this.version_ = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.z
    public final Object u(com.google.crypto.tink.shaded.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f7027a[fVar.ordinal()]) {
            case 1:
                return new e0();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.crypto.tink.shaded.protobuf.z.E(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"version_", "params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                a1<e0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (e0.class) {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new com.google.crypto.tink.shaded.protobuf.z.b<>(DEFAULT_INSTANCE);
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
}
