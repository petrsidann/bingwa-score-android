package g8;

import android.database.Cursor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b3 implements f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f8683a;

    public b3(e3 e3Var) {
        this.f8683a = e3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        if (f()) {
            Set<String> setE = e();
            o1 o1VarH = this.f8683a.h();
            Iterator<String> it = setE.iterator();
            while (it.hasNext()) {
                c8.j jVar = new c8.j(it.next());
                e3 e3Var = this.f8683a;
                e1 e1VarE = e3Var.e(jVar, e3Var.d(jVar));
                HashSet hashSet = new HashSet();
                Iterator<i8.g> it2 = e1VarE.k().iterator();
                while (it2.hasNext()) {
                    hashSet.addAll(it2.next().f());
                }
                new o(o1VarH, e1VarE, this.f8683a.b(jVar), this.f8683a.d(jVar)).o(hashSet);
            }
            j();
        }
    }

    public static /* synthetic */ void h(Set set, Cursor cursor) {
        set.add(cursor.getString(0));
    }

    public static /* synthetic */ void i(Boolean[] boolArr, Cursor cursor) {
        try {
            if (h1.f8757b.equals(cursor.getString(0))) {
                boolArr[0] = Boolean.TRUE;
            }
        } catch (IllegalArgumentException e10) {
            throw l8.b.a("SQLitePersistence.DataMigration failed to parse: %s", e10);
        }
    }

    public final void d() {
        this.f8683a.l("build overlays", new Runnable() { // from class: g8.y2
            @Override // java.lang.Runnable
            public final void run() {
                this.f9017a.g();
            }
        });
    }

    public final Set<String> e() {
        final HashSet hashSet = new HashSet();
        this.f8683a.F("SELECT DISTINCT uid FROM mutation_queues").e(new l8.n() { // from class: g8.a3
            @Override // l8.n
            public final void accept(Object obj) {
                b3.h(hashSet, (Cursor) obj);
            }
        });
        return hashSet;
    }

    public boolean f() {
        final Boolean[] boolArr = {Boolean.FALSE};
        this.f8683a.F("SELECT migration_name FROM data_migrations").e(new l8.n() { // from class: g8.z2
            @Override // l8.n
            public final void accept(Object obj) {
                b3.i(boolArr, (Cursor) obj);
            }
        });
        return boolArr[0].booleanValue();
    }

    public final void j() {
        this.f8683a.w("DELETE FROM data_migrations WHERE migration_name = ?", h1.f8757b);
    }

    @Override // g8.f1
    public void run() {
        d();
    }
}
