package e7;

import com.google.crypto.tink.shaded.protobuf.a1;
import com.google.crypto.tink.shaded.protobuf.t0;

/* JADX INFO: loaded from: classes.dex */
public final class e extends com.google.crypto.tink.shaded.protobuf.z<e, b> implements t0 {
    public static final int AES_CTR_KEY_FORMAT_FIELD_NUMBER = 1;
    private static final e DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FORMAT_FIELD_NUMBER = 2;
    private static volatile a1<e> PARSER;
    private g aesCtrKeyFormat_;
    private w hmacKeyFormat_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7026a;

        static {
            int[] iArr = new int[com.google.crypto.tink.shaded.protobuf.z.f.values().length];
            f7026a = iArr;
            try {
                iArr[com.google.crypto.tink.shaded.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7026a[com.google.crypto.tink.shaded.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7026a[com.google.crypto.tink.shaded.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7026a[com.google.crypto.tink.shaded.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7026a[com.google.crypto.tink.shaded.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7026a[com.google.crypto.tink.shaded.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7026a[com.google.crypto.tink.shaded.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.crypto.tink.shaded.protobuf.z.a<e, b> implements t0 {
        public b() {
            super(e.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b x(g gVar) {
            r();
            ((e) this.f5353b).T(gVar);
            return this;
        }

        public b y(w wVar) {
            r();
            ((e) this.f5353b).U(wVar);
            return this;
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        com.google.crypto.tink.shaded.protobuf.z.K(e.class, eVar);
    }

    public static b R() {
        return DEFAULT_INSTANCE.r();
    }

    public static e S(com.google.crypto.tink.shaded.protobuf.i iVar, com.google.crypto.tink.shaded.protobuf.q qVar) {
        return (e) com.google.crypto.tink.shaded.protobuf.z.F(DEFAULT_INSTANCE, iVar, qVar);
    }

    public g P() {
        g gVar = this.aesCtrKeyFormat_;
        return gVar == null ? g.P() : gVar;
    }

    public w Q() {
        w wVar = this.hmacKeyFormat_;
        return wVar == null ? w.P() : wVar;
    }

    public final void T(g gVar) {
        gVar.getClass();
        this.aesCtrKeyFormat_ = gVar;
    }

    public final void U(w wVar) {
        wVar.getClass();
        this.hmacKeyFormat_ = wVar;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.z
    public final Object u(com.google.crypto.tink.shaded.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f7026a[fVar.ordinal()]) {
            case 1:
                return new e();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.crypto.tink.shaded.protobuf.z.E(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"aesCtrKeyFormat_", "hmacKeyFormat_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                a1<e> bVar = PARSER;
                if (bVar == null) {
                    synchronized (e.class) {
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
