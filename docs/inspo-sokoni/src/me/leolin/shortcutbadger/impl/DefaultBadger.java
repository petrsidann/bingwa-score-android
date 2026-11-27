package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import ke.a;
import ke.b;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultBadger implements a {
    @Override // ke.a
    public List<String> a() {
        return Arrays.asList("fr.neamar.kiss", "com.quaap.launchtime", "com.quaap.launchtime_official");
    }

    @Override // ke.a
    public void b(Context context, ComponentName componentName, int i10) throws b {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i10);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        me.a.b(context, intent);
    }

    public boolean c(Context context) {
        return me.a.a(context, new Intent("android.intent.action.BADGE_COUNT_UPDATE")).size() > 0 || me.a.a(context, new Intent("me.leolin.shortcutbadger.BADGE_COUNT_UPDATE")).size() > 0;
    }
}
