package o7;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class c2 implements OnCompleteListener<p7.r1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.firebase.auth.a f13694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f13695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f13696c;

    public c2(FirebaseAuth firebaseAuth, com.google.firebase.auth.a aVar, String str) {
        this.f13694a = aVar;
        this.f13695b = str;
        this.f13696c = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<p7.r1> task) {
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            Log.e("FirebaseAuth", "Error while validating application identity: " + (exception != null ? exception.getMessage() : ""));
            if (exception != null && p7.d0.i(exception)) {
                FirebaseAuth.j0((h7.l) exception, this.f13694a, this.f13695b);
                return;
            }
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
        }
        this.f13696c.i0(this.f13694a, task.getResult());
    }
}
