package k9;

import e9.e;
import e9.s;
import e9.x;
import e9.y;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class b extends x<Time> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f11894b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f11895a;

    public class a implements y {
        @Override // e9.y
        public <T> x<T> create(e eVar, l9.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() == Time.class) {
                return new b(aVar2);
            }
            return null;
        }
    }

    public b() {
        this.f11895a = new SimpleDateFormat("hh:mm:ss a");
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    @Override // e9.x
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Time c(m9.a aVar) throws IOException {
        Time time;
        if (aVar.l0() == m9.b.NULL) {
            aVar.h0();
            return null;
        }
        String strJ0 = aVar.j0();
        try {
            synchronized (this) {
                time = new Time(this.f11895a.parse(strJ0).getTime());
            }
            return time;
        } catch (ParseException e10) {
            throw new s("Failed parsing '" + strJ0 + "' as SQL Time; at path " + aVar.G(), e10);
        }
    }

    @Override // e9.x
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(m9.c cVar, Time time) throws IOException {
        String str;
        if (time == null) {
            cVar.L();
            return;
        }
        synchronized (this) {
            str = this.f11895a.format((Date) time);
        }
        cVar.n0(str);
    }
}
