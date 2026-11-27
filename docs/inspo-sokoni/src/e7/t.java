package e7;

import com.google.crypto.tink.shaded.protobuf.a1;
import com.google.crypto.tink.shaded.protobuf.t0;

/* JADX INFO: loaded from: classes.dex */
public final class t extends com.google.crypto.tink.shaded.protobuf.z<t, b> implements t0 {
    private static final t DEFAULT_INSTANCE;
    public static final int ENCRYPTED_KEYSET_FIELD_NUMBER = 2;
    public static final int KEYSET_INFO_FIELD_NUMBER = 3;
    private static volatile a1<t> PARSER;
    private com.google.crypto.tink.shaded.protobuf.i encryptedKeyset_ = com.google.crypto.tink.shaded.protobuf.i.f5103b;
    private d0 keysetInfo_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7057a;

        static {
            int[] iArr = new int[com.google.crypto.tink.shaded.protobuf.z.f.values().length];
            f7057a = iArr;
            try {
                iArr[com.google.crypto.tink.shaded.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7057a[com.google.crypto.tink.shaded.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7057a[com.google.crypto.tink.shaded.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7057a[com.google.crypto.tink.shaded.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7057a[com.google.crypto.tink.shaded.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7057a[com.google.crypto.tink.shaded.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7057a[com.google.crypto.tink.shaded.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.crypto.tink.shaded.protobuf.z.a<t, b> implements t0 {
        public b() {
            super(t.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b x(com.google.crypto.tink.shaded.protobuf.i iVar) {
            r();
            ((t) this.f5353b).S(iVar);
            return this;
        }

        public b y(d0 d0Var) {
            r();
            ((t) this.f5353b).T(d0Var);
            return this;
        }
    }

    static {
        t tVar = new t();
        DEFAULT_INSTANCE = tVar;
        com.google.crypto.tink.shaded.protobuf.z.K(t.class, tVar);
    }

    public static b Q() {
        return DEFAULT_INSTANCE.r();
    }

    public static t R(byte[] bArr, com.google.crypto.tink.shaded.protobuf.q qVar) {
        return (t) com.google.crypto.tink.shaded.protobuf.z.G(DEFAULT_INSTANCE, bArr, qVar);
    }

    public com.google.crypto.tink.shaded.protobuf.i P() {
        return this.encryptedKeyset_;
    }

    public final void S(com.google.crypto.tink.shaded.protobuf.i iVar) {
        iVar.getClass();
        this.encryptedKeyset_ = iVar;
    }

    public final void T(d0 d0Var) {
        d0Var.getClass();
        this.keysetInfo_ = d0Var;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.z
    public final Object u(com.google.crypto.tink.shaded.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f7057a[fVar.ordinal()]) {
            case 1:
                return new t();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.crypto.tink.shaded.protobuf.z.E(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"encryptedKeyset_", "keysetInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                a1<t> bVar = PARSER;
                if (bVar == null) {
                    synchronized (t.class) {
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
