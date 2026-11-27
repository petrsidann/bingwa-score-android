package xd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f19109a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f19110b;

    public interface a<T> {
        T a(Cursor cursor, int i10);
    }

    public interface b<T> {
        T a(Cursor cursor, int i10);
    }

    public f(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static f C(Context context) {
        if (f19110b == null) {
            try {
                f19110b = new f(context, "AwesomePrimitivesDB.db");
            } catch (Exception e10) {
                ae.b.e().h("SQLitePrimitivesDB", "SHARED_PREFERENCES_NOT_AVAILABLE", "SQLitePrimitivesDB could not be correctly initialized: " + e10.getMessage(), "initialization.SQLitePrimitivesDB");
            }
        }
        return f19110b;
    }

    public static /* synthetic */ Boolean L(Cursor cursor, int i10) {
        return Boolean.valueOf(cursor.getInt(i10) == 1);
    }

    public boolean B(Context context, String str, String str2, boolean z10) {
        boolean zBooleanValue;
        synchronized (f19109a) {
            zBooleanValue = ((Boolean) G(context, "boolean_prefs", str, str2, Boolean.valueOf(z10), new b() { // from class: xd.d
                @Override // xd.f.b
                public final Object a(Cursor cursor, int i10) {
                    return f.L(cursor, i10);
                }
            })).booleanValue();
        }
        return zBooleanValue;
    }

    public long D(Context context, String str, String str2, long j10) {
        long jLongValue;
        synchronized (f19109a) {
            jLongValue = ((Long) G(context, "long_prefs", str, str2, Long.valueOf(j10), new b() { // from class: xd.c
                @Override // xd.f.b
                public final Object a(Cursor cursor, int i10) {
                    return Long.valueOf(cursor.getLong(i10));
                }
            })).longValue();
        }
        return jLongValue;
    }

    public final SQLiteDatabase E(Context context) {
        try {
            return super.getReadableDatabase();
        } catch (Exception e10) {
            ae.b.e().h("SQLitePrimitivesDB", "SHARED_PREFERENCES_NOT_AVAILABLE", "Could not delivery readable database: " + e10.getMessage(), "initialization.SQLitePrimitivesDB");
            return null;
        }
    }

    public final <T> T G(Context context, String str, String str2, String str3, T t10, b<T> bVar) {
        String str4 = "SELECT value FROM " + str + " WHERE tag = ? AND key = ?";
        SQLiteDatabase sQLiteDatabaseE = E(context);
        if (sQLiteDatabaseE == null) {
            if (sQLiteDatabaseE != null) {
                sQLiteDatabaseE.close();
            }
            return t10;
        }
        try {
            Cursor cursorRawQuery = sQLiteDatabaseE.rawQuery(str4, new String[]{str2, str3});
            try {
                if (cursorRawQuery.moveToNext()) {
                    t10 = bVar.a(cursorRawQuery, 0);
                }
                cursorRawQuery.close();
                sQLiteDatabaseE.close();
                return t10;
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
                sQLiteDatabaseE.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public String I(Context context, String str, String str2, String str3) {
        String str4;
        synchronized (f19109a) {
            str4 = (String) G(context, "string_prefs", str, str2, str3, new b() { // from class: xd.b
                @Override // xd.f.b
                public final Object a(Cursor cursor, int i10) {
                    return cursor.getString(i10);
                }
            });
        }
        return str4;
    }

    public final SQLiteDatabase J(Context context) {
        try {
            return super.getWritableDatabase();
        } catch (Exception e10) {
            ae.b.e().h("SQLitePrimitivesDB", "SHARED_PREFERENCES_NOT_AVAILABLE", "Could not delivery writable database: " + e10.getMessage(), "initialization.SQLitePrimitivesDB");
            return null;
        }
    }

    public final boolean O(Context context, String str, String str2, String str3) {
        SQLiteDatabase sQLiteDatabaseJ = J(context);
        if (sQLiteDatabaseJ == null) {
            if (sQLiteDatabaseJ != null) {
                sQLiteDatabaseJ.close();
            }
            return false;
        }
        try {
            sQLiteDatabaseJ.delete(str, "tag = ? AND key = ?", new String[]{str2, str3});
            sQLiteDatabaseJ.close();
            return true;
        } catch (Throwable th) {
            try {
                sQLiteDatabaseJ.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean Q(Context context, String str, String str2) {
        SQLiteDatabase sQLiteDatabaseJ = J(context);
        if (sQLiteDatabaseJ == null) {
            if (sQLiteDatabaseJ != null) {
                sQLiteDatabaseJ.close();
            }
            return false;
        }
        try {
            sQLiteDatabaseJ.delete(str, "tag = ?", new String[]{str2});
            sQLiteDatabaseJ.close();
            return true;
        } catch (Throwable th) {
            try {
                sQLiteDatabaseJ.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void c0(Context context, String str) {
        synchronized (f19109a) {
            Q(context, "string_prefs", str);
        }
    }

    public void d0(Context context, String str, String str2) {
        synchronized (f19109a) {
            O(context, "int_prefs", str, str2);
        }
    }

    public void e(Context context) {
    }

    public void e0(Context context, String str, String str2) {
        synchronized (f19109a) {
            O(context, "string_prefs", str, str2);
        }
    }

    public boolean f0(Context context, String str, String str2, boolean z10) {
        synchronized (f19109a) {
            SQLiteDatabase sQLiteDatabaseJ = J(context);
            if (sQLiteDatabaseJ == null) {
                if (sQLiteDatabaseJ != null) {
                    sQLiteDatabaseJ.close();
                }
                return false;
            }
            try {
                sQLiteDatabaseJ.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("tag", str);
                contentValues.put("key", str2);
                contentValues.put("value", Integer.valueOf(z10 ? 1 : 0));
                sQLiteDatabaseJ.insertWithOnConflict("boolean_prefs", null, contentValues, 5);
                sQLiteDatabaseJ.setTransactionSuccessful();
                sQLiteDatabaseJ.endTransaction();
                sQLiteDatabaseJ.close();
                return true;
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseJ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public boolean g0(Context context, String str, String str2, int i10) {
        synchronized (f19109a) {
            SQLiteDatabase sQLiteDatabaseJ = J(context);
            if (sQLiteDatabaseJ == null) {
                if (sQLiteDatabaseJ != null) {
                    sQLiteDatabaseJ.close();
                }
                return false;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("tag", str);
                contentValues.put("key", str2);
                contentValues.put("value", Integer.valueOf(i10));
                sQLiteDatabaseJ.insertWithOnConflict("int_prefs", null, contentValues, 5);
                sQLiteDatabaseJ.setTransactionSuccessful();
                sQLiteDatabaseJ.endTransaction();
                sQLiteDatabaseJ.close();
                return true;
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseJ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public boolean h0(Context context, String str, String str2, long j10) {
        synchronized (f19109a) {
            SQLiteDatabase sQLiteDatabaseJ = J(context);
            if (sQLiteDatabaseJ == null) {
                if (sQLiteDatabaseJ != null) {
                    sQLiteDatabaseJ.close();
                }
                return false;
            }
            try {
                sQLiteDatabaseJ.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("tag", str);
                contentValues.put("key", str2);
                contentValues.put("value", Long.valueOf(j10));
                sQLiteDatabaseJ.insertWithOnConflict("long_prefs", null, contentValues, 5);
                sQLiteDatabaseJ.setTransactionSuccessful();
                sQLiteDatabaseJ.endTransaction();
                sQLiteDatabaseJ.close();
                return true;
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseJ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public boolean i0(Context context, String str, String str2, String str3) {
        synchronized (f19109a) {
            SQLiteDatabase sQLiteDatabaseJ = J(context);
            if (sQLiteDatabaseJ == null) {
                if (sQLiteDatabaseJ != null) {
                    sQLiteDatabaseJ.close();
                }
                return false;
            }
            try {
                sQLiteDatabaseJ.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("tag", str);
                contentValues.put("key", str2);
                contentValues.put("value", str3);
                sQLiteDatabaseJ.insertWithOnConflict("string_prefs", null, contentValues, 5);
                sQLiteDatabaseJ.setTransactionSuccessful();
                sQLiteDatabaseJ.endTransaction();
                sQLiteDatabaseJ.close();
                return true;
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseJ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public int j0(Context context, String str) {
        int iK;
        synchronized (f19109a) {
            iK = k(context, str, "string_prefs");
        }
        return iK;
    }

    public final int k(Context context, String str, String str2) {
        String str3 = "SELECT count(*) FROM " + str2 + " WHERE tag = ?";
        SQLiteDatabase sQLiteDatabaseE = E(context);
        if (sQLiteDatabaseE == null) {
            if (sQLiteDatabaseE != null) {
                sQLiteDatabaseE.close();
            }
            return 0;
        }
        try {
            Cursor cursorRawQuery = sQLiteDatabaseE.rawQuery(str3, new String[]{str});
            try {
                int i10 = cursorRawQuery.moveToNext() ? cursorRawQuery.getInt(0) : 0;
                cursorRawQuery.close();
                sQLiteDatabaseE.close();
                return i10;
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
                sQLiteDatabaseE.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS string_prefs(tag TEXT, key TEXT, value TEXT,  PRIMARY KEY (tag, key));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS int_prefs(tag TEXT, key TEXT, value INTEGER,  PRIMARY KEY (tag, key));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS float_prefs(tag TEXT, key TEXT, value REAL,  PRIMARY KEY (tag, key));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS boolean_prefs(tag TEXT, key TEXT, value INTEGER,  PRIMARY KEY (tag, key));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS long_prefs(tag TEXT, key TEXT, value LONG,  PRIMARY KEY (tag, key));");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    public final <T> Map<String, T> t(Context context, String str, String str2, a<T> aVar) {
        HashMap map = new HashMap();
        String str3 = "SELECT key, value FROM " + str2 + " WHERE tag = ?";
        SQLiteDatabase sQLiteDatabaseE = E(context);
        if (sQLiteDatabaseE == null) {
            if (sQLiteDatabaseE != null) {
                sQLiteDatabaseE.close();
            }
            return map;
        }
        try {
            Cursor cursorRawQuery = sQLiteDatabaseE.rawQuery(str3, new String[]{str});
            try {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        map.put(cursorRawQuery.getString(0), aVar.a(cursorRawQuery, 1));
                    } while (cursorRawQuery.moveToNext());
                }
                cursorRawQuery.close();
                sQLiteDatabaseE.close();
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
                sQLiteDatabaseE.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public Map<String, Integer> v(Context context, String str) {
        Map<String, Integer> mapT;
        synchronized (f19109a) {
            mapT = t(context, str, "int_prefs", new a() { // from class: xd.e
                @Override // xd.f.a
                public final Object a(Cursor cursor, int i10) {
                    return Integer.valueOf(cursor.getInt(i10));
                }
            });
        }
        return mapT;
    }

    public Map<String, String> z(Context context, String str) {
        Map<String, String> mapT;
        synchronized (f19109a) {
            mapT = t(context, str, "string_prefs", new a() { // from class: xd.a
                @Override // xd.f.a
                public final Object a(Cursor cursor, int i10) {
                    return cursor.getString(i10);
                }
            });
        }
        return mapT;
    }
}
