package p7;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.Recaptcha;
import com.google.android.recaptcha.RecaptchaTasksClient;

/* JADX INFO: loaded from: classes.dex */
public final class z0 implements w0 {
    @Override // p7.w0
    public final Task<RecaptchaTasksClient> a(Application application, String str) {
        return Recaptcha.fetchTaskClient(application, str);
    }
}
