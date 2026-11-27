package ed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mc.w;

/* JADX INFO: loaded from: classes2.dex */
public class j extends g {
    public static final xc.l<String, String> d(final String str) {
        return str.length() == 0 ? new xc.l() { // from class: ed.h
            @Override // xc.l
            public final Object invoke(Object obj) {
                return j.e((String) obj);
            }
        } : new xc.l() { // from class: ed.i
            @Override // xc.l
            public final Object invoke(Object obj) {
                return j.f(str, (String) obj);
            }
        };
    }

    public static final String e(String line) {
        kotlin.jvm.internal.k.e(line, "line");
        return line;
    }

    public static final String f(String str, String line) {
        kotlin.jvm.internal.k.e(line, "line");
        return str + line;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    public static final int g(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (!a.c(str.charAt(i10))) {
                if (i10 == -1) {
                    return str.length();
                }
                return i10;
            }
            i10++;
        }
        i10 = -1;
        if (i10 == -1) {
            return str.length();
        }
        return i10;
    }

    public static final String h(String str, String newIndent) {
        String strInvoke;
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(newIndent, "newIndent");
        List<String> listM = t.M(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            if (!t.F((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(mc.p.m(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(g((String) it.next())));
        }
        Integer num = (Integer) w.C(arrayList2);
        int i10 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listM.size());
        xc.l<String, String> lVarD = d(newIndent);
        int iH = mc.o.h(listM);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listM) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                mc.o.l();
            }
            String str2 = (String) obj2;
            if ((i10 == 0 || i10 == iH) && t.F(str2)) {
                str2 = null;
            } else {
                String strP0 = v.p0(str2, iIntValue);
                if (strP0 != null && (strInvoke = lVarD.invoke(strP0)) != null) {
                    str2 = strInvoke;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i10 = i11;
        }
        return ((StringBuilder) w.x(arrayList3, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
    }

    public static final String i(String str) {
        kotlin.jvm.internal.k.e(str, "<this>");
        return h(str, "");
    }
}
