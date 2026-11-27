package d9;

import com.google.protobuf.f1;
import com.google.protobuf.g1;
import com.google.protobuf.u1;
import com.google.protobuf.x0;

/* JADX INFO: loaded from: classes.dex */
public final class d0 extends com.google.protobuf.z<d0, b> implements x0 {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    private static final d0 DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile g1<d0> PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6523a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6523a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6523a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6523a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6523a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6523a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6523a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6523a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<d0, b> implements x0 {
        public b() {
            super(d0.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public u E() {
            return ((d0) this.f5995b).w0();
        }

        public b F(d9.b.C0113b c0113b) {
            v();
            ((d0) this.f5995b).C0(c0113b.build());
            return this;
        }

        public b H(d9.b bVar) {
            v();
            ((d0) this.f5995b).C0(bVar);
            return this;
        }

        public b I(boolean z10) {
            v();
            ((d0) this.f5995b).D0(z10);
            return this;
        }

        public b K(com.google.protobuf.i iVar) {
            v();
            ((d0) this.f5995b).E0(iVar);
            return this;
        }

        public b L(double d10) {
            v();
            ((d0) this.f5995b).F0(d10);
            return this;
        }

        public b M(o9.a.b bVar) {
            v();
            ((d0) this.f5995b).G0(bVar.build());
            return this;
        }

        public b N(long j10) {
            v();
            ((d0) this.f5995b).H0(j10);
            return this;
        }

        public b O(u.b bVar) {
            v();
            ((d0) this.f5995b).I0(bVar.build());
            return this;
        }

        public b P(u uVar) {
            v();
            ((d0) this.f5995b).I0(uVar);
            return this;
        }

        public b Q(f1 f1Var) {
            v();
            ((d0) this.f5995b).J0(f1Var);
            return this;
        }

        public b R(String str) {
            v();
            ((d0) this.f5995b).K0(str);
            return this;
        }

        public b S(String str) {
            v();
            ((d0) this.f5995b).L0(str);
            return this;
        }

        public b T(u1.b bVar) {
            v();
            ((d0) this.f5995b).M0(bVar.build());
            return this;
        }
    }

    public enum c {
        NULL_VALUE(11),
        BOOLEAN_VALUE(1),
        INTEGER_VALUE(2),
        DOUBLE_VALUE(3),
        TIMESTAMP_VALUE(10),
        STRING_VALUE(17),
        BYTES_VALUE(18),
        REFERENCE_VALUE(5),
        GEO_POINT_VALUE(8),
        ARRAY_VALUE(9),
        MAP_VALUE(6),
        VALUETYPE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6537a;

        c(int i10) {
            this.f6537a = i10;
        }

        public static c h(int i10) {
            if (i10 == 0) {
                return VALUETYPE_NOT_SET;
            }
            if (i10 == 1) {
                return BOOLEAN_VALUE;
            }
            if (i10 == 2) {
                return INTEGER_VALUE;
            }
            if (i10 == 3) {
                return DOUBLE_VALUE;
            }
            if (i10 == 5) {
                return REFERENCE_VALUE;
            }
            if (i10 == 6) {
                return MAP_VALUE;
            }
            if (i10 == 17) {
                return STRING_VALUE;
            }
            if (i10 == 18) {
                return BYTES_VALUE;
            }
            switch (i10) {
                case 8:
                    return GEO_POINT_VALUE;
                case 9:
                    return ARRAY_VALUE;
                case 10:
                    return TIMESTAMP_VALUE;
                case 11:
                    return NULL_VALUE;
                default:
                    return null;
            }
        }
    }

    static {
        d0 d0Var = new d0();
        DEFAULT_INSTANCE = d0Var;
        com.google.protobuf.z.a0(d0.class, d0Var);
    }

    public static b B0() {
        return DEFAULT_INSTANCE.y();
    }

    public static d0 s0() {
        return DEFAULT_INSTANCE;
    }

    public c A0() {
        return c.h(this.valueTypeCase_);
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6523a[fVar.ordinal()]) {
            case 1:
                return new d0();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001\u0012\u000b\u0000\u0000\u0000\u0001:\u0000\u00025\u0000\u00033\u0000\u0005Ȼ\u0000\u0006<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b?\u0000\u0011Ȼ\u0000\u0012=\u0000", new Object[]{"valueType_", "valueTypeCase_", u.class, o9.a.class, d9.b.class, u1.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<d0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (d0.class) {
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

    public final void C0(d9.b bVar) {
        bVar.getClass();
        this.valueType_ = bVar;
        this.valueTypeCase_ = 9;
    }

    public final void D0(boolean z10) {
        this.valueTypeCase_ = 1;
        this.valueType_ = Boolean.valueOf(z10);
    }

    public final void E0(com.google.protobuf.i iVar) {
        iVar.getClass();
        this.valueTypeCase_ = 18;
        this.valueType_ = iVar;
    }

    public final void F0(double d10) {
        this.valueTypeCase_ = 3;
        this.valueType_ = Double.valueOf(d10);
    }

    public final void G0(o9.a aVar) {
        aVar.getClass();
        this.valueType_ = aVar;
        this.valueTypeCase_ = 8;
    }

    public final void H0(long j10) {
        this.valueTypeCase_ = 2;
        this.valueType_ = Long.valueOf(j10);
    }

    public final void I0(u uVar) {
        uVar.getClass();
        this.valueType_ = uVar;
        this.valueTypeCase_ = 6;
    }

    public final void J0(f1 f1Var) {
        this.valueType_ = Integer.valueOf(f1Var.a());
        this.valueTypeCase_ = 11;
    }

    public final void K0(String str) {
        str.getClass();
        this.valueTypeCase_ = 5;
        this.valueType_ = str;
    }

    public final void L0(String str) {
        str.getClass();
        this.valueTypeCase_ = 17;
        this.valueType_ = str;
    }

    public final void M0(u1 u1Var) {
        u1Var.getClass();
        this.valueType_ = u1Var;
        this.valueTypeCase_ = 10;
    }

    public d9.b p0() {
        return this.valueTypeCase_ == 9 ? (d9.b) this.valueType_ : d9.b.k0();
    }

    public boolean q0() {
        if (this.valueTypeCase_ == 1) {
            return ((Boolean) this.valueType_).booleanValue();
        }
        return false;
    }

    public com.google.protobuf.i r0() {
        return this.valueTypeCase_ == 18 ? (com.google.protobuf.i) this.valueType_ : com.google.protobuf.i.f5753b;
    }

    public double t0() {
        if (this.valueTypeCase_ == 3) {
            return ((Double) this.valueType_).doubleValue();
        }
        return 0.0d;
    }

    public o9.a u0() {
        return this.valueTypeCase_ == 8 ? (o9.a) this.valueType_ : o9.a.g0();
    }

    public long v0() {
        if (this.valueTypeCase_ == 2) {
            return ((Long) this.valueType_).longValue();
        }
        return 0L;
    }

    public u w0() {
        return this.valueTypeCase_ == 6 ? (u) this.valueType_ : u.f0();
    }

    public String x0() {
        return this.valueTypeCase_ == 5 ? (String) this.valueType_ : "";
    }

    public String y0() {
        return this.valueTypeCase_ == 17 ? (String) this.valueType_ : "";
    }

    public u1 z0() {
        return this.valueTypeCase_ == 10 ? (u1) this.valueType_ : u1.g0();
    }
}
