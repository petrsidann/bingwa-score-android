package d9;

import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;

/* JADX INFO: loaded from: classes.dex */
public final class a0 extends com.google.protobuf.z<a0, b> implements x0 {
    private static final a0 DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 3;
    public static final int EXPECTED_COUNT_FIELD_NUMBER = 12;
    public static final int ONCE_FIELD_NUMBER = 6;
    private static volatile g1<a0> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int READ_TIME_FIELD_NUMBER = 11;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_ID_FIELD_NUMBER = 5;
    private int bitField0_;
    private com.google.protobuf.a0 expectedCount_;
    private boolean once_;
    private Object resumeType_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private int resumeTypeCase_ = 0;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6509a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6509a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6509a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6509a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6509a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6509a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6509a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6509a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<a0, b> implements x0 {
        public b() {
            super(a0.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(c cVar) {
            v();
            ((a0) this.f5995b).l0(cVar);
            return this;
        }

        public b F(com.google.protobuf.a0.b bVar) {
            v();
            ((a0) this.f5995b).m0(bVar.build());
            return this;
        }

        public b H(d dVar) {
            v();
            ((a0) this.f5995b).n0(dVar);
            return this;
        }

        public b I(u1 u1Var) {
            v();
            ((a0) this.f5995b).o0(u1Var);
            return this;
        }

        public b K(com.google.protobuf.i iVar) {
            v();
            ((a0) this.f5995b).p0(iVar);
            return this;
        }

        public b L(int i10) {
            v();
            ((a0) this.f5995b).q0(i10);
            return this;
        }
    }

    public static final class c extends com.google.protobuf.z<c, a> implements x0 {
        private static final c DEFAULT_INSTANCE;
        public static final int DOCUMENTS_FIELD_NUMBER = 2;
        private static volatile g1<c> PARSER;
        private com.google.protobuf.d0.i<String> documents_ = com.google.protobuf.z.E();

        public static final class a extends com.google.protobuf.z.a<c, a> implements x0 {
            public a() {
                super(c.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public a E(String str) {
                v();
                ((c) this.f5995b).f0(str);
                return this;
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            com.google.protobuf.z.a0(c.class, cVar);
        }

        public static c h0() {
            return DEFAULT_INSTANCE;
        }

        public static a k0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6509a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002Ț", new Object[]{"documents_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<c> bVar = PARSER;
                    if (bVar == null) {
                        synchronized (c.class) {
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
            this.documents_.add(str);
        }

        public final void g0() {
            com.google.protobuf.d0.i<String> iVar = this.documents_;
            if (iVar.g()) {
                return;
            }
            this.documents_ = com.google.protobuf.z.Q(iVar);
        }

        public String i0(int i10) {
            return this.documents_.get(i10);
        }

        public int j0() {
            return this.documents_.size();
        }
    }

    public static final class d extends com.google.protobuf.z<d, a> implements x0 {
        private static final d DEFAULT_INSTANCE;
        public static final int PARENT_FIELD_NUMBER = 1;
        private static volatile g1<d> PARSER = null;
        public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
        private Object queryType_;
        private int queryTypeCase_ = 0;
        private String parent_ = "";

        public static final class a extends com.google.protobuf.z.a<d, a> implements x0 {
            public a() {
                super(d.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public a E(String str) {
                v();
                ((d) this.f5995b).k0(str);
                return this;
            }

            public a F(z.b bVar) {
                v();
                ((d) this.f5995b).l0(bVar.build());
                return this;
            }
        }

        static {
            d dVar = new d();
            DEFAULT_INSTANCE = dVar;
            com.google.protobuf.z.a0(d.class, dVar);
        }

        public static d g0() {
            return DEFAULT_INSTANCE;
        }

        public static a j0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6509a[fVar.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000", new Object[]{"queryType_", "queryTypeCase_", "parent_", z.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<d> bVar = PARSER;
                    if (bVar == null) {
                        synchronized (d.class) {
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

        public String h0() {
            return this.parent_;
        }

        public z i0() {
            return this.queryTypeCase_ == 2 ? (z) this.queryType_ : z.o0();
        }

        public final void k0(String str) {
            str.getClass();
            this.parent_ = str;
        }

        public final void l0(z zVar) {
            zVar.getClass();
            this.queryType_ = zVar;
            this.queryTypeCase_ = 2;
        }
    }

    static {
        a0 a0Var = new a0();
        DEFAULT_INSTANCE = a0Var;
        com.google.protobuf.z.a0(a0.class, a0Var);
    }

    public static b k0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6509a[fVar.ordinal()]) {
            case 1:
                return new a0();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0007\u0002\u0001\u0002\f\u0007\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004=\u0001\u0005\u0004\u0006\u0007\u000b<\u0001\fဉ\u0000", new Object[]{"targetType_", "targetTypeCase_", "resumeType_", "resumeTypeCase_", "bitField0_", d.class, c.class, "targetId_", "once_", u1.class, "expectedCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<a0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (a0.class) {
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

    public final void l0(c cVar) {
        cVar.getClass();
        this.targetType_ = cVar;
        this.targetTypeCase_ = 3;
    }

    public final void m0(com.google.protobuf.a0 a0Var) {
        a0Var.getClass();
        this.expectedCount_ = a0Var;
        this.bitField0_ |= 1;
    }

    public final void n0(d dVar) {
        dVar.getClass();
        this.targetType_ = dVar;
        this.targetTypeCase_ = 2;
    }

    public final void o0(u1 u1Var) {
        u1Var.getClass();
        this.resumeType_ = u1Var;
        this.resumeTypeCase_ = 11;
    }

    public final void p0(com.google.protobuf.i iVar) {
        iVar.getClass();
        this.resumeTypeCase_ = 4;
        this.resumeType_ = iVar;
    }

    public final void q0(int i10) {
        this.targetId_ = i10;
    }
}
