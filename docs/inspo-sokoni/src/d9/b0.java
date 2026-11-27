package d9;

import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b0 extends com.google.protobuf.z<b0, b> implements x0 {
    public static final int CAUSE_FIELD_NUMBER = 3;
    private static final b0 DEFAULT_INSTANCE;
    private static volatile g1<b0> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_CHANGE_TYPE_FIELD_NUMBER = 1;
    public static final int TARGET_IDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private n9.a cause_;
    private u1 readTime_;
    private int targetChangeType_;
    private int targetIdsMemoizedSerializedSize = -1;
    private com.google.protobuf.d0.g targetIds_ = com.google.protobuf.z.D();
    private com.google.protobuf.i resumeToken_ = com.google.protobuf.i.f5753b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6511a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6511a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6511a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6511a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6511a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6511a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6511a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6511a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<b0, b> implements x0 {
        public b() {
            super(b0.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public enum c implements com.google.protobuf.d0.c {
        NO_CHANGE(0),
        ADD(1),
        REMOVE(2),
        CURRENT(3),
        RESET(4),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final com.google.protobuf.d0.d<c> f6518m = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6520a;

        public class a implements com.google.protobuf.d0.d<c> {
            @Override // com.google.protobuf.d0.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i10) {
                return c.h(i10);
            }
        }

        c(int i10) {
            this.f6520a = i10;
        }

        public static c h(int i10) {
            if (i10 == 0) {
                return NO_CHANGE;
            }
            if (i10 == 1) {
                return ADD;
            }
            if (i10 == 2) {
                return REMOVE;
            }
            if (i10 == 3) {
                return CURRENT;
            }
            if (i10 != 4) {
                return null;
            }
            return RESET;
        }

        @Override // com.google.protobuf.d0.c
        public final int a() {
            if (this != UNRECOGNIZED) {
                return this.f6520a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        b0 b0Var = new b0();
        DEFAULT_INSTANCE = b0Var;
        com.google.protobuf.z.a0(b0.class, b0Var);
    }

    public static b0 f0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6511a[fVar.ordinal()]) {
            case 1:
                return new b0();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0000\u0001\f\u0002'\u0003ဉ\u0000\u0004\n\u0006ဉ\u0001", new Object[]{"bitField0_", "targetChangeType_", "targetIds_", "cause_", "resumeToken_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<b0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (b0.class) {
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

    public n9.a e0() {
        n9.a aVar = this.cause_;
        return aVar == null ? n9.a.f0() : aVar;
    }

    public u1 g0() {
        u1 u1Var = this.readTime_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public com.google.protobuf.i h0() {
        return this.resumeToken_;
    }

    public c i0() {
        c cVarH = c.h(this.targetChangeType_);
        return cVarH == null ? c.UNRECOGNIZED : cVarH;
    }

    public int j0() {
        return this.targetIds_.size();
    }

    public List<Integer> k0() {
        return this.targetIds_;
    }
}
