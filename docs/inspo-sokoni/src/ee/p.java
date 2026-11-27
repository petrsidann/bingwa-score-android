package ee;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o<fe.l> f7995a = new o<>(je.o.c(), "ScheduleManager", fe.l.class, "NotificationModel");

    public static xd.g a(Context context) {
        xd.g gVarK = xd.g.k(context);
        try {
            o<fe.l> oVar = f7995a;
            List<T> listD = oVar.d(context, "schedules");
            if (!listD.isEmpty()) {
                o(context, gVarK, listD);
                oVar.g(context, "schedules");
            }
            return gVarK;
        } catch (ae.a e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void b(Context context) {
        xd.g gVarA = a(context);
        try {
            gVarA.D(context);
            gVarA.close();
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void c(Context context, Integer num) {
        xd.g gVarA = a(context);
        try {
            gVarA.E(context, num);
            gVarA.close();
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void d(Context context, String str) {
        xd.g gVarA = a(context);
        try {
            gVarA.G(context, str);
            gVarA.close();
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void e(Context context, String str) {
        xd.g gVarA = a(context);
        try {
            gVarA.I(context, str);
            gVarA.close();
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void f(Context context) {
        xd.g gVarA = a(context);
        try {
            gVarA.d(context);
            gVarA.close();
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static AlarmManager g(Context context) {
        return (AlarmManager) context.getSystemService("alarm");
    }

    public static fe.l h(Context context, Integer num) {
        xd.g gVarA = a(context);
        try {
            Iterator<String> it = gVarA.v(context, num).values().iterator();
            if (!it.hasNext()) {
                gVarA.close();
                return null;
            }
            fe.l lVarA = new fe.l().a(it.next());
            gVarA.close();
            return lVarA;
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static boolean i(AlarmManager alarmManager) {
        if (Build.VERSION.SDK_INT >= 31) {
            return alarmManager.canScheduleExactAlarms();
        }
        return true;
    }

    public static boolean j(Context context) {
        return i(g(context));
    }

    public static List<Integer> k(Context context) {
        xd.g gVarA = a(context);
        try {
            Map<Integer, String> mapE = gVarA.e(context);
            gVarA.close();
            return new ArrayList(mapE.keySet());
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static List<Integer> l(Context context, String str) {
        xd.g gVarA = a(context);
        try {
            Map<Integer, String> mapZ = gVarA.z(context, str);
            gVarA.close();
            return new ArrayList(mapZ.keySet());
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static List<Integer> m(Context context, String str) {
        xd.g gVarA = a(context);
        try {
            ArrayList arrayList = new ArrayList(gVarA.B(context, str).keySet());
            gVarA.close();
            return arrayList;
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static List<fe.l> n(Context context) {
        ArrayList arrayList = new ArrayList();
        xd.g gVarA = a(context);
        try {
            Iterator<String> it = gVarA.e(context).values().iterator();
            while (it.hasNext()) {
                arrayList.add(new fe.l().a(it.next()));
            }
            gVarA.close();
            return arrayList;
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void o(Context context, xd.g gVar, List<fe.l> list) {
        for (fe.l lVar : list) {
            fe.g gVar2 = lVar.f8412l;
            gVar.J(context, gVar2.f8380l, gVar2.f8381m, gVar2.f8388t, lVar.N());
        }
    }

    public static Boolean p(Context context, fe.l lVar) {
        xd.g gVarA = a(context);
        try {
            gVarA.E(context, lVar.f8412l.f8380l);
            gVarA.close();
            return Boolean.TRUE;
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static Boolean q(Context context, fe.l lVar) {
        xd.g gVarA = a(context);
        try {
            fe.g gVar = lVar.f8412l;
            gVarA.J(context, gVar.f8380l, gVar.f8381m, gVar.f8388t, lVar.N());
            gVarA.close();
            return Boolean.TRUE;
        } catch (Throwable th) {
            if (gVarA != null) {
                try {
                    gVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
