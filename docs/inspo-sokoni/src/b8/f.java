package b8;

import com.google.firebase.firestore.FirebaseFirestore;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.google.firebase.firestore.i {
    public f(h8.t tVar, FirebaseFirestore firebaseFirestore) {
        super(e8.b1.b(tVar), firebaseFirestore);
        if (tVar.u() % 2 == 1) {
            return;
        }
        throw new IllegalArgumentException("Invalid collection reference. Collection references must have an odd number of segments, but " + tVar.i() + " has " + tVar.u());
    }
}
