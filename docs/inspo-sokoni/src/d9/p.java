package d9;

import com.google.protobuf.g1;
import com.google.protobuf.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class p extends com.google.protobuf.z<p, b> implements x0 {
    private static final p DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int FIELD_TRANSFORMS_FIELD_NUMBER = 2;
    private static volatile g1<p> PARSER;
    private String document_ = "";
    private com.google.protobuf.d0.i<c> fieldTransforms_ = com.google.protobuf.z.E();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6567a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6567a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6567a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6567a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6567a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6567a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6567a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6567a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<p, b> implements x0 {
        public b() {
            super(p.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static final class c extends com.google.protobuf.z<c, a> implements x0 {
        public static final int APPEND_MISSING_ELEMENTS_FIELD_NUMBER = 6;
        private static final c DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int INCREMENT_FIELD_NUMBER = 3;
        public static final int MAXIMUM_FIELD_NUMBER = 4;
        public static final int MINIMUM_FIELD_NUMBER = 5;
        private static volatile g1<c> PARSER = null;
        public static final int REMOVE_ALL_FROM_ARRAY_FIELD_NUMBER = 7;
        public static final int SET_TO_SERVER_VALUE_FIELD_NUMBER = 2;
        private Object transformType_;
        private int transformTypeCase_ = 0;
        private String fieldPath_ = "";

        public static final class a extends com.google.protobuf.z.a<c, a> implements x0 {
            public a() {
                super(c.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public a E(d9.b.C0113b c0113b) {
                v();
                ((c) this.f5995b).q0(c0113b.build());
                return this;
            }

            public a F(String str) {
                v();
                ((c) this.f5995b).r0(str);
                return this;
            }

            public a H(d0 d0Var) {
                v();
                ((c) this.f5995b).s0(d0Var);
                return this;
            }

            public a I(d9.b.C0113b c0113b) {
                v();
                ((c) this.f5995b).t0(c0113b.build());
                return this;
            }

            public a K(b bVar) {
                v();
                ((c) this.f5995b).u0(bVar);
                return this;
            }
        }

        public enum b implements com.google.protobuf.d0.c {
            SERVER_VALUE_UNSPECIFIED(0),
            REQUEST_TIME(1),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final com.google.protobuf.d0.d<b> f6571e = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f6573a;

            public class a implements com.google.protobuf.d0.d<b> {
                @Override // com.google.protobuf.d0.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public b a(int i10) {
                    return b.h(i10);
                }
            }

            b(int i10) {
                this.f6573a = i10;
            }

            public static b h(int i10) {
                if (i10 == 0) {
                    return SERVER_VALUE_UNSPECIFIED;
                }
                if (i10 != 1) {
                    return null;
                }
                return REQUEST_TIME;
            }

            @Override // com.google.protobuf.d0.c
            public final int a() {
                if (this != UNRECOGNIZED) {
                    return this.f6573a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* JADX INFO: renamed from: d9.p$c$c, reason: collision with other inner class name */
        public enum EnumC0114c {
            SET_TO_SERVER_VALUE(2),
            INCREMENT(3),
            MAXIMUM(4),
            MINIMUM(5),
            APPEND_MISSING_ELEMENTS(6),
            REMOVE_ALL_FROM_ARRAY(7),
            TRANSFORMTYPE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f6582a;

            EnumC0114c(int i10) {
                this.f6582a = i10;
            }

            public static EnumC0114c h(int i10) {
                if (i10 == 0) {
                    return TRANSFORMTYPE_NOT_SET;
                }
                switch (i10) {
                    case 2:
                        return SET_TO_SERVER_VALUE;
                    case 3:
                        return INCREMENT;
                    case 4:
                        return MAXIMUM;
                    case 5:
                        return MINIMUM;
                    case 6:
                        return APPEND_MISSING_ELEMENTS;
                    case 7:
                        return REMOVE_ALL_FROM_ARRAY;
                    default:
                        return null;
                }
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            com.google.protobuf.z.a0(c.class, cVar);
        }

        public static a p0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6567a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000", new Object[]{"transformType_", "transformTypeCase_", "fieldPath_", d0.class, d0.class, d0.class, d9.b.class, d9.b.class});
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

        public d9.b j0() {
            return this.transformTypeCase_ == 6 ? (d9.b) this.transformType_ : d9.b.k0();
        }

        public String k0() {
            return this.fieldPath_;
        }

        public d0 l0() {
            return this.transformTypeCase_ == 3 ? (d0) this.transformType_ : d0.s0();
        }

        public d9.b m0() {
            return this.transformTypeCase_ == 7 ? (d9.b) this.transformType_ : d9.b.k0();
        }

        public b n0() {
            if (this.transformTypeCase_ != 2) {
                return b.SERVER_VALUE_UNSPECIFIED;
            }
            b bVarH = b.h(((Integer) this.transformType_).intValue());
            return bVarH == null ? b.UNRECOGNIZED : bVarH;
        }

        public EnumC0114c o0() {
            return EnumC0114c.h(this.transformTypeCase_);
        }

        public final void q0(d9.b bVar) {
            bVar.getClass();
            this.transformType_ = bVar;
            this.transformTypeCase_ = 6;
        }

        public final void r0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        public final void s0(d0 d0Var) {
            d0Var.getClass();
            this.transformType_ = d0Var;
            this.transformTypeCase_ = 3;
        }

        public final void t0(d9.b bVar) {
            bVar.getClass();
            this.transformType_ = bVar;
            this.transformTypeCase_ = 7;
        }

        public final void u0(b bVar) {
            this.transformType_ = Integer.valueOf(bVar.a());
            this.transformTypeCase_ = 2;
        }
    }

    static {
        p pVar = new p();
        DEFAULT_INSTANCE = pVar;
        com.google.protobuf.z.a0(p.class, pVar);
    }

    public static p e0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6567a[fVar.ordinal()]) {
            case 1:
                return new p();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"document_", "fieldTransforms_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<p> bVar = PARSER;
                if (bVar == null) {
                    synchronized (p.class) {
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

    public List<c> f0() {
        return this.fieldTransforms_;
    }
}
