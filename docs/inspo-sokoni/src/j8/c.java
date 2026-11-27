package j8;

import com.google.protobuf.g1;
import com.google.protobuf.i;
import com.google.protobuf.u1;
import com.google.protobuf.x0;
import com.google.protobuf.z;
import d9.a0;

/* JADX INFO: loaded from: classes.dex */
public final class c extends z<c, b> implements x0 {
    private static final c DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 6;
    public static final int LAST_LIMBO_FREE_SNAPSHOT_VERSION_FIELD_NUMBER = 7;
    public static final int LAST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 4;
    private static volatile g1<c> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 5;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 3;
    public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 2;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private u1 lastLimboFreeSnapshotVersion_;
    private long lastListenSequenceNumber_;
    private u1 snapshotVersion_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private i resumeToken_ = i.f5753b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11313a;

        static {
            int[] iArr = new int[z.f.values().length];
            f11313a = iArr;
            try {
                iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11313a[z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11313a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11313a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11313a[z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11313a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11313a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends z.a<c, b> implements x0 {
        public b() {
            super(c.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E() {
            v();
            ((c) this.f5995b).m0();
            return this;
        }

        public b F(a0.c cVar) {
            v();
            ((c) this.f5995b).x0(cVar);
            return this;
        }

        public b H(u1 u1Var) {
            v();
            ((c) this.f5995b).y0(u1Var);
            return this;
        }

        public b I(long j10) {
            v();
            ((c) this.f5995b).z0(j10);
            return this;
        }

        public b K(a0.d dVar) {
            v();
            ((c) this.f5995b).A0(dVar);
            return this;
        }

        public b L(i iVar) {
            v();
            ((c) this.f5995b).B0(iVar);
            return this;
        }

        public b M(u1 u1Var) {
            v();
            ((c) this.f5995b).C0(u1Var);
            return this;
        }

        public b N(int i10) {
            v();
            ((c) this.f5995b).D0(i10);
            return this;
        }
    }

    /* JADX INFO: renamed from: j8.c$c, reason: collision with other inner class name */
    public enum EnumC0188c {
        QUERY(5),
        DOCUMENTS(6),
        TARGETTYPE_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11318a;

        EnumC0188c(int i10) {
            this.f11318a = i10;
        }

        public static EnumC0188c h(int i10) {
            if (i10 == 0) {
                return TARGETTYPE_NOT_SET;
            }
            if (i10 == 5) {
                return QUERY;
            }
            if (i10 != 6) {
                return null;
            }
            return DOCUMENTS;
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        z.a0(c.class, cVar);
    }

    public static b v0() {
        return DEFAULT_INSTANCE.y();
    }

    public static c w0(byte[] bArr) {
        return (c) z.W(DEFAULT_INSTANCE, bArr);
    }

    public final void A0(a0.d dVar) {
        dVar.getClass();
        this.targetType_ = dVar;
        this.targetTypeCase_ = 5;
    }

    public final void B0(i iVar) {
        iVar.getClass();
        this.resumeToken_ = iVar;
    }

    @Override // com.google.protobuf.z
    public final Object C(z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f11313a[fVar.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new b(aVar);
            case 3:
                return z.S(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003\n\u0004\u0002\u0005<\u0000\u0006<\u0000\u0007ဉ\u0001", new Object[]{"targetType_", "targetTypeCase_", "bitField0_", "targetId_", "snapshotVersion_", "resumeToken_", "lastListenSequenceNumber_", a0.d.class, a0.c.class, "lastLimboFreeSnapshotVersion_"});
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

    public final void C0(u1 u1Var) {
        u1Var.getClass();
        this.snapshotVersion_ = u1Var;
        this.bitField0_ |= 1;
    }

    public final void D0(int i10) {
        this.targetId_ = i10;
    }

    public final void m0() {
        this.lastLimboFreeSnapshotVersion_ = null;
        this.bitField0_ &= -3;
    }

    public a0.c n0() {
        return this.targetTypeCase_ == 6 ? (a0.c) this.targetType_ : a0.c.h0();
    }

    public u1 o0() {
        u1 u1Var = this.lastLimboFreeSnapshotVersion_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public long p0() {
        return this.lastListenSequenceNumber_;
    }

    public a0.d q0() {
        return this.targetTypeCase_ == 5 ? (a0.d) this.targetType_ : a0.d.g0();
    }

    public i r0() {
        return this.resumeToken_;
    }

    public u1 s0() {
        u1 u1Var = this.snapshotVersion_;
        return u1Var == null ? u1.g0() : u1Var;
    }

    public int t0() {
        return this.targetId_;
    }

    public EnumC0188c u0() {
        return EnumC0188c.h(this.targetTypeCase_);
    }

    public final void x0(a0.c cVar) {
        cVar.getClass();
        this.targetType_ = cVar;
        this.targetTypeCase_ = 6;
    }

    public final void y0(u1 u1Var) {
        u1Var.getClass();
        this.lastLimboFreeSnapshotVersion_ = u1Var;
        this.bitField0_ |= 2;
    }

    public final void z0(long j10) {
        this.lastListenSequenceNumber_ = j10;
    }
}
