package e7;

import com.google.crypto.tink.shaded.protobuf.a1;
import com.google.crypto.tink.shaded.protobuf.t0;

/* JADX INFO: loaded from: classes.dex */
public final class b extends com.google.crypto.tink.shaded.protobuf.z<b, C0123b> implements t0 {
    private static final b DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile a1<b> PARSER;
    private int keySize_;
    private c params_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7020a;

        static {
            int[] iArr = new int[com.google.crypto.tink.shaded.protobuf.z.f.values().length];
            f7020a = iArr;
            try {
                iArr[com.google.crypto.tink.shaded.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7020a[com.google.crypto.tink.shaded.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7020a[com.google.crypto.tink.shaded.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7020a[com.google.crypto.tink.shaded.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7020a[com.google.crypto.tink.shaded.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7020a[com.google.crypto.tink.shaded.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7020a[com.google.crypto.tink.shaded.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: e7.b$b, reason: collision with other inner class name */
    public static final class C0123b extends com.google.crypto.tink.shaded.protobuf.z.a<b, C0123b> implements t0 {
        public C0123b() {
            super(b.DEFAULT_INSTANCE);
        }

        public /* synthetic */ C0123b(a aVar) {
            this();
        }

        public C0123b x(int i10) {
            r();
            ((b) this.f5353b).T(i10);
            return this;
        }

        public C0123b y(c cVar) {
            r();
            ((b) this.f5353b).U(cVar);
            return this;
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        com.google.crypto.tink.shaded.protobuf.z.K(b.class, bVar);
    }

    public static C0123b R() {
        return DEFAULT_INSTANCE.r();
    }

    public static b S(com.google.crypto.tink.shaded.protobuf.i iVar, com.google.crypto.tink.shaded.protobuf.q qVar) {
        return (b) com.google.crypto.tink.shaded.protobuf.z.F(DEFAULT_INSTANCE, iVar, qVar);
    }

    public int P() {
        return this.keySize_;
    }

    public c Q() {
        c cVar = this.params_;
        return cVar == null ? c.O() : cVar;
    }

    public final void T(int i10) {
        this.keySize_ = i10;
    }

    public final void U(c cVar) {
        cVar.getClass();
        this.params_ = cVar;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.z
    public final Object u(com.google.crypto.tink.shaded.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f7020a[fVar.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return new C0123b(aVar);
            case 3:
                return com.google.crypto.tink.shaded.protobuf.z.E(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"keySize_", "params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                a1<b> bVar = PARSER;
                if (bVar == null) {
                    synchronized (b.class) {
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
