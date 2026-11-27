package d9;

import com.google.protobuf.g1;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b extends com.google.protobuf.z<b, C0113b> implements c {
    private static final b DEFAULT_INSTANCE;
    private static volatile g1<b> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private com.google.protobuf.d0.i<d0> values_ = com.google.protobuf.z.E();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6510a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6510a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6510a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6510a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6510a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6510a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6510a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6510a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: renamed from: d9.b$b, reason: collision with other inner class name */
    public static final class C0113b extends com.google.protobuf.z.a<b, C0113b> implements c {
        public C0113b() {
            super(b.DEFAULT_INSTANCE);
        }

        public /* synthetic */ C0113b(a aVar) {
            this();
        }

        public C0113b E(Iterable<? extends d0> iterable) {
            v();
            ((b) this.f5995b).h0(iterable);
            return this;
        }

        public C0113b F(d0 d0Var) {
            v();
            ((b) this.f5995b).i0(d0Var);
            return this;
        }

        public d0 H(int i10) {
            return ((b) this.f5995b).l0(i10);
        }

        public int I() {
            return ((b) this.f5995b).m0();
        }

        public C0113b K(int i10) {
            v();
            ((b) this.f5995b).o0(i10);
            return this;
        }

        @Override // d9.c
        public List<d0> m() {
            return Collections.unmodifiableList(((b) this.f5995b).m());
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        com.google.protobuf.z.a0(b.class, bVar);
    }

    public static b k0() {
        return DEFAULT_INSTANCE;
    }

    public static C0113b n0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6510a[fVar.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return new C0113b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", d0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<b> bVar = PARSER;
                if (bVar == null) {
                    synchronized (b.class) {
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

    public final void h0(Iterable<? extends d0> iterable) {
        j0();
        com.google.protobuf.a.k(iterable, this.values_);
    }

    public final void i0(d0 d0Var) {
        d0Var.getClass();
        j0();
        this.values_.add(d0Var);
    }

    public final void j0() {
        com.google.protobuf.d0.i<d0> iVar = this.values_;
        if (iVar.g()) {
            return;
        }
        this.values_ = com.google.protobuf.z.Q(iVar);
    }

    public d0 l0(int i10) {
        return this.values_.get(i10);
    }

    @Override // d9.c
    public List<d0> m() {
        return this.values_;
    }

    public int m0() {
        return this.values_.size();
    }

    public final void o0(int i10) {
        j0();
        this.values_.remove(i10);
    }
}
