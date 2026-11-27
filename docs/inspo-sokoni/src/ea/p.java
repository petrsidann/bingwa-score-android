package ea;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class p implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<k> f7531d = new LinkedList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<m> f7532e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<m> f7533f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, m> f7534g = new HashMap();

    public p(String str, int i10, int i11) {
        this.f7528a = str;
        this.f7529b = i10;
        this.f7530c = i11;
    }

    @Override // ea.n
    public synchronized void b(k kVar) {
        this.f7531d.add(kVar);
        Iterator it = new HashSet(this.f7532e).iterator();
        while (it.hasNext()) {
            j((m) it.next());
        }
    }

    @Override // ea.n
    public synchronized void d() {
        Iterator<m> it = this.f7532e.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        Iterator<m> it2 = this.f7533f.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
    }

    public m f(String str, int i10) {
        return new m(str, i10);
    }

    public final synchronized k g(m mVar) {
        k next;
        m mVar2;
        ListIterator<k> listIterator = this.f7531d.listIterator();
        do {
            if (!listIterator.hasNext()) {
                return null;
            }
            next = listIterator.next();
            mVar2 = next.a() != null ? this.f7534g.get(next.a()) : null;
            if (mVar2 == null) {
                break;
            }
        } while (mVar2 != mVar);
        listIterator.remove();
        return next;
    }

    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final synchronized void h(m mVar) {
        HashSet hashSet = new HashSet(this.f7532e);
        this.f7533f.remove(mVar);
        this.f7532e.add(mVar);
        if (!mVar.b() && mVar.d() != null) {
            this.f7534g.remove(mVar.d());
        }
        j(mVar);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            j((m) it.next());
        }
    }

    public final synchronized void j(m mVar) {
        k kVarG = g(mVar);
        if (kVarG != null) {
            this.f7533f.add(mVar);
            this.f7532e.remove(mVar);
            if (kVarG.a() != null) {
                this.f7534g.put(kVarG.a(), mVar);
            }
            mVar.e(kVarG);
        }
    }

    @Override // ea.n
    public synchronized void start() {
        for (int i10 = 0; i10 < this.f7529b; i10++) {
            final m mVarF = f(this.f7528a + i10, this.f7530c);
            mVarF.g(new Runnable() { // from class: ea.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7526a.h(mVarF);
                }
            });
            this.f7532e.add(mVarF);
        }
    }
}
