package d9;

import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;

/* JADX INFO: loaded from: classes.dex */
public final class w extends com.google.protobuf.z<w, b> implements x0 {
    private static final w DEFAULT_INSTANCE;
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 5;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile g1<w> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int STRUCTURED_AGGREGATION_QUERY_FIELD_NUMBER = 2;
    public static final int TRANSACTION_FIELD_NUMBER = 4;
    private Object consistencySelector_;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private int consistencySelectorCase_ = 0;
    private String parent_ = "";

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6608a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6608a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6608a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6608a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6608a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6608a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6608a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6608a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<w, b> implements x0 {
        public b() {
            super(w.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(String str) {
            v();
            ((w) this.f5995b).i0(str);
            return this;
        }

        public b F(y yVar) {
            v();
            ((w) this.f5995b).j0(yVar);
            return this;
        }
    }

    static {
        w wVar = new w();
        DEFAULT_INSTANCE = wVar;
        com.google.protobuf.z.a0(w.class, wVar);
    }

    public static w g0() {
        return DEFAULT_INSTANCE;
    }

    public static b h0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6608a[fVar.ordinal()]) {
            case 1:
                return new w();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0005\u0002\u0000\u0001\u0006\u0005\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0004=\u0001\u0005<\u0001\u0006<\u0001", new Object[]{"queryType_", "queryTypeCase_", "consistencySelector_", "consistencySelectorCase_", "parent_", y.class, c0.class, u1.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<w> bVar = PARSER;
                if (bVar == null) {
                    synchronized (w.class) {
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

    public final void i0(String str) {
        str.getClass();
        this.parent_ = str;
    }

    public final void j0(y yVar) {
        yVar.getClass();
        this.queryType_ = yVar;
        this.queryTypeCase_ = 2;
    }
}
