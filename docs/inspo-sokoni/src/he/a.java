package he;

import ae.b;
import android.content.Context;
import android.content.Intent;
import e0.l;
import ee.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends l {
    public static Long j(Context context) {
        return g.f(context).c(context);
    }

    public static Long k(Context context) {
        return g.f(context).g(context);
    }

    @Override // e0.l
    public void g(Intent intent) {
        de.a.a("BackgroundService", "A new Dart background service has started");
        try {
            l(this);
            rd.a.N(this);
            Long lJ = j(this);
            if (lJ.longValue() == 0) {
                b.e().h("BackgroundService", "BACKGROUND_EXECUTION_EXCEPTION", "A background message could not be handled in Dart because there is no onActionReceivedMethod handler registered.", "arguments.invalid.dartCallback");
                return;
            }
            Long lK = k(this);
            if (lK.longValue() == 0) {
                b.e().h("BackgroundService", "BACKGROUND_EXECUTION_EXCEPTION", "A background message could not be handled in Dart because there is no dart background handler registered.", "arguments.invalid.silentCallback");
            } else {
                sd.a.c(this, intent, lJ, lK);
            }
        } catch (ae.a unused) {
        } catch (Exception e10) {
            b.e().i("BackgroundService", "BACKGROUND_EXECUTION_EXCEPTION", "A new Dart background service could not be executed", "arguments.invalid", e10);
        }
    }

    public abstract void l(Context context);
}
