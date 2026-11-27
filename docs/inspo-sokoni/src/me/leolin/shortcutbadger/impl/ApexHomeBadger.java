package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import ke.a;
import ke.b;

/* JADX INFO: loaded from: classes2.dex */
public class ApexHomeBadger implements a {
    @Override // ke.a
    public List<String> a() {
        return Arrays.asList("com.anddoes.launcher");
    }

    @Override // ke.a
    public void b(Context context, ComponentName componentName, int i10) throws b {
        Intent intent = new Intent("com.anddoes.launcher.COUNTER_CHANGED");
        intent.putExtra("package", componentName.getPackageName());
        intent.putExtra("count", i10);
        intent.putExtra("class", componentName.getClassName());
        me.a.c(context, intent);
    }
}
