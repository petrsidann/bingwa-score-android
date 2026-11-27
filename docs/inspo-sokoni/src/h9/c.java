package h9;

import e9.s;
import e9.x;
import e9.y;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class c extends x<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f9806b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<DateFormat> f9807a;

    public class a implements y {
        @Override // e9.y
        public <T> x<T> create(e9.e eVar, l9.a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f9807a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (g9.e.d()) {
            arrayList.add(g9.j.c(2, 2));
        }
    }

    public final Date f(m9.a aVar) throws IOException {
        String strJ0 = aVar.j0();
        synchronized (this.f9807a) {
            Iterator<DateFormat> it = this.f9807a.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(strJ0);
                } catch (ParseException unused) {
                }
            }
            try {
                return i9.a.c(strJ0, new ParsePosition(0));
            } catch (ParseException e10) {
                throw new s("Failed parsing '" + strJ0 + "' as Date; at path " + aVar.G(), e10);
            }
        }
    }

    @Override // e9.x
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Date c(m9.a aVar) throws IOException {
        if (aVar.l0() != m9.b.NULL) {
            return f(aVar);
        }
        aVar.h0();
        return null;
    }

    @Override // e9.x
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void e(m9.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.L();
            return;
        }
        DateFormat dateFormat = this.f9807a.get(0);
        synchronized (this.f9807a) {
            str = dateFormat.format(date);
        }
        cVar.n0(str);
    }
}
