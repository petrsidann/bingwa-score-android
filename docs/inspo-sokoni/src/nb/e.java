package nb;

import b8.d1;
import b8.v0;
import b8.w0;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class e implements fb.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fb.c.b f13511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FirebaseFirestore f13512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13513c;

    public e(FirebaseFirestore firebaseFirestore, byte[] bArr) {
        this.f13512b = firebaseFirestore;
        this.f13513c = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(fb.c.b bVar, Exception exc) {
        bVar.b("firebase_firestore", exc.getMessage(), ob.a.a(exc));
        onCancel(null);
    }

    @Override // fb.c.d
    public void onCancel(Object obj) {
        this.f13511a.c();
    }

    @Override // fb.c.d
    public void onListen(Object obj, final fb.c.b bVar) {
        this.f13511a = bVar;
        v0 v0VarT = this.f13512b.T(this.f13513c);
        Objects.requireNonNull(bVar);
        v0VarT.a(new d1() { // from class: nb.c
            @Override // b8.d1
            public final void a(Object obj2) {
                bVar.a((w0) obj2);
            }
        });
        v0VarT.addOnFailureListener(new OnFailureListener() { // from class: nb.d
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f13509a.b(bVar, exc);
            }
        });
    }
}
