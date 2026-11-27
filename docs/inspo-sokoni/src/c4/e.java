package c4;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.q0;
import com.google.android.gms.common.api.internal.r0;
import com.google.android.gms.internal.base.zad;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: loaded from: classes.dex */
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {zad.class, zae.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
public class e extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3361c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f3359e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f3360f = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3358d = f.f3366a;

    public static e n() {
        return f3360f;
    }

    @Override // c4.f
    public Intent b(Context context, int i10, String str) {
        return super.b(context, i10, str);
    }

    @Override // c4.f
    public PendingIntent c(Context context, int i10, int i11) {
        return super.c(context, i10, i11);
    }

    @Override // c4.f
    public final String e(int i10) {
        return super.e(i10);
    }

    @Override // c4.f
    @ResultIgnorabilityUnspecified
    public int g(Context context) {
        return super.g(context);
    }

    @Override // c4.f
    public int h(Context context, int i10) {
        return super.h(context, i10);
    }

    @Override // c4.f
    public final boolean j(int i10) {
        return super.j(i10);
    }

    public Dialog l(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        return q(activity, i10, com.google.android.gms.common.internal.g0.b(activity, b(activity, i10, "d"), i11), onCancelListener, null);
    }

    public PendingIntent m(Context context, b bVar) {
        return bVar.V() ? bVar.U() : c(context, bVar.S(), 0);
    }

    @ResultIgnorabilityUnspecified
    public boolean o(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogL = l(activity, i10, i11, onCancelListener);
        if (dialogL == null) {
            return false;
        }
        t(activity, dialogL, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void p(Context context, int i10) {
        u(context, i10, null, d(context, i10, 0, "n"));
    }

    public final Dialog q(Context context, int i10, com.google.android.gms.common.internal.g0 g0Var, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.d0.c(context, i10));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strB = com.google.android.gms.common.internal.d0.b(context, i10);
        DialogInterface.OnClickListener onClickListener2 = g0Var;
        if (strB != null) {
            if (g0Var == null) {
                onClickListener2 = onClickListener;
            }
            builder.setPositiveButton(strB, onClickListener2);
        }
        String strF = com.google.android.gms.common.internal.d0.f(context, i10);
        if (strF != null) {
            builder.setTitle(strF);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i10)), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog r(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(com.google.android.gms.common.internal.d0.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        t(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    @ResultIgnorabilityUnspecified
    public final r0 s(Context context, q0 q0Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        r0 r0Var = new r0(q0Var);
        zao.zaa(context, r0Var, intentFilter);
        r0Var.a(context);
        if (i(context, "com.google.android.gms")) {
            return r0Var;
        }
        q0Var.a();
        r0Var.b();
        return null;
    }

    public final void t(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof i1.u) {
                m.T1(dialog, onCancelListener).S1(((i1.u) activity).S(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public final void u(Context context, int i10, String str, PendingIntent pendingIntent) {
        int i11;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i10), null), new IllegalArgumentException());
        if (i10 == 18) {
            v(context);
            return;
        }
        if (pendingIntent == null) {
            if (i10 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = com.google.android.gms.common.internal.d0.e(context, i10);
        String strD = com.google.android.gms.common.internal.d0.d(context, i10);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) com.google.android.gms.common.internal.r.l(context.getSystemService("notification"));
        e0.q.e eVarK = new e0.q.e(context).x(true).f(true).n(strE).K(new e0.q.c().n(strD));
        if (j4.h.c(context)) {
            com.google.android.gms.common.internal.r.o(j4.m.b());
            eVarK.H(context.getApplicationInfo().icon).B(2);
            if (j4.h.d(context)) {
                eVarK.a(a4.a.f344a, resources.getString(a4.b.f359o), pendingIntent);
            } else {
                eVarK.l(pendingIntent);
            }
        } else {
            eVarK.H(R.drawable.stat_sys_warning).M(resources.getString(a4.b.f352h)).R(System.currentTimeMillis()).l(pendingIntent).m(strD);
        }
        if (j4.m.e()) {
            com.google.android.gms.common.internal.r.o(j4.m.e());
            synchronized (f3359e) {
                str2 = this.f3361c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(a4.b.f351g);
                if (notificationChannel == null) {
                    notificationChannel = new NotificationChannel("com.google.android.gms.availability", string, 4);
                } else if (!string.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(string);
                }
                notificationManager.createNotificationChannel(notificationChannel);
            }
            eVarK.h(str2);
        }
        Notification notificationC = eVarK.c();
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            j.f3377b.set(false);
            i11 = 10436;
        } else {
            i11 = 39789;
        }
        notificationManager.notify(i11, notificationC);
    }

    public final void v(Context context) {
        new o(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    @ResultIgnorabilityUnspecified
    public final boolean w(Activity activity, com.google.android.gms.common.api.internal.k kVar, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogQ = q(activity, i10, com.google.android.gms.common.internal.g0.c(kVar, b(activity, i10, "d"), 2), onCancelListener, null);
        if (dialogQ == null) {
            return false;
        }
        t(activity, dialogQ, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean x(Context context, b bVar, int i10) {
        PendingIntent pendingIntentM;
        if (l4.b.a(context) || (pendingIntentM = m(context, bVar)) == null) {
            return false;
        }
        u(context, bVar.S(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, pendingIntentM, i10, true), zap.zaa | 134217728));
        return true;
    }
}
