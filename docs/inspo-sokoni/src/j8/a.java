package j8;

import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import d9.k;

/* JADX INFO: loaded from: classes.dex */
public final class a extends z<a, b> implements x0 {
    private static final a DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 2;
    public static final int HAS_COMMITTED_MUTATIONS_FIELD_NUMBER = 4;
    public static final int NO_DOCUMENT_FIELD_NUMBER = 1;
    private static volatile g1<a> PARSER = null;
    public static final int UNKNOWN_DOCUMENT_FIELD_NUMBER = 3;
    private int documentTypeCase_ = 0;
    private Object documentType_;
    private boolean hasCommittedMutations_;

    /* JADX INFO: renamed from: j8.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0186a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11305a;

        static {
            int[] iArr = new int[z.f.values().length];
            f11305a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11305a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11305a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11305a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11305a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11305a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11305a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends z.a<a, b> implements x0 {
        public b() {
            super(a.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(C0186a c0186a) {
            this();
        }

        public b E(k kVar) {
            v();
            ((a) this.f5995b).p0(kVar);
            return this;
        }

        public b F(boolean z10) {
            v();
            ((a) this.f5995b).q0(z10);
            return this;
        }

        public b H(j8.b bVar) {
            v();
            ((a) this.f5995b).r0(bVar);
            return this;
        }

        public b I(d dVar) {
            v();
            ((a) this.f5995b).s0(dVar);
            return this;
        }
    }

    public enum c {
        NO_DOCUMENT(1),
        DOCUMENT(2),
        UNKNOWN_DOCUMENT(3),
        DOCUMENTTYPE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11311a;

        c(int i10) {
            this.f11311a = i10;
        }

        public static c h(int i10) {
            if (i10 == 0) {
                return DOCUMENTTYPE_NOT_SET;
            }
            if (i10 == 1) {
                return NO_DOCUMENT;
            }
            if (i10 == 2) {
                return DOCUMENT;
            }
            if (i10 != 3) {
                return null;
            }
            return UNKNOWN_DOCUMENT;
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.a0(a.class, aVar);
    }

    public static b n0() {
        return DEFAULT_INSTANCE.y();
    }

    public static a o0(byte[] bArr) {
        return (a) z.W(DEFAULT_INSTANCE, bArr);
    }

    @Override // com.google.protobuf.z
    public final Object C(z.f fVar, Object obj, Object obj2) {
        C0186a c0186a = null;
        switch (C0186a.f11305a[fVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b(c0186a);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004\u0007", new Object[]{"documentType_", "documentTypeCase_", j8.b.class, k.class, d.class, "hasCommittedMutations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<a> bVar = PARSER;
                if (bVar == null) {
                    synchronized (a.class) {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new z.b<>(DEFAULT_INSTANCE);
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

    public k i0() {
        return this.documentTypeCase_ == 2 ? (k) this.documentType_ : k.h0();
    }

    public c j0() {
        return c.h(this.documentTypeCase_);
    }

    public boolean k0() {
        return this.hasCommittedMutations_;
    }

    public j8.b l0() {
        return this.documentTypeCase_ == 1 ? (j8.b) this.documentType_ : j8.b.g0();
    }

    public d m0() {
        return this.documentTypeCase_ == 3 ? (d) this.documentType_ : d.g0();
    }

    public final void p0(k kVar) {
        kVar.getClass();
        this.documentType_ = kVar;
        this.documentTypeCase_ = 2;
    }

    public final void q0(boolean z10) {
        this.hasCommittedMutations_ = z10;
    }

    public final void r0(j8.b bVar) {
        bVar.getClass();
        this.documentType_ = bVar;
        this.documentTypeCase_ = 1;
    }

    public final void s0(d dVar) {
        dVar.getClass();
        this.documentType_ = dVar;
        this.documentTypeCase_ = 3;
    }
}
