package xd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f19111a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f19112b;

    public g(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static synchronized g k(Context context) {
        if (f19112b == null) {
            try {
                f19112b = new g(context, "AwesomeSchedules.db");
            } catch (Exception e10) {
                ae.b.e().h("SQLiteSchedulesDB", "SHARED_PREFERENCES_NOT_AVAILABLE", "SQLiteSchedulesDB could not be correctly initialized: " + e10.getMessage(), "initialization.SQLiteSchedulesDB");
            }
        }
        return f19112b;
    }

    public Map<Integer, String> B(Context context, String str) {
        synchronized (f19111a) {
            HashMap map = new HashMap();
            SQLiteDatabase sQLiteDatabaseT = t(context);
            if (sQLiteDatabaseT == null) {
                if (sQLiteDatabaseT != null) {
                    sQLiteDatabaseT.close();
                }
                return map;
            }
            try {
                Cursor cursorRawQuery = sQLiteDatabaseT.rawQuery("SELECT id, content FROM schedules WHERE group_key = ?", new String[]{str});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            map.put(Integer.valueOf(cursorRawQuery.getInt(0)), cursorRawQuery.getString(1));
                        } while (cursorRawQuery.moveToNext());
                    }
                    cursorRawQuery.close();
                    sQLiteDatabaseT.close();
                    return map;
                } catch (Throwable th) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    sQLiteDatabaseT.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    public final SQLiteDatabase C(Context context) {
        try {
            return super.getWritableDatabase();
        } catch (Exception e10) {
            ae.b.e().h("SQLiteSchedulesDB", "SHARED_PREFERENCES_NOT_AVAILABLE", "Writable database could not be delivered: " + e10.getMessage(), "initialization.SQLiteSchedulesDB");
            return null;
        }
    }

    public synchronized void D(Context context) {
        synchronized (f19111a) {
            SQLiteDatabase sQLiteDatabaseC = C(context);
            if (sQLiteDatabaseC == null) {
                if (sQLiteDatabaseC != null) {
                    sQLiteDatabaseC.close();
                }
                return;
            }
            try {
                sQLiteDatabaseC.beginTransaction();
                sQLiteDatabaseC.execSQL("DELETE FROM schedules");
                sQLiteDatabaseC.setTransactionSuccessful();
                sQLiteDatabaseC.endTransaction();
                sQLiteDatabaseC.close();
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseC.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public synchronized void E(Context context, Integer num) {
        synchronized (f19111a) {
            SQLiteDatabase sQLiteDatabaseC = C(context);
            if (sQLiteDatabaseC == null) {
                if (sQLiteDatabaseC != null) {
                    sQLiteDatabaseC.close();
                }
                return;
            }
            try {
                sQLiteDatabaseC.beginTransaction();
                sQLiteDatabaseC.delete("schedules", "id = ?", new String[]{String.valueOf(num)});
                sQLiteDatabaseC.setTransactionSuccessful();
                sQLiteDatabaseC.endTransaction();
                sQLiteDatabaseC.close();
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseC.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public synchronized void G(Context context, String str) {
        synchronized (f19111a) {
            SQLiteDatabase sQLiteDatabaseC = C(context);
            if (sQLiteDatabaseC == null) {
                if (sQLiteDatabaseC != null) {
                    sQLiteDatabaseC.close();
                }
                return;
            }
            try {
                sQLiteDatabaseC.beginTransaction();
                sQLiteDatabaseC.delete("schedules", "channel_key = ?", new String[]{str});
                sQLiteDatabaseC.setTransactionSuccessful();
                sQLiteDatabaseC.endTransaction();
                sQLiteDatabaseC.close();
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseC.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public synchronized void I(Context context, String str) {
        synchronized (f19111a) {
            SQLiteDatabase sQLiteDatabaseC = C(context);
            if (sQLiteDatabaseC == null) {
                if (sQLiteDatabaseC != null) {
                    sQLiteDatabaseC.close();
                }
                return;
            }
            try {
                sQLiteDatabaseC.beginTransaction();
                sQLiteDatabaseC.delete("schedules", "group_key = ?", new String[]{str});
                sQLiteDatabaseC.setTransactionSuccessful();
                sQLiteDatabaseC.endTransaction();
                sQLiteDatabaseC.close();
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseC.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public synchronized void J(Context context, Integer num, String str, String str2, String str3) {
        synchronized (f19111a) {
            SQLiteDatabase sQLiteDatabaseC = C(context);
            if (sQLiteDatabaseC == null) {
                if (sQLiteDatabaseC != null) {
                    sQLiteDatabaseC.close();
                }
                return;
            }
            try {
                sQLiteDatabaseC.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", num);
                contentValues.put("channel_key", str);
                contentValues.put("group_key", str2);
                contentValues.put("content", str3);
                sQLiteDatabaseC.insertWithOnConflict("schedules", null, contentValues, 5);
                sQLiteDatabaseC.setTransactionSuccessful();
                sQLiteDatabaseC.endTransaction();
                sQLiteDatabaseC.close();
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseC.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public synchronized void d(Context context) {
    }

    public Map<Integer, String> e(Context context) {
        synchronized (f19111a) {
            HashMap map = new HashMap();
            SQLiteDatabase sQLiteDatabaseT = t(context);
            if (sQLiteDatabaseT == null) {
                if (sQLiteDatabaseT != null) {
                    sQLiteDatabaseT.close();
                }
                return map;
            }
            try {
                Cursor cursorRawQuery = sQLiteDatabaseT.rawQuery("SELECT id, content FROM schedules", null);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            map.put(Integer.valueOf(cursorRawQuery.getInt(0)), cursorRawQuery.getString(1));
                        } while (cursorRawQuery.moveToNext());
                    }
                    cursorRawQuery.close();
                    sQLiteDatabaseT.close();
                    return map;
                } catch (Throwable th) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    sQLiteDatabaseT.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS schedules(id INTEGER PRIMARY KEY,group_key TEXT,channel_key TEXT,content TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS group_key_index  ON schedules(group_key);");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS channel_key_index  ON schedules(channel_key);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    public final SQLiteDatabase t(Context context) {
        try {
            return super.getReadableDatabase();
        } catch (Exception e10) {
            ae.b.e().h("SQLiteSchedulesDB", "SHARED_PREFERENCES_NOT_AVAILABLE", "Readable database could not be delivered: " + e10.getMessage(), "initialization.SQLiteSchedulesDB");
            return null;
        }
    }

    public Map<Integer, String> v(Context context, Integer num) {
        synchronized (f19111a) {
            HashMap map = new HashMap();
            SQLiteDatabase sQLiteDatabaseT = t(context);
            if (sQLiteDatabaseT == null) {
                if (sQLiteDatabaseT != null) {
                    sQLiteDatabaseT.close();
                }
                return map;
            }
            try {
                Cursor cursorRawQuery = sQLiteDatabaseT.rawQuery("SELECT id, content FROM schedules WHERE id = ?", new String[]{String.valueOf(num)});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            map.put(Integer.valueOf(cursorRawQuery.getInt(0)), cursorRawQuery.getString(1));
                        } while (cursorRawQuery.moveToNext());
                    }
                    cursorRawQuery.close();
                    sQLiteDatabaseT.close();
                    return map;
                } catch (Throwable th) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    sQLiteDatabaseT.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    public Map<Integer, String> z(Context context, String str) {
        synchronized (f19111a) {
            HashMap map = new HashMap();
            SQLiteDatabase sQLiteDatabaseT = t(context);
            if (sQLiteDatabaseT == null) {
                if (sQLiteDatabaseT != null) {
                    sQLiteDatabaseT.close();
                }
                return map;
            }
            try {
                Cursor cursorRawQuery = sQLiteDatabaseT.rawQuery("SELECT id, content FROM schedules WHERE channel_key = ?", new String[]{str});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            map.put(Integer.valueOf(cursorRawQuery.getInt(0)), cursorRawQuery.getString(1));
                        } while (cursorRawQuery.moveToNext());
                    }
                    cursorRawQuery.close();
                    sQLiteDatabaseT.close();
                    return map;
                } catch (Throwable th) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    sQLiteDatabaseT.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }
}
