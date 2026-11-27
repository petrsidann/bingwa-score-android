package e7;

import com.google.crypto.tink.shaded.protobuf.a1;
import com.google.crypto.tink.shaded.protobuf.t0;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class b0 extends com.google.crypto.tink.shaded.protobuf.z<b0, b> implements t0 {
    public static final int CATALOGUE_NAME_FIELD_NUMBER = 5;
    private static final b0 DEFAULT_INSTANCE;
    public static final int KEY_MANAGER_VERSION_FIELD_NUMBER = 3;
    public static final int NEW_KEY_ALLOWED_FIELD_NUMBER = 4;
    private static volatile a1<b0> PARSER = null;
    public static final int PRIMITIVE_NAME_FIELD_NUMBER = 1;
    public static final int TYPE_URL_FIELD_NUMBER = 2;
    private int keyManagerVersion_;
    private boolean newKeyAllowed_;
    private String primitiveName_ = "";
    private String typeUrl_ = "";
    private String catalogueName_ = "";

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7021a;

        static {
            int[] iArr = new int[com.google.crypto.tink.shaded.protobuf.z.f.values().length];
            f7021a = iArr;
            try {
                iArr[com.google.crypto.tink.shaded.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7021a[com.google.crypto.tink.shaded.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7021a[com.google.crypto.tink.shaded.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7021a[com.google.crypto.tink.shaded.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7021a[com.google.crypto.tink.shaded.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7021a[com.google.crypto.tink.shaded.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7021a[com.google.crypto.tink.shaded.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.crypto.tink.shaded.protobuf.z.a<b0, b> implements t0 {
        public b() {
            super(b0.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        b0 b0Var = new b0();
        DEFAULT_INSTANCE = b0Var;
        com.google.crypto.tink.shaded.protobuf.z.K(b0.class, b0Var);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.z
    public final Object u(com.google.crypto.tink.shaded.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f7021a[fVar.ordinal()]) {
            case 1:
                return new b0();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.crypto.tink.shaded.protobuf.z.E(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"primitiveName_", "typeUrl_", "keyManagerVersion_", "newKeyAllowed_", "catalogueName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                a1<b0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (b0.class) {
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
