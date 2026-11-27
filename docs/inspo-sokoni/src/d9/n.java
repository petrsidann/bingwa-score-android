package d9;

import com.google.protobuf.g1;
import com.google.protobuf.x0;

/* JADX INFO: loaded from: classes.dex */
public final class n extends com.google.protobuf.z<n, b> implements x0 {
    private static final n DEFAULT_INSTANCE;
    public static final int FIELD_PATHS_FIELD_NUMBER = 1;
    private static volatile g1<n> PARSER;
    private com.google.protobuf.d0.i<String> fieldPaths_ = com.google.protobuf.z.E();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6565a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6565a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6565a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6565a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6565a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6565a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6565a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6565a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<n, b> implements x0 {
        public b() {
            super(n.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(String str) {
            v();
            ((n) this.f5995b).f0(str);
            return this;
        }
    }

    static {
        n nVar = new n();
        DEFAULT_INSTANCE = nVar;
        com.google.protobuf.z.a0(n.class, nVar);
    }

    public static n h0() {
        return DEFAULT_INSTANCE;
    }

    public static b k0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6565a[fVar.ordinal()]) {
            case 1:
                return new n();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"fieldPaths_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<n> bVar = PARSER;
                if (bVar == null) {
                    synchronized (n.class) {
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

    public final void f0(String str) {
        str.getClass();
        g0();
        this.fieldPaths_.add(str);
    }

    public final void g0() {
        com.google.protobuf.d0.i<String> iVar = this.fieldPaths_;
        if (iVar.g()) {
            return;
        }
        this.fieldPaths_ = com.google.protobuf.z.Q(iVar);
    }

    public String i0(int i10) {
        return this.fieldPaths_.get(i10);
    }

    public int j0() {
        return this.fieldPaths_.size();
    }
}
