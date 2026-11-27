package e9;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class v implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f7456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f7457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f7458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f7459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ v[] f7460e;

    public final enum a extends v {
        public a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // e9.w
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Double d(m9.a aVar) {
            return Double.valueOf(aVar.c0());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        f7456a = aVar;
        v vVar = new v("LAZILY_PARSED_NUMBER", 1) { // from class: e9.v.b
            {
                a aVar2 = null;
            }

            @Override // e9.w
            public Number d(m9.a aVar2) {
                return new g9.g(aVar2.j0());
            }
        };
        f7457b = vVar;
        v vVar2 = new v("LONG_OR_DOUBLE", 2) { // from class: e9.v.c
            {
                a aVar2 = null;
            }

            @Override // e9.w
            public Number d(m9.a aVar2) throws IOException {
                String strJ0 = aVar2.j0();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strJ0));
                    } catch (NumberFormatException e10) {
                        throw new o("Cannot parse " + strJ0 + "; at path " + aVar2.G(), e10);
                    }
                } catch (NumberFormatException unused) {
                    Double dValueOf = Double.valueOf(strJ0);
                    if ((!dValueOf.isInfinite() && !dValueOf.isNaN()) || aVar2.J()) {
                        return dValueOf;
                    }
                    throw new m9.d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar2.G());
                }
            }
        };
        f7458c = vVar2;
        v vVar3 = new v("BIG_DECIMAL", 3) { // from class: e9.v.d
            {
                a aVar2 = null;
            }

            @Override // e9.w
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public BigDecimal d(m9.a aVar2) throws IOException {
                String strJ0 = aVar2.j0();
                try {
                    return new BigDecimal(strJ0);
                } catch (NumberFormatException e10) {
                    throw new o("Cannot parse " + strJ0 + "; at path " + aVar2.G(), e10);
                }
            }
        };
        f7459d = vVar3;
        f7460e = new v[]{aVar, vVar, vVar2, vVar3};
    }

    public v(String str, int i10) {
        super(str, i10);
    }

    public /* synthetic */ v(String str, int i10, a aVar) {
        this(str, i10);
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f7460e.clone();
    }
}
