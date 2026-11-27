package ee;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o<fe.f> f7941c = new o<>(je.o.c(), "ChannelManager", fe.f.class, "NotificationChannelModel");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static e f7942d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final je.o f7943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final je.a f7944b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7945a;

        static {
            int[] iArr = new int[zd.b.values().length];
            f7945a = iArr;
            try {
                iArr[zd.b.Ringtone.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7945a[zd.b.Alarm.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7945a[zd.b.Notification.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(je.o oVar, je.a aVar) {
        this.f7943a = oVar;
        this.f7944b = aVar;
    }

    public static e h() {
        if (f7942d == null) {
            f7942d = new e(je.o.c(), je.a.f());
        }
        return f7942d;
    }

    public final boolean a(fe.f fVar, NotificationChannel notificationChannel) {
        Integer num;
        Uri sound = notificationChannel.getSound();
        return (Arrays.equals(fVar.f8369t, notificationChannel.getVibrationPattern()) && Objects.equals(fVar.f8374y, notificationChannel.getGroup()) && fVar.f8362m.booleanValue() == notificationChannel.canShowBadge() && ((num = fVar.f8371v) == null || num.intValue() == notificationChannel.getLightColor()) && fVar.H == zd.n.values()[notificationChannel.getLockscreenVisibility()] && fVar.f8364o == zd.i.values()[notificationChannel.getImportance()] && ((!fVar.f8365p.booleanValue() && sound == null) || sound.getPath().contains(fVar.f8366q))) ? false : true;
    }

    public final boolean b(fe.f fVar, NotificationChannel notificationChannel) {
        return (notificationChannel.getName().equals(fVar.f8360f) && notificationChannel.getDescription().equals(fVar.f8361l)) ? false : true;
    }

    public void c(Context context) {
        f7941c.a(context);
    }

    public NotificationChannel d(Context context, String str) {
        return e(context, str, null);
    }

    public NotificationChannel e(Context context, String str, String str2) {
        NotificationChannel notificationChannel;
        NotificationManager notificationManagerF = f(context);
        if (str != null && (notificationChannel = notificationManagerF.getNotificationChannel(str)) != null) {
            return notificationChannel;
        }
        for (NotificationChannel notificationChannel2 : notificationManagerF.getNotificationChannels()) {
            if (notificationChannel2.getId().startsWith(str + "_")) {
                return notificationChannel2;
            }
        }
        if (str2 == null) {
            return null;
        }
        return notificationManagerF.getNotificationChannel(str2);
    }

    public NotificationManager f(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }

    public fe.f g(Context context, String str) {
        if (this.f7943a.e(str).booleanValue()) {
            if (rd.a.f15359i.booleanValue()) {
                de.a.e("ChannelManager", "'" + str + "' cannot be empty or null");
            }
            return null;
        }
        fe.f fVar = (fe.f) f7941c.c(context, "channels", str);
        if (fVar == null) {
            if (rd.a.f15359i.booleanValue()) {
                de.a.e("ChannelManager", "Channel model '" + str + "' was not found");
            }
            return null;
        }
        fVar.U(context);
        NotificationChannel notificationChannelD = d(context, str);
        if (notificationChannelD == null) {
            if (rd.a.f15359i.booleanValue()) {
                de.a.e("ChannelManager", "Android native channel '" + str + "' was not found");
            }
            return null;
        }
        if (notificationChannelD.getImportance() == 0 && rd.a.f15359i.booleanValue()) {
            de.a.e("ChannelManager", "Android native channel '" + str + "' is disabled");
        }
        q(fVar, notificationChannelD);
        return fVar;
    }

    public boolean i(Context context, String str) {
        if (this.f7943a.e(str).booleanValue()) {
            return false;
        }
        NotificationChannel notificationChannelD = d(context, str);
        if (notificationChannelD != null) {
            return notificationChannelD.getImportance() != 0;
        }
        NotificationChannel notificationChannelE = e(context, null, g(context, str).T(context, false));
        return (notificationChannelE == null || notificationChannelE.getImportance() == 0) ? false : true;
    }

    public final void j(Context context, String str, String str2) {
        NotificationManager notificationManagerF = f(context);
        notificationManagerF.deleteNotificationChannel(str);
        if (this.f7943a.e(str2).booleanValue()) {
            return;
        }
        notificationManagerF.deleteNotificationChannel(str2);
    }

    public Boolean k(Context context, String str) {
        fe.f fVarG = g(context, str);
        j(context, str, fVarG != null ? fVarG.T(context, false) : null);
        return f7941c.f(context, "channels", str);
    }

    public void l(Context context, String str, String str2) {
        NotificationManager notificationManagerF = f(context);
        for (NotificationChannel notificationChannel : notificationManagerF.getNotificationChannels()) {
            String id2 = notificationChannel.getId();
            if (!id2.equals(str) && id2.length() == 32 && notificationChannel.getName().equals(str2)) {
                notificationManagerF.deleteNotificationChannel(id2);
            }
        }
    }

    public Uri m(Context context, zd.b bVar, String str) {
        if (this.f7943a.e(str).booleanValue()) {
            int i10 = a.f7945a[bVar.ordinal()];
            int i11 = 1;
            if (i10 != 1) {
                i11 = 2;
                if (i10 == 2) {
                    i11 = 4;
                }
            }
            return RingtoneManager.getDefaultUri(i11);
        }
        int iE = this.f7944b.e(context, str);
        if (iE <= 0) {
            return null;
        }
        return Uri.parse("android.resource://" + rd.a.K(context) + "/" + iE);
    }

    public final void n(Context context, fe.f fVar, fe.f fVar2, Boolean bool) {
        StringBuilder sb2;
        String strT = fVar2.T(context, false);
        NotificationChannel notificationChannelE = e(context, fVar2.f8359e, strT);
        if (notificationChannelE == null) {
            if (fVar != null) {
                l(context, fVar.f8359e, fVar.f8360f);
            }
            p(context, fVar2, true);
            if (!rd.a.f15359i.booleanValue()) {
                return;
            }
            sb2 = new StringBuilder();
            sb2.append("Notification channel ");
            sb2.append(fVar2.f8360f);
            sb2.append(" created");
        } else {
            String id2 = notificationChannelE.getId();
            if (fVar2.f8359e.equals(id2)) {
                if (bool.booleanValue() && a(fVar2, notificationChannelE)) {
                    j(context, id2, null);
                    p(context, fVar2, false);
                    if (!rd.a.f15359i.booleanValue()) {
                        return;
                    }
                    sb2 = new StringBuilder();
                    sb2.append("Notification channel ");
                    sb2.append(fVar2.f8360f);
                    sb2.append(" updated with forceUpdate");
                } else {
                    if (!b(fVar2, notificationChannelE)) {
                        return;
                    }
                    p(context, fVar2, true);
                    if (!rd.a.f15359i.booleanValue()) {
                        return;
                    }
                    sb2 = new StringBuilder();
                    sb2.append("Notification channel ");
                    sb2.append(fVar2.f8360f);
                    sb2.append(" updated");
                }
            } else if (!id2.equals(strT) && bool.booleanValue()) {
                j(context, id2, strT);
                p(context, fVar2, false);
                if (!rd.a.f15359i.booleanValue()) {
                    return;
                }
                sb2 = new StringBuilder();
                sb2.append("Notification channel ");
                sb2.append(fVar2.f8360f);
                sb2.append(" updated with forceUpdate");
            } else {
                if (!b(fVar2, notificationChannelE)) {
                    return;
                }
                p(context, fVar2, false);
                if (!rd.a.f15359i.booleanValue()) {
                    return;
                }
                sb2 = new StringBuilder();
                sb2.append("Notification channel ");
                sb2.append(fVar2.f8360f);
                sb2.append(" updated");
            }
        }
        de.a.a("ChannelManager", sb2.toString());
    }

    public e o(Context context, fe.f fVar, Boolean bool, Boolean bool2) {
        fVar.U(context);
        fVar.P(context);
        fe.f fVarG = g(context, fVar.f8359e);
        if (bool.booleanValue() && fVarG != null && !fVarG.equals(fVar)) {
            return this;
        }
        o<fe.f> oVar = f7941c;
        oVar.h(context, "channels", fVar.f8359e, fVar);
        oVar.a(context);
        n(context, fVarG, fVar, bool2);
        return this;
    }

    public void p(Context context, fe.f fVar, boolean z10) {
        fe.e eVarA;
        Integer num;
        NotificationManager notificationManagerF = f(context);
        NotificationChannel notificationChannel = new NotificationChannel(z10 ? fVar.f8359e : fVar.T(context, false), fVar.f8360f, fVar.f8364o.ordinal());
        notificationChannel.setDescription(fVar.f8361l);
        if (this.f7943a.e(fVar.f8363n).booleanValue()) {
            eVarA = null;
        } else {
            eVarA = d.a(context, fVar.f8363n);
            if (eVarA != null) {
                notificationChannel.setGroup(fVar.f8363n);
            } else {
                ae.b.e().h("ChannelManager", "INVALID_ARGUMENTS", "Channel group " + fVar.f8363n + " does not exist.", "arguments.invalid.channelGroup." + fVar.f8363n);
            }
        }
        if (eVarA != null) {
            notificationChannel.setGroup(fVar.f8363n);
        }
        if (fVar.f8365p.booleanValue()) {
            notificationChannel.setSound(m(context, fVar.f8367r, fVar.f8366q), new AudioAttributes.Builder().setContentType(4).setUsage(5).build());
        } else {
            notificationChannel.setSound(null, null);
        }
        notificationChannel.enableVibration(je.c.a().b(fVar.f8368s));
        long[] jArr = fVar.f8369t;
        if (jArr != null && jArr.length > 0) {
            notificationChannel.setVibrationPattern(jArr);
        }
        boolean zB = je.c.a().b(fVar.f8370u);
        notificationChannel.enableLights(zB);
        if (zB && (num = fVar.f8371v) != null) {
            notificationChannel.setLightColor(num.intValue());
        }
        if (fVar.G.booleanValue()) {
            notificationChannel.setBypassDnd(true);
        }
        notificationChannel.setShowBadge(je.c.a().b(fVar.f8362m));
        notificationManagerF.createNotificationChannel(notificationChannel);
    }

    public final void q(fe.f fVar, NotificationChannel notificationChannel) {
        fVar.f8360f = String.valueOf(notificationChannel.getName());
        fVar.f8361l = notificationChannel.getDescription();
        fVar.f8362m = Boolean.valueOf(notificationChannel.canShowBadge());
        fVar.f8365p = Boolean.valueOf(notificationChannel.getSound() != null);
        fVar.f8370u = Boolean.valueOf(notificationChannel.shouldShowLights());
        fVar.f8368s = Boolean.valueOf(notificationChannel.shouldVibrate());
        fVar.f8364o = zd.i.i(notificationChannel.getImportance());
    }
}
