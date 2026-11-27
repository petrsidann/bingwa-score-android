package j8;

import com.google.protobuf.d0;
import com.google.protobuf.g1;
import com.google.protobuf.i;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import d9.e0;

/* JADX INFO: loaded from: classes.dex */
public final class e extends z<e, b> implements x0 {
    public static final int BASE_WRITES_FIELD_NUMBER = 4;
    public static final int BATCH_ID_FIELD_NUMBER = 1;
    private static final e DEFAULT_INSTANCE;
    public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
    private static volatile g1<e> PARSER = null;
    public static final int WRITES_FIELD_NUMBER = 2;
    private int batchId_;
    private int bitField0_;
    private u1 localWriteTime_;
    private d0.i<e0> writes_ = z.E();
    private d0.i<e0> baseWrites_ = z.E();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11320a;

        static {
            int[] iArr = new int[z.f.values().length];
            f11320a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11320a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11320a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11320a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11320a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11320a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11320a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends z.a<e, b> implements x0 {
        public b() {
            super(e.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(e0 e0Var) {
            v();
            ((e) this.f5995b).i0(e0Var);
            return this;
        }

        public b F(e0 e0Var) {
            v();
            ((e) this.f5995b).j0(e0Var);
            return this;
        }

        public b H(int i10) {
            v();
            ((e) this.f5995b).v0(i10);
            return this;
        }

        public b I(u1 u1Var) {
            v();
            ((e) this.f5995b).w0(u1Var);
            return this;
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        z.a0(e.class, eVar);
    }

    public static b s0() {
        return DEFAULT_INSTANCE.y();
    }

    public static e t0(i iVar) {
        return (e) z.U(DEFAULT_INSTANCE, iVar);
    }

    public static e u0(byte[] bArr) {
        return (e) z.W(DEFAULT_INSTANCE, bArr);
    }

    @Override // com.google.protobuf.z
    public final Object C(z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f11320a[fVar.ordinal()]) {
            case 1:
                return new e();
            case 2:
                return new b(aVar);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003ဉ\u0000\u0004\u001b", new Object[]{"bitField0_", "batchId_", "writes_", e0.class, "localWriteTime_", "baseWrites_", e0.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<e> bVar = PARSER;
                if (bVar == null) {
                    synchronized (e.class) {
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

    public final void i0(e0 e0Var) {
        e0Var.getClass();
        k0();
        this.baseWrites_.add(e0Var);
    }

    public final void j0(e0 e0Var) {
        e0Var.getClass();
        l0();
        this.writes_.add(e0Var);
    }

    public final void k0() {
        d0.i<e0> iVar = this.baseWrites_;
        if (iVar.g()) {
            return;
        }
        this.baseWrites_ = z.Q(iVar);
    }

    public final void l0() {
        d0.i<e0> iVar = this.writes_;
        if (iVar.g()) {
            return;
        }
        this.writes_ = z.Q(iVar);
    }

    public e0 m0(int i10) {
        return this.baseWrites_.get(i10);
    }

    public int n0() {
        return this.baseWrites_.size();
    }

    public int o0() {
        return this.batchId_;
    }

    public u1 p0() {
        u1 u1Var = this.localWriteTime_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public e0 q0(int i10) {
        return this.writes_.get(i10);
    }

    public int r0() {
        return this.writes_.size();
    }

    public final void v0(int i10) {
        this.batchId_ = i10;
    }

    public final void w0(u1 u1Var) {
        u1Var.getClass();
        this.localWriteTime_ = u1Var;
        this.bitField0_ |= 1;
    }
}
