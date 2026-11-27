package td;

import android.content.Context;
import android.content.Intent;
import me.carda.awesome_notifications.core.managers.StatusBarManager;
import me.carda.awesome_notifications.core.services.ForegroundService;
import zd.k;
import zd.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends td.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15931a = "NotificationActionReceiver";

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15932a;

        static {
            int[] iArr = new int[zd.a.values().length];
            f15932a = iArr;
            try {
                iArr[zd.a.Default.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15932a[zd.a.KeepOnTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15932a[zd.a.SilentAction.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15932a[zd.a.SilentBackgroundAction.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15932a[zd.a.DismissAction.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15932a[zd.a.DisabledAction.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static void c(Context context, Intent intent) {
        d(context, intent, false);
    }

    public static void d(Context context, Intent intent, boolean z10) {
        ge.a aVarA;
        ud.a aVarC;
        String action;
        if (rd.a.f15359i.booleanValue()) {
            de.a.a(f15931a, "New action received");
        }
        vd.b bVarM = vd.b.m();
        k kVarH = ee.k.h();
        try {
            aVarA = bVarM.a(context, intent, kVarH);
        } catch (ae.a e10) {
            e10.printStackTrace();
            aVarA = null;
        }
        if (aVarA == null) {
            if (rd.a.f15359i.booleanValue()) {
                de.a.e(f15931a, "The action received do not contain any awesome notification data and was discarded");
                return;
            }
            return;
        }
        zd.a aVar = aVarA.S;
        zd.a aVar2 = zd.a.DismissAction;
        if (aVar == aVar2) {
            aVarA.e0(kVarH);
        } else {
            aVarA.f0(kVarH);
        }
        if (aVarA.S == aVar2 || bVarM.q(aVarA)) {
            if (aVarA.W == o.ForegroundService) {
                ForegroundService.c(aVarA.f8380l);
            } else {
                StatusBarManager.k(context).d(context, aVarA.f8380l);
            }
        } else if (je.o.c().e(aVarA.f9279e0).booleanValue() && aVarA.S != zd.a.KeepOnTop) {
            StatusBarManager.k(context).b(context);
        }
        try {
            int i10 = a.f15932a[aVarA.S.ordinal()];
            if (i10 == 1) {
                ud.a.c().f(context, aVarA, z10);
                return;
            }
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4) {
                        ud.a.c().b(context, intent.getAction(), aVarA, intent);
                        return;
                    } else {
                        if (i10 != 5) {
                            return;
                        }
                        ud.a.c().h(context, aVarA);
                        return;
                    }
                }
                if (kVarH != k.Terminated) {
                    ud.a.c().j(context, aVarA);
                    return;
                } else {
                    aVarC = ud.a.c();
                    action = intent.getAction();
                }
            } else if (kVarH != k.Terminated) {
                ud.a.c().e(context, aVarA);
                return;
            } else {
                aVarC = ud.a.c();
                action = intent.getAction();
            }
            aVarC.a(context, action, aVarA, intent);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // td.a
    public void b(Context context, Intent intent) {
        c(context, intent);
    }
}
