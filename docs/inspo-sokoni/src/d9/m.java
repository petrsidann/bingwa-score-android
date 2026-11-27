package d9;

import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class m extends com.google.protobuf.z<m, b> implements x0 {
    private static final m DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile g1<m> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
    private int bitField0_;
    private u1 readTime_;
    private int removedTargetIdsMemoizedSerializedSize = -1;
    private String document_ = "";
    private com.google.protobuf.d0.g removedTargetIds_ = com.google.protobuf.z.D();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6564a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6564a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6564a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6564a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6564a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6564a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6564a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6564a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<m, b> implements x0 {
        public b() {
            super(m.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        m mVar = new m();
        DEFAULT_INSTANCE = mVar;
        com.google.protobuf.z.a0(m.class, mVar);
    }

    public static m e0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6564a[fVar.ordinal()]) {
            case 1:
                return new m();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0006\u0003\u0000\u0001\u0000\u0001Ȉ\u0004ဉ\u0000\u0006'", new Object[]{"bitField0_", "document_", "readTime_", "removedTargetIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<m> bVar = PARSER;
                if (bVar == null) {
                    synchronized (m.class) {
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

    public String f0() {
        return this.document_;
    }

    public u1 g0() {
        u1 u1Var = this.readTime_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public List<Integer> h0() {
        return this.removedTargetIds_;
    }
}
