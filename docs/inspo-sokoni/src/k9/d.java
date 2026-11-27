package k9;

import e9.y;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f11898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h9.d.b<? extends Date> f11899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h9.d.b<? extends Date> f11900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f11901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f11902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y f11903f;

    public class a extends h9.d.b<java.sql.Date> {
        public a(Class cls) {
            super(cls);
        }

        @Override // h9.d.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public java.sql.Date d(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    public class b extends h9.d.b<Timestamp> {
        public b(Class cls) {
            super(cls);
        }

        @Override // h9.d.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z10;
        y yVar;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        f11898a = z10;
        if (z10) {
            f11899b = new a(java.sql.Date.class);
            f11900c = new b(Timestamp.class);
            f11901d = k9.a.f11892b;
            f11902e = k9.b.f11894b;
            yVar = c.f11896b;
        } else {
            yVar = null;
            f11899b = null;
            f11900c = null;
            f11901d = null;
            f11902e = null;
        }
        f11903f = yVar;
    }
}
