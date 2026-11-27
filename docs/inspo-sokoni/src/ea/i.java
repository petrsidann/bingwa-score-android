package ea;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Boolean f7499n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f7504e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f7507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SQLiteDatabase f7508i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f7511l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<ga.g> f7505f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, s> f7506g = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7509j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7510k = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7512m = 0;

    public class a implements DatabaseErrorHandler {
        public a() {
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        }
    }

    public i(Context context, String str, int i10, boolean z10, int i11) {
        this.f7504e = context;
        this.f7501b = str;
        this.f7500a = z10;
        this.f7502c = i10;
        this.f7503d = i11;
    }

    public static /* synthetic */ Cursor E(c0 c0Var, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        c0Var.a(sQLiteQuery);
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(ga.e eVar) {
        Boolean boolI = eVar.i();
        boolean z10 = Boolean.TRUE.equals(boolI) && eVar.g();
        if (z10) {
            int i10 = this.f7510k + 1;
            this.f7510k = i10;
            this.f7511l = Integer.valueOf(i10);
        }
        if (!v(eVar)) {
            if (z10) {
                this.f7511l = null;
            }
        } else if (z10) {
            HashMap map = new HashMap();
            map.put("transactionId", this.f7511l);
            eVar.a(map);
        } else {
            if (Boolean.FALSE.equals(boolI)) {
                this.f7511l = null;
            }
            eVar.a(null);
        }
    }

    public static boolean i(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("com.tekartik.sqflite.wal_enabled", false);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void n(String str) {
        SQLiteDatabase.deleteDatabase(new File(str));
    }

    public static boolean w(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public SQLiteDatabase A() {
        return this.f7508i;
    }

    public void B(Exception exc, ga.e eVar) {
        String message;
        Map<String, Object> mapA;
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            message = "open_failed " + this.f7501b;
            mapA = null;
        } else {
            boolean z10 = exc instanceof SQLException;
            message = exc.getMessage();
            mapA = ga.h.a(eVar);
        }
        eVar.b("sqlite_error", message, mapA);
    }

    public void C(final ga.e eVar) {
        Q(eVar, new Runnable() { // from class: ea.d
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f7491a.G(eVar);
            }
        });
    }

    public synchronized boolean D() {
        return this.f7509j > 0;
    }

    public void K() {
        if (f7499n == null) {
            Boolean boolValueOf = Boolean.valueOf(i(this.f7504e));
            f7499n = boolValueOf;
            if (boolValueOf.booleanValue() && q.c(this.f7503d)) {
                Log.d("Sqflite", y() + "[sqflite] WAL enabled");
            }
        }
        this.f7508i = SQLiteDatabase.openDatabase(this.f7501b, null, f7499n.booleanValue() ? 805306368 : 268435456);
    }

    public void L() {
        this.f7508i = SQLiteDatabase.openDatabase(this.f7501b, null, 1, new a());
    }

    public void M(final ga.e eVar) {
        Q(eVar, new Runnable() { // from class: ea.e
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f7493a.H(eVar);
            }
        });
    }

    public void N(final ga.e eVar) {
        Q(eVar, new Runnable() { // from class: ea.b
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f7466a.I(eVar);
            }
        });
    }

    public final void O() {
        while (!this.f7505f.isEmpty() && this.f7511l == null) {
            this.f7505f.get(0).a();
            this.f7505f.remove(0);
        }
    }

    public void P(final ga.e eVar) {
        Q(eVar, new Runnable() { // from class: ea.g
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f7496a.J(eVar);
            }
        });
    }

    public final void Q(ga.e eVar, Runnable runnable) {
        Integer numF = eVar.f();
        Integer num = this.f7511l;
        if (num == null) {
            runnable.run();
            return;
        }
        if (numF == null || !(numF.equals(num) || numF.intValue() == -1)) {
            this.f7505f.add(new ga.g(eVar, runnable));
            return;
        }
        runnable.run();
        if (this.f7511l != null || this.f7505f.isEmpty()) {
            return;
        }
        this.f7507h.a(this, new Runnable() { // from class: ea.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f7498a.O();
            }
        });
    }

    public void h(fb.i iVar, fb.j.d dVar) {
        ga.d dVar2 = new ga.d(iVar, dVar);
        boolean zE = dVar2.e();
        boolean zK = dVar2.k();
        List list = (List) dVar2.c("operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ga.c cVar = new ga.c((Map) it.next(), zE);
            String method = cVar.getMethod();
            method.hashCode();
            switch (method) {
                case "execute":
                    if (!o(cVar)) {
                        if (!zK) {
                            cVar.q(dVar);
                            break;
                        }
                        cVar.r(arrayList);
                        break;
                    } else {
                        cVar.s(arrayList);
                        break;
                    }
                    break;
                case "insert":
                    if (!G(cVar)) {
                        if (!zK) {
                            cVar.q(dVar);
                            break;
                        }
                        cVar.r(arrayList);
                        break;
                    } else {
                        cVar.s(arrayList);
                        break;
                    }
                    break;
                case "update":
                    if (!J(cVar)) {
                        if (!zK) {
                            cVar.q(dVar);
                            break;
                        }
                        cVar.r(arrayList);
                        break;
                    } else {
                        cVar.s(arrayList);
                        break;
                    }
                    break;
                case "query":
                    if (!H(cVar)) {
                        if (!zK) {
                            cVar.q(dVar);
                            break;
                        }
                        cVar.r(arrayList);
                        break;
                    } else {
                        cVar.s(arrayList);
                        break;
                    }
                    break;
                default:
                    dVar.b("bad_param", "Batch method '" + method + "' not supported", null);
                    break;
            }
            return;
        }
        if (zE) {
            dVar.a(null);
        } else {
            dVar.a(arrayList);
        }
    }

    public void j() {
        if (!this.f7506g.isEmpty() && q.b(this.f7503d)) {
            Log.d("Sqflite", y() + this.f7506g.size() + " cursor(s) are left opened");
        }
        this.f7508i.close();
    }

    public final void k(int i10) {
        s sVar = this.f7506g.get(Integer.valueOf(i10));
        if (sVar != null) {
            l(sVar);
        }
    }

    public final void l(s sVar) {
        try {
            int i10 = sVar.f7539a;
            if (q.c(this.f7503d)) {
                Log.d("Sqflite", y() + "closing cursor " + i10);
            }
            this.f7506g.remove(Integer.valueOf(i10));
            sVar.f7541c.close();
        } catch (Exception unused) {
        }
    }

    public final Map<String, Object> m(Cursor cursor, Integer num) {
        HashMap map = null;
        int columnCount = 0;
        ArrayList arrayList = null;
        while (cursor.moveToNext()) {
            if (map == null) {
                ArrayList arrayList2 = new ArrayList();
                HashMap map2 = new HashMap();
                columnCount = cursor.getColumnCount();
                map2.put("columns", Arrays.asList(cursor.getColumnNames()));
                map2.put("rows", arrayList2);
                arrayList = arrayList2;
                map = map2;
            }
            arrayList.add(d0.a(cursor, columnCount));
            if (num != null && arrayList.size() >= num.intValue()) {
                break;
            }
        }
        return map == null ? new HashMap() : map;
    }

    public final boolean o(ga.e eVar) {
        if (!v(eVar)) {
            return false;
        }
        eVar.a(null);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00cf  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final boolean G(ga.e eVar) throws Throwable {
        Exception e10;
        Cursor cursorRawQuery;
        if (!v(eVar)) {
            return false;
        }
        SQLiteCursor sQLiteCursor = 0;
        if (eVar.e()) {
            eVar.a(null);
            return true;
        }
        try {
            try {
                cursorRawQuery = A().rawQuery("SELECT changes(), last_insert_rowid()", null);
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                            if (cursorRawQuery.getInt(0) == 0) {
                                if (q.b(this.f7503d)) {
                                    Log.d("Sqflite", y() + "no changes (id was " + cursorRawQuery.getLong(1) + ")");
                                }
                                eVar.a(null);
                                cursorRawQuery.close();
                                return true;
                            }
                            long j10 = cursorRawQuery.getLong(1);
                            if (q.b(this.f7503d)) {
                                Log.d("Sqflite", y() + "inserted " + j10);
                            }
                            eVar.a(Long.valueOf(j10));
                            cursorRawQuery.close();
                            return true;
                        }
                    } catch (Exception e11) {
                        e10 = e11;
                        B(e10, eVar);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return false;
                    }
                }
                Log.e("Sqflite", y() + "fail to read changes for Insert");
                eVar.a(null);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return true;
            } catch (Throwable th) {
                th = th;
                sQLiteCursor = "SELECT changes(), last_insert_rowid()";
                if (sQLiteCursor != 0) {
                    sQLiteCursor.close();
                }
                throw th;
            }
        } catch (Exception e12) {
            e10 = e12;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteCursor != 0) {
                sQLiteCursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [ga.e, ga.f] */
    /* JADX WARN: Type inference failed for: r1v0, types: [ea.c0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v0, types: [ea.i] */
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final boolean H(ga.e eVar) throws Throwable {
        Integer num = (Integer) eVar.c("cursorPageSize");
        final ?? D = eVar.d();
        if (q.b(this.f7503d)) {
            Log.d("Sqflite", y() + D);
        }
        s sVar = null;
        try {
            try {
                D = x().rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: ea.f
                    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                        return i.E(D, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                    }
                }, D.c(), ea.a.f7462a, null);
                try {
                    Map<String, Object> mapM = m(D, num);
                    if ((num == null || D.isLast() || D.isAfterLast()) ? false : true) {
                        int i10 = this.f7512m + 1;
                        this.f7512m = i10;
                        mapM.put("cursorId", Integer.valueOf(i10));
                        s sVar2 = new s(i10, num.intValue(), D);
                        try {
                            this.f7506g.put(Integer.valueOf(i10), sVar2);
                            sVar = sVar2;
                        } catch (Exception e10) {
                            e = e10;
                            sVar = sVar2;
                            B(e, eVar);
                            if (sVar != null) {
                                l(sVar);
                            }
                            if (sVar == null && D != 0) {
                                D.close();
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            sVar = sVar2;
                            if (sVar == null && D != 0) {
                                D.close();
                            }
                            throw th;
                        }
                    }
                    eVar.a(mapM);
                    if (sVar == null && D != 0) {
                        D.close();
                    }
                    return true;
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e12) {
            e = e12;
            D = 0;
        } catch (Throwable th3) {
            th = th3;
            D = 0;
        }
    }

    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final boolean I(ga.e eVar) throws Throwable {
        boolean z10;
        int iIntValue = ((Integer) eVar.c("cursorId")).intValue();
        boolean zEquals = Boolean.TRUE.equals(eVar.c("cancel"));
        if (q.c(this.f7503d)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(y());
            sb2.append("cursor ");
            sb2.append(iIntValue);
            sb2.append(zEquals ? " cancel" : " next");
            Log.d("Sqflite", sb2.toString());
        }
        s sVar = null;
        if (zEquals) {
            k(iIntValue);
            eVar.a(null);
            return true;
        }
        s sVar2 = this.f7506g.get(Integer.valueOf(iIntValue));
        boolean z11 = false;
        try {
            if (sVar2 == null) {
                throw new IllegalStateException("Cursor " + iIntValue + " not found");
            }
            Cursor cursor = sVar2.f7541c;
            Map<String, Object> mapM = m(cursor, Integer.valueOf(sVar2.f7540b));
            z10 = (cursor.isLast() || cursor.isAfterLast()) ? false : true;
            if (z10) {
                try {
                    try {
                        mapM.put("cursorId", Integer.valueOf(iIntValue));
                    } catch (Exception e10) {
                        e = e10;
                        B(e, eVar);
                        if (sVar2 != null) {
                            l(sVar2);
                        } else {
                            sVar = sVar2;
                        }
                        if (!z10 && sVar != null) {
                            l(sVar);
                        }
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    z11 = z10;
                    if (!z11 && sVar2 != null) {
                        l(sVar2);
                    }
                    throw th;
                }
            }
            eVar.a(mapM);
            if (!z10) {
                l(sVar2);
            }
            return true;
        } catch (Exception e11) {
            e = e11;
            z10 = false;
        } catch (Throwable th2) {
            th = th2;
            if (!z11) {
                l(sVar2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final boolean J(ga.e eVar) throws Throwable {
        if (!v(eVar)) {
            return false;
        }
        Cursor cursor = null;
        if (eVar.e()) {
            eVar.a(null);
            return true;
        }
        try {
            try {
                Cursor cursorRawQuery = A().rawQuery("SELECT changes()", null);
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                            int i10 = cursorRawQuery.getInt(0);
                            if (q.b(this.f7503d)) {
                                Log.d("Sqflite", y() + "changed " + i10);
                            }
                            eVar.a(Integer.valueOf(i10));
                            cursorRawQuery.close();
                            return true;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        cursor = cursorRawQuery;
                        B(e, eVar);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                Log.e("Sqflite", y() + "fail to read changes for Update/Delete");
                eVar.a(null);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return true;
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void t(Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            this.f7509j++;
        } else if (Boolean.FALSE.equals(bool)) {
            this.f7509j--;
        }
    }

    public void u(final ga.e eVar) {
        Q(eVar, new Runnable() { // from class: ea.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f7487a.F(eVar);
            }
        });
    }

    public final boolean v(ga.e eVar) {
        c0 c0VarD = eVar.d();
        if (q.b(this.f7503d)) {
            Log.d("Sqflite", y() + c0VarD);
        }
        Boolean boolI = eVar.i();
        try {
            A().execSQL(c0VarD.c(), c0VarD.d());
            t(boolI);
            return true;
        } catch (Exception e10) {
            B(e10, eVar);
            return false;
        }
    }

    public SQLiteDatabase x() {
        return this.f7508i;
    }

    public String y() {
        return "[" + z() + "] ";
    }

    public String z() {
        Thread threadCurrentThread = Thread.currentThread();
        return "" + this.f7502c + "," + threadCurrentThread.getName() + "(" + threadCurrentThread.getId() + ")";
    }
}
