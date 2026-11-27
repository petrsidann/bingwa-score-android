package h9;

import e9.s;
import e9.x;
import e9.y;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class d<T extends Date> extends x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f9808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<DateFormat> f9809b;

    public static abstract class b<T extends Date> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b<Date> f9810b = new a(Date.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f9811a;

        public class a extends b<Date> {
            public a(Class cls) {
                super(cls);
            }

            @Override // h9.d.b
            public Date d(Date date) {
                return date;
            }
        }

        public b(Class<T> cls) {
            this.f9811a = cls;
        }

        public final y a(int i10, int i11) {
            return c(new d<>(this, i10, i11));
        }

        public final y b(String str) {
            return c(new d<>(this, str));
        }

        public final y c(d<T> dVar) {
            return o.a(this.f9811a, dVar);
        }

        public abstract T d(Date date);
    }

    public d(b<T> bVar, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f9809b = arrayList;
        Objects.requireNonNull(bVar);
        this.f9808a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (g9.e.d()) {
            arrayList.add(g9.j.c(i10, i11));
        }
    }

    public d(b<T> bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f9809b = arrayList;
        Objects.requireNonNull(bVar);
        this.f9808a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    public final Date f(m9.a aVar) throws IOException {
        String strJ0 = aVar.j0();
        synchronized (this.f9809b) {
            Iterator<DateFormat> it = this.f9809b.iterator();
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
    public T c(m9.a aVar) throws IOException {
        if (aVar.l0() == m9.b.NULL) {
            aVar.h0();
            return null;
        }
        return (T) this.f9808a.d(f(aVar));
    }

    @Override // e9.x
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void e(m9.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.L();
            return;
        }
        DateFormat dateFormat = this.f9809b.get(0);
        synchronized (this.f9809b) {
            str = dateFormat.format(date);
        }
        cVar.n0(str);
    }

    public String toString() {
        StringBuilder sb2;
        String simpleName;
        DateFormat dateFormat = this.f9809b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            sb2 = new StringBuilder();
            sb2.append("DefaultDateTypeAdapter(");
            simpleName = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            sb2 = new StringBuilder();
            sb2.append("DefaultDateTypeAdapter(");
            simpleName = dateFormat.getClass().getSimpleName();
        }
        sb2.append(simpleName);
        sb2.append(')');
        return sb2.toString();
    }
}
