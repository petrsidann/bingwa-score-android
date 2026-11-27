package d9;

import com.google.protobuf.g1;
import com.google.protobuf.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class z extends com.google.protobuf.z<z, b> implements x0 {
    private static final z DEFAULT_INSTANCE;
    public static final int END_AT_FIELD_NUMBER = 8;
    public static final int FROM_FIELD_NUMBER = 2;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int OFFSET_FIELD_NUMBER = 6;
    public static final int ORDER_BY_FIELD_NUMBER = 4;
    private static volatile g1<z> PARSER = null;
    public static final int SELECT_FIELD_NUMBER = 1;
    public static final int START_AT_FIELD_NUMBER = 7;
    public static final int WHERE_FIELD_NUMBER = 3;
    private int bitField0_;
    private d9.j endAt_;
    private com.google.protobuf.a0 limit_;
    private int offset_;
    private j select_;
    private d9.j startAt_;
    private h where_;
    private com.google.protobuf.d0.i<c> from_ = com.google.protobuf.z.E();
    private com.google.protobuf.d0.i<i> orderBy_ = com.google.protobuf.z.E();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6611a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6611a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6611a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6611a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6611a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6611a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6611a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6611a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<z, b> implements x0 {
        public b() {
            super(z.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(c.a aVar) {
            v();
            ((z) this.f5995b).k0(aVar.build());
            return this;
        }

        public b F(i iVar) {
            v();
            ((z) this.f5995b).l0(iVar);
            return this;
        }

        public b H(d9.j.b bVar) {
            v();
            ((z) this.f5995b).C0(bVar.build());
            return this;
        }

        public b I(com.google.protobuf.a0.b bVar) {
            v();
            ((z) this.f5995b).D0(bVar.build());
            return this;
        }

        public b K(d9.j.b bVar) {
            v();
            ((z) this.f5995b).E0(bVar.build());
            return this;
        }

        public b L(h hVar) {
            v();
            ((z) this.f5995b).F0(hVar);
            return this;
        }
    }

    public static final class c extends com.google.protobuf.z<c, a> implements x0 {
        public static final int ALL_DESCENDANTS_FIELD_NUMBER = 3;
        public static final int COLLECTION_ID_FIELD_NUMBER = 2;
        private static final c DEFAULT_INSTANCE;
        private static volatile g1<c> PARSER;
        private boolean allDescendants_;
        private String collectionId_ = "";

        public static final class a extends com.google.protobuf.z.a<c, a> implements x0 {
            public a() {
                super(c.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public a E(boolean z10) {
                v();
                ((c) this.f5995b).j0(z10);
                return this;
            }

            public a F(String str) {
                v();
                ((c) this.f5995b).k0(str);
                return this;
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            com.google.protobuf.z.a0(c.class, cVar);
        }

        public static a i0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6611a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002Ȉ\u0003\u0007", new Object[]{"collectionId_", "allDescendants_"});
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

        public boolean g0() {
            return this.allDescendants_;
        }

        public String h0() {
            return this.collectionId_;
        }

        public final void j0(boolean z10) {
            this.allDescendants_ = z10;
        }

        public final void k0(String str) {
            str.getClass();
            this.collectionId_ = str;
        }
    }

    public static final class d extends com.google.protobuf.z<d, a> implements x0 {
        private static final d DEFAULT_INSTANCE;
        public static final int FILTERS_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile g1<d> PARSER;
        private com.google.protobuf.d0.i<h> filters_ = com.google.protobuf.z.E();
        private int op_;

        public static final class a extends com.google.protobuf.z.a<d, a> implements x0 {
            public a() {
                super(d.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public a E(Iterable<? extends h> iterable) {
                v();
                ((d) this.f5995b).g0(iterable);
                return this;
            }

            public a F(b bVar) {
                v();
                ((d) this.f5995b).m0(bVar);
                return this;
            }
        }

        public enum b implements com.google.protobuf.d0.c {
            OPERATOR_UNSPECIFIED(0),
            AND(1),
            OR(2),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final com.google.protobuf.d0.d<b> f6616f = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f6618a;

            public class a implements com.google.protobuf.d0.d<b> {
                @Override // com.google.protobuf.d0.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public b a(int i10) {
                    return b.h(i10);
                }
            }

            b(int i10) {
                this.f6618a = i10;
            }

            public static b h(int i10) {
                if (i10 == 0) {
                    return OPERATOR_UNSPECIFIED;
                }
                if (i10 == 1) {
                    return AND;
                }
                if (i10 != 2) {
                    return null;
                }
                return OR;
            }

            @Override // com.google.protobuf.d0.c
            public final int a() {
                if (this != UNRECOGNIZED) {
                    return this.f6618a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            d dVar = new d();
            DEFAULT_INSTANCE = dVar;
            com.google.protobuf.z.a0(d.class, dVar);
        }

        public static d i0() {
            return DEFAULT_INSTANCE;
        }

        public static a l0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6611a[fVar.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0002\u001b", new Object[]{"op_", "filters_", h.class});
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

        public final void g0(Iterable<? extends h> iterable) {
            h0();
            com.google.protobuf.a.k(iterable, this.filters_);
        }

        public final void h0() {
            com.google.protobuf.d0.i<h> iVar = this.filters_;
            if (iVar.g()) {
                return;
            }
            this.filters_ = com.google.protobuf.z.Q(iVar);
        }

        public List<h> j0() {
            return this.filters_;
        }

        public b k0() {
            b bVarH = b.h(this.op_);
            return bVarH == null ? b.UNRECOGNIZED : bVarH;
        }

        public final void m0(b bVar) {
            this.op_ = bVar.a();
        }
    }

    public enum e implements com.google.protobuf.d0.c {
        DIRECTION_UNSPECIFIED(0),
        ASCENDING(1),
        DESCENDING(2),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final com.google.protobuf.d0.d<e> f6623f = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6625a;

        public class a implements com.google.protobuf.d0.d<e> {
            @Override // com.google.protobuf.d0.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e a(int i10) {
                return e.h(i10);
            }
        }

        e(int i10) {
            this.f6625a = i10;
        }

        public static e h(int i10) {
            if (i10 == 0) {
                return DIRECTION_UNSPECIFIED;
            }
            if (i10 == 1) {
                return ASCENDING;
            }
            if (i10 != 2) {
                return null;
            }
            return DESCENDING;
        }

        @Override // com.google.protobuf.d0.c
        public final int a() {
            if (this != UNRECOGNIZED) {
                return this.f6625a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final class f extends com.google.protobuf.z<f, a> implements x0 {
        private static final f DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 1;
        public static final int OP_FIELD_NUMBER = 2;
        private static volatile g1<f> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 3;
        private int bitField0_;
        private g field_;
        private int op_;
        private d0 value_;

        public static final class a extends com.google.protobuf.z.a<f, a> implements x0 {
            public a() {
                super(f.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public a E(g gVar) {
                v();
                ((f) this.f5995b).m0(gVar);
                return this;
            }

            public a F(b bVar) {
                v();
                ((f) this.f5995b).n0(bVar);
                return this;
            }

            public a H(d0 d0Var) {
                v();
                ((f) this.f5995b).o0(d0Var);
                return this;
            }
        }

        public enum b implements com.google.protobuf.d0.c {
            OPERATOR_UNSPECIFIED(0),
            LESS_THAN(1),
            LESS_THAN_OR_EQUAL(2),
            GREATER_THAN(3),
            GREATER_THAN_OR_EQUAL(4),
            EQUAL(5),
            NOT_EQUAL(6),
            ARRAY_CONTAINS(7),
            IN(8),
            ARRAY_CONTAINS_ANY(9),
            NOT_IN(10),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public static final com.google.protobuf.d0.d<b> f6638s = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f6640a;

            public class a implements com.google.protobuf.d0.d<b> {
                @Override // com.google.protobuf.d0.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public b a(int i10) {
                    return b.h(i10);
                }
            }

            b(int i10) {
                this.f6640a = i10;
            }

            public static b h(int i10) {
                switch (i10) {
                    case 0:
                        return OPERATOR_UNSPECIFIED;
                    case 1:
                        return LESS_THAN;
                    case 2:
                        return LESS_THAN_OR_EQUAL;
                    case 3:
                        return GREATER_THAN;
                    case 4:
                        return GREATER_THAN_OR_EQUAL;
                    case 5:
                        return EQUAL;
                    case 6:
                        return NOT_EQUAL;
                    case 7:
                        return ARRAY_CONTAINS;
                    case 8:
                        return IN;
                    case 9:
                        return ARRAY_CONTAINS_ANY;
                    case 10:
                        return NOT_IN;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.d0.c
            public final int a() {
                if (this != UNRECOGNIZED) {
                    return this.f6640a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            f fVar = new f();
            DEFAULT_INSTANCE = fVar;
            com.google.protobuf.z.a0(f.class, fVar);
        }

        public static f h0() {
            return DEFAULT_INSTANCE;
        }

        public static a l0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6611a[fVar.ordinal()]) {
                case 1:
                    return new f();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003ဉ\u0001", new Object[]{"bitField0_", "field_", "op_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<f> bVar = PARSER;
                    if (bVar == null) {
                        synchronized (f.class) {
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

        public g i0() {
            g gVar = this.field_;
            return gVar == null ? g.f0() : gVar;
        }

        public b j0() {
            b bVarH = b.h(this.op_);
            return bVarH == null ? b.UNRECOGNIZED : bVarH;
        }

        public d0 k0() {
            d0 d0Var = this.value_;
            return d0Var == null ? d0.s0() : d0Var;
        }

        public final void m0(g gVar) {
            gVar.getClass();
            this.field_ = gVar;
            this.bitField0_ |= 1;
        }

        public final void n0(b bVar) {
            this.op_ = bVar.a();
        }

        public final void o0(d0 d0Var) {
            d0Var.getClass();
            this.value_ = d0Var;
            this.bitField0_ |= 2;
        }
    }

    public static final class g extends com.google.protobuf.z<g, a> implements x0 {
        private static final g DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 2;
        private static volatile g1<g> PARSER;
        private String fieldPath_ = "";

        public static final class a extends com.google.protobuf.z.a<g, a> implements x0 {
            public a() {
                super(g.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public a E(String str) {
                v();
                ((g) this.f5995b).i0(str);
                return this;
            }
        }

        static {
            g gVar = new g();
            DEFAULT_INSTANCE = gVar;
            com.google.protobuf.z.a0(g.class, gVar);
        }

        public static g f0() {
            return DEFAULT_INSTANCE;
        }

        public static a h0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6611a[fVar.ordinal()]) {
                case 1:
                    return new g();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"fieldPath_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<g> bVar = PARSER;
                    if (bVar == null) {
                        synchronized (g.class) {
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

        public String g0() {
            return this.fieldPath_;
        }

        public final void i0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }
    }

    public static final class h extends com.google.protobuf.z<h, a> implements x0 {
        public static final int COMPOSITE_FILTER_FIELD_NUMBER = 1;
        private static final h DEFAULT_INSTANCE;
        public static final int FIELD_FILTER_FIELD_NUMBER = 2;
        private static volatile g1<h> PARSER = null;
        public static final int UNARY_FILTER_FIELD_NUMBER = 3;
        private int filterTypeCase_ = 0;
        private Object filterType_;

        public static final class a extends com.google.protobuf.z.a<h, a> implements x0 {
            public a() {
                super(h.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public a E(d.a aVar) {
                v();
                ((h) this.f5995b).n0(aVar.build());
                return this;
            }

            public a F(f.a aVar) {
                v();
                ((h) this.f5995b).o0(aVar.build());
                return this;
            }

            public a H(k.a aVar) {
                v();
                ((h) this.f5995b).p0(aVar.build());
                return this;
            }
        }

        public enum b {
            COMPOSITE_FILTER(1),
            FIELD_FILTER(2),
            UNARY_FILTER(3),
            FILTERTYPE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f6646a;

            b(int i10) {
                this.f6646a = i10;
            }

            public static b h(int i10) {
                if (i10 == 0) {
                    return FILTERTYPE_NOT_SET;
                }
                if (i10 == 1) {
                    return COMPOSITE_FILTER;
                }
                if (i10 == 2) {
                    return FIELD_FILTER;
                }
                if (i10 != 3) {
                    return null;
                }
                return UNARY_FILTER;
            }
        }

        static {
            h hVar = new h();
            DEFAULT_INSTANCE = hVar;
            com.google.protobuf.z.a0(h.class, hVar);
        }

        public static h i0() {
            return DEFAULT_INSTANCE;
        }

        public static a m0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6611a[fVar.ordinal()]) {
                case 1:
                    return new h();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"filterType_", "filterTypeCase_", d.class, f.class, k.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<h> bVar = PARSER;
                    if (bVar == null) {
                        synchronized (h.class) {
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

        public d h0() {
            return this.filterTypeCase_ == 1 ? (d) this.filterType_ : d.i0();
        }

        public f j0() {
            return this.filterTypeCase_ == 2 ? (f) this.filterType_ : f.h0();
        }

        public b k0() {
            return b.h(this.filterTypeCase_);
        }

        public k l0() {
            return this.filterTypeCase_ == 3 ? (k) this.filterType_ : k.g0();
        }

        public final void n0(d dVar) {
            dVar.getClass();
            this.filterType_ = dVar;
            this.filterTypeCase_ = 1;
        }

        public final void o0(f fVar) {
            fVar.getClass();
            this.filterType_ = fVar;
            this.filterTypeCase_ = 2;
        }

        public final void p0(k kVar) {
            kVar.getClass();
            this.filterType_ = kVar;
            this.filterTypeCase_ = 3;
        }
    }

    public static final class i extends com.google.protobuf.z<i, a> implements x0 {
        private static final i DEFAULT_INSTANCE;
        public static final int DIRECTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile g1<i> PARSER;
        private int bitField0_;
        private int direction_;
        private g field_;

        public static final class a extends com.google.protobuf.z.a<i, a> implements x0 {
            public a() {
                super(i.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public a E(e eVar) {
                v();
                ((i) this.f5995b).j0(eVar);
                return this;
            }

            public a F(g gVar) {
                v();
                ((i) this.f5995b).k0(gVar);
                return this;
            }
        }

        static {
            i iVar = new i();
            DEFAULT_INSTANCE = iVar;
            com.google.protobuf.z.a0(i.class, iVar);
        }

        public static a i0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6611a[fVar.ordinal()]) {
                case 1:
                    return new i();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f", new Object[]{"bitField0_", "field_", "direction_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<i> bVar = PARSER;
                    if (bVar == null) {
                        synchronized (i.class) {
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

        public e g0() {
            e eVarH = e.h(this.direction_);
            return eVarH == null ? e.UNRECOGNIZED : eVarH;
        }

        public g h0() {
            g gVar = this.field_;
            return gVar == null ? g.f0() : gVar;
        }

        public final void j0(e eVar) {
            this.direction_ = eVar.a();
        }

        public final void k0(g gVar) {
            gVar.getClass();
            this.field_ = gVar;
            this.bitField0_ |= 1;
        }
    }

    public static final class j extends com.google.protobuf.z<j, a> implements x0 {
        private static final j DEFAULT_INSTANCE;
        public static final int FIELDS_FIELD_NUMBER = 2;
        private static volatile g1<j> PARSER;
        private com.google.protobuf.d0.i<g> fields_ = com.google.protobuf.z.E();

        public static final class a extends com.google.protobuf.z.a<j, a> implements x0 {
            public a() {
                super(j.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        static {
            j jVar = new j();
            DEFAULT_INSTANCE = jVar;
            com.google.protobuf.z.a0(j.class, jVar);
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6611a[fVar.ordinal()]) {
                case 1:
                    return new j();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002\u001b", new Object[]{"fields_", g.class});
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
    }

    public static final class k extends com.google.protobuf.z<k, a> implements x0 {
        private static final k DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile g1<k> PARSER;
        private int op_;
        private int operandTypeCase_ = 0;
        private Object operandType_;

        public static final class a extends com.google.protobuf.z.a<k, a> implements x0 {
            public a() {
                super(k.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public a E(g gVar) {
                v();
                ((k) this.f5995b).k0(gVar);
                return this;
            }

            public a F(b bVar) {
                v();
                ((k) this.f5995b).l0(bVar);
                return this;
            }
        }

        public enum b implements com.google.protobuf.d0.c {
            OPERATOR_UNSPECIFIED(0),
            IS_NAN(2),
            IS_NULL(3),
            IS_NOT_NAN(4),
            IS_NOT_NULL(5),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final com.google.protobuf.d0.d<b> f6653m = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f6655a;

            public class a implements com.google.protobuf.d0.d<b> {
                @Override // com.google.protobuf.d0.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public b a(int i10) {
                    return b.h(i10);
                }
            }

            b(int i10) {
                this.f6655a = i10;
            }

            public static b h(int i10) {
                if (i10 == 0) {
                    return OPERATOR_UNSPECIFIED;
                }
                if (i10 == 2) {
                    return IS_NAN;
                }
                if (i10 == 3) {
                    return IS_NULL;
                }
                if (i10 == 4) {
                    return IS_NOT_NAN;
                }
                if (i10 != 5) {
                    return null;
                }
                return IS_NOT_NULL;
            }

            @Override // com.google.protobuf.d0.c
            public final int a() {
                if (this != UNRECOGNIZED) {
                    return this.f6655a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            k kVar = new k();
            DEFAULT_INSTANCE = kVar;
            com.google.protobuf.z.a0(k.class, kVar);
        }

        public static k g0() {
            return DEFAULT_INSTANCE;
        }

        public static a j0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f6611a[fVar.ordinal()]) {
                case 1:
                    return new k();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002<\u0000", new Object[]{"operandType_", "operandTypeCase_", "op_", g.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<k> bVar = PARSER;
                    if (bVar == null) {
                        synchronized (k.class) {
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

        public g h0() {
            return this.operandTypeCase_ == 2 ? (g) this.operandType_ : g.f0();
        }

        public b i0() {
            b bVarH = b.h(this.op_);
            return bVarH == null ? b.UNRECOGNIZED : bVarH;
        }

        public final void k0(g gVar) {
            gVar.getClass();
            this.operandType_ = gVar;
            this.operandTypeCase_ = 2;
        }

        public final void l0(b bVar) {
            this.op_ = bVar.a();
        }
    }

    static {
        z zVar = new z();
        DEFAULT_INSTANCE = zVar;
        com.google.protobuf.z.a0(z.class, zVar);
    }

    public static b B0() {
        return DEFAULT_INSTANCE.y();
    }

    public static z o0() {
        return DEFAULT_INSTANCE;
    }

    public boolean A0() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6611a[fVar.ordinal()]) {
            case 1:
                return new z();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u001b\u0005ဉ\u0004\u0006\u0004\u0007ဉ\u0002\bဉ\u0003", new Object[]{"bitField0_", "select_", "from_", c.class, "where_", "orderBy_", i.class, "limit_", "offset_", "startAt_", "endAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<z> bVar = PARSER;
                if (bVar == null) {
                    synchronized (z.class) {
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

    public final void C0(d9.j jVar) {
        jVar.getClass();
        this.endAt_ = jVar;
        this.bitField0_ |= 8;
    }

    public final void D0(com.google.protobuf.a0 a0Var) {
        a0Var.getClass();
        this.limit_ = a0Var;
        this.bitField0_ |= 16;
    }

    public final void E0(d9.j jVar) {
        jVar.getClass();
        this.startAt_ = jVar;
        this.bitField0_ |= 4;
    }

    public final void F0(h hVar) {
        hVar.getClass();
        this.where_ = hVar;
        this.bitField0_ |= 2;
    }

    public final void k0(c cVar) {
        cVar.getClass();
        m0();
        this.from_.add(cVar);
    }

    public final void l0(i iVar) {
        iVar.getClass();
        n0();
        this.orderBy_.add(iVar);
    }

    public final void m0() {
        com.google.protobuf.d0.i<c> iVar = this.from_;
        if (iVar.g()) {
            return;
        }
        this.from_ = com.google.protobuf.z.Q(iVar);
    }

    public final void n0() {
        com.google.protobuf.d0.i<i> iVar = this.orderBy_;
        if (iVar.g()) {
            return;
        }
        this.orderBy_ = com.google.protobuf.z.Q(iVar);
    }

    public d9.j p0() {
        d9.j jVar = this.endAt_;
        return jVar == null ? d9.j.j0() : jVar;
    }

    public c q0(int i10) {
        return this.from_.get(i10);
    }

    public int r0() {
        return this.from_.size();
    }

    public com.google.protobuf.a0 s0() {
        com.google.protobuf.a0 a0Var = this.limit_;
        return a0Var == null ? com.google.protobuf.a0.f0() : a0Var;
    }

    public i t0(int i10) {
        return this.orderBy_.get(i10);
    }

    public int u0() {
        return this.orderBy_.size();
    }

    public d9.j v0() {
        d9.j jVar = this.startAt_;
        return jVar == null ? d9.j.j0() : jVar;
    }

    public h w0() {
        h hVar = this.where_;
        return hVar == null ? h.i0() : hVar;
    }

    public boolean x0() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean y0() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean z0() {
        return (this.bitField0_ & 4) != 0;
    }
}
