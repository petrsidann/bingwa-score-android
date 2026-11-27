package b9;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a extends z<a, b> implements x0 {
    private static final a DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile g1<a> PARSER = null;
    public static final int QUERY_SCOPE_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 4;
    private int queryScope_;
    private int state_;
    private String name_ = "";
    private d0.i<c> fields_ = z.E();

    /* JADX INFO: renamed from: b9.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0047a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3016a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3016a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3016a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3016a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3016a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3016a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3016a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3016a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends z.a<a, b> implements x0 {
        public b() {
            super(a.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(C0047a c0047a) {
            this();
        }

        public b E(c.b bVar) {
            v();
            ((a) this.f5995b).g0(bVar.build());
            return this;
        }

        public b F(d dVar) {
            v();
            ((a) this.f5995b).l0(dVar);
            return this;
        }
    }

    public static final class c extends z<c, b> implements x0 {
        public static final int ARRAY_CONFIG_FIELD_NUMBER = 3;
        private static final c DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int ORDER_FIELD_NUMBER = 2;
        private static volatile g1<c> PARSER;
        private Object valueMode_;
        private int valueModeCase_ = 0;
        private String fieldPath_ = "";

        /* JADX INFO: renamed from: b9.a$c$a, reason: collision with other inner class name */
        public enum EnumC0048a implements d0.c {
            ARRAY_CONFIG_UNSPECIFIED(0),
            CONTAINS(1),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final d0.d<EnumC0048a> f3020e = new C0049a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f3022a;

            /* JADX INFO: renamed from: b9.a$c$a$a, reason: collision with other inner class name */
            public class C0049a implements d0.d<EnumC0048a> {
                @Override // com.google.protobuf.d0.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumC0048a a(int i10) {
                    return EnumC0048a.h(i10);
                }
            }

            EnumC0048a(int i10) {
                this.f3022a = i10;
            }

            public static EnumC0048a h(int i10) {
                if (i10 == 0) {
                    return ARRAY_CONFIG_UNSPECIFIED;
                }
                if (i10 != 1) {
                    return null;
                }
                return CONTAINS;
            }

            @Override // com.google.protobuf.d0.c
            public final int a() {
                if (this != UNRECOGNIZED) {
                    return this.f3022a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        public static final class b extends z.a<c, b> implements x0 {
            public b() {
                super(c.DEFAULT_INSTANCE);
            }

            public /* synthetic */ b(C0047a c0047a) {
                this();
            }

            public b E(EnumC0048a enumC0048a) {
                v();
                ((c) this.f5995b).l0(enumC0048a);
                return this;
            }

            public b F(String str) {
                v();
                ((c) this.f5995b).m0(str);
                return this;
            }

            public b H(EnumC0050c enumC0050c) {
                v();
                ((c) this.f5995b).n0(enumC0050c);
                return this;
            }
        }

        /* JADX INFO: renamed from: b9.a$c$c, reason: collision with other inner class name */
        public enum EnumC0050c implements d0.c {
            ORDER_UNSPECIFIED(0),
            ASCENDING(1),
            DESCENDING(2),
            UNRECOGNIZED(-1);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final d0.d<EnumC0050c> f3027f = new C0051a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f3029a;

            /* JADX INFO: renamed from: b9.a$c$c$a, reason: collision with other inner class name */
            public class C0051a implements d0.d<EnumC0050c> {
                @Override // com.google.protobuf.d0.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumC0050c a(int i10) {
                    return EnumC0050c.h(i10);
                }
            }

            EnumC0050c(int i10) {
                this.f3029a = i10;
            }

            public static EnumC0050c h(int i10) {
                if (i10 == 0) {
                    return ORDER_UNSPECIFIED;
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
                    return this.f3029a;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        public enum d {
            ORDER(2),
            ARRAY_CONFIG(3),
            VALUEMODE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f3034a;

            d(int i10) {
                this.f3034a = i10;
            }

            public static d h(int i10) {
                if (i10 == 0) {
                    return VALUEMODE_NOT_SET;
                }
                if (i10 == 2) {
                    return ORDER;
                }
                if (i10 != 3) {
                    return null;
                }
                return ARRAY_CONFIG;
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            z.a0(c.class, cVar);
        }

        public static b k0() {
            return DEFAULT_INSTANCE.y();
        }

        @Override // com.google.protobuf.z
        public final Object C(z.f fVar, Object obj, Object obj2) {
            C0047a c0047a = null;
            switch (C0047a.f3016a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new b(c0047a);
                case 3:
                    return z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003?\u0000", new Object[]{"valueMode_", "valueModeCase_", "fieldPath_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    g1<c> bVar = PARSER;
                    if (bVar == null) {
                        synchronized (c.class) {
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

        public String h0() {
            return this.fieldPath_;
        }

        public EnumC0050c i0() {
            if (this.valueModeCase_ != 2) {
                return EnumC0050c.ORDER_UNSPECIFIED;
            }
            EnumC0050c enumC0050cH = EnumC0050c.h(((Integer) this.valueMode_).intValue());
            return enumC0050cH == null ? EnumC0050c.UNRECOGNIZED : enumC0050cH;
        }

        public d j0() {
            return d.h(this.valueModeCase_);
        }

        public final void l0(EnumC0048a enumC0048a) {
            this.valueMode_ = Integer.valueOf(enumC0048a.a());
            this.valueModeCase_ = 3;
        }

        public final void m0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        public final void n0(EnumC0050c enumC0050c) {
            this.valueMode_ = Integer.valueOf(enumC0050c.a());
            this.valueModeCase_ = 2;
        }
    }

    public enum d implements d0.c {
        QUERY_SCOPE_UNSPECIFIED(0),
        COLLECTION(1),
        COLLECTION_GROUP(2),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d0.d<d> f3039f = new C0052a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3041a;

        /* JADX INFO: renamed from: b9.a$d$a, reason: collision with other inner class name */
        public class C0052a implements d0.d<d> {
            @Override // com.google.protobuf.d0.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i10) {
                return d.h(i10);
            }
        }

        d(int i10) {
            this.f3041a = i10;
        }

        public static d h(int i10) {
            if (i10 == 0) {
                return QUERY_SCOPE_UNSPECIFIED;
            }
            if (i10 == 1) {
                return COLLECTION;
            }
            if (i10 != 2) {
                return null;
            }
            return COLLECTION_GROUP;
        }

        @Override // com.google.protobuf.d0.c
        public final int a() {
            if (this != UNRECOGNIZED) {
                return this.f3041a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.a0(a.class, aVar);
    }

    public static b j0() {
        return DEFAULT_INSTANCE.y();
    }

    public static a k0(byte[] bArr) {
        return (a) z.W(DEFAULT_INSTANCE, bArr);
    }

    @Override // com.google.protobuf.z
    public final Object C(z.f fVar, Object obj, Object obj2) {
        C0047a c0047a = null;
        switch (C0047a.f3016a[fVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b(c0047a);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\f\u0003\u001b\u0004\f", new Object[]{"name_", "queryScope_", "fields_", c.class, "state_"});
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

    public final void g0(c cVar) {
        cVar.getClass();
        h0();
        this.fields_.add(cVar);
    }

    public final void h0() {
        d0.i<c> iVar = this.fields_;
        if (iVar.g()) {
            return;
        }
        this.fields_ = z.Q(iVar);
    }

    public List<c> i0() {
        return this.fields_;
    }

    public final void l0(d dVar) {
        this.queryScope_ = dVar.a();
    }
}
