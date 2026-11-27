package u4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzcf;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class z {
    public static Set<String> a(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    public static void b(v5 v5Var, SQLiteDatabase sQLiteDatabase) {
        if (v5Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(zzcf.zza().zza(sQLiteDatabase.getPath()));
        if (!file.setReadable(false, false)) {
            v5Var.H().a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            v5Var.H().a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            v5Var.H().a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        v5Var.H().a("Failed to turn on database write permission for owner");
    }

    public static void c(v5 v5Var, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        if (v5Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!d(v5Var, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            Set<String> setA = a(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!setA.remove(str4)) {
                    throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                }
            }
            if (strArr != null) {
                for (int i10 = 0; i10 < strArr.length; i10 += 2) {
                    if (!setA.remove(strArr[i10])) {
                        sQLiteDatabase.execSQL(strArr[i10 + 1]);
                    }
                }
            }
            if (setA.isEmpty()) {
                return;
            }
            v5Var.H().c("Table has extra columns. table, columns", str, TextUtils.join(", ", setA));
        } catch (SQLiteException e10) {
            v5Var.C().b("Failed to verify columns on table that was just created", str);
            throw e10;
        }
    }

    public static boolean d(v5 v5Var, SQLiteDatabase sQLiteDatabase, String str) {
        if (v5Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean zMoveToFirst = cursorQuery.moveToFirst();
                cursorQuery.close();
                return zMoveToFirst;
            } catch (SQLiteException e10) {
                v5Var.H().c("Error querying for table", str, e10);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
