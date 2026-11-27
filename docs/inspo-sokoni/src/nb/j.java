package nb;

import b8.t0;
import com.google.firebase.firestore.FirebaseFirestore;

/* JADX INFO: loaded from: classes2.dex */
public class j implements fb.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t0 f13522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FirebaseFirestore f13523b;

    public j(FirebaseFirestore firebaseFirestore) {
        this.f13523b = firebaseFirestore;
    }

    @Override // fb.c.d
    public void onCancel(Object obj) {
        t0 t0Var = this.f13522a;
        if (t0Var != null) {
            t0Var.remove();
            this.f13522a = null;
        }
    }

    @Override // fb.c.d
    public void onListen(Object obj, final fb.c.b bVar) {
        this.f13522a = this.f13523b.o(new Runnable() { // from class: nb.i
            @Override // java.lang.Runnable
            public final void run() {
                bVar.a(null);
            }
        });
    }
}
