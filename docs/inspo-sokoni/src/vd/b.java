package vd;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.Spanned;
import androidx.core.graphics.drawable.IconCompat;
import e0.f1;
import e0.h1;
import e0.q;
import ee.e;
import ee.n;
import fe.c;
import fe.f;
import fe.g;
import fe.k;
import fe.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import je.o;
import me.carda.awesome_notifications.core.managers.StatusBarManager;
import zd.h;
import zd.i;
import zd.j;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f17558d = "NotificationBuilder";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f17559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static MediaSessionCompat f17560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap<String, List<k>> f17561g = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final je.b f17562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f17563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f17564c;

    public class a extends MediaSessionCompat.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Context f17565f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Intent f17566g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ l f17567h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ f f17568i;

        public a(Context context, Intent intent, l lVar, f fVar) {
            this.f17565f = context;
            this.f17566g = intent;
            this.f17567h = lVar;
            this.f17568i = fVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void e(String str, Bundle bundle) {
            super.e(str, bundle);
            boolean z10 = bundle.getBoolean("enabled");
            boolean z11 = bundle.getBoolean("autoDismissible");
            boolean z12 = bundle.getBoolean("showInCompactView");
            zd.a aVarI = zd.a.i(bundle.getString("actionType"));
            b bVar = b.this;
            Context context = this.f17565f;
            Intent intent = this.f17566g;
            String str2 = "ACTION_NOTIFICATION_" + str;
            l lVar = this.f17567h;
            f fVar = this.f17568i;
            zd.a aVar = zd.a.Default;
            Intent intentC = bVar.c(context, intent, str2, lVar, fVar, aVarI, aVarI == aVar ? b.this.k(this.f17565f) : rd.a.f15360j);
            if (aVarI == aVar) {
                intentC.addFlags(268435456);
            }
            intentC.putExtra("autoDismissible", z11);
            intentC.putExtra("showInCompactView", z12);
            intentC.putExtra("enabled", z10);
            intentC.putExtra("key", str);
            intentC.putExtra("actionType", aVarI == null ? aVar.h() : aVarI.h());
            if (aVarI == null || !z10) {
                return;
            }
            if (aVarI == aVar) {
                this.f17565f.startActivity(intentC);
            } else {
                this.f17565f.sendBroadcast(intentC);
            }
        }
    }

    /* JADX INFO: renamed from: vd.b$b, reason: collision with other inner class name */
    public static /* synthetic */ class C0306b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17571b;

        static {
            int[] iArr = new int[h.values().length];
            f17571b = iArr;
            try {
                iArr[h.Alarm.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17571b[h.Call.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[j.values().length];
            f17570a = iArr2;
            try {
                iArr2[j.Inbox.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17570a[j.BigText.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17570a[j.BigPicture.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17570a[j.ProgressBar.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17570a[j.MediaPlayer.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17570a[j.Default.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17570a[j.Messaging.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17570a[j.MessagingGroup.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public b(o oVar, je.b bVar, n nVar) {
        this.f17563b = oVar;
        this.f17562a = bVar;
        this.f17564c = nVar;
    }

    public static b m() {
        return new b(o.c(), je.b.k(), n.e());
    }

    public final void A(Context context, f fVar) {
        if (fVar.G.booleanValue()) {
            f(context);
        }
    }

    public final void B(Context context, l lVar) {
        fe.j jVar;
        List<c> list;
        Map<String, fe.j> map = lVar.f8415o;
        if (map == null || map.isEmpty()) {
            return;
        }
        String strL = l(lVar.f8415o, ee.l.a().b(context));
        if (strL == null || (jVar = lVar.f8415o.get(strL)) == null) {
            return;
        }
        if (!o.c().e(jVar.f8400e).booleanValue()) {
            lVar.f8412l.f8382n = jVar.f8400e;
        }
        if (!o.c().e(jVar.f8401f).booleanValue()) {
            lVar.f8412l.f8383o = jVar.f8401f;
        }
        if (!o.c().e(jVar.f8402l).booleanValue()) {
            lVar.f8412l.f8384p = jVar.f8402l;
        }
        if (!o.c().e(jVar.f8403m).booleanValue()) {
            lVar.f8412l.f8392x = jVar.f8403m;
        }
        if (!o.c().e(jVar.f8404n).booleanValue()) {
            lVar.f8412l.f8394z = jVar.f8404n;
        }
        if (jVar.f8405o == null || (list = lVar.f8414n) == null) {
            return;
        }
        for (c cVar : list) {
            if (jVar.f8405o.containsKey(cVar.f8336e)) {
                cVar.f8338l = jVar.f8405o.get(cVar.f8336e);
            }
        }
    }

    public final void C(Context context, PendingIntent pendingIntent, l lVar, q.e eVar) {
        if (je.c.a().b(lVar.f8412l.B)) {
            eVar.r(pendingIntent, true);
        }
    }

    public final void D(l lVar, f fVar) {
        g gVar = lVar.f8412l;
        gVar.f8388t = i(gVar, fVar);
    }

    public final void E(Context context, l lVar, f fVar, q.e eVar) {
        g gVar = lVar.f8412l;
        j jVar = gVar.V;
        if (jVar == j.Messaging || jVar == j.MessagingGroup) {
            return;
        }
        String strI = i(gVar, fVar);
        if (this.f17563b.e(strI).booleanValue()) {
            return;
        }
        eVar.s(strI);
        if (lVar.f8410e) {
            eVar.u(true);
        }
        String string = lVar.f8412l.f8380l.toString();
        eVar.I(Long.toString(fVar.f8375z == zd.f.Asc ? System.currentTimeMillis() : Long.MAX_VALUE - System.currentTimeMillis()) + string);
        eVar.t(fVar.A.ordinal());
    }

    public final void F(f fVar, q.e eVar) {
        eVar.B(i.l(fVar.f8364o));
    }

    public final Boolean G(Context context, g gVar, q.e eVar) {
        CharSequence charSequenceB;
        q.h hVar = new q.h();
        if (this.f17563b.e(gVar.f8383o).booleanValue()) {
            return Boolean.FALSE;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(gVar.f8383o.split("\\r?\\n")));
        if (je.k.a(arrayList)) {
            return Boolean.FALSE;
        }
        if (this.f17563b.e(gVar.f8384p).booleanValue()) {
            charSequenceB = "+ " + arrayList.size() + " more";
        } else {
            charSequenceB = je.h.b(gVar.f8383o);
        }
        hVar.p(charSequenceB);
        if (!this.f17563b.e(gVar.f8382n).booleanValue()) {
            hVar.o(je.h.b(gVar.f8382n));
        }
        String str = gVar.f8384p;
        if (str != null) {
            hVar.p(je.h.b(str));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hVar.n(je.h.b((String) it.next()));
        }
        eVar.K(hVar);
        return Boolean.TRUE;
    }

    public final void H(Context context, l lVar, q.e eVar) {
        Bitmap bitmapH;
        g gVar = lVar.f8412l;
        if (gVar.V == j.BigPicture) {
            return;
        }
        String str = gVar.f8392x;
        if (this.f17563b.e(str).booleanValue() || (bitmapH = this.f17562a.h(context, str, lVar.f8412l.Q.booleanValue())) == null) {
            return;
        }
        eVar.v(bitmapH);
    }

    public final void I(Context context, Intent intent, l lVar, f fVar, q.e eVar) {
        switch (C0306b.f17570a[lVar.f8412l.V.ordinal()]) {
            case 1:
                G(context, lVar.f8412l, eVar).booleanValue();
                break;
            case 2:
                u(context, lVar.f8412l, eVar).booleanValue();
                break;
            case 3:
                t(context, lVar, eVar).booleanValue();
                break;
            case 4:
                S(lVar, eVar);
                break;
            case 5:
                M(context, lVar, eVar, intent, fVar).booleanValue();
                break;
            case 7:
                O(context, false, lVar.f8412l, fVar, eVar).booleanValue();
                break;
            case 8:
                O(context, true, lVar.f8412l, fVar, eVar).booleanValue();
                break;
        }
    }

    public final void J(Context context, l lVar, f fVar, q.e eVar) {
        eVar.j((lVar.f8412l.I == null ? j(lVar, fVar) : h(lVar, fVar, eVar)).intValue());
    }

    public final void K(f fVar, q.e eVar) {
        if (je.c.a().b(fVar.f8370u)) {
            eVar.w(je.i.b(fVar.f8371v, -1).intValue(), je.i.b(fVar.f8372w, 300).intValue(), je.i.b(fVar.f8373x, 700).intValue());
        }
    }

    public final void L(l lVar, f fVar, q.e eVar) {
        boolean zC;
        boolean zB = je.c.a().b(lVar.f8412l.f8393y);
        boolean zB2 = je.c.a().b(fVar.E);
        if (zB) {
            zC = true;
        } else if (!zB2) {
            return;
        } else {
            zC = je.c.a().c(lVar.f8412l.f8393y, Boolean.TRUE);
        }
        eVar.z(zC);
    }

    public final Boolean M(Context context, l lVar, q.e eVar, Intent intent, f fVar) throws ae.a {
        List<String> list;
        g gVar = lVar.f8412l;
        List<c> list2 = lVar.f8414n;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < list2.size(); i10++) {
            if (list2.get(i10).f8343q.booleanValue()) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (!StatusBarManager.k(context).n(gVar.f8388t) && (list = StatusBarManager.k(context).f13323c.get(gVar.f8388t)) != null && list.size() > 0) {
            gVar.f8380l = Integer.valueOf(Integer.parseInt(list.get(0)));
        }
        int[] iArrE0 = e0(arrayList);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            MediaSessionCompat mediaSessionCompat = f17560f;
            if (mediaSessionCompat == null) {
                throw ae.b.e().c(f17558d, "INITIALIZATION_EXCEPTION", "There is no valid media session available", "insufficientRequirements");
            }
            mediaSessionCompat.f(new MediaMetadataCompat.b().c("android.media.metadata.TITLE", gVar.f8382n).c("android.media.metadata.ARTIST", gVar.f8383o).b("android.media.metadata.DURATION", gVar.N.intValue()).a());
            PlaybackStateCompat.d dVarC = new PlaybackStateCompat.d().c(gVar.P.f20653b, (long) ((((long) gVar.J.intValue()) * ((long) gVar.N.intValue())) / 100.0f), gVar.O.floatValue(), SystemClock.elapsedRealtime());
            if (i11 >= 30) {
                for (int i12 = 0; i12 < list2.size(); i12++) {
                    c cVar = list2.get(i12);
                    PlaybackStateCompat.CustomAction.b bVar = new PlaybackStateCompat.CustomAction.b(cVar.f8336e, cVar.f8338l, !this.f17563b.e(cVar.f8337f).booleanValue() ? this.f17562a.j(context, cVar.f8337f) : 0);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("enabled", cVar.f8340n.booleanValue());
                    bundle.putBoolean("autoDismissible", cVar.f8342p.booleanValue());
                    bundle.putBoolean("showInCompactView", cVar.f8343q.booleanValue());
                    bundle.putString("actionType", cVar.f8345s.h());
                    bVar.b(bundle);
                    dVarC.a(bVar.a());
                }
                f17560f.d(new a(context, intent, lVar, fVar));
            }
            f17560f.g(dVarC.b());
        }
        eVar.K(new s1.c().n(f17560f.b()).o(iArrE0).p(true));
        if (!this.f17563b.e(gVar.f8384p).booleanValue()) {
            eVar.L(gVar.f8384p);
        }
        Integer num = gVar.J;
        if (num != null && je.i.d(num, 0, 100).booleanValue()) {
            eVar.C(100, Math.max(0, Math.min(100, je.i.b(gVar.J, 0).intValue())), gVar.J == null);
        }
        eVar.F(false);
        return Boolean.TRUE;
    }

    public b N(MediaSessionCompat mediaSessionCompat) {
        f17560f = mediaSessionCompat;
        return this;
    }

    public final Boolean O(Context context, boolean z10, g gVar, f fVar, q.e eVar) {
        Bitmap bitmapH;
        String strI = i(gVar, fVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strI);
        sb2.append(z10 ? ".Gr" : "");
        String string = sb2.toString();
        int iIntValue = gVar.f8380l.intValue();
        List<String> list = StatusBarManager.k(context).f13323c.get(strI);
        if (list == null || list.size() == 0) {
            f17561g.remove(string);
        } else {
            iIntValue = Integer.parseInt(list.get(0));
        }
        k kVar = new k(gVar.f8382n, gVar.f8383o, gVar.f8392x);
        List<k> arrayList = gVar.f8386r;
        if (je.k.a(arrayList) && (arrayList = f17561g.get(string)) == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(kVar);
        f17561g.put(string, arrayList);
        gVar.f8380l = Integer.valueOf(iIntValue);
        gVar.f8386r = arrayList;
        q.i iVar = new q.i(gVar.f8384p);
        for (k kVar2 : gVar.f8386r) {
            if (Build.VERSION.SDK_INT >= 28) {
                f1.b bVarF = new f1.b().f(kVar2.f8406e);
                String str = kVar2.f8408l;
                if (str == null) {
                    str = gVar.f8392x;
                }
                if (!this.f17563b.e(str).booleanValue() && (bitmapH = this.f17562a.h(context, str, gVar.Q.booleanValue())) != null) {
                    bVarF.c(IconCompat.f(bitmapH));
                }
                iVar.o(kVar2.f8407f, kVar2.f8409m.longValue(), bVarF.a());
            } else {
                iVar.p(kVar2.f8407f, kVar2.f8409m.longValue(), kVar2.f8406e);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && !this.f17563b.e(gVar.f8384p).booleanValue()) {
            iVar.v(gVar.f8384p);
            iVar.w(z10);
        }
        eVar.K(iVar);
        return Boolean.TRUE;
    }

    public final void P(l lVar) {
        Integer num = lVar.f8412l.f8380l;
        if (num == null || num.intValue() < 0) {
            lVar.f8412l.f8380l = Integer.valueOf(je.i.c());
        }
    }

    public final void Q(l lVar, PendingIntent pendingIntent, PendingIntent pendingIntent2, q.e eVar) {
        eVar.l(pendingIntent);
        if (lVar.f8410e) {
            return;
        }
        eVar.p(pendingIntent2);
    }

    public final void R(l lVar, f fVar, q.e eVar) {
        eVar.A(je.c.a().b(Boolean.valueOf(lVar.f8412l.V == j.ProgressBar || fVar.F.booleanValue())));
    }

    public final void S(l lVar, q.e eVar) {
        eVar.C(100, Math.max(0, Math.min(100, je.i.b(lVar.f8412l.J, 0).intValue())), lVar.f8412l.J == null);
    }

    public final void T(l lVar, q.e eVar) {
        if (this.f17563b.e(lVar.f8411f).booleanValue() || lVar.f8412l.V != j.Default) {
            return;
        }
        eVar.D(new CharSequence[]{lVar.f8411f});
    }

    public final void U(l lVar, q.e eVar) {
        eVar.F(je.c.a().c(lVar.f8412l.f8385q, Boolean.TRUE));
    }

    public final void V(Context context, l lVar, f fVar, q.e eVar) {
        int iJ;
        if (!this.f17563b.e(lVar.f8412l.f8391w).booleanValue()) {
            iJ = this.f17562a.j(context, lVar.f8412l.f8391w);
        } else if (this.f17563b.e(fVar.C).booleanValue()) {
            String strD = ee.g.f(context).d(context);
            if (this.f17563b.e(strD).booleanValue()) {
                Integer num = fVar.B;
                if (num == null) {
                    try {
                        int identifier = context.getResources().getIdentifier("ic_launcher", "mipmap", rd.a.K(context));
                        if (identifier > 0) {
                            eVar.H(identifier);
                            return;
                        }
                        return;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        return;
                    }
                }
                iJ = num.intValue();
            } else {
                iJ = this.f17562a.j(context, strD);
                if (iJ <= 0) {
                    return;
                }
            }
        } else {
            iJ = this.f17562a.j(context, fVar.C);
        }
        eVar.H(iJ);
    }

    public final void W(Context context, l lVar, f fVar, q.e eVar) {
        Uri uriM;
        if (!lVar.f8412l.f8378e && lVar.f8411f == null && je.c.a().b(fVar.f8365p)) {
            uriM = e.h().m(context, fVar.f8367r, this.f17563b.e(lVar.f8412l.f8389u).booleanValue() ? fVar.f8366q : lVar.f8412l.f8389u);
        } else {
            uriM = null;
        }
        eVar.J(uriM);
    }

    public final void X(l lVar, q.e eVar) {
        String str = lVar.f8412l.f8384p;
        if (str == null) {
            return;
        }
        eVar.L(je.h.b(str));
    }

    public final void Y(l lVar, q.e eVar) {
        eVar.M(this.f17563b.d(this.f17563b.d(this.f17563b.d(this.f17563b.d(lVar.f8412l.M, ""), lVar.f8412l.f8384p), lVar.f8412l.f8383o), lVar.f8412l.f8382n));
    }

    public final void Z(l lVar, q.e eVar) {
        Integer num = lVar.f8412l.L;
        if (num != null && num.intValue() >= 1) {
            eVar.N(lVar.f8412l.L.intValue() * 1000);
        }
    }

    public ge.a a(Context context, Intent intent, zd.k kVar) {
        ge.a aVarA;
        String action = intent.getAction();
        if (action == null) {
            return null;
        }
        boolean z10 = "SELECT_NOTIFICATION".equals(action) || "DISMISSED_NOTIFICATION".equals(action);
        boolean zStartsWith = action.startsWith("ACTION_NOTIFICATION");
        if (!z10 && !zStartsWith) {
            return null;
        }
        String stringExtra = intent.getStringExtra("notificationActionJson");
        if (!this.f17563b.e(stringExtra).booleanValue() && (aVarA = new ge.a().a(stringExtra)) != null) {
            return aVarA;
        }
        l lVarV = new l().a(intent.getStringExtra("notificationJson"));
        if (lVarV == null) {
            return null;
        }
        ge.a aVar = new ge.a(lVarV.f8412l, intent);
        aVar.f0(kVar);
        if (aVar.f8376a0 == null) {
            aVar.V(kVar);
        }
        Boolean boolValueOf = Boolean.valueOf(intent.getBooleanExtra("autoDismissible", true));
        aVar.D = boolValueOf;
        aVar.f9280f0 = boolValueOf.booleanValue();
        aVar.S = (zd.a) this.f17563b.b(zd.a.class, intent.getStringExtra("actionType"));
        if (zStartsWith) {
            aVar.f9278d0 = intent.getStringExtra("key");
            Bundle bundleJ = h1.j(intent);
            aVar.f9279e0 = bundleJ != null ? bundleJ.getCharSequence(aVar.f9278d0).toString() : "";
            if (!this.f17563b.e(aVar.f9279e0).booleanValue()) {
                h0(context, lVarV, aVar, null);
            }
        }
        return aVar;
    }

    public final void a0(l lVar, q.e eVar) {
        String str = lVar.f8412l.f8382n;
        if (str == null) {
            return;
        }
        eVar.n(je.h.b(str));
    }

    public Intent b(Context context, Intent intent, String str, ge.a aVar, Class<?> cls) {
        Intent intent2 = new Intent(context, cls);
        if (intent != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.setAction(str);
        Bundle extras = intent2.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putString("notificationActionJson", aVar.N());
        intent2.putExtras(extras);
        return intent2;
    }

    public final void b0(f fVar, q.e eVar) {
        if (!je.c.a().b(fVar.f8368s)) {
            eVar.P(new long[]{0});
            return;
        }
        long[] jArr = fVar.f8369t;
        if (jArr == null || jArr.length <= 0) {
            return;
        }
        eVar.P(jArr);
    }

    public Intent c(Context context, Intent intent, String str, l lVar, f fVar, zd.a aVar, Class cls) {
        Intent intent2 = new Intent(context, (Class<?>) cls);
        if (intent != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.setAction(str);
        if (aVar == zd.a.Default) {
            intent2.addFlags(268435456);
        }
        Bundle extras = intent2.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putString("notificationJson", lVar.N());
        i0(lVar, fVar, extras);
        intent2.putExtras(extras);
        return intent2;
    }

    public final void c0(Context context, l lVar, f fVar, q.e eVar) {
        zd.n nVar = lVar.f8412l.T;
        if (nVar == null) {
            nVar = fVar.H;
        }
        eVar.Q(zd.n.k(nVar));
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0148  */
    public void d(Context context, Intent intent, l lVar, f fVar, q.e eVar) {
        PendingIntent broadcast;
        String string;
        StringBuilder sb2;
        String str;
        Spanned spannedA;
        Boolean bool;
        q.e eVar2;
        if (je.k.a(lVar.f8414n)) {
            return;
        }
        Iterator<c> it = lVar.f8414n.iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i10 = Build.VERSION.SDK_INT;
            String str2 = next.f8338l;
            if (str2 != null) {
                zd.a aVar = next.f8345s;
                String str3 = "ACTION_NOTIFICATION_" + next.f8336e;
                zd.a aVar2 = next.f8345s;
                zd.a aVar3 = zd.a.Default;
                Iterator<c> it2 = it;
                Intent intentC = c(context, intent, str3, lVar, fVar, aVar2, aVar == aVar3 ? k(context) : rd.a.f15360j);
                if (next.f8345s == aVar3) {
                    intentC.addFlags(268435456);
                }
                intentC.putExtra("autoDismissible", next.f8342p);
                intentC.putExtra("showInCompactView", next.f8343q);
                intentC.putExtra("enabled", next.f8340n);
                intentC.putExtra("key", next.f8336e);
                zd.a aVar4 = next.f8345s;
                intentC.putExtra("actionType", aVar4 != null ? aVar4.toString() : aVar3.toString());
                if (next.f8340n.booleanValue()) {
                    int iIntValue = lVar.f8412l.f8380l.intValue();
                    if (aVar == aVar3) {
                        broadcast = PendingIntent.getActivity(context, iIntValue, intentC, i10 < 31 ? 134217728 : 167772160);
                    } else {
                        broadcast = PendingIntent.getBroadcast(context, iIntValue, intentC, i10 < 31 ? 134217728 : 167772160);
                    }
                } else {
                    broadcast = null;
                }
                int iJ = !this.f17563b.e(next.f8337f).booleanValue() ? this.f17562a.j(context, next.f8337f) : 0;
                if (next.f8344r.booleanValue()) {
                    sb2 = new StringBuilder();
                    str = "<font color=\"16711680\">";
                } else {
                    if (next.f8339m != null) {
                        sb2 = new StringBuilder();
                        sb2.append("<font color=\"");
                        sb2.append(next.f8339m.toString());
                        str = "\">";
                    } else {
                        string = str2;
                    }
                    spannedA = n0.b.a(string, 0);
                    bool = next.f8341o;
                    if (bool == null && bool.booleanValue()) {
                        eVar2 = eVar;
                        eVar2.b(new q.a.C0119a(iJ, spannedA, broadcast).a(new h1.d(next.f8336e).e(str2).a()).b());
                    } else {
                        eVar2 = eVar;
                        eVar2.a(iJ, spannedA, broadcast);
                    }
                    it = it2;
                }
                sb2.append(str);
                sb2.append(str2);
                sb2.append("</font>");
                string = sb2.toString();
                spannedA = n0.b.a(string, 0);
                bool = next.f8341o;
                if (bool == null) {
                    eVar2 = eVar;
                    eVar2.a(iJ, spannedA, broadcast);
                } else {
                    eVar2 = eVar;
                    eVar2.a(iJ, spannedA, broadcast);
                }
                it = it2;
            }
        }
    }

    public final void d0(Context context, l lVar) {
        if (lVar.f8412l.A.booleanValue()) {
            j0(context);
        }
    }

    public Notification e(Context context, Intent intent, l lVar) throws ae.a {
        f fVarG = e.h().g(context, lVar.f8412l.f8381m);
        if (fVarG == null) {
            throw ae.b.e().c(f17558d, "INVALID_ARGUMENTS", "Channel '" + lVar.f8412l.f8381m + "' does not exist", "arguments.invalid.channel.notFound." + lVar.f8412l.f8381m);
        }
        if (e.h().i(context, lVar.f8412l.f8381m)) {
            q.e eVarN = n(context, intent, fVarG, lVar);
            Notification notificationC = eVarN.c();
            if (notificationC.extras == null) {
                notificationC.extras = new Bundle();
            }
            i0(lVar, fVarG, notificationC.extras);
            d0(context, lVar);
            A(context, fVarG);
            x(context, lVar, notificationC);
            s(context, lVar, fVarG, eVarN);
            return notificationC;
        }
        throw ae.b.e().c(f17558d, "INSUFFICIENT_PERMISSIONS", "Channel '" + lVar.f8412l.f8381m + "' is disabled", "insufficientPermissions.channel.disabled." + lVar.f8412l.f8381m);
    }

    public final int[] e0(ArrayList<Integer> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[arrayList.size()];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            iArr[i10] = arrayList.get(i10).intValue();
        }
        return iArr;
    }

    public void f(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (!n.e().n(context) || this.f17564c.q(context, zd.l.CriticalAlert)) {
            return;
        }
        notificationManager.setInterruptionFilter(2);
        if (i10 >= 28) {
            notificationManager.setNotificationPolicy(new NotificationManager.Policy(32, 0, 0));
        }
    }

    public final Class f0(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            ae.b.e().h(f17558d, "CLASS_NOT_FOUND", "Was not possible to resolve the class named '" + str + "'", "class.notFound." + str);
            return null;
        }
    }

    public String g(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i10 = applicationInfo.labelRes;
        return i10 == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i10);
    }

    public b g0(Context context) {
        String strK = rd.a.K(context);
        Intent intent = new Intent();
        intent.setPackage(strK);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (listQueryIntentActivities.size() > 0) {
            f17559e = listQueryIntentActivities.get(0).activityInfo.name;
        }
        return this;
    }

    public final Integer h(l lVar, f fVar, q.e eVar) {
        Integer numB = je.i.b(lVar.f8412l.I, null);
        if (numB == null) {
            return j(lVar, fVar);
        }
        eVar.k(true);
        return numB;
    }

    public void h0(Context context, l lVar, ge.a aVar, wd.c cVar) {
        if (this.f17563b.e(aVar.f9279e0).booleanValue()) {
            return;
        }
        aVar.f9280f0 = false;
        switch (C0306b.f17570a[lVar.f8412l.V.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                lVar.f8411f = aVar.f9279e0;
                ie.c.l(context, this, lVar.f8412l.Z, lVar, cVar);
                break;
        }
    }

    public String i(g gVar, f fVar) {
        return !this.f17563b.e(gVar.f8388t).booleanValue() ? gVar.f8388t : fVar.f8374y;
    }

    public final void i0(l lVar, f fVar, Bundle bundle) {
        String strI = i(lVar.f8412l, fVar);
        bundle.putInt("id", lVar.f8412l.f8380l.intValue());
        bundle.putString("channelKey", this.f17563b.a(lVar.f8412l.f8381m));
        bundle.putString("groupKey", this.f17563b.a(strI));
        bundle.putBoolean("autoDismissible", lVar.f8412l.D.booleanValue());
        zd.a aVar = lVar.f8412l.S;
        if (aVar == null) {
            aVar = zd.a.Default;
        }
        bundle.putString("actionType", aVar.toString());
        if (je.k.a(lVar.f8412l.f8386r)) {
            return;
        }
        Map<String, Object> mapO = lVar.f8412l.O();
        List list = mapO.get("messages") instanceof List ? (List) mapO.get("messages") : null;
        if (list != null) {
            bundle.putSerializable("messages", (Serializable) list);
        }
    }

    public final Integer j(l lVar, f fVar) {
        return je.i.b(je.i.b(lVar.f8412l.H, fVar.D), -16777216);
    }

    public void j0(Context context) {
        String strG = g(context);
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager.isInteractive()) {
            return;
        }
        powerManager.newWakeLock(268435466, strG + ":" + f17558d + ":WakeupLock").acquire(3000L);
    }

    public Class k(Context context) {
        if (f17559e == null) {
            g0(context);
        }
        if (f17559e == null) {
            f17559e = rd.a.K(context) + ".MainActivity";
        }
        Class clsF0 = f0(f17559e);
        return clsF0 != null ? clsF0 : f0("MainActivity");
    }

    public final String l(Map<String, fe.j> map, String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        if (map.containsKey(lowerCase)) {
            return lowerCase;
        }
        String strReplace = lowerCase.replace("-", "_");
        TreeSet<String> treeSet = new TreeSet(new vd.a());
        treeSet.addAll(map.keySet());
        String str2 = null;
        String str3 = null;
        String str4 = null;
        for (String str5 : treeSet) {
            String strReplace2 = str5.toLowerCase(Locale.ROOT).replace("-", "_");
            if (strReplace2.equals(strReplace)) {
                str2 = str5;
            } else {
                if (strReplace2.startsWith(strReplace + "_")) {
                    str3 = str5;
                } else {
                    if (strReplace.startsWith(strReplace2 + "_")) {
                        str4 = str5;
                    }
                }
            }
        }
        if (o.c().e(str2).booleanValue()) {
            return str2;
        }
        if (o.c().e(str3).booleanValue()) {
            return str3;
        }
        if (o.c().e(str4).booleanValue()) {
            return str4;
        }
        return null;
    }

    public final q.e n(Context context, Intent intent, f fVar, l lVar) {
        q.e eVar = new q.e(context, lVar.f8412l.f8381m);
        y(context, fVar, eVar);
        P(lVar);
        B(context, lVar);
        a0(lVar, eVar);
        v(lVar, eVar);
        X(lVar, eVar);
        D(lVar, fVar);
        V(context, lVar, fVar, eVar);
        T(lVar, eVar);
        E(context, lVar, fVar, eVar);
        c0(context, lVar, fVar, eVar);
        U(lVar, eVar);
        I(context, intent, lVar, fVar, eVar);
        r(lVar, eVar);
        Y(lVar, eVar);
        R(lVar, fVar, eVar);
        L(lVar, fVar, eVar);
        F(fVar, eVar);
        w(lVar, eVar);
        z(lVar, eVar);
        Z(lVar, eVar);
        W(context, lVar, fVar, eVar);
        b0(fVar, eVar);
        K(fVar, eVar);
        V(context, lVar, fVar, eVar);
        H(context, lVar, eVar);
        J(context, lVar, fVar, eVar);
        PendingIntent pendingIntentO = o(context, intent, lVar, fVar);
        PendingIntent pendingIntentP = p(context, intent, lVar, fVar);
        C(context, pendingIntentO, lVar, eVar);
        Q(lVar, pendingIntentO, pendingIntentP, eVar);
        d(context, intent, lVar, fVar, eVar);
        return eVar;
    }

    public final PendingIntent o(Context context, Intent intent, l lVar, f fVar) {
        zd.a aVar = lVar.f8412l.S;
        zd.a aVar2 = zd.a.Default;
        Intent intentC = c(context, intent, "SELECT_NOTIFICATION", lVar, fVar, aVar, aVar == aVar2 ? k(context) : rd.a.f15360j);
        if (aVar == aVar2) {
            intentC.addFlags(67108864);
        }
        int iIntValue = lVar.f8412l.f8380l.intValue();
        return aVar == aVar2 ? PendingIntent.getActivity(context, iIntValue, intentC, 167772160) : PendingIntent.getBroadcast(context, iIntValue, intentC, 167772160);
    }

    public final PendingIntent p(Context context, Intent intent, l lVar, f fVar) {
        return PendingIntent.getBroadcast(context, lVar.f8412l.f8380l.intValue(), c(context, intent, "DISMISSED_NOTIFICATION", lVar, fVar, lVar.f8412l.S, rd.a.f15361k), 167772160);
    }

    public boolean q(ge.a aVar) {
        return o.c().e(aVar.f9279e0).booleanValue() && aVar.f9280f0 && aVar.D.booleanValue();
    }

    public final void r(l lVar, q.e eVar) {
        eVar.f(je.c.a().c(lVar.f8412l.D, Boolean.TRUE));
    }

    public final void s(Context context, l lVar, f fVar, q.e eVar) {
        if (lVar.f8412l.K != null) {
            ee.b.c().i(context, lVar.f8412l.K.intValue());
        } else {
            if (lVar.f8410e || !je.c.a().b(fVar.f8362m)) {
                return;
            }
            ee.b.c().d(context);
            eVar.y(1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0069  */
    /* JADX WARN: Code duplicated, block: B:30:0x0084  */
    public final Boolean t(Context context, l lVar, q.e eVar) {
        Bitmap bitmapH;
        g gVar = lVar.f8412l;
        String str = gVar.f8394z;
        String str2 = gVar.f8392x;
        Bitmap bitmapH2 = !this.f17563b.e(str).booleanValue() ? this.f17562a.h(context, str, gVar.R.booleanValue()) : null;
        boolean z10 = true;
        if (!gVar.C.booleanValue()) {
            if (!this.f17563b.e(str2).booleanValue() && str2.equals(str)) {
                bitmapH = bitmapH2;
            } else if (this.f17563b.e(str2).booleanValue()) {
                bitmapH = null;
            } else {
                bitmapH = this.f17562a.h(context, str2, gVar.Q.booleanValue());
            }
        } else if (bitmapH2 != null) {
            bitmapH = bitmapH2;
        } else if (this.f17563b.e(str2).booleanValue()) {
            bitmapH = null;
        } else {
            je.b bVar = this.f17562a;
            if (!gVar.Q.booleanValue() && !gVar.R.booleanValue()) {
                z10 = false;
            }
            bitmapH = bVar.h(context, str2, z10);
        }
        if (bitmapH != null) {
            eVar.v(bitmapH);
        }
        if (bitmapH2 == null) {
            return Boolean.FALSE;
        }
        q.b bVar2 = new q.b();
        bVar2.p(bitmapH2);
        bVar2.o(gVar.C.booleanValue() ? null : bitmapH);
        if (!this.f17563b.e(gVar.f8382n).booleanValue()) {
            bVar2.r(je.h.b(gVar.f8382n));
        }
        if (!this.f17563b.e(gVar.f8383o).booleanValue()) {
            bVar2.s(je.h.b(gVar.f8383o));
        }
        eVar.K(bVar2);
        return Boolean.TRUE;
    }

    public final Boolean u(Context context, g gVar, q.e eVar) {
        q.c cVar = new q.c();
        if (this.f17563b.e(gVar.f8383o).booleanValue()) {
            return Boolean.FALSE;
        }
        cVar.n(je.h.b(gVar.f8383o));
        if (!this.f17563b.e(gVar.f8384p).booleanValue()) {
            cVar.p(je.h.b(gVar.f8384p));
        }
        if (!this.f17563b.e(gVar.f8382n).booleanValue()) {
            cVar.o(je.h.b(gVar.f8382n));
        }
        eVar.K(cVar);
        return Boolean.TRUE;
    }

    public final void v(l lVar, q.e eVar) {
        String str = lVar.f8412l.f8383o;
        if (str == null) {
            return;
        }
        eVar.m(je.h.b(str));
    }

    public final void w(l lVar, q.e eVar) {
        h hVar = lVar.f8412l.f8377b0;
        if (hVar != null) {
            eVar.g(hVar.f20595b);
        }
    }

    public final void x(Context context, l lVar, Notification notification) {
        int i10;
        h hVar = lVar.f8412l.f8377b0;
        if (hVar != null) {
            int i11 = C0306b.f17571b[hVar.ordinal()];
            if (i11 == 1) {
                i10 = notification.flags | 4;
            } else if (i11 != 2) {
                return;
            } else {
                i10 = notification.flags | 4 | 128;
            }
            notification.flags = i10 | 32;
        }
    }

    public final void y(Context context, f fVar, q.e eVar) {
        eVar.h(e.h().d(context, fVar.f8359e).getId());
    }

    public final void z(l lVar, q.e eVar) {
        Integer num = lVar.f8412l.G;
        if (num == null || num.intValue() < 0 || !lVar.f8412l.f8385q.booleanValue()) {
            return;
        }
        eVar.R(System.currentTimeMillis() - ((long) (lVar.f8412l.G.intValue() * 1000)));
        eVar.O(true);
    }
}
