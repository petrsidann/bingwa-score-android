package ee;

import android.content.Context;
import android.content.SharedPreferences;
import fe.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class o<T extends fe.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f7990e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<T> f7991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xd.f f7992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final je.o f7994d;

    public o(je.o oVar, String str, Class<T> cls, String str2) {
        this.f7993c = "default";
        this.f7991a = cls;
        this.f7994d = oVar;
        String str3 = "sharedManager." + str + "." + str2;
        try {
            this.f7993c = oVar.a(str3);
        } catch (Exception e10) {
            this.f7993c = str3;
            ae.b.e().h("SharedManager", "SHARED_PREFERENCES_NOT_AVAILABLE", "SharedManager could not be correctly initialized: " + e10.getMessage(), "initialization." + str3);
        }
    }

    public boolean a(Context context) throws ae.a {
        try {
            e(context).e(context);
            return true;
        } catch (Exception e10) {
            throw ae.b.e().b("SharedManager", "SHARED_PREFERENCES_NOT_AVAILABLE", "sharedPreferences.commit", e10);
        }
    }

    public final xd.f b(Context context, SharedPreferences sharedPreferences) throws ae.a {
        if (this.f7992b.B(context, "conv", this.f7993c, false)) {
            return this.f7992b;
        }
        if (this.f7992b.j0(context, this.f7993c) == 0) {
            try {
                Map<String, ?> all = sharedPreferences.getAll();
                if (all != null) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof String) {
                            this.f7992b.i0(context, this.f7993c, key, (String) value);
                        }
                    }
                }
            } catch (Exception e10) {
                throw ae.b.e().b("SharedManager", "SHARED_PREFERENCES_NOT_AVAILABLE", "sharedPreferences.getAllObjects", e10);
            }
        }
        this.f7992b.f0(context, "conv", this.f7993c, true);
        return this.f7992b;
    }

    public T c(Context context, String str, String str2) throws ae.a {
        T t10;
        try {
            String strI = e(context).I(context, str, str2, null);
            if (this.f7994d.e(strI).booleanValue() || (t10 = (T) this.f7991a.newInstance().a(strI)) == null) {
                return null;
            }
            return t10;
        } catch (ae.a e10) {
            throw e10;
        } catch (Exception e11) {
            throw ae.b.e().b("SharedManager", "SHARED_PREFERENCES_NOT_AVAILABLE", "sharedPreferences.get", e11);
        }
    }

    public List<T> d(Context context, String str) throws ae.a {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<Map.Entry<String, String>> it = e(context).z(context, str).entrySet().iterator();
            while (it.hasNext()) {
                String value = it.next().getValue();
                if (value instanceof String) {
                    try {
                        arrayList.add(this.f7991a.newInstance().a(value));
                    } catch (Exception e10) {
                        ae.b.e().g("SharedManager", "SHARED_PREFERENCES_NOT_AVAILABLE", "sharedPreferences.getAllObjects", e10);
                    }
                }
            }
            return arrayList;
        } catch (Exception e11) {
            throw ae.b.e().b("SharedManager", "SHARED_PREFERENCES_NOT_AVAILABLE", "sharedPreferences.getAllObjects", e11);
        }
    }

    public final xd.f e(Context context) throws ae.a {
        xd.h.a(context);
        if (f7990e == null) {
            f7990e = rd.a.K(context);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.f7993c, 0);
        if (sharedPreferences == null) {
            throw ae.b.e().c("SharedManager", "SHARED_PREFERENCES_NOT_AVAILABLE", "SharedPreferences.getSharedPreferences is not available", "sharedPreferences.getSharedInstance");
        }
        if (this.f7992b == null) {
            this.f7992b = xd.f.C(context);
        }
        return b(context, sharedPreferences);
    }

    public Boolean f(Context context, String str, String str2) {
        try {
            e(context).e0(context, str, str2);
            return Boolean.TRUE;
        } catch (ae.a e10) {
            throw e10;
        } catch (Exception e11) {
            throw ae.b.e().b("SharedManager", "SHARED_PREFERENCES_NOT_AVAILABLE", "sharedPreferences.remove", e11);
        }
    }

    public Boolean g(Context context, String str) throws ae.a {
        try {
            e(context).c0(context, str);
            return Boolean.TRUE;
        } catch (ae.a e10) {
            throw e10;
        } catch (Exception e11) {
            throw ae.b.e().b("SharedManager", "SHARED_PREFERENCES_NOT_AVAILABLE", "sharedPreferences.removeAll", e11);
        }
    }

    public Boolean h(Context context, String str, String str2, T t10) {
        try {
            e(context).i0(context, str, str2, t10.N());
            return Boolean.TRUE;
        } catch (ae.a e10) {
            throw e10;
        } catch (Exception e11) {
            throw ae.b.e().b("SharedManager", "SHARED_PREFERENCES_NOT_AVAILABLE", "sharedPreferences.set", e11);
        }
    }
}
