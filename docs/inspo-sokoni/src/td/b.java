package td;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.o;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f15921b = "AwesomeEventsReceiver";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f15922c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f15923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static List<ce.e> f15924e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static List<ce.a> f15925f = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f15926a;

    public b(o oVar) {
        this.f15926a = oVar;
    }

    public static b c() {
        if (f15923d == null) {
            f15923d = new b(o.c());
        }
        return f15923d;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0060  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(Context context, String str, ge.a aVar) {
        byte b10;
        if (f15924e.isEmpty()) {
            if (rd.a.f15359i.booleanValue()) {
                de.a.e(f15921b, "New event " + str + " ignored, as there is no listeners waiting for new action events");
                return;
            }
            return;
        }
        try {
            switch (str.hashCode()) {
                case -1368808637:
                    if (!str.equals("broadcast.awesome_notifications.DEFAULT_ACTION")) {
                        b10 = -1;
                    } else {
                        b10 = 0;
                    }
                    break;
                case 168712976:
                    if (!str.equals("broadcast.awesome_notifications.DISMISSED_NOTIFICATION")) {
                        b10 = -1;
                    } else {
                        b10 = 1;
                    }
                    break;
                case 189222616:
                    if (!str.equals("broadcast.awesome_notifications.BACKGROUND_ACTION")) {
                        b10 = -1;
                    } else {
                        b10 = 3;
                    }
                    break;
                case 1577246289:
                    if (!str.equals("broadcast.awesome_notifications.SILENT_ACTION")) {
                        b10 = -1;
                    } else {
                        b10 = 2;
                    }
                    break;
                default:
                    b10 = -1;
                    break;
            }
            if (b10 == 0) {
                i(context, aVar);
                return;
            }
            if (b10 == 1) {
                k(context, aVar);
                return;
            }
            if (b10 == 2) {
                m(context, aVar);
                return;
            }
            if (b10 == 3) {
                h(context, aVar);
                return;
            }
            if (rd.a.f15359i.booleanValue()) {
                String str2 = f15921b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Received unknown action event: ");
                if (this.f15926a.e(str).booleanValue()) {
                    str = "empty";
                }
                sb2.append(str);
                de.a.a(str2, sb2.toString());
            }
        } catch (Exception e10) {
            if (rd.a.f15359i.booleanValue()) {
                de.a.a(f15921b, String.format("%s", e10.getMessage()));
            }
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0051  */
    public void b(Context context, String str, ge.b bVar) {
        byte b10;
        if (f15924e.isEmpty()) {
            if (rd.a.f15359i.booleanValue()) {
                de.a.e(f15921b, "New event " + str + " ignored, as there is no listeners waiting for new notification events");
                return;
            }
            return;
        }
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != 1581039064) {
                if (iHashCode == 1645069041 && str.equals("broadcast.awesome_notifications.CREATED_NOTIFICATION")) {
                    b10 = 0;
                } else {
                    b10 = -1;
                }
            } else if (str.equals("broadcast.awesome_notifications.DISPLAYED_NOTIFICATION")) {
                b10 = 1;
            } else {
                b10 = -1;
            }
            if (b10 == 0) {
                j(context, bVar);
                return;
            }
            if (b10 == 1) {
                l(context, bVar);
                return;
            }
            if (rd.a.f15359i.booleanValue()) {
                String str2 = f15921b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Received unknown notification event: ");
                if (this.f15926a.e(str).booleanValue()) {
                    str = "empty";
                }
                sb2.append(str);
                de.a.a(str2, sb2.toString());
            }
        } catch (Exception e10) {
            if (rd.a.f15359i.booleanValue()) {
                de.a.a(f15921b, String.format("%s", e10.getMessage()));
            }
            e10.printStackTrace();
        }
    }

    public boolean d() {
        return f15925f.isEmpty();
    }

    public boolean e() {
        return f15922c;
    }

    public final void f(String str, ge.a aVar) {
        boolean z10;
        if (rd.a.f15359i.booleanValue() && f15924e.isEmpty()) {
            de.a.e(f15921b, "New event " + str + " ignored, as there is no listeners waiting for new action events");
        }
        Iterator<ce.a> it = f15925f.iterator();
        loop0: while (true) {
            z10 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                ce.a next = it.next();
                if (z10 || next.a(str, aVar)) {
                    z10 = true;
                }
            }
        }
        if (z10) {
            return;
        }
        Iterator<ce.a> it2 = f15925f.iterator();
        while (it2.hasNext()) {
            it2.next().d(str, aVar);
        }
    }

    public final void g(String str, ge.b bVar) {
        if (rd.a.f15359i.booleanValue() && f15924e.isEmpty()) {
            de.a.e(f15921b, "New event " + str + " ignored, as there is no listeners waiting for new notification events");
        }
        Iterator<ce.e> it = f15924e.iterator();
        while (it.hasNext()) {
            it.next().b(str, bVar);
        }
    }

    public final void h(Context context, ge.a aVar) throws ae.a {
        try {
            aVar.P(context);
            if (rd.a.f15359i.booleanValue()) {
                de.a.a(f15921b, "New background silent action event");
            }
            f("silentAction", aVar);
        } catch (Exception e10) {
            throw ae.b.e().b(f15921b, "EVENT_EXCEPTION", "unexpectedError", e10);
        }
    }

    public final void i(Context context, ge.a aVar) {
        try {
            aVar.P(context);
            if (rd.a.f15359i.booleanValue()) {
                de.a.a(f15921b, "New notification action event");
            }
            f("defaultAction", aVar);
        } catch (Exception e10) {
            if (rd.a.f15359i.booleanValue()) {
                de.a.a(f15921b, String.format("%s", e10.getMessage()));
            }
            e10.printStackTrace();
        }
    }

    public final void j(Context context, ge.b bVar) throws ae.a {
        try {
            bVar.P(context);
            if (rd.a.f15359i.booleanValue()) {
                de.a.a(f15921b, "New notification creation event");
            }
            g("notificationCreated", bVar);
        } catch (Exception e10) {
            throw ae.b.e().b(f15921b, "EVENT_EXCEPTION", "unexpectedError", e10);
        }
    }

    public final void k(Context context, ge.a aVar) throws ae.a {
        try {
            aVar.P(context);
            if (rd.a.f15359i.booleanValue()) {
                de.a.a(f15921b, "New notification dismiss event");
            }
            f("notificationDismissed", aVar);
        } catch (Exception e10) {
            throw ae.b.e().b(f15921b, "EVENT_EXCEPTION", "unexpectedError", e10);
        }
    }

    public final void l(Context context, ge.b bVar) throws ae.a {
        try {
            bVar.P(context);
            if (rd.a.f15359i.booleanValue()) {
                de.a.a(f15921b, "New notification display event");
            }
            g("notificationDisplayed", bVar);
        } catch (Exception e10) {
            throw ae.b.e().b(f15921b, "EVENT_EXCEPTION", "unexpectedError", e10);
        }
    }

    public final void m(Context context, ge.a aVar) throws ae.a {
        try {
            aVar.P(context);
            if (rd.a.f15359i.booleanValue()) {
                de.a.a(f15921b, "New silent action event");
            }
            f("silentAction", aVar);
        } catch (Exception e10) {
            throw ae.b.e().b(f15921b, "EVENT_EXCEPTION", "unexpectedError", e10);
        }
    }

    public b n(ce.a aVar) {
        f15925f.add(aVar);
        if (rd.a.f15359i.booleanValue()) {
            de.a.a(f15921b, aVar.getClass().getSimpleName() + " subscribed to receive action events");
        }
        return this;
    }

    public b o(ce.e eVar) {
        f15924e.add(eVar);
        if (eVar instanceof rd.a) {
            f15922c = true;
        }
        if (rd.a.f15359i.booleanValue()) {
            de.a.a(f15921b, eVar.getClass().getSimpleName() + " subscribed to receive notification events");
        }
        return this;
    }

    public b p(ce.a aVar) {
        f15925f.remove(aVar);
        if (rd.a.f15359i.booleanValue()) {
            de.a.a(f15921b, aVar.getClass().getSimpleName() + " unsubscribed from action events");
        }
        return this;
    }

    public b q(ce.e eVar) {
        f15924e.remove(eVar);
        if (eVar instanceof rd.a) {
            Iterator<ce.e> it = f15924e.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                if (it.next() instanceof rd.a) {
                    z10 = true;
                }
            }
            f15922c = z10;
        }
        if (rd.a.f15359i.booleanValue()) {
            de.a.a(f15921b, eVar.getClass().getSimpleName() + " unsubscribed from notification events");
        }
        return this;
    }
}
