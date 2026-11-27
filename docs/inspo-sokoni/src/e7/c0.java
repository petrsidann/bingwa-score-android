package e7;

import com.google.crypto.tink.shaded.protobuf.a1;
import com.google.crypto.tink.shaded.protobuf.t0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends com.google.crypto.tink.shaded.protobuf.z<c0, b> implements t0 {
    private static final c0 DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile a1<c0> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.b0.i<c> key_ = com.google.crypto.tink.shaded.protobuf.z.v();
    private int primaryKeyId_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7023a;

        static {
            int[] iArr = new int[com.google.crypto.tink.shaded.protobuf.z.f.values().length];
            f7023a = iArr;
            try {
                iArr[com.google.crypto.tink.shaded.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7023a[com.google.crypto.tink.shaded.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7023a[com.google.crypto.tink.shaded.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7023a[com.google.crypto.tink.shaded.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7023a[com.google.crypto.tink.shaded.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7023a[com.google.crypto.tink.shaded.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7023a[com.google.crypto.tink.shaded.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.crypto.tink.shaded.protobuf.z.a<c0, b> implements t0 {
        public b() {
            super(c0.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public List<c> A() {
            return Collections.unmodifiableList(((c0) this.f5353b).T());
        }

        public b C(int i10) {
            r();
            ((c0) this.f5353b).X(i10);
            return this;
        }

        public b x(c cVar) {
            r();
            ((c0) this.f5353b).P(cVar);
            return this;
        }

        public c y(int i10) {
            return ((c0) this.f5353b).R(i10);
        }

        public int z() {
            return ((c0) this.f5353b).S();
        }
    }

    public static final class c extends com.google.crypto.tink.shaded.protobuf.z<c, a> implements t0 {
        private static final c DEFAULT_INSTANCE;
        public static final int KEY_DATA_FIELD_NUMBER = 1;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile a1<c> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        private y keyData_;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;

        public static final class a extends com.google.crypto.tink.shaded.protobuf.z.a<c, a> implements t0 {
            public a() {
                super(c.DEFAULT_INSTANCE);
            }

            public /* synthetic */ a(a aVar) {
                this();
            }

            public a A(z zVar) {
                r();
                ((c) this.f5353b).a0(zVar);
                return this;
            }

            public a x(y yVar) {
                r();
                ((c) this.f5353b).X(yVar);
                return this;
            }

            public a y(int i10) {
                r();
                ((c) this.f5353b).Y(i10);
                return this;
            }

            public a z(i0 i0Var) {
                r();
                ((c) this.f5353b).Z(i0Var);
                return this;
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            com.google.crypto.tink.shaded.protobuf.z.K(c.class, cVar);
        }

        public static a W() {
            return DEFAULT_INSTANCE.r();
        }

        public y R() {
            y yVar = this.keyData_;
            return yVar == null ? y.Q() : yVar;
        }

        public int S() {
            return this.keyId_;
        }

        public i0 T() {
            i0 i0VarD = i0.d(this.outputPrefixType_);
            return i0VarD == null ? i0.UNRECOGNIZED : i0VarD;
        }

        public z U() {
            z zVarD = z.d(this.status_);
            return zVarD == null ? z.UNRECOGNIZED : zVarD;
        }

        public boolean V() {
            return this.keyData_ != null;
        }

        public final void X(y yVar) {
            yVar.getClass();
            this.keyData_ = yVar;
        }

        public final void Y(int i10) {
            this.keyId_ = i10;
        }

        public final void Z(i0 i0Var) {
            this.outputPrefixType_ = i0Var.a();
        }

        public final void a0(z zVar) {
            this.status_ = zVar.a();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.z
        public final Object u(com.google.crypto.tink.shaded.protobuf.z.f fVar, Object obj, Object obj2) {
            a aVar = null;
            switch (a.f7023a[fVar.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return com.google.crypto.tink.shaded.protobuf.z.E(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    a1<c> bVar = PARSER;
                    if (bVar == null) {
                        synchronized (c.class) {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new com.google.crypto.tink.shaded.protobuf.z.b<>(DEFAULT_INSTANCE);
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

    static {
        c0 c0Var = new c0();
        DEFAULT_INSTANCE = c0Var;
        com.google.crypto.tink.shaded.protobuf.z.K(c0.class, c0Var);
    }

    public static b V() {
        return DEFAULT_INSTANCE.r();
    }

    public static c0 W(byte[] bArr, com.google.crypto.tink.shaded.protobuf.q qVar) {
        return (c0) com.google.crypto.tink.shaded.protobuf.z.G(DEFAULT_INSTANCE, bArr, qVar);
    }

    public final void P(c cVar) {
        cVar.getClass();
        Q();
        this.key_.add(cVar);
    }

    public final void Q() {
        com.google.crypto.tink.shaded.protobuf.b0.i<c> iVar = this.key_;
        if (iVar.g()) {
            return;
        }
        this.key_ = com.google.crypto.tink.shaded.protobuf.z.C(iVar);
    }

    public c R(int i10) {
        return this.key_.get(i10);
    }

    public int S() {
        return this.key_.size();
    }

    public List<c> T() {
        return this.key_;
    }

    public int U() {
        return this.primaryKeyId_;
    }

    public final void X(int i10) {
        this.primaryKeyId_ = i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.z
    public final Object u(com.google.crypto.tink.shaded.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f7023a[fVar.ordinal()]) {
            case 1:
                return new c0();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.crypto.tink.shaded.protobuf.z.E(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                a1<c0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (c0.class) {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new com.google.crypto.tink.shaded.protobuf.z.b<>(DEFAULT_INSTANCE);
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
