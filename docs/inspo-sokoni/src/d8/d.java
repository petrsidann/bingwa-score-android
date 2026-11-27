package d8;

import b8.w0;
import h8.k;
import h8.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l8.x;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f6477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f6478b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f6482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f6483g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<j> f6479c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s7.c<k, r> f6481e = h8.i.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<k, h> f6480d = new HashMap();

    public d(a aVar, e eVar) {
        this.f6477a = aVar;
        this.f6478b = eVar;
    }

    public w0 a(c cVar, long j10) {
        s7.c<k, r> cVar2;
        k kVarB;
        r rVarX;
        x.a(!(cVar instanceof e), "Unexpected bundle metadata element.", new Object[0]);
        int size = this.f6481e.size();
        if (cVar instanceof j) {
            this.f6479c.add((j) cVar);
        } else if (cVar instanceof h) {
            h hVar = (h) cVar;
            this.f6480d.put(hVar.b(), hVar);
            this.f6483g = hVar;
            if (!hVar.a()) {
                cVar2 = this.f6481e;
                kVarB = hVar.b();
                rVarX = r.t(hVar.b(), hVar.d()).x(hVar.d());
                this.f6481e = cVar2.l(kVarB, rVarX);
                this.f6483g = null;
            }
        } else if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (this.f6483g == null || !bVar.b().equals(this.f6483g.b())) {
                throw new IllegalArgumentException("The document being added does not match the stored metadata.");
            }
            cVar2 = this.f6481e;
            kVarB = bVar.b();
            rVarX = bVar.a().x(this.f6483g.d());
            this.f6481e = cVar2.l(kVarB, rVarX);
            this.f6483g = null;
        }
        this.f6482f += j10;
        if (size != this.f6481e.size()) {
            return new w0(this.f6481e.size(), this.f6478b.e(), this.f6482f, this.f6478b.d(), null, w0.a.RUNNING);
        }
        return null;
    }

    public s7.c<k, h8.h> b() {
        x.a(this.f6483g == null, "Bundled documents end with a document metadata element instead of a document.", new Object[0]);
        x.a(this.f6478b.a() != null, "Bundle ID must be set", new Object[0]);
        x.a(this.f6481e.size() == this.f6478b.e(), "Expected %s documents, but loaded %s.", Integer.valueOf(this.f6478b.e()), Integer.valueOf(this.f6481e.size()));
        s7.c<k, h8.h> cVarC = this.f6477a.c(this.f6481e, this.f6478b.a());
        Map<String, s7.e<k>> mapC = c();
        for (j jVar : this.f6479c) {
            this.f6477a.b(jVar, mapC.get(jVar.b()));
        }
        this.f6477a.a(this.f6478b);
        return cVarC;
    }

    public final Map<String, s7.e<k>> c() {
        HashMap map = new HashMap();
        Iterator<j> it = this.f6479c.iterator();
        while (it.hasNext()) {
            map.put(it.next().b(), k.k());
        }
        for (h hVar : this.f6480d.values()) {
            for (String str : hVar.c()) {
                map.put(str, ((s7.e) map.get(str)).i(hVar.b()));
            }
        }
        return map;
    }
}
