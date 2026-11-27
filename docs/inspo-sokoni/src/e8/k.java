package e8;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q> f7202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f7203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<p> f7204c;

    public enum a {
        AND("and"),
        OR("or");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7208a;

        a(String str) {
            this.f7208a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f7208a;
        }
    }

    public k(List<q> list, a aVar) {
        this.f7202a = new ArrayList(list);
        this.f7203b = aVar;
    }

    @Override // e8.q
    public String a() {
        StringBuilder sb2 = new StringBuilder();
        if (i()) {
            Iterator<q> it = this.f7202a.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().a());
            }
            return sb2.toString();
        }
        sb2.append(this.f7203b.toString() + "(");
        sb2.append(TextUtils.join(",", this.f7202a));
        sb2.append(")");
        return sb2.toString();
    }

    @Override // e8.q
    public List<q> b() {
        return Collections.unmodifiableList(this.f7202a);
    }

    @Override // e8.q
    public List<p> c() {
        List<p> list = this.f7204c;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        this.f7204c = new ArrayList();
        Iterator<q> it = this.f7202a.iterator();
        while (it.hasNext()) {
            this.f7204c.addAll(it.next().c());
        }
        return Collections.unmodifiableList(this.f7204c);
    }

    @Override // e8.q
    public boolean d(h8.h hVar) {
        if (f()) {
            Iterator<q> it = this.f7202a.iterator();
            while (it.hasNext()) {
                if (!it.next().d(hVar)) {
                    return false;
                }
            }
            return true;
        }
        Iterator<q> it2 = this.f7202a.iterator();
        while (it2.hasNext()) {
            if (it2.next().d(hVar)) {
                return true;
            }
        }
        return false;
    }

    public a e() {
        return this.f7203b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f7203b == kVar.f7203b && this.f7202a.equals(kVar.f7202a);
    }

    public boolean f() {
        return this.f7203b == a.AND;
    }

    public boolean g() {
        return this.f7203b == a.OR;
    }

    public boolean h() {
        Iterator<q> it = this.f7202a.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof k) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return ((1147 + this.f7203b.hashCode()) * 31) + this.f7202a.hashCode();
    }

    public boolean i() {
        return h() && f();
    }

    public k j(List<q> list) {
        ArrayList arrayList = new ArrayList(this.f7202a);
        arrayList.addAll(list);
        return new k(arrayList, this.f7203b);
    }

    public String toString() {
        return a();
    }
}
