package h9;

import e9.v;
import e9.w;
import e9.x;
import e9.y;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j extends x<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f9835c = g(v.f7456a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e9.e f9836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f9837b;

    public class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f9838a;

        public a(w wVar) {
            this.f9838a = wVar;
        }

        @Override // e9.y
        public <T> x<T> create(e9.e eVar, l9.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() == Object.class) {
                return new j(eVar, this.f9838a, aVar2);
            }
            return null;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9839a;

        static {
            int[] iArr = new int[m9.b.values().length];
            f9839a = iArr;
            try {
                iArr[m9.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9839a[m9.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9839a[m9.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9839a[m9.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9839a[m9.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9839a[m9.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public j(e9.e eVar, w wVar) {
        this.f9836a = eVar;
        this.f9837b = wVar;
    }

    public /* synthetic */ j(e9.e eVar, w wVar, a aVar) {
        this(eVar, wVar);
    }

    public static y f(w wVar) {
        return wVar == v.f7456a ? f9835c : g(wVar);
    }

    public static y g(w wVar) {
        return new a(wVar);
    }

    @Override // e9.x
    public Object c(m9.a aVar) throws IOException {
        m9.b bVarL0 = aVar.l0();
        Object objI = i(aVar, bVarL0);
        if (objI == null) {
            return h(aVar, bVarL0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.I()) {
                String strF0 = objI instanceof Map ? aVar.f0() : null;
                m9.b bVarL1 = aVar.l0();
                Object objI2 = i(aVar, bVarL1);
                boolean z10 = objI2 != null;
                if (objI2 == null) {
                    objI2 = h(aVar, bVarL1);
                }
                if (objI instanceof List) {
                    ((List) objI).add(objI2);
                } else {
                    ((Map) objI).put(strF0, objI2);
                }
                if (z10) {
                    arrayDeque.addLast(objI);
                    objI = objI2;
                }
            } else {
                if (objI instanceof List) {
                    aVar.z();
                } else {
                    aVar.B();
                }
                if (arrayDeque.isEmpty()) {
                    return objI;
                }
                objI = arrayDeque.removeLast();
            }
        }
    }

    @Override // e9.x
    public void e(m9.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.L();
            return;
        }
        x xVarK = this.f9836a.k(obj.getClass());
        if (!(xVarK instanceof j)) {
            xVarK.e(cVar, obj);
        } else {
            cVar.t();
            cVar.B();
        }
    }

    public final Object h(m9.a aVar, m9.b bVar) throws IOException {
        int i10 = b.f9839a[bVar.ordinal()];
        if (i10 == 3) {
            return aVar.j0();
        }
        if (i10 == 4) {
            return this.f9837b.d(aVar);
        }
        if (i10 == 5) {
            return Boolean.valueOf(aVar.Q());
        }
        if (i10 == 6) {
            aVar.h0();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    public final Object i(m9.a aVar, m9.b bVar) throws IOException {
        int i10 = b.f9839a[bVar.ordinal()];
        if (i10 == 1) {
            aVar.d();
            return new ArrayList();
        }
        if (i10 != 2) {
            return null;
        }
        aVar.e();
        return new g9.h();
    }
}
