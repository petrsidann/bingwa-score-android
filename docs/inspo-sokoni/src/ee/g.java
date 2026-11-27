package ee;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o<fe.b> f7948b = new o<>(je.o.c(), "DefaultsManager", fe.b.class, "DefaultsModel");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static g f7949c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xd.f f7950a;

    public g(Context context) {
        this.f7950a = xd.f.C(context);
        try {
            fe.b bVarE = e(context);
            if (bVarE != null) {
                l(context, bVarE.f8332e);
                k(context, Long.valueOf(Long.parseLong(bVarE.f8334l)));
                i(context, Long.valueOf(Long.parseLong(bVarE.f8333f)));
                h(context, null);
            }
        } catch (ae.a e10) {
            throw new RuntimeException(e10);
        }
    }

    public static fe.b e(Context context) {
        return (fe.b) f7948b.c(context, "defaults", "Defaults");
    }

    public static g f(Context context) {
        if (f7949c == null) {
            f7949c = new g(context);
        }
        return f7949c;
    }

    public static void h(Context context, fe.b bVar) {
        if (bVar != null) {
            f7948b.h(context, "defaults", "Defaults", bVar);
        } else {
            f7948b.f(context, "defaults", "Defaults");
        }
    }

    public void a(Context context) {
        f7948b.a(context);
    }

    public Long b(Context context) {
        return Long.valueOf(this.f7950a.D(context, "defaults", "actionHandle", 0L));
    }

    public Long c(Context context) {
        return Long.valueOf(this.f7950a.D(context, "defaults", "awesomeDartBGHandle", 0L));
    }

    public String d(Context context) {
        return this.f7950a.I(context, "defaults", "defaultIcon", null);
    }

    public Long g(Context context) {
        return Long.valueOf(this.f7950a.D(context, "defaults", "silentHandle", 0L));
    }

    public boolean i(Context context, Long l10) {
        return this.f7950a.h0(context, "defaults", "actionHandle", l10.longValue());
    }

    public boolean j(Context context, Long l10) {
        return this.f7950a.h0(context, "defaults", "createdHandle", l10.longValue());
    }

    public boolean k(Context context, Long l10) {
        return this.f7950a.h0(context, "defaults", "awesomeDartBGHandle", l10.longValue());
    }

    public boolean l(Context context, String str) {
        return this.f7950a.i0(context, "defaults", "defaultIcon", str);
    }

    public boolean m(Context context, Long l10) {
        return this.f7950a.h0(context, "defaults", "dismissedHandle", l10.longValue());
    }

    public boolean n(Context context, Long l10) {
        return this.f7950a.h0(context, "defaults", "displayedHandle", l10.longValue());
    }
}
