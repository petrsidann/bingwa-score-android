package d9;

import com.google.protobuf.g1;
import com.google.protobuf.x0;

/* JADX INFO: loaded from: classes.dex */
public final class q extends com.google.protobuf.z<q, b> implements x0 {
    public static final int COUNT_FIELD_NUMBER = 2;
    private static final q DEFAULT_INSTANCE;
    private static volatile g1<q> PARSER = null;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    public static final int UNCHANGED_NAMES_FIELD_NUMBER = 3;
    private int bitField0_;
    private int count_;
    private int targetId_;
    private g unchangedNames_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6583a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6583a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6583a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6583a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6583a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6583a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6583a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6583a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<q, b> implements x0 {
        public b() {
            super(q.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        q qVar = new q();
        DEFAULT_INSTANCE = qVar;
        com.google.protobuf.z.a0(q.class, qVar);
    }

    public static q f0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6583a[fVar.ordinal()]) {
            case 1:
                return new q();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003ဉ\u0000", new Object[]{"bitField0_", "targetId_", "count_", "unchangedNames_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<q> bVar = PARSER;
                if (bVar == null) {
                    synchronized (q.class) {
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

    public int e0() {
        return this.count_;
    }

    public int g0() {
        return this.targetId_;
    }

    public g h0() {
        g gVar = this.unchangedNames_;
        return gVar == null ? g.f0() : gVar;
    }
}
