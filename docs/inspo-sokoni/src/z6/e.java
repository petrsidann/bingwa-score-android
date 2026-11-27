package z6;

import e7.i0;
import e7.y;
import java.security.GeneralSecurityException;
import r6.t;
import r6.x;

/* JADX INFO: loaded from: classes.dex */
public final class e extends r6.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f20312a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f20314b;

        static {
            int[] iArr = new int[y.c.values().length];
            f20314b = iArr;
            try {
                iArr[y.c.SYMMETRIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20314b[y.c.ASYMMETRIC_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[i0.values().length];
            f20313a = iArr2;
            try {
                iArr2[i0.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20313a[i0.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20313a[i0.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20313a[i0.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class b extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i0 f20316b;

        public b(String str, i0 i0Var) {
            this.f20315a = str;
            this.f20316b = i0Var;
        }

        public /* synthetic */ b(String str, i0 i0Var, a aVar) {
            this(str, i0Var);
        }

        public static String a(i0 i0Var) {
            int i10 = a.f20313a[i0Var.ordinal()];
            if (i10 == 1) {
                return "TINK";
            }
            if (i10 == 2) {
                return "LEGACY";
            }
            if (i10 != 3) {
                return i10 != 4 ? "UNKNOWN" : "CRUNCHY";
            }
            return "RAW";
        }

        public String toString() {
            return String.format("(typeUrl=%s, outputPrefixType=%s)", this.f20315a, a(this.f20316b));
        }
    }

    public e(l lVar, x xVar) throws GeneralSecurityException {
        b(lVar, xVar);
        this.f20312a = lVar;
    }

    public static void b(l lVar, x xVar) throws GeneralSecurityException {
        int i10 = a.f20314b[lVar.d().ordinal()];
        if (i10 == 1 || i10 == 2) {
            x.b(xVar);
        }
    }

    @Override // r6.f
    public t a() {
        return new b(this.f20312a.f(), this.f20312a.e(), null);
    }
}
