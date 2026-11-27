package k9;

import e9.e;
import e9.s;
import e9.x;
import e9.y;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class a extends x<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f11892b = new C0202a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f11893a;

    /* JADX INFO: renamed from: k9.a$a, reason: collision with other inner class name */
    public class C0202a implements y {
        @Override // e9.y
        public <T> x<T> create(e eVar, l9.a<T> aVar) {
            C0202a c0202a = null;
            if (aVar.c() == Date.class) {
                return new a(c0202a);
            }
            return null;
        }
    }

    public a() {
        this.f11893a = new SimpleDateFormat("MMM d, yyyy");
    }

    public /* synthetic */ a(C0202a c0202a) {
        this();
    }

    @Override // e9.x
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date c(m9.a aVar) throws IOException {
        java.util.Date date;
        if (aVar.l0() == m9.b.NULL) {
            aVar.h0();
            return null;
        }
        String strJ0 = aVar.j0();
        try {
            synchronized (this) {
                date = this.f11893a.parse(strJ0);
            }
            return new Date(date.getTime());
        } catch (ParseException e10) {
            throw new s("Failed parsing '" + strJ0 + "' as SQL Date; at path " + aVar.G(), e10);
        }
    }

    @Override // e9.x
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(m9.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.L();
            return;
        }
        synchronized (this) {
            str = this.f11893a.format((java.util.Date) date);
        }
        cVar.n0(str);
    }
}
