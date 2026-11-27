package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Collections;
import java.util.List;
import ke.a;
import ke.b;

/* JADX INFO: loaded from: classes2.dex */
public class NewHtcHomeBadger implements a {
    @Override // ke.a
    public List<String> a() {
        return Collections.singletonList("com.htc.launcher");
    }

    @Override // ke.a
    public void b(Context context, ComponentName componentName, int i10) throws b {
        boolean z10;
        Intent intent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent.putExtra("com.htc.launcher.extra.COMPONENT", componentName.flattenToShortString());
        intent.putExtra("com.htc.launcher.extra.COUNT", i10);
        Intent intent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent2.putExtra("packagename", componentName.getPackageName());
        intent2.putExtra("count", i10);
        boolean z11 = false;
        try {
            me.a.c(context, intent);
            z10 = true;
        } catch (b unused) {
            z10 = false;
        }
        try {
            me.a.c(context, intent2);
            z11 = true;
        } catch (b unused2) {
        }
        if (z10 || z11) {
            return;
        }
        throw new b("unable to resolve intent: " + intent2.toString());
    }
}
