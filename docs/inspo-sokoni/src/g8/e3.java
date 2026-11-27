package g8;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e3 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f8713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f8714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k4 f8715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r1 f8716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k3 f8717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m2 f8718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SQLiteTransactionListener f8719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SQLiteDatabase f8720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8721k;

    public class a implements SQLiteTransactionListener {
        public a() {
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onBegin() {
            e3.this.f8718h.f();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onCommit() {
            e3.this.f8718h.d();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onRollback() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e3 f8723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f8725c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Object> f8726d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8727e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Iterator<Object> f8728f;

        public b(e3 e3Var, String str, List<Object> list, String str2) {
            this.f8727e = 0;
            this.f8723a = e3Var;
            this.f8724b = str;
            this.f8726d = Collections.emptyList();
            this.f8725c = str2;
            this.f8728f = list.iterator();
        }

        public b(e3 e3Var, String str, List<Object> list, List<Object> list2, String str2) {
            this.f8727e = 0;
            this.f8723a = e3Var;
            this.f8724b = str;
            this.f8726d = list;
            this.f8725c = str2;
            this.f8728f = list2.iterator();
        }

        public void a() {
            this.f8727e++;
            Object[] objArrB = b();
            this.f8723a.w(this.f8724b + ((Object) l8.g0.A("?", objArrB.length, ", ")) + this.f8725c, objArrB);
        }

        public final Object[] b() {
            ArrayList arrayList = new ArrayList(this.f8726d);
            for (int i10 = 0; this.f8728f.hasNext() && i10 < 900 - this.f8726d.size(); i10++) {
                arrayList.add(this.f8728f.next());
            }
            return arrayList.toArray();
        }

        public int c() {
            return this.f8727e;
        }

        public boolean d() {
            return this.f8728f.hasNext();
        }

        public d e() {
            this.f8727e++;
            Object[] objArrB = b();
            return this.f8723a.F(this.f8724b + ((Object) l8.g0.A("?", objArrB.length, ", ")) + this.f8725c).b(objArrB);
        }
    }

    public static class c extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f8729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8730b;

        public c(Context context, p pVar, String str) {
            this(context, pVar, str, 17);
        }

        public c(Context context, p pVar, String str, int i10) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
            this.f8729a = pVar;
        }

        public /* synthetic */ c(Context context, p pVar, String str, a aVar) {
            this(context, pVar, str);
        }

        public final void d(SQLiteDatabase sQLiteDatabase) {
            if (this.f8730b) {
                return;
            }
            onConfigure(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f8730b = true;
            sQLiteDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            d(sQLiteDatabase);
            new e4(sQLiteDatabase, this.f8729a).m0(0);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            d(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            d(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            d(sQLiteDatabase);
            new e4(sQLiteDatabase, this.f8729a).m0(i10);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SQLiteDatabase f8731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SQLiteDatabase.CursorFactory f8733c;

        public d(SQLiteDatabase sQLiteDatabase, String str) {
            this.f8731a = sQLiteDatabase;
            this.f8732b = str;
        }

        public static /* synthetic */ Cursor g(Object[] objArr, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            e3.s(sQLiteQuery, objArr);
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public d b(final Object... objArr) {
            this.f8733c = new SQLiteDatabase.CursorFactory() { // from class: g8.f3
                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    return e3.d.g(objArr, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                }
            };
            return this;
        }

        public int c(l8.n<Cursor> nVar) {
            Cursor cursorH = h();
            try {
                if (!cursorH.moveToFirst()) {
                    cursorH.close();
                    return 0;
                }
                nVar.accept(cursorH);
                cursorH.close();
                return 1;
            } catch (Throwable th) {
                if (cursorH != null) {
                    try {
                        cursorH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public <T> T d(l8.t<Cursor, T> tVar) {
            Cursor cursorH = h();
            try {
                if (!cursorH.moveToFirst()) {
                    cursorH.close();
                    return null;
                }
                T tApply = tVar.apply(cursorH);
                cursorH.close();
                return tApply;
            } catch (Throwable th) {
                if (cursorH != null) {
                    try {
                        cursorH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public int e(l8.n<Cursor> nVar) {
            Cursor cursorH = h();
            int i10 = 0;
            while (cursorH.moveToNext()) {
                try {
                    i10++;
                    nVar.accept(cursorH);
                } catch (Throwable th) {
                    if (cursorH != null) {
                        try {
                            cursorH.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            cursorH.close();
            return i10;
        }

        public boolean f() {
            Cursor cursorH = h();
            try {
                boolean z10 = !cursorH.moveToFirst();
                cursorH.close();
                return z10;
            } catch (Throwable th) {
                if (cursorH != null) {
                    try {
                        cursorH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public final Cursor h() {
            SQLiteDatabase.CursorFactory cursorFactory = this.f8733c;
            return cursorFactory != null ? this.f8731a.rawQueryWithFactory(cursorFactory, this.f8732b, null, null) : this.f8731a.rawQuery(this.f8732b, null);
        }
    }

    public e3(Context context, String str, h8.f fVar, p pVar, q0.b bVar) {
        this(pVar, bVar, new c(context, pVar, u(str, fVar), (a) null));
    }

    public e3(p pVar, q0.b bVar, c cVar) {
        this.f8719i = new a();
        this.f8713c = cVar;
        this.f8714d = pVar;
        this.f8715e = new k4(this, pVar);
        this.f8716f = new r1(this, pVar);
        this.f8717g = new k3(this, pVar);
        this.f8718h = new m2(this, bVar);
    }

    public static /* synthetic */ Long C(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    public static /* synthetic */ Long D(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    public static void s(SQLiteProgram sQLiteProgram, Object[] objArr) {
        int i10;
        long jLongValue;
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Object obj = objArr[i11];
            if (obj == null) {
                sQLiteProgram.bindNull(i11 + 1);
            } else if (obj instanceof String) {
                sQLiteProgram.bindString(i11 + 1, (String) obj);
            } else {
                if (obj instanceof Integer) {
                    i10 = i11 + 1;
                    jLongValue = ((Integer) obj).intValue();
                } else if (obj instanceof Long) {
                    i10 = i11 + 1;
                    jLongValue = ((Long) obj).longValue();
                } else if (obj instanceof Double) {
                    sQLiteProgram.bindDouble(i11 + 1, ((Double) obj).doubleValue());
                } else {
                    if (!(obj instanceof byte[])) {
                        throw l8.b.a("Unknown argument %s of type %s", obj, obj.getClass());
                    }
                    sQLiteProgram.bindBlob(i11 + 1, (byte[]) obj);
                }
                sQLiteProgram.bindLong(i10, jLongValue);
            }
        }
    }

    public static void t(Context context, h8.f fVar, String str) throws com.google.firebase.firestore.f {
        String path = context.getDatabasePath(u(str, fVar)).getPath();
        String str2 = path + "-wal";
        File file = new File(path);
        File file2 = new File(path + "-journal");
        File file3 = new File(str2);
        try {
            l8.s.a(file);
            l8.s.a(file2);
            l8.s.a(file3);
        } catch (IOException e10) {
            throw new com.google.firebase.firestore.f("Failed to clear persistence." + e10, com.google.firebase.firestore.f.a.UNKNOWN);
        }
    }

    public static String u(String str, h8.f fVar) {
        try {
            return "firestore." + URLEncoder.encode(str, "utf-8") + "." + URLEncoder.encode(fVar.l(), "utf-8") + "." + URLEncoder.encode(fVar.k(), "utf-8");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // g8.h1
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public m2 g() {
        return this.f8718h;
    }

    @Override // g8.h1
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public k4 i() {
        return this.f8715e;
    }

    public SQLiteStatement E(String str) {
        return this.f8720j.compileStatement(str);
    }

    public d F(String str) {
        return new d(this.f8720j, str);
    }

    @Override // g8.h1
    public g8.a a() {
        return this.f8716f;
    }

    @Override // g8.h1
    public g8.b b(c8.j jVar) {
        return new y1(this, this.f8714d, jVar);
    }

    @Override // g8.h1
    public g c() {
        return new z1(this);
    }

    @Override // g8.h1
    public m d(c8.j jVar) {
        return new i2(this, this.f8714d, jVar);
    }

    @Override // g8.h1
    public e1 e(c8.j jVar, m mVar) {
        return new x2(this, this.f8714d, jVar, mVar);
    }

    @Override // g8.h1
    public f1 f() {
        return new b3(this);
    }

    @Override // g8.h1
    public o1 h() {
        return this.f8717g;
    }

    @Override // g8.h1
    public boolean j() {
        return this.f8721k;
    }

    @Override // g8.h1
    public <T> T k(String str, l8.y<T> yVar) {
        l8.v.a(h1.f8756a, "Starting transaction: %s", str);
        this.f8720j.beginTransactionWithListener(this.f8719i);
        try {
            T t10 = yVar.get();
            this.f8720j.setTransactionSuccessful();
            return t10;
        } finally {
            this.f8720j.endTransaction();
        }
    }

    @Override // g8.h1
    public void l(String str, Runnable runnable) {
        l8.v.a(h1.f8756a, "Starting transaction: %s", str);
        this.f8720j.beginTransactionWithListener(this.f8719i);
        try {
            runnable.run();
            this.f8720j.setTransactionSuccessful();
        } finally {
            this.f8720j.endTransaction();
        }
    }

    @Override // g8.h1
    public void m() {
        l8.b.d(this.f8721k, "SQLitePersistence shutdown without start!", new Object[0]);
        this.f8721k = false;
        this.f8720j.close();
        this.f8720j = null;
    }

    @Override // g8.h1
    public void n() {
        l8.b.d(!this.f8721k, "SQLitePersistence double-started!", new Object[0]);
        this.f8721k = true;
        try {
            this.f8720j = this.f8713c.getWritableDatabase();
            this.f8715e.B();
            this.f8718h.z(this.f8715e.r());
        } catch (SQLiteDatabaseLockedException e10) {
            throw new RuntimeException("Failed to gain exclusive lock to the Cloud Firestore client's offline persistence. This generally means you are using Cloud Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Cloud Firestore in your Application class. If you are intentionally using Cloud Firestore from multiple processes, you can only enable offline persistence (that is, call setPersistenceEnabled(true)) in one of them.", e10);
        }
    }

    public int v(SQLiteStatement sQLiteStatement, Object... objArr) {
        sQLiteStatement.clearBindings();
        s(sQLiteStatement, objArr);
        return sQLiteStatement.executeUpdateDelete();
    }

    public void w(String str, Object... objArr) {
        this.f8720j.execSQL(str, objArr);
    }

    public long x() {
        return y() * z();
    }

    public final long y() {
        return ((Long) F("PRAGMA page_count").d(new l8.t() { // from class: g8.d3
            @Override // l8.t
            public final Object apply(Object obj) {
                return e3.C((Cursor) obj);
            }
        })).longValue();
    }

    public final long z() {
        return ((Long) F("PRAGMA page_size").d(new l8.t() { // from class: g8.c3
            @Override // l8.t
            public final Object apply(Object obj) {
                return e3.D((Cursor) obj);
            }
        })).longValue();
    }
}
