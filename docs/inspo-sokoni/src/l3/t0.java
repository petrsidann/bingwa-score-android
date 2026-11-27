package l3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class t0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12470c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f12471d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f12472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12473f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f12474l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f12475m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f12476n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final List<a> f12477o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12479b;

    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a aVar = new a() { // from class: l3.o0
            @Override // l3.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.B(sQLiteDatabase);
            }
        };
        f12472e = aVar;
        a aVar2 = new a() { // from class: l3.p0
            @Override // l3.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.C(sQLiteDatabase);
            }
        };
        f12473f = aVar2;
        a aVar3 = new a() { // from class: l3.q0
            @Override // l3.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f12474l = aVar3;
        a aVar4 = new a() { // from class: l3.r0
            @Override // l3.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.E(sQLiteDatabase);
            }
        };
        f12475m = aVar4;
        a aVar5 = new a() { // from class: l3.s0
            @Override // l3.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.G(sQLiteDatabase);
            }
        };
        f12476n = aVar5;
        f12477o = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public t0(Context context, String str, int i10) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f12479b = false;
        this.f12478a = i10;
    }

    public static /* synthetic */ void B(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void C(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void E(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    public static /* synthetic */ void G(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f12470c);
    }

    public final void I(SQLiteDatabase sQLiteDatabase, int i10) {
        z(sQLiteDatabase);
        J(sQLiteDatabase, 0, i10);
    }

    public final void J(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        List<a> list = f12477o;
        if (i11 <= list.size()) {
            while (i10 < i11) {
                f12477o.get(i10).a(sQLiteDatabase);
                i10++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i10 + " to " + i11 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f12479b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        I(sQLiteDatabase, this.f12478a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        I(sQLiteDatabase, i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        z(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        z(sQLiteDatabase);
        J(sQLiteDatabase, i10, i11);
    }

    public final void z(SQLiteDatabase sQLiteDatabase) {
        if (this.f12479b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }
}
