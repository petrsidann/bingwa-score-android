package d9;

import com.google.protobuf.g1;
import com.google.protobuf.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e0 extends com.google.protobuf.z<e0, b> implements x0 {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    private static final e0 DEFAULT_INSTANCE;
    public static final int DELETE_FIELD_NUMBER = 2;
    private static volatile g1<e0> PARSER = null;
    public static final int TRANSFORM_FIELD_NUMBER = 6;
    public static final int UPDATE_FIELD_NUMBER = 1;
    public static final int UPDATE_MASK_FIELD_NUMBER = 3;
    public static final int UPDATE_TRANSFORMS_FIELD_NUMBER = 7;
    public static final int VERIFY_FIELD_NUMBER = 5;
    private int bitField0_;
    private v currentDocument_;
    private Object operation_;
    private n updateMask_;
    private int operationCase_ = 0;
    private com.google.protobuf.d0.i<p.c> updateTransforms_ = com.google.protobuf.z.E();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6544a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6544a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6544a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6544a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6544a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6544a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6544a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6544a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b extends com.google.protobuf.z.a<e0, b> implements x0 {
        public b() {
            super(e0.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b E(p.c cVar) {
            v();
            ((e0) this.f5995b).k0(cVar);
            return this;
        }

        public b F(v vVar) {
            v();
            ((e0) this.f5995b).B0(vVar);
            return this;
        }

        public b H(String str) {
            v();
            ((e0) this.f5995b).C0(str);
            return this;
        }

        public b I(k kVar) {
            v();
            ((e0) this.f5995b).D0(kVar);
            return this;
        }

        public b K(n nVar) {
            v();
            ((e0) this.f5995b).E0(nVar);
            return this;
        }

        public b L(String str) {
            v();
            ((e0) this.f5995b).F0(str);
            return this;
        }
    }

    public enum c {
        UPDATE(1),
        DELETE(2),
        VERIFY(5),
        TRANSFORM(6),
        OPERATION_NOT_SET(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6551a;

        c(int i10) {
            this.f6551a = i10;
        }

        public static c h(int i10) {
            if (i10 == 0) {
                return OPERATION_NOT_SET;
            }
            if (i10 == 1) {
                return UPDATE;
            }
            if (i10 == 2) {
                return DELETE;
            }
            if (i10 == 5) {
                return VERIFY;
            }
            if (i10 != 6) {
                return null;
            }
            return TRANSFORM;
        }
    }

    static {
        e0 e0Var = new e0();
        DEFAULT_INSTANCE = e0Var;
        com.google.protobuf.z.a0(e0.class, e0Var);
    }

    public static e0 A0(byte[] bArr) {
        return (e0) com.google.protobuf.z.W(DEFAULT_INSTANCE, bArr);
    }

    public static b y0() {
        return DEFAULT_INSTANCE.y();
    }

    public static b z0(e0 e0Var) {
        return DEFAULT_INSTANCE.z(e0Var);
    }

    public final void B0(v vVar) {
        vVar.getClass();
        this.currentDocument_ = vVar;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f6544a[fVar.ordinal()]) {
            case 1:
                return new e0();
            case 2:
                return new b(aVar);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003ဉ\u0000\u0004ဉ\u0001\u0005Ȼ\u0000\u0006<\u0000\u0007\u001b", new Object[]{"operation_", "operationCase_", "bitField0_", k.class, "updateMask_", "currentDocument_", p.class, "updateTransforms_", p.c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<e0> bVar = PARSER;
                if (bVar == null) {
                    synchronized (e0.class) {
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

    public final void C0(String str) {
        str.getClass();
        this.operationCase_ = 2;
        this.operation_ = str;
    }

    public final void D0(k kVar) {
        kVar.getClass();
        this.operation_ = kVar;
        this.operationCase_ = 1;
    }

    public final void E0(n nVar) {
        nVar.getClass();
        this.updateMask_ = nVar;
        this.bitField0_ |= 1;
    }

    public final void F0(String str) {
        str.getClass();
        this.operationCase_ = 5;
        this.operation_ = str;
    }

    public final void k0(p.c cVar) {
        cVar.getClass();
        l0();
        this.updateTransforms_.add(cVar);
    }

    public final void l0() {
        com.google.protobuf.d0.i<p.c> iVar = this.updateTransforms_;
        if (iVar.g()) {
            return;
        }
        this.updateTransforms_ = com.google.protobuf.z.Q(iVar);
    }

    public v m0() {
        v vVar = this.currentDocument_;
        return vVar == null ? v.h0() : vVar;
    }

    public String n0() {
        return this.operationCase_ == 2 ? (String) this.operation_ : "";
    }

    public c o0() {
        return c.h(this.operationCase_);
    }

    public p p0() {
        return this.operationCase_ == 6 ? (p) this.operation_ : p.e0();
    }

    public k q0() {
        return this.operationCase_ == 1 ? (k) this.operation_ : k.h0();
    }

    public n r0() {
        n nVar = this.updateMask_;
        return nVar == null ? n.h0() : nVar;
    }

    public List<p.c> s0() {
        return this.updateTransforms_;
    }

    public String t0() {
        return this.operationCase_ == 5 ? (String) this.operation_ : "";
    }

    public boolean u0() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean v0() {
        return this.operationCase_ == 6;
    }

    public boolean w0() {
        return this.operationCase_ == 1;
    }

    public boolean x0() {
        return (this.bitField0_ & 1) != 0;
    }
}
