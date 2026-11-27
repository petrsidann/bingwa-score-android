package v3;

import android.app.PendingIntent;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public interface k {
    Task<c> beginSignIn(b bVar);

    Task<PendingIntent> getSignInIntent(f fVar);
}
