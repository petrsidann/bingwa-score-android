package e9;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g9.d f7424a = g9.d.f9059l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f7425b = t.f7448a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f7426c = c.f7385a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Type, g<?>> f7427d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<y> f7428e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<y> f7429f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7430g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f7431h = e.f7393z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7432i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7433j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7434k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7435l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f7436m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7437n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7438o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7439p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7440q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public w f7441r = e.B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public w f7442s = e.C;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LinkedList<u> f7443t = new LinkedList<>();

    public final void a(String str, int i10, int i11, List<y> list) {
        y yVarB;
        y yVarB2;
        boolean z10 = k9.d.f11898a;
        y yVarA = null;
        if (str != null && !str.trim().isEmpty()) {
            yVarB = h9.d.b.f9810b.b(str);
            if (z10) {
                yVarA = k9.d.f11900c.b(str);
                yVarB2 = k9.d.f11899b.b(str);
            } else {
                yVarB2 = null;
            }
        } else {
            if (i10 == 2 || i11 == 2) {
                return;
            }
            y yVarA2 = h9.d.b.f9810b.a(i10, i11);
            if (z10) {
                yVarA = k9.d.f11900c.a(i10, i11);
                y yVarA3 = k9.d.f11899b.a(i10, i11);
                yVarB = yVarA2;
                yVarB2 = yVarA3;
            } else {
                yVarB = yVarA2;
                yVarB2 = null;
            }
        }
        list.add(yVarB);
        if (z10) {
            list.add(yVarA);
            list.add(yVarB2);
        }
    }

    public e b() {
        List<y> arrayList = new ArrayList<>(this.f7428e.size() + this.f7429f.size() + 3);
        arrayList.addAll(this.f7428e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f7429f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f7431h, this.f7432i, this.f7433j, arrayList);
        return new e(this.f7424a, this.f7426c, new HashMap(this.f7427d), this.f7430g, this.f7434k, this.f7438o, this.f7436m, this.f7437n, this.f7439p, this.f7435l, this.f7440q, this.f7425b, this.f7431h, this.f7432i, this.f7433j, new ArrayList(this.f7428e), new ArrayList(this.f7429f), arrayList, this.f7441r, this.f7442s, new ArrayList(this.f7443t));
    }

    public f c(Type type, Object obj) {
        Objects.requireNonNull(type);
        boolean z10 = obj instanceof r;
        g9.a.a(z10 || (obj instanceof j) || (obj instanceof g) || (obj instanceof x));
        if (obj instanceof g) {
            this.f7427d.put(type, (g) obj);
        }
        if (z10 || (obj instanceof j)) {
            this.f7428e.add(h9.m.h(l9.a.b(type), obj));
        }
        if (obj instanceof x) {
            this.f7428e.add(h9.o.c(l9.a.b(type), (x) obj));
        }
        return this;
    }

    public f d(y yVar) {
        Objects.requireNonNull(yVar);
        this.f7428e.add(yVar);
        return this;
    }
}
