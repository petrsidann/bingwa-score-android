package ea;

import android.database.Cursor;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class d0 {
    public static List<Object> a(Cursor cursor, int i10) {
        String name;
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            Object objB = b(cursor, i11);
            if (fa.a.f8259c) {
                if (objB == null) {
                    name = null;
                } else if (objB.getClass().isArray()) {
                    name = "array(" + objB.getClass().getComponentType().getName() + ")";
                } else {
                    name = objB.getClass().getName();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("column ");
                sb2.append(i11);
                sb2.append(" ");
                sb2.append(cursor.getType(i11));
                sb2.append(": ");
                sb2.append(objB);
                sb2.append(name == null ? "" : " (" + name + ")");
                Log.d("Sqflite", sb2.toString());
            }
            arrayList.add(objB);
        }
        return arrayList;
    }

    public static Object b(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i10));
        }
        if (type == 3) {
            return cursor.getString(i10);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i10);
    }

    public static Locale c(String str) {
        return Locale.forLanguageTag(str);
    }

    public static Locale d(String str) {
        return c(str);
    }
}
