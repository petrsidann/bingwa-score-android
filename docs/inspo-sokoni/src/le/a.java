package le;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ke.a {
    @Override // ke.a
    public List<String> a() {
        return Arrays.asList("com.asus.launcher");
    }

    @Override // ke.a
    public void b(Context context, ComponentName componentName, int i10) throws ke.b {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i10);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        intent.putExtra("badge_vip_count", 0);
        me.a.b(context, intent);
    }
}
