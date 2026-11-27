package e8;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap<h8.k, m> f7235a = new TreeMap<>();

    public void a(m mVar) {
        h8.k key = mVar.b().getKey();
        m mVar2 = this.f7235a.get(key);
        if (mVar2 == null) {
            this.f7235a.put(key, mVar);
            return;
        }
        m.a aVarC = mVar2.c();
        m.a aVarC2 = mVar.c();
        m.a aVar = m.a.ADDED;
        if (aVarC2 == aVar || aVarC != m.a.METADATA) {
            if (aVarC2 != m.a.METADATA || aVarC == m.a.REMOVED) {
                m.a aVar2 = m.a.MODIFIED;
                if (aVarC2 == aVar2 && aVarC == aVar2) {
                    mVar = m.a(aVar2, mVar.b());
                } else if (aVarC2 == aVar2 && aVarC == aVar) {
                    mVar = m.a(aVar, mVar.b());
                } else {
                    m.a aVar3 = m.a.REMOVED;
                    if (aVarC2 == aVar3 && aVarC == aVar) {
                        this.f7235a.remove(key);
                        return;
                    } else if (aVarC2 == aVar3 && aVarC == aVar2) {
                        mVar = m.a(aVar3, mVar2.b());
                    } else {
                        if (aVarC2 != aVar || aVarC != aVar3) {
                            throw l8.b.a("Unsupported combination of changes %s after %s", aVarC2, aVarC);
                        }
                        mVar = m.a(aVar2, mVar.b());
                    }
                }
            } else {
                mVar = m.a(aVarC, mVar.b());
            }
        }
        this.f7235a.put(key, mVar);
    }

    public List<m> b() {
        return new ArrayList(this.f7235a.values());
    }
}
