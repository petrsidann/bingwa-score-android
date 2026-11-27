package mb;

import com.google.firebase.firestore.FirebaseFirestore;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FirebaseFirestore f13032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13033b;

    public b(FirebaseFirestore firebaseFirestore, String str) {
        this.f13032a = firebaseFirestore;
        this.f13033b = str;
    }

    public String a() {
        return this.f13033b;
    }

    public FirebaseFirestore b() {
        return this.f13032a;
    }
}
