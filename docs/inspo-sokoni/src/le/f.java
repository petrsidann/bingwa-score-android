package le;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f implements ke.a {
    @Override // ke.a
    public List<String> a() {
        return Arrays.asList("com.vivo.launcher");
    }

    @Override // ke.a
    public void b(Context context, ComponentName componentName, int i10) {
        Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra("className", componentName.getClassName());
        intent.putExtra("notificationNum", i10);
        context.sendBroadcast(intent);
    }
}
