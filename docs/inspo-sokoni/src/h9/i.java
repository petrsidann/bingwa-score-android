package h9;

import e9.s;
import e9.v;
import e9.w;
import e9.x;
import e9.y;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class i extends x<Number> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f9831b = g(v.f7457b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f9832a;

    public class a implements y {
        public a() {
        }

        @Override // e9.y
        public <T> x<T> create(e9.e eVar, l9.a<T> aVar) {
            if (aVar.c() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9834a;

        static {
            int[] iArr = new int[m9.b.values().length];
            f9834a = iArr;
            try {
                iArr[m9.b.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9834a[m9.b.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9834a[m9.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public i(w wVar) {
        this.f9832a = wVar;
    }

    public static y f(w wVar) {
        return wVar == v.f7457b ? f9831b : g(wVar);
    }

    public static y g(w wVar) {
        return new i(wVar).new a();
    }

    @Override // e9.x
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Number c(m9.a aVar) throws IOException {
        m9.b bVarL0 = aVar.l0();
        int i10 = b.f9834a[bVarL0.ordinal()];
        if (i10 == 1) {
            aVar.h0();
            return null;
        }
        if (i10 == 2 || i10 == 3) {
            return this.f9832a.d(aVar);
        }
        throw new s("Expecting number, got: " + bVarL0 + "; at path " + aVar.D());
    }

    @Override // e9.x
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(m9.c cVar, Number number) throws IOException {
        cVar.m0(number);
    }
}
