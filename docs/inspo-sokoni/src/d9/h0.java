package d9;

import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;

/* JADX INFO: loaded from: classes.dex */
public final class h0 extends com.google.protobuf.z<h0, b> implements x0 {
    private static final h0 DEFAULT_INSTANCE;
    private static volatile g1<h0> PARSER = null;
    public static final int TRANSFORM_RESULTS_FIELD_NUMBER = 2;
    public static final int UPDATE_TIME_FIELD_NUMBER = 1;
    private int bitField0_;
    private com.google.protobuf.d0.i<d0> transformResults_ = com.google.protobuf.z.E();
    private u1 updateTime_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6558a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6558a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6558a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6558a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6558a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6558a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6558a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6558a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<h0, b> implements x0 {
        public b() {
            super(h0.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        h0 h0Var = new h0();
        DEFAULT_INSTANCE = h0Var;
        com.google.protobuf.z.a0(h0.class, h0Var);
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6558a[fVar.ordinal()]) {
            case 1:
                return new h0();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "updateTime_", "transformResults_", d0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<h0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (h0.class) {
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

    public d0 e0(int i10) {
        return this.transformResults_.get(i10);
    }

    public int f0() {
        return this.transformResults_.size();
    }

    public u1 g0() {
        u1 u1Var = this.updateTime_;
        return u1Var == null ? u1.g0() : u1Var;
    }
}
