package d9;

import com.google.protobuf.g1;
import com.google.protobuf.x0;

/* JADX INFO: loaded from: classes.dex */
public final class y extends com.google.protobuf.z<y, c> implements x0 {
    public static final int AGGREGATIONS_FIELD_NUMBER = 3;
    private static final y DEFAULT_INSTANCE;
    private static volatile g1<y> PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 1;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private com.google.protobuf.d0.i<b> aggregations_ = com.google.protobuf.z.E();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6610a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6610a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6610a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6610a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6610a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6610a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6610a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6610a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z<b, C0116b> implements x0 {
        public static final int ALIAS_FIELD_NUMBER = 7;
        public static final int AVG_FIELD_NUMBER = 3;
        public static final int COUNT_FIELD_NUMBER = 1;
        private static final b DEFAULT_INSTANCE;
        private static volatile g1<b> PARSER = null;
        public static final int SUM_FIELD_NUMBER = 2;
        private Object operator_;
        private int operatorCase_ = 0;
        private String alias_ = "";

        public static final class a extends com.google.protobuf.z<a, C0115a> implements x0 {
            private static final a DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile g1<a> PARSER;
            private int bitField0_;
            private z.g field_;

            /* JADX INFO: renamed from: d9.y$b$a$a, reason: collision with other inner class name */
            public static final class C0115a extends com.google.protobuf.z.a<a, C0115a> implements x0 {
                public C0115a() {
                    super(a.DEFAULT_INSTANCE);
                }

                public /* synthetic */ C0115a(a aVar) {
                    this();
                }

                public C0115a E(z.g gVar) {
                    v();
                    ((a) this.f5995b).g0(gVar);
                    return this;
                }
            }

            static {
                a aVar = new a();
                DEFAULT_INSTANCE = aVar;
                com.google.protobuf.z.a0(a.class, aVar);
            }

            public static C0115a f0() {
                return DEFAULT_INSTANCE.y();
            }

            @Override // com.google.protobuf.z
            public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
                a aVar = null;
                switch (a.f6610a[fVar.ordinal()]) {
                    case 1:
                        return new a();
                    case 2:
                        return new C0115a(aVar);
                    case 3:
                        return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "field_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        g1<a> bVar = PARSER;
                        if (bVar == null) {
                            synchronized (a.class) {
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

            public final void g0(z.g gVar) {
                gVar.getClass();
                this.field_ = gVar;
                this.bitField0_ |= 1;
            }
        }

        /* JADX INFO: renamed from: d9.y$b$b, reason: collision with other inner class name */
        public static final class C0116b extends com.google.protobuf.z.a<b, C0116b> implements x0 {
            public C0116b() {
                super(b.DEFAULT_INSTANCE);
            }

            public /* synthetic */ C0116b(a aVar) {
                this();
            }

            public C0116b E(String str) {
                v();
                ((b) this.f5995b).j0(str);
                return this;
            }

            public C0116b F(a aVar) {
                v();
                ((b) this.f5995b).k0(aVar);
                return this;
            }

            public C0116b H(c cVar) {
                v();
                ((b) this.f5995b).l0(cVar);
                return this;
            }

            public C0116b I(d dVar) {
                v();
                ((b) this.f5995b).m0(dVar);
                return this;
            }
        }

        public static final class c extends com.google.protobuf.z<c, a> implements x0 {
            private static final c DEFAULT_INSTANCE;
            private static volatile g1<c> PARSER = null;
            public static final int UP_TO_FIELD_NUMBER = 1;
            private int bitField0_;
            private com.google.protobuf.b0 upTo_;

            public static final class a extends com.google.protobuf.z.a<c, a> implements x0 {
                public a() {
                    super(c.DEFAULT_INSTANCE);
                }

                public /* synthetic */ a(a aVar) {
                    this();
                }
            }

            static {
                c cVar = new c();
                DEFAULT_INSTANCE = cVar;
                com.google.protobuf.z.a0(c.class, cVar);
            }

            public static c e0() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.z
            public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
                a aVar = null;
                switch (a.f6610a[fVar.ordinal()]) {
                    case 1:
                        return new c();
                    case 2:
                        return new a(aVar);
                    case 3:
                        return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "upTo_"});
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
        }

        public static final class d extends com.google.protobuf.z<d, a> implements x0 {
            private static final d DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile g1<d> PARSER;
            private int bitField0_;
            private z.g field_;

            public static final class a extends com.google.protobuf.z.a<d, a> implements x0 {
                public a() {
                    super(d.DEFAULT_INSTANCE);
                }

                public /* synthetic */ a(a aVar) {
                    this();
                }

                public a E(z.g gVar) {
                    v();
                    ((d) this.f5995b).g0(gVar);
                    return this;
                }
            }

            static {
                d dVar = new d();
                DEFAULT_INSTANCE = dVar;
                com.google.protobuf.z.a0(d.class, dVar);
            }

            public static a f0() {
                return DEFAULT_INSTANCE.y();
            }

            @Override // com.google.protobuf.z
            public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
                a aVar = null;
                switch (a.f6610a[fVar.ordinal()]) {
                    case 1:
                        return new d();
                    case 2:
                        return new a(aVar);
                    case 3:
                        return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "field_"});
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

            public final void g0(z.g gVar) {
                gVar.getClass();
                this.field_ = gVar;
                this.bitField0_ |= 1;
            }
        }

        static {
            b bVar = new b();
            DEFAULT_INSTANCE = bVar;
            com.google.protobuf.z.a0(b.class, bVar);
        }

        public static C0116b i0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6610a[fVar.ordinal()]) {
                case 1:
                    return new b();
                case 2:
                    return new C0116b(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0007\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0007Ȉ", new Object[]{"operator_", "operatorCase_", c.class, d.class, a.class, "alias_"});
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

        public final void j0(String str) {
            str.getClass();
            this.alias_ = str;
        }

        public final void k0(a aVar) {
            aVar.getClass();
            this.operator_ = aVar;
            this.operatorCase_ = 3;
        }

        public final void l0(c cVar) {
            cVar.getClass();
            this.operator_ = cVar;
            this.operatorCase_ = 1;
        }

        public final void m0(d dVar) {
            dVar.getClass();
            this.operator_ = dVar;
            this.operatorCase_ = 2;
        }
    }

    public static final class c extends com.google.protobuf.z.a<y, c> implements x0 {
        public c() {
            super(y.DEFAULT_INSTANCE);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public c E(Iterable<? extends b> iterable) {
            v();
            ((y) this.f5995b).g0(iterable);
            return this;
        }

        public c F(z zVar) {
            v();
            ((y) this.f5995b).j0(zVar);
            return this;
        }
    }

    static {
        y yVar = new y();
        DEFAULT_INSTANCE = yVar;
        com.google.protobuf.z.a0(y.class, yVar);
    }

    public static c i0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6610a[fVar.ordinal()]) {
            case 1:
                return new y();
            case 2:
                return new c(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001<\u0000\u0003\u001b", new Object[]{"queryType_", "queryTypeCase_", z.class, "aggregations_", b.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<y> bVar = PARSER;
                if (bVar == null) {
                    synchronized (y.class) {
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

    public final void g0(Iterable<? extends b> iterable) {
        h0();
        com.google.protobuf.a.k(iterable, this.aggregations_);
    }

    public final void h0() {
        com.google.protobuf.d0.i<b> iVar = this.aggregations_;
        if (iVar.g()) {
            return;
        }
        this.aggregations_ = com.google.protobuf.z.Q(iVar);
    }

    public final void j0(z zVar) {
        zVar.getClass();
        this.queryType_ = zVar;
        this.queryTypeCase_ = 1;
    }
}
