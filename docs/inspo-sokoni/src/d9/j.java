package d9;

import com.google.protobuf.g1;
import com.google.protobuf.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class j extends com.google.protobuf.z<j, b> implements x0 {
    public static final int BEFORE_FIELD_NUMBER = 2;
    private static final j DEFAULT_INSTANCE;
    private static volatile g1<j> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private boolean before_;
    private com.google.protobuf.d0.i<d0> values_ = com.google.protobuf.z.E();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6560a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6560a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6560a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6560a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6560a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6560a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6560a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6560a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<j, b> implements x0 {
        public b() {
            super(j.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(Iterable<? extends d0> iterable) {
            v();
            ((j) this.f5995b).g0(iterable);
            return this;
        }

        public b F(boolean z10) {
            v();
            ((j) this.f5995b).l0(z10);
            return this;
        }
    }

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        com.google.protobuf.z.a0(j.class, jVar);
    }

    public static j j0() {
        return DEFAULT_INSTANCE;
    }

    public static b k0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6560a[fVar.ordinal()]) {
            case 1:
                return new j();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0007", new Object[]{"values_", d0.class, "before_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<j> bVar = PARSER;
                if (bVar == null) {
                    synchronized (j.class) {
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

    public final void g0(Iterable<? extends d0> iterable) {
        h0();
        com.google.protobuf.a.k(iterable, this.values_);
    }

    public final void h0() {
        com.google.protobuf.d0.i<d0> iVar = this.values_;
        if (iVar.g()) {
            return;
        }
        this.values_ = com.google.protobuf.z.Q(iVar);
    }

    public boolean i0() {
        return this.before_;
    }

    public final void l0(boolean z10) {
        this.before_ = z10;
    }

    public List<d0> m() {
        return this.values_;
    }
}
