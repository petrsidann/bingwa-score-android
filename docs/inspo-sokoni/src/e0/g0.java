package e0;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g0 implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Notification.Builder f6777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q.e f6778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteViews f6779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RemoteViews f6780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Bundle> f6781f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f6782g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RemoteViews f6784i;

    public static class a {
        public static Notification a(Notification.Builder builder) {
            return builder.build();
        }

        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setPriority(i10);
        }

        public static Notification.Builder c(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSubText(charSequence);
        }

        public static Notification.Builder d(Notification.Builder builder, boolean z10) {
            return builder.setUsesChronometer(z10);
        }
    }

    public static class b {
        public static Notification.Builder a(Notification.Builder builder, boolean z10) {
            return builder.setShowWhen(z10);
        }
    }

    public static class c {
        public static Notification.Builder a(Notification.Builder builder, Bundle bundle) {
            return builder.setExtras(bundle);
        }
    }

    public static class d {
        public static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        public static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        public static Notification.Action.Builder e(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i10, charSequence, pendingIntent);
        }

        public static String f(Notification notification) {
            return notification.getGroup();
        }

        public static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Builder h(Notification.Builder builder, boolean z10) {
            return builder.setGroupSummary(z10);
        }

        public static Notification.Builder i(Notification.Builder builder, boolean z10) {
            return builder.setLocalOnly(z10);
        }

        public static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    public static class e {
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        public static Notification.Builder c(Notification.Builder builder, int i10) {
            return builder.setColor(i10);
        }

        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder f(Notification.Builder builder, int i10) {
            return builder.setVisibility(i10);
        }
    }

    public static class f {
        public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        public static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        public static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    public static class g {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAllowGeneratedReplies(z10);
        }

        public static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        public static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        public static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    public static class h {
        public static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setBadgeIconType(i10);
        }

        public static Notification.Builder c(Notification.Builder builder, boolean z10) {
            return builder.setColorized(z10);
        }

        public static Notification.Builder d(Notification.Builder builder, int i10) {
            return builder.setGroupAlertBehavior(i10);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder g(Notification.Builder builder, long j10) {
            return builder.setTimeoutAfter(j10);
        }
    }

    public static class i {
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i10) {
            return builder.setSemanticAction(i10);
        }
    }

    public static class j {
        public static Notification.Builder a(Notification.Builder builder, boolean z10) {
            return builder.setAllowSystemGeneratedContextualActions(z10);
        }

        public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z10) {
            return builder.setContextual(z10);
        }

        public static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    public static class k {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAuthenticationRequired(z10);
        }

        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setForegroundServiceBehavior(i10);
        }
    }

    public g0(q.e eVar) {
        int i10;
        this.f6778c = eVar;
        Context context = eVar.f6883a;
        this.f6776a = context;
        Notification.Builder builderA = h.a(context, eVar.L);
        this.f6777b = builderA;
        Notification notification = eVar.S;
        builderA.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f6891i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f6887e).setContentText(eVar.f6888f).setContentInfo(eVar.f6893k).setContentIntent(eVar.f6889g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f6890h, (notification.flags & 128) != 0).setNumber(eVar.f6894l).setProgress(eVar.f6903u, eVar.f6904v, eVar.f6905w);
        IconCompat iconCompat = eVar.f6892j;
        f.b(builderA, iconCompat == null ? null : iconCompat.v(context));
        a.b(a.d(a.c(builderA, eVar.f6900r), eVar.f6897o), eVar.f6895m);
        q.j jVar = eVar.f6899q;
        if (jVar instanceof q.f) {
            Iterator<q.a> it = ((q.f) jVar).n().iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        } else {
            Iterator<q.a> it2 = eVar.f6884b.iterator();
            while (it2.hasNext()) {
                b(it2.next());
            }
        }
        Bundle bundle = eVar.E;
        if (bundle != null) {
            this.f6782g.putAll(bundle);
        }
        int i11 = Build.VERSION.SDK_INT;
        this.f6779d = eVar.I;
        this.f6780e = eVar.J;
        b.a(this.f6777b, eVar.f6896n);
        d.i(this.f6777b, eVar.A);
        d.g(this.f6777b, eVar.f6906x);
        d.j(this.f6777b, eVar.f6908z);
        d.h(this.f6777b, eVar.f6907y);
        this.f6783h = eVar.P;
        e.b(this.f6777b, eVar.D);
        e.c(this.f6777b, eVar.F);
        e.f(this.f6777b, eVar.G);
        e.d(this.f6777b, eVar.H);
        e.e(this.f6777b, notification.sound, notification.audioAttributes);
        List listE = i11 < 28 ? e(g(eVar.f6885c), eVar.V) : eVar.V;
        if (listE != null && !listE.isEmpty()) {
            Iterator it3 = listE.iterator();
            while (it3.hasNext()) {
                e.a(this.f6777b, (String) it3.next());
            }
        }
        this.f6784i = eVar.K;
        if (eVar.f6886d.size() > 0) {
            Bundle bundle2 = eVar.d().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i12 = 0; i12 < eVar.f6886d.size(); i12++) {
                bundle4.putBundle(Integer.toString(i12), n0.a(eVar.f6886d.get(i12)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            eVar.d().putBundle("android.car.EXTENSIONS", bundle2);
            this.f6782g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i13 = Build.VERSION.SDK_INT;
        Object obj = eVar.U;
        if (obj != null) {
            f.c(this.f6777b, obj);
        }
        c.a(this.f6777b, eVar.E);
        g.e(this.f6777b, eVar.f6902t);
        RemoteViews remoteViews = eVar.I;
        if (remoteViews != null) {
            g.c(this.f6777b, remoteViews);
        }
        RemoteViews remoteViews2 = eVar.J;
        if (remoteViews2 != null) {
            g.b(this.f6777b, remoteViews2);
        }
        RemoteViews remoteViews3 = eVar.K;
        if (remoteViews3 != null) {
            g.d(this.f6777b, remoteViews3);
        }
        h.b(this.f6777b, eVar.M);
        h.e(this.f6777b, eVar.f6901s);
        h.f(this.f6777b, eVar.N);
        h.g(this.f6777b, eVar.O);
        h.d(this.f6777b, eVar.P);
        if (eVar.C) {
            h.c(this.f6777b, eVar.B);
        }
        if (!TextUtils.isEmpty(eVar.L)) {
            this.f6777b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        if (i13 >= 28) {
            Iterator<f1> it4 = eVar.f6885c.iterator();
            while (it4.hasNext()) {
                i.a(this.f6777b, it4.next().j());
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 29) {
            j.a(this.f6777b, eVar.R);
            j.b(this.f6777b, q.d.a(null));
        }
        if (i14 >= 31 && (i10 = eVar.Q) != 0) {
            k.b(this.f6777b, i10);
        }
        if (eVar.T) {
            if (this.f6778c.f6907y) {
                this.f6783h = 2;
            } else {
                this.f6783h = 1;
            }
            this.f6777b.setVibrate(null);
            this.f6777b.setSound(null);
            int i15 = notification.defaults & (-2) & (-3);
            notification.defaults = i15;
            this.f6777b.setDefaults(i15);
            if (TextUtils.isEmpty(this.f6778c.f6906x)) {
                d.g(this.f6777b, "silent");
            }
            h.d(this.f6777b, this.f6783h);
        }
    }

    public static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        t.b bVar = new t.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    public static List<String> g(List<f1> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<f1> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().i());
        }
        return arrayList;
    }

    @Override // e0.p
    public Notification.Builder a() {
        return this.f6777b;
    }

    public final void b(q.a aVar) {
        IconCompat iconCompatD = aVar.d();
        Notification.Action.Builder builderA = f.a(iconCompatD != null ? iconCompatD.u() : null, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : h1.b(aVar.e())) {
                d.c(builderA, remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i10 = Build.VERSION.SDK_INT;
        g.a(builderA, aVar.b());
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i10 >= 28) {
            i.b(builderA, aVar.f());
        }
        if (i10 >= 29) {
            j.c(builderA, aVar.j());
        }
        if (i10 >= 31) {
            k.a(builderA, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        d.b(builderA, bundle);
        d.a(this.f6777b, d.d(builderA));
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsK;
        RemoteViews remoteViewsI;
        q.j jVar = this.f6778c.f6899q;
        if (jVar != null) {
            jVar.b(this);
        }
        RemoteViews remoteViewsJ = jVar != null ? jVar.j(this) : null;
        Notification notificationD = d();
        if (remoteViewsJ != null || (remoteViewsJ = this.f6778c.I) != null) {
            notificationD.contentView = remoteViewsJ;
        }
        if (jVar != null && (remoteViewsI = jVar.i(this)) != null) {
            notificationD.bigContentView = remoteViewsI;
        }
        if (jVar != null && (remoteViewsK = this.f6778c.f6899q.k(this)) != null) {
            notificationD.headsUpContentView = remoteViewsK;
        }
        if (jVar != null && (bundleA = q.a(notificationD)) != null) {
            jVar.a(bundleA);
        }
        return notificationD;
    }

    public Notification d() {
        return a.a(this.f6777b);
    }

    public Context f() {
        return this.f6776a;
    }
}
