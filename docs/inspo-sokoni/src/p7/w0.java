package p7;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaTasksClient;

/* JADX INFO: loaded from: classes.dex */
public interface w0 {
    Task<RecaptchaTasksClient> a(Application application, String str);
}
