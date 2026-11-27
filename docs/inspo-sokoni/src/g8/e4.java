package g8;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f8734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f8735b;

    public e4(SQLiteDatabase sQLiteDatabase, p pVar) {
        this.f8734a = sQLiteDatabase;
        this.f8735b = pVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        this.f8734a.execSQL("CREATE TABLE bundles (bundle_id TEXT PRIMARY KEY, create_time_seconds INTEGER, create_time_nanos INTEGER, schema_version INTEGER, total_documents INTEGER, total_bytes INTEGER)");
        this.f8734a.execSQL("CREATE TABLE named_queries (name TEXT PRIMARY KEY, read_time_seconds INTEGER, read_time_nanos INTEGER, bundled_query_proto BLOB)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        this.f8734a.execSQL("CREATE TABLE data_migrations (migration_name TEXT, PRIMARY KEY (migration_name))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        this.f8734a.execSQL("CREATE TABLE index_configuration (index_id INTEGER, collection_group TEXT, index_proto BLOB, PRIMARY KEY (index_id))");
        this.f8734a.execSQL("CREATE TABLE index_state (index_id INTEGER, uid TEXT, sequence_number INTEGER, read_time_seconds INTEGER, read_time_nanos INTEGER, document_key TEXT, largest_batch_id INTEGER, PRIMARY KEY (index_id, uid))");
        this.f8734a.execSQL("CREATE TABLE index_entries (index_id INTEGER, uid TEXT, array_value BLOB, directional_value BLOB, document_key TEXT, PRIMARY KEY (index_id, uid, array_value, directional_value, document_key))");
        this.f8734a.execSQL("CREATE INDEX read_time ON remote_documents(read_time_seconds, read_time_nanos)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        this.f8734a.execSQL("CREATE TABLE globals (name TEXT PRIMARY KEY, value BLOB)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.f8734a.execSQL("CREATE TABLE document_overlays (uid TEXT, collection_path TEXT, document_id TEXT, collection_group TEXT, largest_batch_id INTEGER, overlay_mutation BLOB, PRIMARY KEY (uid, collection_path, document_id))");
        this.f8734a.execSQL("CREATE INDEX batch_id_overlay ON document_overlays (uid, largest_batch_id)");
        this.f8734a.execSQL("CREATE INDEX collection_group_overlay ON document_overlays (uid, collection_group)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        this.f8734a.execSQL("CREATE TABLE mutation_queues (uid TEXT PRIMARY KEY, last_acknowledged_batch_id INTEGER, last_stream_token BLOB)");
        this.f8734a.execSQL("CREATE TABLE mutations (uid TEXT, batch_id INTEGER, mutations BLOB, PRIMARY KEY (uid, batch_id))");
        this.f8734a.execSQL("CREATE TABLE document_mutations (uid TEXT, path TEXT, batch_id INTEGER, PRIMARY KEY (uid, path, batch_id))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        this.f8734a.execSQL("CREATE TABLE remote_documents (path TEXT PRIMARY KEY, contents BLOB)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        this.f8734a.execSQL("CREATE TABLE targets (target_id INTEGER PRIMARY KEY, canonical_id TEXT, snapshot_version_seconds INTEGER, snapshot_version_nanos INTEGER, resume_token BLOB, last_listen_sequence_number INTEGER,target_proto BLOB)");
        this.f8734a.execSQL("CREATE INDEX query_targets ON targets (canonical_id, target_id)");
        this.f8734a.execSQL("CREATE TABLE target_globals (highest_target_id INTEGER, highest_listen_sequence_number INTEGER, last_remote_snapshot_version_seconds INTEGER, last_remote_snapshot_version_nanos INTEGER)");
        this.f8734a.execSQL("CREATE TABLE target_documents (target_id INTEGER, path TEXT, PRIMARY KEY (target_id, path))");
        this.f8734a.execSQL("CREATE INDEX document_targets ON target_documents (path, target_id)");
    }

    public static /* synthetic */ void Y(w0.a aVar, SQLiteStatement sQLiteStatement, h8.t tVar) {
        if (aVar.a(tVar)) {
            String strP = tVar.p();
            h8.t tVarW = tVar.w();
            sQLiteStatement.clearBindings();
            sQLiteStatement.bindString(1, strP);
            sQLiteStatement.bindString(2, f.c(tVarW));
            sQLiteStatement.execute();
        }
    }

    public static /* synthetic */ void Z(l8.n nVar, Cursor cursor) {
        nVar.accept(f.b(cursor.getString(0)).w());
    }

    public static /* synthetic */ void a0(l8.n nVar, Cursor cursor) {
        nVar.accept(f.b(cursor.getString(0)).w());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        this.f8734a.execSQL("CREATE TABLE collection_parents (collection_id TEXT, parent TEXT, PRIMARY KEY(collection_id, parent))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Cursor cursor) {
        int i10 = cursor.getInt(0);
        try {
            this.f8734a.execSQL("UPDATE targets SET target_proto = ? WHERE target_id = ?", new Object[]{j8.c.w0(cursor.getBlob(1)).b().E().build().i(), Integer.valueOf(i10)});
        } catch (com.google.protobuf.e0 unused) {
            throw l8.b.a("Failed to decode Query data for target %s", Integer.valueOf(i10));
        }
    }

    public static /* synthetic */ void d0(boolean[] zArr, SQLiteStatement sQLiteStatement, Cursor cursor) {
        zArr[0] = true;
        String string = cursor.getString(0);
        h8.t tVarB = f.b(string);
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, tVarB.u());
        sQLiteStatement.bindString(2, string);
        l8.b.d(sQLiteStatement.executeUpdateDelete() != -1, "Failed to update document path", new Object[0]);
    }

    public static /* synthetic */ Long e0(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    public static /* synthetic */ void f0(boolean[] zArr, SQLiteStatement sQLiteStatement, long j10, Cursor cursor) {
        zArr[0] = true;
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindString(1, cursor.getString(0));
        sQLiteStatement.bindLong(2, j10);
        l8.b.d(sQLiteStatement.executeInsert() != -1, "Failed to insert a sentinel row", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(String str, Cursor cursor) {
        k0(str, cursor.getInt(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(Cursor cursor) {
        final String string = cursor.getString(0);
        new e3.d(this.f8734a, "SELECT batch_id FROM mutations WHERE uid = ? AND batch_id <= ?").b(string, Long.valueOf(cursor.getLong(1))).e(new l8.n() { // from class: g8.u3
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8967a.g0(string, (Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Cursor cursor) {
        int i10 = cursor.getInt(0);
        try {
            this.f8734a.execSQL("UPDATE targets SET canonical_id  = ? WHERE target_id = ?", new Object[]{this.f8735b.h(j8.c.w0(cursor.getBlob(1))).g().c(), Integer.valueOf(i10)});
        } catch (com.google.protobuf.e0 unused) {
            throw l8.b.a("Failed to decode Query data for target %s", Integer.valueOf(i10));
        }
    }

    public final void A() {
        P(new String[]{"index_configuration", "index_state", "index_entries"}, new Runnable() { // from class: g8.y3
            @Override // java.lang.Runnable
            public final void run() {
                this.f9018a.S();
            }
        });
    }

    public final void B() {
        P(new String[]{"globals"}, new Runnable() { // from class: g8.b4
            @Override // java.lang.Runnable
            public final void run() {
                this.f8684a.T();
            }
        });
    }

    public final void C() {
        P(new String[]{"document_overlays"}, new Runnable() { // from class: g8.x3
            @Override // java.lang.Runnable
            public final void run() {
                this.f9005a.U();
            }
        });
    }

    public final void D() {
        P(new String[]{"mutation_queues", "mutations", "document_mutations"}, new Runnable() { // from class: g8.o3
            @Override // java.lang.Runnable
            public final void run() {
                this.f8897a.V();
            }
        });
    }

    public final void E() {
        P(new String[]{"remote_documents"}, new Runnable() { // from class: g8.z3
            @Override // java.lang.Runnable
            public final void run() {
                this.f9029a.W();
            }
        });
    }

    public final void F() {
        P(new String[]{"targets", "target_globals", "target_documents"}, new Runnable() { // from class: g8.l3
            @Override // java.lang.Runnable
            public final void run() {
                this.f8865a.X();
            }
        });
    }

    public final void G() {
        P(new String[]{"collection_parents"}, new Runnable() { // from class: g8.p3
            @Override // java.lang.Runnable
            public final void run() {
                this.f8905a.b0();
            }
        });
        final w0.a aVar = new w0.a();
        final SQLiteStatement sQLiteStatementCompileStatement = this.f8734a.compileStatement("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)");
        final l8.n nVar = new l8.n() { // from class: g8.q3
            @Override // l8.n
            public final void accept(Object obj) {
                e4.Y(aVar, sQLiteStatementCompileStatement, (h8.t) obj);
            }
        };
        new e3.d(this.f8734a, "SELECT path FROM remote_documents").e(new l8.n() { // from class: g8.r3
            @Override // l8.n
            public final void accept(Object obj) {
                e4.Z(nVar, (Cursor) obj);
            }
        });
        new e3.d(this.f8734a, "SELECT path FROM document_mutations").e(new l8.n() { // from class: g8.s3
            @Override // l8.n
            public final void accept(Object obj) {
                e4.a0(nVar, (Cursor) obj);
            }
        });
    }

    public final void H() {
        new e3.d(this.f8734a, "SELECT target_id, target_proto FROM targets").e(new l8.n() { // from class: g8.d4
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8706a.c0((Cursor) obj);
            }
        });
    }

    public final void I() {
        if (p0("targets")) {
            this.f8734a.execSQL("DROP TABLE targets");
        }
        if (p0("target_globals")) {
            this.f8734a.execSQL("DROP TABLE target_globals");
        }
        if (p0("target_documents")) {
            this.f8734a.execSQL("DROP TABLE target_documents");
        }
    }

    public final void J() {
        e3.d dVarB = new e3.d(this.f8734a, "SELECT path FROM remote_documents WHERE path_length IS NULL LIMIT ?").b(100);
        final SQLiteStatement sQLiteStatementCompileStatement = this.f8734a.compileStatement("UPDATE remote_documents SET path_length = ? WHERE path = ?");
        final boolean[] zArr = new boolean[1];
        do {
            zArr[0] = false;
            dVarB.e(new l8.n() { // from class: g8.t3
                @Override // l8.n
                public final void accept(Object obj) {
                    e4.d0(zArr, sQLiteStatementCompileStatement, (Cursor) obj);
                }
            });
        } while (zArr[0]);
    }

    public final void K() {
        this.f8734a.execSQL("UPDATE remote_documents SET read_time_seconds = 0, read_time_nanos = 0 WHERE read_time_seconds IS NULL");
    }

    public final void L() {
        Long l10 = (Long) new e3.d(this.f8734a, "SELECT highest_listen_sequence_number FROM target_globals LIMIT 1").d(new l8.t() { // from class: g8.m3
            @Override // l8.t
            public final Object apply(Object obj) {
                return e4.e0((Cursor) obj);
            }
        });
        l8.b.d(l10 != null, "Missing highest sequence number", new Object[0]);
        final long jLongValue = l10.longValue();
        final SQLiteStatement sQLiteStatementCompileStatement = this.f8734a.compileStatement("INSERT INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)");
        e3.d dVarB = new e3.d(this.f8734a, "SELECT RD.path FROM remote_documents AS RD WHERE NOT EXISTS (SELECT TD.path FROM target_documents AS TD WHERE RD.path = TD.path AND TD.target_id = 0) LIMIT ?").b(100);
        final boolean[] zArr = new boolean[1];
        do {
            zArr[0] = false;
            dVarB.e(new l8.n() { // from class: g8.n3
                @Override // l8.n
                public final void accept(Object obj) {
                    e4.f0(zArr, sQLiteStatementCompileStatement, jLongValue, (Cursor) obj);
                }
            });
        } while (zArr[0]);
    }

    public final void M() {
        if (DatabaseUtils.queryNumEntries(this.f8734a, "target_globals") == 1) {
            return;
        }
        this.f8734a.execSQL("INSERT INTO target_globals (highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos) VALUES (?, ?, ?, ?)", new String[]{"0", "0", "0", "0"});
    }

    public List<String> N(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.f8734a.rawQuery("PRAGMA table_info(" + str + ")", null);
            int columnIndex = cursorRawQuery.getColumnIndex("name");
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(cursorRawQuery.getString(columnIndex));
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final boolean O() {
        boolean zO0 = o0("remote_documents", "read_time_seconds");
        boolean zO1 = o0("remote_documents", "read_time_nanos");
        l8.b.d(zO0 == zO1, "Table contained just one of read_time_seconds or read_time_nanos", new Object[0]);
        return zO0 && zO1;
    }

    public final void P(String[] strArr, Runnable runnable) {
        StringBuilder sb2;
        String str;
        String str2 = "[" + TextUtils.join(", ", strArr) + "]";
        boolean z10 = false;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str3 = strArr[i10];
            boolean zP0 = p0(str3);
            if (i10 == 0) {
                z10 = zP0;
            } else if (zP0 != z10) {
                String str4 = "Expected all of " + str2 + " to either exist or not, but ";
                if (z10) {
                    sb2 = new StringBuilder();
                    sb2.append(str4);
                    sb2.append(strArr[0]);
                    sb2.append(" exists and ");
                    sb2.append(str3);
                    str = " does not";
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str4);
                    sb2.append(strArr[0]);
                    sb2.append(" does not exist and ");
                    sb2.append(str3);
                    str = " does";
                }
                sb2.append(str);
                throw new IllegalStateException(sb2.toString());
            }
        }
        if (!z10) {
            runnable.run();
            return;
        }
        l8.v.a("SQLiteSchema", "Skipping migration because all of " + str2 + " already exist", new Object[0]);
    }

    public final void j0() {
        new e3.d(this.f8734a, "SELECT uid, last_acknowledged_batch_id FROM mutation_queues").e(new l8.n() { // from class: g8.a4
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8671a.h0((Cursor) obj);
            }
        });
    }

    public final void k0(String str, int i10) {
        SQLiteStatement sQLiteStatementCompileStatement = this.f8734a.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        sQLiteStatementCompileStatement.bindString(1, str);
        sQLiteStatementCompileStatement.bindLong(2, i10);
        l8.b.d(sQLiteStatementCompileStatement.executeUpdateDelete() != 0, "Mutation batch (%s, %d) did not exist", str, Integer.valueOf(i10));
        this.f8734a.execSQL("DELETE FROM document_mutations WHERE uid = ? AND batch_id = ?", new Object[]{str, Integer.valueOf(i10)});
    }

    public final void l0() {
        new e3.d(this.f8734a, "SELECT target_id, target_proto FROM targets").e(new l8.n() { // from class: g8.v3
            @Override // l8.n
            public final void accept(Object obj) {
                this.f8978a.i0((Cursor) obj);
            }
        });
    }

    public void m0(int i10) {
        n0(i10, 17);
    }

    public void n0(int i10, int i11) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i10 < 1 && i11 >= 1) {
            D();
            F();
            E();
        }
        if (i10 < 3 && i11 >= 3 && i10 != 0) {
            I();
            F();
        }
        if (i10 < 4 && i11 >= 4) {
            M();
            x();
        }
        if (i10 < 5 && i11 >= 5) {
            w();
        }
        if (i10 < 6 && i11 >= 6) {
            j0();
        }
        if (i10 < 7 && i11 >= 7) {
            L();
        }
        if (i10 < 8 && i11 >= 8) {
            G();
        }
        if (i10 < 9 && i11 >= 9) {
            if (O()) {
                H();
            } else {
                v();
            }
        }
        if (i10 == 9 && i11 >= 10) {
            H();
        }
        if (i10 < 11 && i11 >= 11) {
            l0();
        }
        if (i10 < 12 && i11 >= 12) {
            y();
        }
        if (i10 < 13 && i11 >= 13) {
            t();
            J();
        }
        if (i10 < 14 && i11 >= 14) {
            C();
            z();
            u(h1.f8757b);
        }
        if (i10 < 15 && i11 >= 15) {
            K();
        }
        if (i10 < 16 && i11 >= 16) {
            A();
        }
        if (i10 < 17 && i11 >= 17) {
            B();
        }
        l8.v.a("SQLiteSchema", "Migration from version %s to %s took %s milliseconds", Integer.valueOf(i10), Integer.valueOf(i11), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public final boolean o0(String str, String str2) {
        return N(str).indexOf(str2) != -1;
    }

    public final boolean p0(String str) {
        return !new e3.d(this.f8734a, "SELECT 1=1 FROM sqlite_master WHERE tbl_name = ?").b(str).f();
    }

    public final void t() {
        if (o0("remote_documents", "path_length")) {
            return;
        }
        this.f8734a.execSQL("ALTER TABLE remote_documents ADD COLUMN path_length INTEGER");
    }

    public final void u(String str) {
        this.f8734a.execSQL("INSERT OR IGNORE INTO data_migrations (migration_name) VALUES (?)", new String[]{str});
    }

    public final void v() {
        this.f8734a.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_seconds INTEGER");
        this.f8734a.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_nanos INTEGER");
    }

    public final void w() {
        if (o0("target_documents", "sequence_number")) {
            return;
        }
        this.f8734a.execSQL("ALTER TABLE target_documents ADD COLUMN sequence_number INTEGER");
    }

    public final void x() {
        if (!o0("target_globals", "target_count")) {
            this.f8734a.execSQL("ALTER TABLE target_globals ADD COLUMN target_count INTEGER");
        }
        long jQueryNumEntries = DatabaseUtils.queryNumEntries(this.f8734a, "targets");
        ContentValues contentValues = new ContentValues();
        contentValues.put("target_count", Long.valueOf(jQueryNumEntries));
        this.f8734a.update("target_globals", contentValues, null, null);
    }

    public final void y() {
        P(new String[]{"bundles", "named_queries"}, new Runnable() { // from class: g8.c4
            @Override // java.lang.Runnable
            public final void run() {
                this.f8694a.Q();
            }
        });
    }

    public final void z() {
        P(new String[]{"data_migrations"}, new Runnable() { // from class: g8.w3
            @Override // java.lang.Runnable
            public final void run() {
                this.f8991a.R();
            }
        });
    }
}
