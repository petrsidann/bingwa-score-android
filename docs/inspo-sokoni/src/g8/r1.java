package g8;

import android.database.Cursor;

/* JADX INFO: loaded from: classes.dex */
public class r1 implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f8936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f8937b;

    public r1(e3 e3Var, p pVar) {
        this.f8936a = e3Var;
        this.f8937b = pVar;
    }

    public static /* synthetic */ d8.e g(String str, Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new d8.e(str, cursor.getInt(0), new h8.v(new h7.q(cursor.getLong(1), cursor.getInt(2))), cursor.getInt(3), cursor.getLong(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ d8.j h(String str, Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            return new d8.j(str, this.f8937b.a(c9.a.l0(cursor.getBlob(2))), new h8.v(new h7.q(cursor.getLong(0), cursor.getInt(1))));
        } catch (com.google.protobuf.e0 e10) {
            throw l8.b.a("NamedQuery failed to parse: %s", e10);
        }
    }

    @Override // g8.a
    public d8.e a(final String str) {
        return (d8.e) this.f8936a.F("SELECT schema_version, create_time_seconds, create_time_nanos, total_documents,  total_bytes FROM bundles WHERE bundle_id = ?").b(str).d(new l8.t() { // from class: g8.p1
            @Override // l8.t
            public final Object apply(Object obj) {
                return r1.g(str, (Cursor) obj);
            }
        });
    }

    @Override // g8.a
    public void b(d8.e eVar) {
        this.f8936a.w("INSERT OR REPLACE INTO bundles (bundle_id, schema_version, create_time_seconds, create_time_nanos, total_documents, total_bytes) VALUES (?, ?, ?, ?, ?, ?)", eVar.a(), Integer.valueOf(eVar.c()), Long.valueOf(eVar.b().h().k()), Integer.valueOf(eVar.b().h().h()), Integer.valueOf(eVar.e()), Long.valueOf(eVar.d()));
    }

    @Override // g8.a
    public d8.j c(final String str) {
        return (d8.j) this.f8936a.F("SELECT read_time_seconds, read_time_nanos, bundled_query_proto FROM named_queries WHERE name = ?").b(str).d(new l8.t() { // from class: g8.q1
            @Override // l8.t
            public final Object apply(Object obj) {
                return this.f8926a.h(str, (Cursor) obj);
            }
        });
    }

    @Override // g8.a
    public void d(d8.j jVar) {
        this.f8936a.w("INSERT OR REPLACE INTO named_queries (name, read_time_seconds, read_time_nanos, bundled_query_proto) VALUES (?, ?, ?, ?)", jVar.b(), Long.valueOf(jVar.c().h().k()), Integer.valueOf(jVar.c().h().h()), this.f8937b.j(jVar.a()).i());
    }
}
