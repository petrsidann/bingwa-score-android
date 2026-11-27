package nb;

import b8.c1;
import b8.r;
import b8.s0;
import b8.s1;
import b8.t0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class h implements fb.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t0 f13516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.google.firebase.firestore.i f13517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c1 f13518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.google.firebase.firestore.d.a f13519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s0 f13520e;

    public h(com.google.firebase.firestore.i iVar, Boolean bool, com.google.firebase.firestore.d.a aVar, s0 s0Var) {
        this.f13517b = iVar;
        this.f13518c = bool.booleanValue() ? c1.INCLUDE : c1.EXCLUDE;
        this.f13519d = aVar;
        this.f13520e = s0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(fb.c.b bVar, com.google.firebase.firestore.k kVar, com.google.firebase.firestore.f fVar) {
        if (fVar != null) {
            bVar.b("firebase_firestore", fVar.getMessage(), ob.a.a(fVar));
            bVar.c();
            onCancel(null);
            return;
        }
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(kVar.k().size());
        ArrayList arrayList3 = new ArrayList(kVar.i().size());
        Iterator<com.google.firebase.firestore.d> it = kVar.k().iterator();
        while (it.hasNext()) {
            arrayList2.add(ob.b.k(it.next(), this.f13519d).e());
        }
        Iterator<b8.g> it2 = kVar.i().iterator();
        while (it2.hasNext()) {
            arrayList3.add(ob.b.h(it2.next(), this.f13519d).f());
        }
        arrayList.add(arrayList2);
        arrayList.add(arrayList3);
        arrayList.add(ob.b.n(kVar.l()).d());
        bVar.a(arrayList);
    }

    @Override // fb.c.d
    public void onCancel(Object obj) {
        t0 t0Var = this.f13516a;
        if (t0Var != null) {
            t0Var.remove();
            this.f13516a = null;
        }
    }

    @Override // fb.c.d
    public void onListen(Object obj, final fb.c.b bVar) {
        s1.b bVar2 = new s1.b();
        bVar2.f(this.f13518c);
        bVar2.g(this.f13520e);
        this.f13516a = this.f13517b.g(bVar2.e(), new r() { // from class: nb.g
            @Override // b8.r
            public final void a(Object obj2, com.google.firebase.firestore.f fVar) {
                this.f13514a.b(bVar, (com.google.firebase.firestore.k) obj2, fVar);
            }
        });
    }
}
