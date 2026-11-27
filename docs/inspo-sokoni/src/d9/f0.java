package d9;

import com.google.protobuf.c2;
import com.google.protobuf.g1;
import com.google.protobuf.p0;
import com.google.protobuf.q0;
import com.google.protobuf.x0;

/* JADX INFO: loaded from: classes.dex */
public final class f0 extends com.google.protobuf.z<f0, b> implements x0 {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final f0 DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 5;
    private static volatile g1<f0> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 2;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 4;
    public static final int WRITES_FIELD_NUMBER = 3;
    private q0<String, String> labels_ = q0.d();
    private String database_ = "";
    private String streamId_ = "";
    private com.google.protobuf.d0.i<e0> writes_ = com.google.protobuf.z.E();
    private com.google.protobuf.i streamToken_ = com.google.protobuf.i.f5753b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6553a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6553a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6553a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6553a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6553a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6553a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6553a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6553a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<f0, b> implements x0 {
        public b() {
            super(f0.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(e0 e0Var) {
            v();
            ((f0) this.f5995b).h0(e0Var);
            return this;
        }

        public b F(String str) {
            v();
            ((f0) this.f5995b).l0(str);
            return this;
        }

        public b H(com.google.protobuf.i iVar) {
            v();
            ((f0) this.f5995b).m0(iVar);
            return this;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p0<String, String> f6554a;

        static {
            c2.b bVar = c2.b.f5675p;
            f6554a = p0.d(bVar, "", bVar, "");
        }
    }

    static {
        f0 f0Var = new f0();
        DEFAULT_INSTANCE = f0Var;
        com.google.protobuf.z.a0(f0.class, f0Var);
    }

    public static f0 j0() {
        return DEFAULT_INSTANCE;
    }

    public static b k0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6553a[fVar.ordinal()]) {
            case 1:
                return new f0();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004\n\u00052", new Object[]{"database_", "streamId_", "writes_", e0.class, "streamToken_", "labels_", c.f6554a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<f0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (f0.class) {
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

    public final void h0(e0 e0Var) {
        e0Var.getClass();
        i0();
        this.writes_.add(e0Var);
    }

    public final void i0() {
        com.google.protobuf.d0.i<e0> iVar = this.writes_;
        if (iVar.g()) {
            return;
        }
        this.writes_ = com.google.protobuf.z.Q(iVar);
    }

    public final void l0(String str) {
        str.getClass();
        this.database_ = str;
    }

    public final void m0(com.google.protobuf.i iVar) {
        iVar.getClass();
        this.streamToken_ = iVar;
    }
}
