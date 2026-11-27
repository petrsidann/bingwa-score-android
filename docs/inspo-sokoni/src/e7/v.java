package e7;

import com.google.crypto.tink.shaded.protobuf.a1;
import com.google.crypto.tink.shaded.protobuf.t0;

/* JADX INFO: loaded from: classes.dex */
public final class v extends com.google.crypto.tink.shaded.protobuf.z<v, b> implements t0 {
    private static final v DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile a1<v> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.i keyValue_ = com.google.crypto.tink.shaded.protobuf.i.f5103b;
    private x params_;
    private int version_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7068a;

        static {
            int[] iArr = new int[com.google.crypto.tink.shaded.protobuf.z.f.values().length];
            f7068a = iArr;
            try {
                iArr[com.google.crypto.tink.shaded.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7068a[com.google.crypto.tink.shaded.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7068a[com.google.crypto.tink.shaded.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7068a[com.google.crypto.tink.shaded.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7068a[com.google.crypto.tink.shaded.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7068a[com.google.crypto.tink.shaded.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7068a[com.google.crypto.tink.shaded.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.crypto.tink.shaded.protobuf.z.a<v, b> implements t0 {
        public b() {
            super(v.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b x(com.google.crypto.tink.shaded.protobuf.i iVar) {
            r();
            ((v) this.f5353b).W(iVar);
            return this;
        }

        public b y(x xVar) {
            r();
            ((v) this.f5353b).X(xVar);
            return this;
        }

        public b z(int i10) {
            r();
            ((v) this.f5353b).Y(i10);
            return this;
        }
    }

    static {
        v vVar = new v();
        DEFAULT_INSTANCE = vVar;
        com.google.crypto.tink.shaded.protobuf.z.K(v.class, vVar);
    }

    public static v Q() {
        return DEFAULT_INSTANCE;
    }

    public static b U() {
        return DEFAULT_INSTANCE.r();
    }

    public static v V(com.google.crypto.tink.shaded.protobuf.i iVar, com.google.crypto.tink.shaded.protobuf.q qVar) {
        return (v) com.google.crypto.tink.shaded.protobuf.z.F(DEFAULT_INSTANCE, iVar, qVar);
    }

    public com.google.crypto.tink.shaded.protobuf.i R() {
        return this.keyValue_;
    }

    public x S() {
        x xVar = this.params_;
        return xVar == null ? x.P() : xVar;
    }

    public int T() {
        return this.version_;
    }

    public final void W(com.google.crypto.tink.shaded.protobuf.i iVar) {
        iVar.getClass();
        this.keyValue_ = iVar;
    }

    public final void X(x xVar) {
        xVar.getClass();
        this.params_ = xVar;
    }

    public final void Y(int i10) {
        this.version_ = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.z
    public final Object u(com.google.crypto.tink.shaded.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f7068a[fVar.ordinal()]) {
            case 1:
                return new v();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.crypto.tink.shaded.protobuf.z.E(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                a1<v> bVar = PARSER;
                if (bVar == null) {
                    synchronized (v.class) {
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
