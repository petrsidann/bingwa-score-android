package j8;

import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;

/* JADX INFO: loaded from: classes.dex */
public final class d extends z<d, b> implements x0 {
    private static final d DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile g1<d> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private int bitField0_;
    private String name_ = "";
    private u1 version_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11319a;

        static {
            int[] iArr = new int[z.f.values().length];
            f11319a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11319a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11319a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11319a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11319a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11319a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11319a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends z.a<d, b> implements x0 {
        public b() {
            super(d.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(String str) {
            v();
            ((d) this.f5995b).k0(str);
            return this;
        }

        public b F(u1 u1Var) {
            v();
            ((d) this.f5995b).l0(u1Var);
            return this;
        }
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        z.a0(d.class, dVar);
    }

    public static d g0() {
        return DEFAULT_INSTANCE;
    }

    public static b j0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f11319a[fVar.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return new b(aVar);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "name_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<d> bVar = PARSER;
                if (bVar == null) {
                    synchronized (d.class) {
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
        return this.name_;
    }

    public u1 i0() {
        u1 u1Var = this.version_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public final void k0(String str) {
        str.getClass();
        this.name_ = str;
    }

    public final void l0(u1 u1Var) {
        u1Var.getClass();
        this.version_ = u1Var;
        this.bitField0_ |= 1;
    }
}
