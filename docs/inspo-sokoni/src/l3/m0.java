package l3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class m0 implements l3.d, m3.b, l3.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a3.c f12445f = a3.c.b("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t0 f12446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n3.a f12447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n3.a f12448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f12449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kc.a<String> f12450e;

    public interface b<T, U> {
        U apply(T t10);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f12452b;

        public c(String str, String str2) {
            this.f12451a = str;
            this.f12452b = str2;
        }
    }

    public interface d<T> {
        T a();
    }

    public m0(n3.a aVar, n3.a aVar2, e eVar, t0 t0Var, kc.a<String> aVar3) {
        this.f12446a = t0Var;
        this.f12447b = aVar;
        this.f12448c = aVar2;
        this.f12449d = eVar;
        this.f12450e = aVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object C0(Cursor cursor) {
        while (cursor.moveToNext()) {
            t(cursor.getInt(0), g3.c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer D0(long j10, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j10)};
        j1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: l3.q
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return this.f12464a.C0((Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    public static /* synthetic */ Object E0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Object F0(Throwable th) {
        throw new m3.a("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ SQLiteDatabase G0(Throwable th) {
        throw new m3.a("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Long H0(Cursor cursor) {
        return Long.valueOf(cursor.moveToNext() ? cursor.getLong(0) : 0L);
    }

    public static /* synthetic */ g3.f I0(long j10, Cursor cursor) {
        cursor.moveToNext();
        return g3.f.c().c(cursor.getLong(0)).b(j10).a();
    }

    public static /* synthetic */ g3.f J0(final long j10, SQLiteDatabase sQLiteDatabase) {
        return (g3.f) j1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: l3.d0
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.I0(j10, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ Long K0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean L0(d3.o oVar, SQLiteDatabase sQLiteDatabase) {
        Long lY0 = y0(sQLiteDatabase, oVar);
        return lY0 == null ? Boolean.FALSE : (Boolean) j1(t0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lY0.toString()}), new b() { // from class: l3.x
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    public static /* synthetic */ List M0(SQLiteDatabase sQLiteDatabase) {
        return (List) j1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: l3.j0
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.N0((Cursor) obj);
            }
        });
    }

    public static /* synthetic */ List N0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(d3.o.a().b(cursor.getString(1)).d(o3.a.b(cursor.getInt(2))).c(d1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List O0(d3.o oVar, SQLiteDatabase sQLiteDatabase) {
        List<k> listB1 = b1(sQLiteDatabase, oVar, this.f12449d.d());
        for (a3.e eVar : a3.e.values()) {
            if (eVar != oVar.d()) {
                int iD = this.f12449d.d() - listB1.size();
                if (iD <= 0) {
                    break;
                }
                listB1.addAll(b1(sQLiteDatabase, oVar.f(eVar), iD));
            }
        }
        return B0(listB1, c1(sQLiteDatabase, listB1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ g3.a P0(Map map, g3.a.C0151a c0151a, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            g3.c.b bVarP0 = p0(cursor.getInt(1));
            long j10 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(g3.c.c().c(bVarP0).b(j10).a());
        }
        e1(c0151a, map);
        c0151a.e(x0());
        c0151a.d(u0());
        c0151a.c(this.f12450e.get());
        return c0151a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ g3.a Q0(String str, final Map map, final g3.a.C0151a c0151a, SQLiteDatabase sQLiteDatabase) {
        return (g3.a) j1(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: l3.z
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return this.f12488a.P0(map, c0151a, (Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object R0(List list, d3.o oVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j10 = cursor.getLong(0);
            boolean z10 = cursor.getInt(7) != 0;
            d3.i.a aVarK = d3.i.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            aVarK.h(z10 ? new d3.h(h1(cursor.getString(4)), cursor.getBlob(5)) : new d3.h(h1(cursor.getString(4)), f1(j10)));
            if (!cursor.isNull(6)) {
                aVarK.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(k.a(j10, oVar, aVarK.d()));
        }
        return null;
    }

    public static /* synthetic */ Object S0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j10 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j10));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j10), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long T0(d3.i iVar, d3.o oVar, SQLiteDatabase sQLiteDatabase) {
        if (A0()) {
            t(1L, g3.c.b.CACHE_FULL, iVar.j());
            return -1L;
        }
        long jR0 = r0(sQLiteDatabase, oVar);
        int iE = this.f12449d.e();
        byte[] bArrA = iVar.e().a();
        boolean z10 = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jR0));
        contentValues.put("transport_name", iVar.j());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.k()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z10));
        contentValues.put("payload", z10 ? bArrA : new byte[0]);
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z10) {
            int iCeil = (int) Math.ceil(((double) bArrA.length) / ((double) iE));
            for (int i10 = 1; i10 <= iCeil; i10++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i10 - 1) * iE, Math.min(i10 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i10));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : iVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    public static /* synthetic */ byte[] U0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            byte[] bArr2 = (byte[]) arrayList.get(i10);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object V0(Cursor cursor) {
        while (cursor.moveToNext()) {
            t(cursor.getInt(0), g3.c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object W0(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        j1(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: l3.u
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return this.f12480a.V0((Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public static /* synthetic */ Boolean X0(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    public static /* synthetic */ Object Y0(String str, g3.c.b bVar, long j10, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) j1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.a())}), new b() { // from class: l3.t
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.X0((Cursor) obj);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j10 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.a())});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(bVar.a()));
            contentValues.put("events_dropped_count", Long.valueOf(j10));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    public static /* synthetic */ Object Z0(long j10, d3.o oVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j10));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(o3.a.a(oVar.d()))}) < 1) {
            contentValues.put("backend_name", oVar.b());
            contentValues.put("priority", Integer.valueOf(o3.a.a(oVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object a1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f12447b.a()).execute();
        return null;
    }

    public static byte[] d1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static a3.c h1(String str) {
        return str == null ? f12445f : a3.c.b(str);
    }

    public static String i1(Iterable<k> iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator<k> it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().c());
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static <T> T j1(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final boolean A0() {
        return v0() * w0() >= this.f12449d.f();
    }

    public final List<k> B0(List<k> list, Map<Long, Set<c>> map) {
        ListIterator<k> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            k next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                d3.i.a aVarL = next.b().l();
                for (c cVar : map.get(Long.valueOf(next.c()))) {
                    aVarL.c(cVar.f12451a, cVar.f12452b);
                }
                listIterator.set(k.a(next.c(), next.d(), aVarL.d()));
            }
        }
        return list;
    }

    @Override // l3.d
    public long R(d3.o oVar) {
        return ((Long) j1(t0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(o3.a.a(oVar.d()))}), new b() { // from class: l3.f0
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.H0((Cursor) obj);
            }
        })).longValue();
    }

    @Override // l3.d
    public void S(Iterable<k> iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + i1(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            z0(new b() { // from class: l3.p
                @Override // l3.m0.b
                public final Object apply(Object obj) {
                    return this.f12461a.W0(str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    @Override // l3.d
    public k Y(final d3.o oVar, final d3.i iVar) {
        h3.a.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", oVar.d(), iVar.j(), oVar.b());
        long jLongValue = ((Long) z0(new b() { // from class: l3.a0
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return this.f12422a.T0(iVar, oVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return k.a(jLongValue, oVar, iVar);
    }

    @Override // l3.d
    public boolean Z(final d3.o oVar) {
        return ((Boolean) z0(new b() { // from class: l3.k0
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return this.f12438a.L0(oVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    public final List<k> b1(SQLiteDatabase sQLiteDatabase, final d3.o oVar, int i10) {
        final ArrayList arrayList = new ArrayList();
        Long lY0 = y0(sQLiteDatabase, oVar);
        if (lY0 == null) {
            return arrayList;
        }
        j1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lY0.toString()}, null, null, null, String.valueOf(i10)), new b() { // from class: l3.v
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return this.f12484a.R0(arrayList, oVar, (Cursor) obj);
            }
        });
        return arrayList;
    }

    public final Map<Long, Set<c>> c1(SQLiteDatabase sQLiteDatabase, List<k> list) {
        final HashMap map = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i10 = 0; i10 < list.size(); i10++) {
            sb2.append(list.get(i10).c());
            if (i10 < list.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        j1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb2.toString(), null, null, null, null), new b() { // from class: l3.r
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.S0(map, (Cursor) obj);
            }
        });
        return map;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12446a.close();
    }

    @Override // l3.c
    public void d() {
        z0(new b() { // from class: l3.n
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return this.f12453a.a1((SQLiteDatabase) obj);
            }
        });
    }

    @Override // m3.b
    public <T> T e(m3.b.a<T> aVar) {
        SQLiteDatabase sQLiteDatabaseT0 = t0();
        q0(sQLiteDatabaseT0);
        try {
            T tA = aVar.a();
            sQLiteDatabaseT0.setTransactionSuccessful();
            return tA;
        } finally {
            sQLiteDatabaseT0.endTransaction();
        }
    }

    public final void e1(g3.a.C0151a c0151a, Map<String, List<g3.c>> map) {
        for (Map.Entry<String, List<g3.c>> entry : map.entrySet()) {
            c0151a.a(g3.d.c().c(entry.getKey()).b(entry.getValue()).a());
        }
    }

    public final byte[] f1(long j10) {
        return (byte[]) j1(t0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j10)}, null, null, "sequence_num"), new b() { // from class: l3.y
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.U0((Cursor) obj);
            }
        });
    }

    @Override // l3.d
    public int g() {
        final long jA = this.f12447b.a() - this.f12449d.c();
        return ((Integer) z0(new b() { // from class: l3.i0
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return this.f12435a.D0(jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    public final <T> T g1(d<T> dVar, b<Throwable, T> bVar) {
        long jA = this.f12448c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e10) {
                if (this.f12448c.a() >= ((long) this.f12449d.b()) + jA) {
                    return bVar.apply(e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // l3.d
    public void h(Iterable<k> iterable) {
        if (iterable.iterator().hasNext()) {
            t0().compileStatement("DELETE FROM events WHERE _id in " + i1(iterable)).execute();
        }
    }

    @Override // l3.d
    public void j(final d3.o oVar, final long j10) {
        z0(new b() { // from class: l3.m
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.Z0(j10, oVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // l3.c
    public g3.a k() {
        final g3.a.C0151a c0151aE = g3.a.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (g3.a) z0(new b() { // from class: l3.s
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return this.f12466a.Q0(str, map, c0151aE, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // l3.d
    public Iterable<k> n(final d3.o oVar) {
        return (Iterable) z0(new b() { // from class: l3.o
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return this.f12459a.O0(oVar, (SQLiteDatabase) obj);
            }
        });
    }

    public final g3.c.b p0(int i10) {
        g3.c.b bVar = g3.c.b.REASON_UNKNOWN;
        if (i10 == bVar.a()) {
            return bVar;
        }
        g3.c.b bVar2 = g3.c.b.MESSAGE_TOO_OLD;
        if (i10 == bVar2.a()) {
            return bVar2;
        }
        g3.c.b bVar3 = g3.c.b.CACHE_FULL;
        if (i10 == bVar3.a()) {
            return bVar3;
        }
        g3.c.b bVar4 = g3.c.b.PAYLOAD_TOO_BIG;
        if (i10 == bVar4.a()) {
            return bVar4;
        }
        g3.c.b bVar5 = g3.c.b.MAX_RETRIES_REACHED;
        if (i10 == bVar5.a()) {
            return bVar5;
        }
        g3.c.b bVar6 = g3.c.b.INVALID_PAYLOD;
        if (i10 == bVar6.a()) {
            return bVar6;
        }
        g3.c.b bVar7 = g3.c.b.SERVER_ERROR;
        if (i10 == bVar7.a()) {
            return bVar7;
        }
        h3.a.a("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i10));
        return bVar;
    }

    public final void q0(final SQLiteDatabase sQLiteDatabase) {
        g1(new d() { // from class: l3.g0
            @Override // l3.m0.d
            public final Object a() {
                return m0.E0(sQLiteDatabase);
            }
        }, new b() { // from class: l3.h0
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.F0((Throwable) obj);
            }
        });
    }

    @Override // l3.d
    public Iterable<d3.o> r() {
        return (Iterable) z0(new b() { // from class: l3.l
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.M0((SQLiteDatabase) obj);
            }
        });
    }

    public final long r0(SQLiteDatabase sQLiteDatabase, d3.o oVar) {
        Long lY0 = y0(sQLiteDatabase, oVar);
        if (lY0 != null) {
            return lY0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", oVar.b());
        contentValues.put("priority", Integer.valueOf(o3.a.a(oVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (oVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(oVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    public long s0() {
        return v0() * w0();
    }

    @Override // l3.c
    public void t(final long j10, final g3.c.b bVar, final String str) {
        z0(new b() { // from class: l3.l0
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.Y0(str, bVar, j10, (SQLiteDatabase) obj);
            }
        });
    }

    public SQLiteDatabase t0() {
        final t0 t0Var = this.f12446a;
        Objects.requireNonNull(t0Var);
        return (SQLiteDatabase) g1(new d() { // from class: l3.w
            @Override // l3.m0.d
            public final Object a() {
                return t0Var.getWritableDatabase();
            }
        }, new b() { // from class: l3.e0
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.G0((Throwable) obj);
            }
        });
    }

    public final g3.b u0() {
        return g3.b.b().b(g3.e.c().b(s0()).c(e.f12430a.f()).a()).a();
    }

    public final long v0() {
        return t0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    public final long w0() {
        return t0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    public final g3.f x0() {
        final long jA = this.f12447b.a();
        return (g3.f) z0(new b() { // from class: l3.c0
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.J0(jA, (SQLiteDatabase) obj);
            }
        });
    }

    public final Long y0(SQLiteDatabase sQLiteDatabase, d3.o oVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(oVar.b(), String.valueOf(o3.a.a(oVar.d()))));
        if (oVar.c() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(oVar.c(), 0));
        } else {
            sb2.append(" and extras is null");
        }
        return (Long) j1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: l3.b0
            @Override // l3.m0.b
            public final Object apply(Object obj) {
                return m0.K0((Cursor) obj);
            }
        });
    }

    public <T> T z0(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase sQLiteDatabaseT0 = t0();
        sQLiteDatabaseT0.beginTransaction();
        try {
            T tApply = bVar.apply(sQLiteDatabaseT0);
            sQLiteDatabaseT0.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseT0.endTransaction();
        }
    }
}
