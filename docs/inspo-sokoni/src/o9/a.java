package o9;

import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.z;

/* JADX INFO: loaded from: classes.dex */
public final class a extends z<a, b> implements x0 {
    private static final a DEFAULT_INSTANCE;
    public static final int LATITUDE_FIELD_NUMBER = 1;
    public static final int LONGITUDE_FIELD_NUMBER = 2;
    private static volatile g1<a> PARSER;
    private double latitude_;
    private double longitude_;

    /* JADX INFO: renamed from: o9.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0237a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13796a;

        static {
            int[] iArr = new int[z.f.values().length];
            f13796a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13796a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13796a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13796a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13796a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13796a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13796a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends z.a<a, b> implements x0 {
        public b() {
            super(a.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(C0237a c0237a) {
            this();
        }

        public b E(double d10) {
            v();
            ((a) this.f5995b).k0(d10);
            return this;
        }

        public b F(double d10) {
            v();
            ((a) this.f5995b).l0(d10);
            return this;
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.a0(a.class, aVar);
    }

    public static a g0() {
        return DEFAULT_INSTANCE;
    }

    public static b j0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(z.f fVar, Object obj, Object obj2) {
        C0237a c0237a = null;
        switch (C0237a.f13796a[fVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b(c0237a);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0000\u0002\u0000", new Object[]{"latitude_", "longitude_"});
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

    public double h0() {
        return this.latitude_;
    }

    public double i0() {
        return this.longitude_;
    }

    public final void k0(double d10) {
        this.latitude_ = d10;
    }

    public final void l0(double d10) {
        this.longitude_ = d10;
    }
}
