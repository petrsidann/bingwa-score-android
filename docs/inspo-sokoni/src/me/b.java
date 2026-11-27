package me;

import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static void a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }
}
