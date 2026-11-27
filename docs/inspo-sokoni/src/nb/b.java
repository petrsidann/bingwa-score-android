package nb;

import b8.c1;
import b8.r;
import b8.s0;
import b8.s1;
import b8.t0;
import com.google.firebase.firestore.FirebaseFirestore;

/* JADX INFO: loaded from: classes2.dex */
public class b implements fb.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t0 f13502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FirebaseFirestore f13503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.google.firebase.firestore.c f13504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c1 f13505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.firebase.firestore.d.a f13506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s0 f13507f;

    public b(FirebaseFirestore firebaseFirestore, com.google.firebase.firestore.c cVar, Boolean bool, com.google.firebase.firestore.d.a aVar, s0 s0Var) {
        this.f13503b = firebaseFirestore;
        this.f13504c = cVar;
        this.f13505d = bool.booleanValue() ? c1.INCLUDE : c1.EXCLUDE;
        this.f13506e = aVar;
        this.f13507f = s0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(fb.c.b bVar, com.google.firebase.firestore.d dVar, com.google.firebase.firestore.f fVar) {
        if (fVar == null) {
            bVar.a(ob.b.k(dVar, this.f13506e).e());
            return;
        }
        bVar.b("firebase_firestore", fVar.getMessage(), ob.a.a(fVar));
        bVar.c();
        onCancel(null);
    }

    @Override // fb.c.d
    public void onCancel(Object obj) {
        t0 t0Var = this.f13502a;
        if (t0Var != null) {
            t0Var.remove();
            this.f13502a = null;
        }
    }

    @Override // fb.c.d
    public void onListen(Object obj, final fb.c.b bVar) {
        s1.b bVar2 = new s1.b();
        bVar2.f(this.f13505d);
        bVar2.g(this.f13507f);
        this.f13502a = this.f13504c.j(bVar2.e(), new r() { // from class: nb.a
            @Override // b8.r
            public final void a(Object obj2, com.google.firebase.firestore.f fVar) {
                this.f13500a.b(bVar, (com.google.firebase.firestore.d) obj2, fVar);
            }
        });
    }
}
