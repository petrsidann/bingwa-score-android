package le;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.impl.DefaultBadger;

/* JADX INFO: loaded from: classes2.dex */
public class e implements ke.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f12786b = {"_id", "class"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DefaultBadger f12787a = new DefaultBadger();

    @Override // ke.a
    public List<String> a() {
        return Arrays.asList("com.sec.android.app.launcher", "com.sec.android.app.twlauncher");
    }

    @Override // ke.a
    public void b(Context context, ComponentName componentName, int i10) throws ke.b {
        DefaultBadger defaultBadger = this.f12787a;
        if (defaultBadger != null && defaultBadger.c(context)) {
            this.f12787a.b(context, componentName, i10);
            return;
        }
        Uri uri = Uri.parse("content://com.sec.badge/apps?notify=true");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(uri, f12786b, "package=?", new String[]{componentName.getPackageName()}, null);
            if (cursorQuery != null) {
                String className = componentName.getClassName();
                boolean z10 = false;
                while (cursorQuery.moveToNext()) {
                    contentResolver.update(uri, c(componentName, i10, false), "_id=?", new String[]{String.valueOf(cursorQuery.getInt(0))});
                    if (className.equals(cursorQuery.getString(cursorQuery.getColumnIndex("class")))) {
                        z10 = true;
                    }
                }
                if (!z10) {
                    contentResolver.insert(uri, c(componentName, i10, true));
                }
            }
        } finally {
            me.b.a(cursorQuery);
        }
    }

    public final ContentValues c(ComponentName componentName, int i10, boolean z10) {
        ContentValues contentValues = new ContentValues();
        if (z10) {
            contentValues.put("package", componentName.getPackageName());
            contentValues.put("class", componentName.getClassName());
        }
        contentValues.put("badgecount", Integer.valueOf(i10));
        return contentValues;
    }
}
