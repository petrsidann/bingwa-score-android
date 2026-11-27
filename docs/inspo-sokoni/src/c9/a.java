package c9;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;

/* JADX INFO: loaded from: classes.dex */
public final class a extends z<a, b> implements x0 {
    private static final a DEFAULT_INSTANCE;
    public static final int LIMIT_TYPE_FIELD_NUMBER = 3;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile g1<a> PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
    private int limitType_;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private String parent_ = "";

    /* JADX INFO: renamed from: c9.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0068a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3438a;

        static {
            int[] iArr = new int[z.f.values().length];
            f3438a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3438a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3438a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3438a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3438a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3438a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3438a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends z.a<a, b> implements x0 {
        public b() {
            super(a.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(C0068a c0068a) {
            this();
        }

        public b E(c cVar) {
            v();
            ((a) this.f5995b).m0(cVar);
            return this;
        }

        public b F(String str) {
            v();
            ((a) this.f5995b).n0(str);
            return this;
        }

        public b H(d9.z zVar) {
            v();
            ((a) this.f5995b).o0(zVar);
            return this;
        }
    }

    public enum c implements d0.c {
        FIRST(0),
        LAST(1),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d0.d<c> f3442e = new C0069a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3444a;

        /* JADX INFO: renamed from: c9.a$c$a, reason: collision with other inner class name */
        public class C0069a implements d0.d<c> {
            @Override // com.google.protobuf.d0.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i10) {
                return c.h(i10);
            }
        }

        c(int i10) {
            this.f3444a = i10;
        }

        public static c h(int i10) {
            if (i10 == 0) {
                return FIRST;
            }
            if (i10 != 1) {
                return null;
            }
            return LAST;
        }

        @Override // com.google.protobuf.d0.c
        public final int a() {
            if (this != UNRECOGNIZED) {
                return this.f3444a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.a0(a.class, aVar);
    }

    public static b k0() {
        return DEFAULT_INSTANCE.y();
    }

    public static a l0(byte[] bArr) {
        return (a) z.W(DEFAULT_INSTANCE, bArr);
    }

    @Override // com.google.protobuf.z
    public final Object C(z.f fVar, Object obj, Object obj2) {
        C0068a c0068a = null;
        switch (C0068a.f3438a[fVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b(c0068a);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0003\f", new Object[]{"queryType_", "queryTypeCase_", "parent_", d9.z.class, "limitType_"});
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

    public c h0() {
        c cVarH = c.h(this.limitType_);
        return cVarH == null ? c.UNRECOGNIZED : cVarH;
    }

    public String i0() {
        return this.parent_;
    }

    public d9.z j0() {
        return this.queryTypeCase_ == 2 ? (d9.z) this.queryType_ : d9.z.o0();
    }

    public final void m0(c cVar) {
        this.limitType_ = cVar.a();
    }

    public final void n0(String str) {
        str.getClass();
        this.parent_ = str;
    }

    public final void o0(d9.z zVar) {
        zVar.getClass();
        this.queryType_ = zVar;
        this.queryTypeCase_ = 2;
    }
}
