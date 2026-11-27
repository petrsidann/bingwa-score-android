package ee;

import android.content.Context;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m f7962a;

    public static m b() {
        if (f7962a == null) {
            f7962a = new m();
        }
        return f7962a;
    }

    public final String a(Calendar calendar, Integer num, String str) {
        return String.valueOf(calendar.getTimeInMillis() / 1000) + "::" + num.toString() + "::" + str;
    }

    public void c(Context context, boolean z10, boolean z11, boolean z12, boolean z13) {
        TreeMap treeMap = new TreeMap();
        if (z10) {
            treeMap.putAll(e(context));
        } else {
            f.e().g(context);
        }
        if (z11) {
            treeMap.putAll(f(context));
        } else {
            i.e().g(context);
        }
        if (z12) {
            treeMap.putAll(d(context));
        } else {
            a.f().i(context);
        }
        if (z13) {
            treeMap.putAll(g(context));
        } else {
            h.e().g(context);
        }
        if (treeMap.isEmpty()) {
            return;
        }
        for (String str : treeMap.keySet()) {
            byte b10 = 2;
            String strSubstring = str.substring(str.lastIndexOf("::") + 2);
            strSubstring.hashCode();
            switch (strSubstring.hashCode()) {
                case -1422950858:
                    b10 = strSubstring.equals("action") ? (byte) 0 : (byte) -1;
                    break;
                case 159466665:
                    b10 = strSubstring.equals("dismissed") ? (byte) 1 : (byte) -1;
                    break;
                case 247594209:
                    if (!strSubstring.equals("displayed")) {
                        b10 = -1;
                    }
                    break;
                case 1028554472:
                    b10 = strSubstring.equals("created") ? (byte) 3 : (byte) -1;
                    break;
                default:
                    b10 = -1;
                    break;
            }
            switch (b10) {
                case 0:
                    ud.a.c().f(context, (ge.a) treeMap.get(str), false);
                    break;
                case 1:
                    ud.a.c().h(context, (ge.a) treeMap.get(str));
                    break;
                case 2:
                    ud.a.c().i(context, (ge.b) treeMap.get(str));
                    break;
                case 3:
                    ud.a.c().g(context, (ge.b) treeMap.get(str));
                    break;
            }
        }
    }

    public final Map<String, fe.a> d(Context context) {
        HashMap map = new HashMap();
        List<ge.a> listG = a.f().g(context);
        if (listG == null) {
            return map;
        }
        for (ge.a aVar : listG) {
            try {
                map.put(a(aVar.f9283i0, aVar.f8380l, "action"), aVar);
                a.f().h(context, aVar.f8380l);
            } catch (ae.a e10) {
                if (rd.a.f15359i.booleanValue()) {
                    de.a.a("LostEventsManager", String.format("%s", e10.getMessage()));
                }
                e10.printStackTrace();
            }
        }
        a.f().d(context);
        return map;
    }

    public final Map<String, fe.a> e(Context context) {
        HashMap map = new HashMap();
        List<ge.b> listF = f.e().f(context);
        if (listF.isEmpty()) {
            return map;
        }
        for (ge.b bVar : listF) {
            try {
                bVar.P(context);
                map.put(a(bVar.Y, bVar.f8380l, "created"), bVar);
                f.e().h(context, bVar.f8380l, bVar.Y);
            } catch (ae.a e10) {
                if (rd.a.f15359i.booleanValue()) {
                    de.a.a("LostEventsManager", String.format("%s", e10.getMessage()));
                }
                e10.printStackTrace();
            }
        }
        f.e().d(context);
        return map;
    }

    public final Map<String, fe.a> f(Context context) {
        HashMap map = new HashMap();
        List<ge.b> listF = i.e().f(context);
        if (listF == null) {
            return map;
        }
        for (ge.b bVar : listF) {
            try {
                map.put(a(bVar.f8376a0, bVar.f8380l, "displayed"), bVar);
                i.e().h(context, bVar.f8380l, bVar.f8376a0);
            } catch (ae.a e10) {
                if (rd.a.f15359i.booleanValue()) {
                    de.a.a("LostEventsManager", String.format("%s", e10.getMessage()));
                }
                e10.printStackTrace();
            }
        }
        i.e().d(context);
        return map;
    }

    public final Map<String, fe.a> g(Context context) {
        HashMap map = new HashMap();
        List<ge.a> listF = h.e().f(context);
        if (listF == null) {
            return map;
        }
        for (ge.a aVar : listF) {
            try {
                aVar.P(context);
                map.put(a(aVar.f9284j0, aVar.f8380l, "dismissed"), aVar);
                h.e().h(context, aVar.f8380l, aVar.f9284j0);
            } catch (ae.a e10) {
                if (rd.a.f15359i.booleanValue()) {
                    de.a.a("LostEventsManager", String.format("%s", e10.getMessage()));
                }
                e10.printStackTrace();
            }
        }
        h.e().d(context);
        return map;
    }

    public void h(Context context, ge.b bVar) {
        f.e().i(context, bVar);
        f.e().d(context);
    }

    public void i(Context context, ge.a aVar) {
        h.e().i(context, aVar);
        h.e().d(context);
    }

    public void j(Context context, ge.b bVar) {
        i.e().i(context, bVar);
        i.e().d(context);
    }
}
