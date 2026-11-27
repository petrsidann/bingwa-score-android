package k9;

import e9.e;
import e9.x;
import e9.y;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class c extends x<Timestamp> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f11896b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x<Date> f11897a;

    public class a implements y {
        @Override // e9.y
        public <T> x<T> create(e eVar, l9.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() == Timestamp.class) {
                return new c(eVar.k(Date.class), aVar2);
            }
            return null;
        }
    }

    public c(x<Date> xVar) {
        this.f11897a = xVar;
    }

    public /* synthetic */ c(x xVar, a aVar) {
        this(xVar);
    }

    @Override // e9.x
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Timestamp c(m9.a aVar) {
        Date dateC = this.f11897a.c(aVar);
        if (dateC != null) {
            return new Timestamp(dateC.getTime());
        }
        return null;
    }

    @Override // e9.x
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(m9.c cVar, Timestamp timestamp) {
        this.f11897a.e(cVar, timestamp);
    }
}
