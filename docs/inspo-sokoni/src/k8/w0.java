package k8;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11833a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<h8.k, e8.m.a> f11834b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11835c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.google.protobuf.i f11836d = com.google.protobuf.i.f5753b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11837e = false;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11838a;

        static {
            int[] iArr = new int[e8.m.a.values().length];
            f11838a = iArr;
            try {
                iArr[e8.m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11838a[e8.m.a.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11838a[e8.m.a.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void a(h8.k kVar, e8.m.a aVar) {
        this.f11835c = true;
        this.f11834b.put(kVar, aVar);
    }

    public void b() {
        this.f11835c = false;
        this.f11834b.clear();
    }

    public boolean c() {
        return this.f11835c;
    }

    public boolean d() {
        return this.f11837e;
    }

    public boolean e() {
        return this.f11833a != 0;
    }

    public void f() {
        this.f11835c = true;
        this.f11837e = true;
    }

    public void g() {
        this.f11833a++;
    }

    public void h() {
        this.f11833a--;
    }

    public void i(h8.k kVar) {
        this.f11835c = true;
        this.f11834b.remove(kVar);
    }

    public v0 j() {
        s7.e<h8.k> eVarK = h8.k.k();
        s7.e<h8.k> eVarK2 = h8.k.k();
        s7.e<h8.k> eVarK3 = h8.k.k();
        s7.e<h8.k> eVarI = eVarK;
        s7.e<h8.k> eVarI2 = eVarK2;
        s7.e<h8.k> eVarI3 = eVarK3;
        for (Map.Entry<h8.k, e8.m.a> entry : this.f11834b.entrySet()) {
            h8.k key = entry.getKey();
            e8.m.a value = entry.getValue();
            int i10 = a.f11838a[value.ordinal()];
            if (i10 == 1) {
                eVarI = eVarI.i(key);
            } else if (i10 == 2) {
                eVarI2 = eVarI2.i(key);
            } else {
                if (i10 != 3) {
                    throw l8.b.a("Encountered invalid change type: %s", value);
                }
                eVarI3 = eVarI3.i(key);
            }
        }
        return new v0(this.f11836d, this.f11837e, eVarI, eVarI2, eVarI3);
    }

    public void k(com.google.protobuf.i iVar) {
        if (iVar.isEmpty()) {
            return;
        }
        this.f11835c = true;
        this.f11836d = iVar;
    }
}
