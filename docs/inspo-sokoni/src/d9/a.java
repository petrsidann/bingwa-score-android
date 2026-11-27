package d9;

import com.google.protobuf.c2;
import com.google.protobuf.g1;
import com.google.protobuf.p0;
import com.google.protobuf.q0;
import com.google.protobuf.x0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a extends com.google.protobuf.z<a, c> implements x0 {
    public static final int AGGREGATE_FIELDS_FIELD_NUMBER = 2;
    private static final a DEFAULT_INSTANCE;
    private static volatile g1<a> PARSER;
    private q0<String, d0> aggregateFields_ = q0.d();

    /* JADX INFO: renamed from: d9.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0112a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6507a;

        static {
            int[] iArr = new int[com.google.protobuf.z.f.values().length];
            f6507a = iArr;
            try {
                iArr[com.google.protobuf.z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6507a[com.google.protobuf.z.f.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6507a[com.google.protobuf.z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6507a[com.google.protobuf.z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6507a[com.google.protobuf.z.f.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6507a[com.google.protobuf.z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6507a[com.google.protobuf.z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p0<String, d0> f6508a = p0.d(c2.b.f5675p, "", c2.b.f5677r, d0.s0());
    }

    public static final class c extends com.google.protobuf.z.a<a, c> implements x0 {
        public c() {
            super(a.DEFAULT_INSTANCE);
        }

        public /* synthetic */ c(C0112a c0112a) {
            this();
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        com.google.protobuf.z.a0(a.class, aVar);
    }

    public static a f0() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public final Object C(com.google.protobuf.z.f fVar, Object obj, Object obj2) {
        C0112a c0112a = null;
        switch (C0112a.f6507a[fVar.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new c(c0112a);
            case 3:
                return com.google.protobuf.z.S(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0001\u0000\u0000\u00022", new Object[]{"aggregateFields_", b.f6508a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                g1<a> bVar = PARSER;
                if (bVar == null) {
                    synchronized (a.class) {
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

    public Map<String, d0> e0() {
        return Collections.unmodifiableMap(g0());
    }

    public final q0<String, d0> g0() {
        return this.aggregateFields_;
    }
}
