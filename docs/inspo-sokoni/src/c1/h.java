package c1;

import androidx.datastore.preferences.protobuf.s0;
import androidx.datastore.preferences.protobuf.y;
import androidx.datastore.preferences.protobuf.z0;

/* JADX INFO: loaded from: classes.dex */
public final class h extends y<h, a> implements s0 {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    private static final h DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile z0<h> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int bitField0_;
    private int valueCase_ = 0;
    private Object value_;

    public static final class a extends y.a<h, a> implements s0 {
        public a() {
            super(h.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(e eVar) {
            this();
        }

        public a A(int i10) {
            s();
            ((h) this.f2046b).f0(i10);
            return this;
        }

        public a C(long j10) {
            s();
            ((h) this.f2046b).g0(j10);
            return this;
        }

        public a D(String str) {
            s();
            ((h) this.f2046b).h0(str);
            return this;
        }

        public a E(g.a aVar) {
            s();
            ((h) this.f2046b).i0(aVar);
            return this;
        }

        public a x(boolean z10) {
            s();
            ((h) this.f2046b).c0(z10);
            return this;
        }

        public a y(double d10) {
            s();
            ((h) this.f2046b).d0(d10);
            return this;
        }

        public a z(float f10) {
            s();
            ((h) this.f2046b).e0(f10);
            return this;
        }
    }

    public enum b {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        VALUE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3138a;

        b(int i10) {
            this.f3138a = i10;
        }

        public static b d(int i10) {
            switch (i10) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                default:
                    return null;
            }
        }
    }

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        y.I(h.class, hVar);
    }

    public static h T() {
        return DEFAULT_INSTANCE;
    }

    public static a b0() {
        return DEFAULT_INSTANCE.t();
    }

    public boolean S() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public double U() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public float V() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int W() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long X() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public String Y() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public g Z() {
        return this.valueCase_ == 6 ? (g) this.value_ : g.O();
    }

    public b a0() {
        return b.d(this.valueCase_);
    }

    public final void c0(boolean z10) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z10);
    }

    public final void d0(double d10) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d10);
    }

    public final void e0(float f10) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f10);
    }

    public final void f0(int i10) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i10);
    }

    public final void g0(long j10) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j10);
    }

    public final void h0(String str) {
        str.getClass();
        this.valueCase_ = 5;
        this.value_ = str;
    }

    public final void i0(g.a aVar) {
        this.value_ = aVar.build();
        this.valueCase_ = 6;
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final Object w(y.f fVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.f3127a[fVar.ordinal()]) {
            case 1:
                return new h();
            case 2:
                return new a(eVar);
            case 3:
                return y.F(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", g.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                z0<h> bVar = PARSER;
                if (bVar == null) {
                    synchronized (h.class) {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new y.b<>(DEFAULT_INSTANCE);
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
